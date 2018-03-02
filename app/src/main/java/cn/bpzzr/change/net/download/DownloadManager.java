package cn.bpzzr.change.net.download;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.bpzzr.change.bean.gen.ResInfoDao;
import cn.bpzzr.change.interf.home.ServerHost;
import cn.bpzzr.change.manager.GreenDaoManager;
import cn.bpzzr.change.manager.ProgressManager;
import cn.bpzzr.change.net.MyAbnormalException;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.net.State;
import cn.bpzzr.change.net.common.ResInfo;
import cn.bpzzr.change.util.ListUtil;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2018/1/29.
 * 文件下载管理器
 *
 * @streaming 此注解的作用是一边下载一边往文件写入
 * 使用Retrofit进行文件下载时，通过拦截响应体来获取进度，而下载的本质是文件流是否写入到本地和写入了多少
 */

public class DownloadManager {
    private static final String TAG = "DownloadManager";
    //Retrofit工具实例
    private RetrofitTools retrofitTools;
    //retrofit实例
    private Retrofit retrofit;
    //下载管理器实例
    private static volatile DownloadManager mInstance;
    //线程池
    private ExecutorService executorService = null;
    //数据库操作管理
    private ResInfoDao resInfoDao;
    //创建一个map管理下载队列
    //private Map<Long, ResInfo> resInfoMap;

    //指定最大的线程数
    private DownloadManager(int threadCount) {
        //构造内部可以初始化相应参数
        retrofitTools = RetrofitTools.getInstance(ServerHost.BASE_URL_BOOK);
        //初始化线程池的线程数量,限定在1到cpu核心数
        int maxCount = Runtime.getRuntime().availableProcessors();
        LogUtil.e(TAG, "maxCount....." + maxCount);
        if (threadCount <= 0) {
            threadCount = 1;
        }
        if (threadCount > maxCount) {
            threadCount = maxCount;
        }
        //获取dao
        resInfoDao = GreenDaoManager.getInstance().getSession().getResInfoDao();
        //创建一个固定数的线程池
        executorService = Executors.newFixedThreadPool(threadCount);
        //获取一个retrofit实例
        retrofit = retrofitTools.getRetrofit();
        //创建一个map
        //resInfoMap = new HashMap<>();
    }

