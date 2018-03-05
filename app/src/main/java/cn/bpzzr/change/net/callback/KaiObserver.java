package cn.bpzzr.change.net.callback;


import android.accounts.NetworkErrorException;
import android.text.TextUtils;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZYY
 * kai shu story request result base class
 */

public abstract class KaiObserver<T> implements Observer<BaseResultBean<T>> {
    private static final String mTag = "KaiObserver";
    /**
     * 具体的方法的标识（用静态的子路径做标识）
     */
    private String methodTag = "methodTag";

    public KaiObserver(String methodTag) {
        this.methodTag = methodTag;
    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    protected abstract void onRequestStart();

    @Override
    public void onNext(BaseResultBean<T> resultBaseBean) {
        //数据预处理
        if (resultBaseBean != null) {
            LogUtil.e(mTag, "......response body......" + resultBaseBean);
            String describe = StringUtil.getNotNullStr(resultBaseBean.getErrmsg());
            int errorCode = resultBaseBean.getErrcode();
            switch (errorCode) {
                case 0:
                    //错误码为0，则返回成功
                    T result = resultBaseBean.getResult();
                    if (result != null) {
                        //数据不为空则回调成功的方法，带回方法标识，错误描述，数据结果
                        onResult(methodTag, result);
                    } else {
                        onResultEmpty(methodTag);
                    }
                    break;
            }

        } else {
            onResultError(methodTag, "......response body is null......");
        }
    }

    protected abstract void onResultError(String methodTag, String errorMsg);

    protected abstract void onResultEmpty(String methodTag);

    protected abstract void onResult(String methodTag, T result);

    @Override
    public void onError(Throwable e) {
        LogUtil.e(mTag, "onError: " + e.getMessage());//这里可以打印错误信息
        try {
            if (e instanceof ConnectException) {
                LogUtil.e(mTag, "网络连接异常..." + e.getMessage());
                onResultError(methodTag, "网络连接异常");
            } else if (e instanceof TimeoutException) {
                LogUtil.e(mTag, "网络连接超时..." + e.getMessage());
                onResultError(methodTag, "网络连接超时");
            } else if (e instanceof NetworkErrorException) {
                LogUtil.e(mTag, "网络工作异常..." + e.getMessage());
                onResultError(methodTag, "网络工作异常");
            } else if (e instanceof UnknownHostException) {
                LogUtil.e(mTag, "主机解析异常..." + e.getMessage());
                onResultError(methodTag, "主机解析异常");
            } else {
                LogUtil.e(mTag, "...other...error...");
                onResultError(methodTag, e.getMessage());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            LogUtil.e(mTag, "其它异常信息" + e1.getMessage());
        }
    }

    @Override
    public void onComplete() {
        onRequestEnd();
    }

    protected abstract void onRequestEnd();


}
