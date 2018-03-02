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
 * on 2018/1/8 22:13.
 * 实现一个统一处理的观察者
 */

public class KaiObserver<T> implements Observer<BaseResultBean<T>> {
    private static final String mTag = "KaiObserver";
    /**
     * 实现View接口的页面
     */
    private MVP.View<T> mView;
    /**
     * 具体的方法的标识（用静态的子路径做标识）
     */
    private String methodTag;
    /**
     * 扩展监听器
     */
    private ExtendListener<T> listener;

    public KaiObserver(MVP.View<T> mView, String methodTag) {
        this.mView = mView;
        this.methodTag = methodTag;
    }

    public KaiObserver(MVP.View<T> mView, String methodTag, ExtendListener<T> listener) {
        this(mView, methodTag);
        this.listener = listener;
    }

    public KaiObserver() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        mView.onRequestStart(mTag);
    }

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
                        mView.onSuccess(methodTag, describe, result);
                        if (listener != null){
                            listener.onExtend(methodTag, result);
                        }
                    } else {
                        mView.onEmpty(methodTag);
                    }
                    break;
            }

        } else {
            mView.onError(methodTag, "......response body is null......");
        }
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e(mTag, "onError: " + e.getMessage());//这里可以打印错误信息
        try {
            if (e instanceof ConnectException) {
                LogUtil.e(mTag, "网络连接异常..." + e.getMessage());
                mView.onError(methodTag, "网络连接异常");
            } else if (e instanceof TimeoutException) {
                LogUtil.e(mTag, "网络连接超时..." + e.getMessage());
                mView.onError(methodTag, "网络连接超时");
            } else if (e instanceof NetworkErrorException) {
                LogUtil.e(mTag, "网络工作异常..." + e.getMessage());
                mView.onError(methodTag, "网络工作异常");
            } else if (e instanceof UnknownHostException) {
                LogUtil.e(mTag, "主机解析异常..." + e.getMessage());
                mView.onError(methodTag, "主机解析异常");
            } else {
                LogUtil.e(mTag, "...other...error...");
                mView.onError(methodTag, e.getMessage());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            LogUtil.e(mTag, "其它异常信息" + e1.getMessage());
        }
    }

    @Override
    public void onComplete() {
        //onRequestEnd();
    }

    /**
     * 扩展监听器接口，主要将onNext预处理之后的数据回调到外部做分类处理
     */
    public interface ExtendListener<T> {
        void onExtend(String methodTag, T result);
    }

}
