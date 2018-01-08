package cn.bpzzr.change.net;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;
import java.net.ConnectException;

import cn.bpzzr.change.bean.AbnormalBean;
import cn.bpzzr.change.util.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/5.
 * 网络请求处理回调
 */

public class MyCallback<T> implements Callback<T> {
    private DataParse<T> dataParse;

    public MyCallback(DataParse<T> dataParse) {
        this.dataParse = dataParse;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) {
            //[200..300),说明成功拿到数据
            T body = response.body();
            dataParse.getBody(body);
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
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        LogUtil.e("Throwable...." + t);
        String message = t.getMessage();
        if (t instanceof MyAbnormalException) {
            if (AbnormalBean.ABNORMAL_BEAN_IS_NULL.equals(message)) {
                dataParse.onError(call, "", message);
            } else {
                AbnormalBean msgBean = AbnormalBean.getMsgBean(message);
                LogUtil.e("AbnormalBean msgBean......" + message);
                dataParse.onError(call, "" + msgBean.getCode(), msgBean.getMsg());
            }
        } else if (t instanceof ConnectException) {
            dataParse.onError(call, "", message);
        }  else {
            dataParse.onError(call, "", message);
        }
    }
}
