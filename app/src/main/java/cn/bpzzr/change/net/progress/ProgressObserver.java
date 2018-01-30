package cn.bpzzr.change.net.progress;

import cn.bpzzr.change.util.LogUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/29.
 * 进度观察者
 */

public class ProgressObserver implements Observer<ProgressBean> {
    @Override
    public void onSubscribe(Disposable d) {
        LogUtil.e("onSubscribe()");
    }

    @Override
    public void onNext(ProgressBean progressBean) {
        LogUtil.e("onNext()");
        LogUtil.e(".........." + progressBean.progress + progressBean.isDone);
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e("onError()");
    }

    @Override
    public void onComplete() {
        LogUtil.e("onComplete()");
    }
}