    public static DownloadManager getInstance(int threadCount) {
        if (mInstance == null) {
            synchronized (DownloadManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadManager(threadCount);
                }
            }
        }
        return mInstance;
    }

    private StateChangeListener listener;

    public void setListener(StateChangeListener listener) {
        this.listener = listener;
    }

    /**
     * 点击下载按钮后的操作
     *
     * @param resInfo  下载的相关信息
     * @param adapter  列表数据适配器
     * @param position 当前的条目索引
     * @param listener 监听器
     */
    public void downLoadClick(ResInfo resInfo, final RecyclerView.Adapter adapter, int position, StateChangeListener listener) {
        if (resInfo == null || StringUtil.isSpaceStr(resInfo.getUrl())) {
            //没有信息或URL为空，就不处理
            return;
        }
        setListener(listener);
        int status = resInfo.getStatus();
        switch (status) {
            case State.START:
            case State.FAIL:
            case State.PAUSE:
                download(resInfo, new DownloadObserver(resInfo, adapter, position));
                break;
            case State.LOADING:
                pause(resInfo);
                adapter.notifyItemChanged(position);
                break;
            case State.SUCCESS:
                if (listener != null) {
                    listener.openFile(resInfo.getType());
                }
                break;
        }
    }

    /**
     * 下载的方法
     *
     * @param resInfo  下载相关信息
     * @param observer 观察者
     */
    public void download(final ResInfo resInfo, final DownloadObserver observer) {
        if (resInfo == null || StringUtil.isSpaceStr(resInfo.getUrl())) {
            //没有信息或URL为空，就不处理
            return;
        }
        WriteFileConsumer fileConsumer = new WriteFileConsumer(resInfo);
        //添加监听器
        ProgressManager.addListener(resInfo.getUrl(), observer);
        resInfo.setStatus(State.WAIT);
        //状态改变，通知ui
        if (listener != null) {
            listener.stateChanged(resInfo.getStatus());
        }
        //创建下载任务
        retrofit.create(DownLoadService.class)
                .download("bytes=" + resInfo.getCurrentSize() + "-", resInfo.getUrl())
                //请求在子线程
                .subscribeOn(Schedulers.io())
                //回调在子线程,针对大文件下载,在子线程写入文件（使用自己创建的调度器）
                .observeOn(Schedulers.from(executorService))
                .doOnNext(fileConsumer)
                .observeOn(AndroidSchedulers.mainThread())//在写完文件后，回调到主线程
                .subscribe(observer);

    }

    /**
     * 下载暂停的方法
     *
     * @param resInfo 下载的信息数据实体
     */
    public void pause(ResInfo resInfo) {
        if (resInfo == null) {
            return;
        }
        //将状态置为暂停
        resInfo.setStatus(State.PAUSE);
        //状态改变，停止写文件
        if (listener != null) {
            listener.stateChanged(resInfo.getStatus());
        }
    }

    /**
     * 写文件的操作
     */
    public class WriteFileConsumer implements Consumer<ResponseBody> {
        /**
         * 下载相关信息的封装
         */
        private ResInfo resInfo;

        WriteFileConsumer(ResInfo resInfo) {
            this.resInfo = resInfo;
        }

        @Override
        public void accept(ResponseBody body) throws Exception {
            //执行写文件的操作
            if (resInfo == null || body == null) {
                //下载信息为空或响应体为空，抛出空指针异常
                throw new NullPointerException();
            }
            String path = StringUtil.getNotNullStr(resInfo.getFileDir());
            File dir = new File(path);
            if (!dir.exists()) {
                //目标文件夹不存在，创建目标文件夹
                boolean mkdirs = dir.mkdirs();
                if (!mkdirs) {
                    throw new MyAbnormalException("文件夹创建失败！");
                }
            }
            //获取文件全名
            String fulName = resInfo.getFullName();
            if (StringUtil.isSpaceStr(fulName)) {
                throw new MyAbnormalException("文件名称为空！");
            }
            //获取对应文件
            File file = new File(dir, fulName);
            if (!file.exists()) {
                //文件不存在，直接下载
                resInfo.setCurrentSize(0);
            }
            if (file.length() != resInfo.getCurrentSize() || resInfo.getStatus() == State.FAIL) {
                //无效文件
                boolean delete = file.delete();
                if (!delete) {
                    //删除失败
                    throw new MyAbnormalException("文件删除失败！");
                }
                //删除成功，写文件到本地，重置下载状态
                resInfo.setCurrentSize(0);
            }
            //记录文件总长和类型,只记录一次
            if (resInfo.getCurrentSize() == 0) {
                resInfo.setTotalSize(body.contentLength());
                MediaType mediaType = body.contentType();
                if (mediaType != null) {
                    resInfo.setType(mediaType.toString());
                    LogUtil.e(TAG, "type is " + resInfo.getType());
                }
                LogUtil.e(TAG, "...mediaType is null...");
            }
            //下载状态置为下载中
            resInfo.setStatus(State.LOADING);
            //文件存在且长度和记录一致，开始下载
            //输入流
            InputStream is;
            //缓冲区
            byte[] buf = new byte[1024 * 2];
            //读写长度
            int len;
            //输出流
            FileOutputStream fos;
            //获取文件的总长度
            long totalSize = resInfo.getTotalSize();
            //获取文件的当前长度
            long currentSize = resInfo.getCurrentSize();
            //从响应体里面获取输入流
            is = body.byteStream();

            //获取文件输出流,允许追加
            fos = new FileOutputStream(file, true);
            //写文件
            while (resInfo.getStatus() == State.LOADING && (len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
                LogUtil.e("curSize...." + currentSize);
                currentSize += len;
                //不断记录当前已经写的长度
                resInfo.setCurrentSize(currentSize);
                resInfo.setProgress((int) (100f * currentSize / totalSize + 0.5f));
                //当前文件长度大于总长度就终止记录
                if (currentSize > totalSize) {
                    break;
                }
            }
            //刷文件
            fos.flush();
            //关流
            is.close();
            fos.close();
        }
    }

    /**
     * 下载状态监听接口
     */
    public interface StateChangeListener {
        /**
         * 状态变化的回调
         *
         * @param state 此时的状态
         */
        void stateChanged(int state);

        /**
         * 文件下载成功后的回调
         *
         * @param type 文件的类型，可根据类型对文件做不同的处理
         */
        void openFile(String type);
    }


    /**
     * 查询数据库的记录
     *
     * @param info 传入的信息
     * @return 如果查到了就返回数据库里的数据, 传入数据为空返回也为空
     */
    @Nullable
    public ResInfo queryOne(ResInfo info) {
        if (info == null) {
            LogUtil.e(TAG, "info is null ！");
            return null;
        }
        if (resInfoDao == null) {
            //查询dao为空，返回传入的数据
            return info;
        }
        //拿到资源id
        long resId = info.getResId();
        //查询数据库记录
        QueryBuilder<ResInfo> infoQueryBuilder = resInfoDao.queryBuilder();
        List<ResInfo> list = infoQueryBuilder
                .where(ResInfoDao.Properties.ResId.eq(resId))
                .list();
        if (ListUtil.nullOrEmpty(list)) {
            //没有查询到数据，就用传入的数据
            return info;
        } else {
            //有查询到数据,就取出第一条
            return list.get(0);
        }
    }

    /**
     * 根据资源id查询数据库
     *
     * @param info 下载信息
     * @return 返回查询的集合
     */
    public List<ResInfo> query(ResInfo info) {
        if (info == null) {
            LogUtil.e(TAG, "info is null ！");
            return null;
        }
        if (resInfoDao == null) {
            //查询dao为空，返回传入的数据
            LogUtil.e(TAG, "resInfoDao is null ！");
            return null;
        }
        //拿到资源id
        long resId = info.getResId();
        //查询数据库记录
        QueryBuilder<ResInfo> infoQueryBuilder = resInfoDao.queryBuilder();
        //返回查询到的集合
        return infoQueryBuilder
                .where(ResInfoDao.Properties.ResId.eq(resId))
                .list();
    }

    /**
     * 向数据库插入一条记录
     *
     * @param resInfo 下载的相关信息
     */
    public void insertOne(ResInfo resInfo) {
        if (resInfo == null) {
            LogUtil.e(TAG, "can't insert null data !");
            return;
        }
        //save方法会根据自增id去插入，有就直接更新，没有就插入,此处不用

        long insert = resInfoDao.insert(resInfo);
        LogUtil.e(TAG, "insert........." + insert);
        LogUtil.e(TAG, "SearchHistoryBean........." + resInfo);
    }

    /**
     * 更新数据库的一条记录
     *
     * @param resInfo 下载的相关信息
     */
    public void updateOne(ResInfo resInfo) {
        if (resInfo == null) {
            LogUtil.e(TAG, "can't update data to null !");
            return;
        }
        //更新数据
        resInfoDao.update(resInfo);
    }

    /**
     * 将响应体写入文件的方法
     *
     * @param body    响应体
     * @param fileDir 目标文件夹
     * @param name    目标文件名
     */
    public static void writeToFile(ResponseBody body, File fileDir, String name) {
        if (StringUtil.isSpaceStr(name)) {
            return;
        }
        //输入流
        InputStream is = null;
        //临时串
        byte[] buf = new byte[1024 * 2];
        int len;
        //输出流
        FileOutputStream fos = null;
        try {
            //从响应体里面获取出输出流
            is = body.byteStream();
            LogUtil.e("is......" + is);
            if (!fileDir.exists()) {
                //如果文件夹不存在，则创建文件夹
                boolean mkdirs = fileDir.mkdirs();
                if (!mkdirs) {
                    //没创建成功
                    LogUtil.e(TAG, "文件夹创建失败！");
                    return;
                }
            }
            //文件夹已经存在,创建对应的输出流
            File file = new File(fileDir, name);
            fos = new FileOutputStream(file);
            //写出到目标文件
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            //避免有未写入完的串，刷入
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.e(TAG, e.getMessage());
        } finally {
            //关流
            try {
                if (is != null) {
                    is.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                LogUtil.e(TAG, "文件写入失败！" + e.getMessage());
            }
        }
    }


    /**
     * 根据路径获取文件的名字
     *
     * @param path URL或文件路径
     * @return 空串或本身或最后一个分隔符后的串
     */
    public static String getFileName(String path) {
        if (StringUtil.isSpaceStr(path)) {
            //如果传入路径为空，返回空串
            return "";
        }
        //最后一个 / 的索引
        int separatorIndex = path.lastIndexOf("/");
        //如果不含 / ，就直接返回该串，否则就返回 / 后的内容
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }
}
