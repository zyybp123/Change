package cn.bpzzr.change.net.download;

import android.accounts.NetworkErrorException;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import cn.bpzzr.change.net.State;
import cn.bpzzr.change.net.common.ResInfo;
import cn.bpzzr.change.net.callback.ProgressCallback;
import cn.bpzzr.change.util.LogUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/1/31.
 * 下载进度观察者
 */

public class DownloadObserver implements Observer<ResponseBody>, ProgressCallback {
    private final String TAG = "DownloadObserver";
    private ResInfo resInfo;
    // 在RxJava 2.x 中，Disposable可以做到切断的操作，让Observer观察者不再接收上游事件，但上游的发送不会停止
    private Disposable disposable;
    private DownloadManager downloadManager = DownloadManager.getInstance(1);
    //
    private RecyclerView.Adapter mAdapter;
    private int position;

    public DownloadObserver(ResInfo resInfo, DownloadManager instance) {
        this.resInfo = resInfo;
        this.downloadManager = instance;
    }

    public DownloadObserver(ResInfo resInfo, RecyclerView.Adapter mAdapter,int position) {
        this.resInfo = resInfo;
        this.mAdapter = mAdapter;
        this.position = position;
    }

    @Override
    public void onLoading(long contentLength, long bytesWritten, boolean done) {
        LogUtil.e(TAG, "progress......" + resInfo.getProgress());
        LogUtil.e(TAG, "thread......" + Thread.currentThread());
        //把onLoading回调到主线程
        Observable.just(resInfo.getProgress())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressObserver());
    }

    @Override
    public void onSubscribe(Disposable d) {
        //可以通过此字段做一些控制
        this.disposable = d;
        //此处建立订阅关系
        LogUtil.e(TAG, "start......");
    }

    @Override
    public void onNext(final ResponseBody body) {
        LogUtil.e(TAG, "onNext......" + Thread.currentThread());
    }

    @Override
    public void onError(Throwable e) {
        //发生的异常在此处处理
        LogUtil.e(TAG, "onError: " + e.getMessage());//这里可以打印错误信息
        onFail(e.getMessage());
        try {
            if (e instanceof ConnectException) {
                LogUtil.e(TAG, "网络连接异常..." + e.getMessage());
            } else if (e instanceof TimeoutException) {
                LogUtil.e(TAG, "网络连接超时..." + e.getMessage());
            } else if (e instanceof NetworkErrorException) {
                LogUtil.e(TAG, "网络工作异常..." + e.getMessage());
            } else if (e instanceof UnknownHostException) {
                LogUtil.e(TAG, "主机解析异常..." + e.getMessage());
            } else {
                LogUtil.e(TAG, "...other...error...");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            LogUtil.e(TAG, "其它异常信息" + e1.getMessage());
        }
    }

    @Override
    public void onComplete() {
        //完成监听
        LogUtil.e(TAG, "onComplete......");
        File file = new File(resInfo.getFileDir() + File.separator + resInfo.getFullName());
        if (resInfo.getTotalSize() == file.length() && resInfo.getStatus() == State.LOADING) {
            //此时已经下载成功了，在主线程
            onSuccess();
        } else if (resInfo.getStatus() == State.PAUSE) {
            //下载暂停了,通知界面
            loading(resInfo.getProgress());
        } else {
            //下载失败了
            LogUtil.e(TAG, "......not success or pause......");
            onFail("......not success or pause......");
        }
    }

    /**
     * 下载中
     *
     * @param progress 下载进度
     */
    protected void loading(int progress){
        if (mAdapter != null){
            mAdapter.notifyItemChanged(position);
        }
    }

    /**
     * 下载失败
     *
     * @param message 异常的信息
     */
    protected void onFail(String message) {
        resInfo.setStatus(State.FAIL);
        downloadManager.updateOne(resInfo);
        if (mAdapter != null){
            mAdapter.notifyItemChanged(position);
        }
    }

    /**
     * 下载成功
     */
    protected void onSuccess() {
        resInfo.setStatus(State.SUCCESS);
        downloadManager.updateOne(resInfo);
        if (mAdapter != null){
            mAdapter.notifyItemChanged(position);
        }
    }

    /**
     * 进度观察者，把进度回调到主线程
     */
    public class ProgressObserver implements Observer<Integer> {
        private final String TAG = "ProgressObserver";
        private Disposable disposable;

        @Override
        public void onSubscribe(Disposable d) {
            this.disposable = d;
        }

        @Override
        public void onNext(Integer integer) {
            LogUtil.e(TAG, "progress..." + Thread.currentThread());
            loading(integer);
        }

        @Override
        public void onError(Throwable e) {
            LogUtil.e(TAG, e.getMessage());
            onFail(e.getMessage());
        }

        @Override
        public void onComplete() {
            LogUtil.e(TAG, "onComplete");
        }
    }

}
