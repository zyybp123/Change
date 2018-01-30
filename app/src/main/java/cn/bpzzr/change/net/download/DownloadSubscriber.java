package cn.bpzzr.change.net.download;



import cn.bpzzr.change.net.progress.ProgressCallback;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/30.
 * 文件下载的观察者
 */

public class DownloadSubscriber implements Observer<ResInfo>, ProgressCallback {
    @Override
    public void onLoading(long contentLength, long bytesWritten, boolean done) {
        //下载中的进度
    }

    @Override
    public void onSubscribe(Disposable d) {
        //可以看作开始
    }

    @Override
    public void onNext(ResInfo info) {
        //
    }

    @Override
    public void onError(Throwable e) {
        //错误
    }

    @Override
    public void onComplete() {
        //完成

    }
}
