package cn.bpzzr.change.net.download;

import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.bpzzr.change.bean.AbnormalBean;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.manager.ProgressManager;
import cn.bpzzr.change.net.MyAbnormalException;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.net.State;
import cn.bpzzr.change.net.progress.ProgressCallback;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/29.
 * 文件下载管理器
 */

public class DownloadManager {
    private static final String TAG = "DownloadManager";
    private RetrofitTools retrofitTools;
    private static volatile DownloadManager mInstance;

    private DownloadManager() {
        //构造内部可以初始化相应参数
        retrofitTools = RetrofitTools.getInstance(ServerHost.BASE_URL_BOOK);
    }

    public static DownloadManager getInstance() {
        if (mInstance == null) {
            synchronized (DownloadManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 开始下载的方法
     *
     * @param info 下载的信息
     */
    public void startDownload(ResInfo info) {
        /*if (info == null || StringUtil.isSpaceStr(info.getUrl())) {
            //没有信息或URL为空，就不处理
            return;
        }
        //获取下载状态
        int status = info.getStatus();
        //如果状态值为开始，暂停，等待或失败时都要开始下载
        if (status == State.START || status == State.LOADING ||
                status == State.WAIT || status == State.FAIL) {
            //
        }*/
        LogUtil.e("...url..." + info.getUrl());
        //构建Service
        DownLoadService downLoadService = retrofitTools.getRetrofit().create(DownLoadService.class);
        Call<ResponseBody> call = downLoadService.download(info.getUrl());
        MyDownLoadCallback callback = new MyDownLoadCallback(new File(info.getFileDir()),
                DownloadManager.getFileName(info.getUrl()));
        call.enqueue(callback);
        ProgressManager.addListener(info.getUrl(), callback);
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
        byte[] buf = new byte[1024 * 3];
        int len;
        //输出流
        FileOutputStream fos = null;
        try {
            //从响应体里面获取出输出流
            is = body.byteStream();
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

    public class MyDownLoadCallback implements Callback<ResponseBody>, ProgressCallback {
        private File fileDir;
        private String fileName;

        public MyDownLoadCallback(File fileDir, String fileName) {
            this.fileDir = fileDir;
            this.fileName = fileName;
        }

        @Override
        public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                //[200..300),说明成功拿到数据
                ResponseBody body = response.body();
                //写入文件
                writeToFile(body, fileDir, fileName);
            } else {
                //像404这样的错误,或其它非预期响应
                MyAbnormalException exception = new MyAbnormalException(
                        AbnormalBean.getMsgStr(
                                new AbnormalBean(response.code(), response.message())
                        )
                );
                onFailure(call, exception);
            }
        }

        @Override
        public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
            //下载失败
        }

        @Override
        public void onLoading(long contentLength, long bytesWritten, boolean done) {
            //下载中
            LogUtil.e("....por...." + bytesWritten);
        }
    }

    public interface DownloadListener {
        void onStart();

        void onLoading();

        void onPause();

        void onWait();

        void onSuccess();

        void onFail();
    }
}
