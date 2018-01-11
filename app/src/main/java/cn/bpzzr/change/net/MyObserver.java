package cn.bpzzr.change.net;


import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.util.LogUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZYY
 * on 2018/1/8 22:13.
 * 实现一个统一处理的观察者
 */

public  class MyObserver<T> implements Observer<ResultBaseBean<T>> {
    public static final String mTag = "MyObserver";

    private MVP.View<T> mView;       //实现View接口的界面
    private String methodTag;     //具体方法的标识

    public MyObserver(MVP.View<T> mView, String methodTag) {
        this.mView = mView;
        this.methodTag = methodTag;
    }

    public MyObserver() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        mView.onRequestStart(mTag);
    }

    @Override
    public void onNext(ResultBaseBean<T> resultBaseBean) {
        if (resultBaseBean != null) {
            LogUtil.e("......response body......" + resultBaseBean);
            //数据预处理
            String version = resultBaseBean.getVersion();
            String result = resultBaseBean.getResult();
            String describe = TextUtils.isEmpty(resultBaseBean.getDescribe()) ? "" : resultBaseBean.getDescribe();
            int code = resultBaseBean.getCode();
            switch (code) {
                case 1:
                    //定义返回码
                    T data = resultBaseBean.getData();
                    if (data != null) {
                        mView.onSuccess(methodTag, result, data);
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

}
