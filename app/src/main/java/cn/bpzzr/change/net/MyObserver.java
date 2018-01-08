package cn.bpzzr.change.net;


import android.accounts.NetworkErrorException;
import android.content.Context;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.util.LogUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZYY
 * on 2018/1/8 22:13.
 */

public abstract class MyObserver<T> implements Observer<ResultBaseBean<T>> {
    protected Context mContext;
    public static final String mTag = "MyObserver";

    public MyObserver(Context cxt) {
        this.mContext = cxt;
    }

    public MyObserver() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onNext(ResultBaseBean<T> resultBaseBean) {
        //onRequestEnd();
        //数据的预处理
        /*if (tBaseEntity.isSuccess()) {
            try {
                onSuccees(tBaseEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                onCodeError(tBaseEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e(mTag, "onError: " + e.getMessage());//这里可以打印错误信息
        //onRequestEnd();
        try {
            if (e instanceof ConnectException) {
                onFailure(e, true);
                LogUtil.e(mTag, "网络连接异常");
            } else if (e instanceof TimeoutException) {
                onFailure(e, true);
                LogUtil.e(mTag, "网络连接超时");
            } else if (e instanceof NetworkErrorException) {
                onFailure(e, true);
                LogUtil.e(mTag, "网络工作异常");
            } else if (e instanceof UnknownHostException) {
                onFailure(e, true);
                LogUtil.e(mTag, "主机解析异常");
            } else {
                onFailure(e, false);
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
     * 返回成功
     *
     * @param resultBaseBean 结果
     */
    public abstract void onSuccees(ResultBaseBean<T> resultBaseBean);

    /**
     * 返回成功了,但是code错误
     *
     * @param resultBaseBean 结果
     */
    public void onCodeError(ResultBaseBean<T> resultBaseBean){
    }

    /**
     * 返回失败
     *
     * @param e              抛出的异常信息
     * @param isNetWorkError 是否是网络错误
     */
    public abstract void onFailure(Throwable e, boolean isNetWorkError);

    /**
     * 开始请求
     */
    public abstract void onRequestStart();

    /**
     * 请求结束
     */
    //public abstract void onRequestEnd();

}
