package cn.bpzzr.change.net.callback;

/**
 * Created by Administrator on 2018/1/9.
 */

import android.text.TextUtils;

import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.DataParse;
import cn.bpzzr.change.util.LogUtil;
import retrofit2.Call;

/**
 * 通用处理方法
 *
 * @param <T>
 */
public class MyDataParseSimple<T> implements DataParse<T> {


    private MVP.View mView; //实现View接口的界面
    private String TAG;     //具体方法的标识

    public MyDataParseSimple(MVP.View mView, String TAG) {
        this.mView = mView;
        this.TAG = TAG;
    }

    @Override
    public void onError(Call<T> call, String code, String message) {
        LogUtil.e("RequestFiled........" + message);
        mView.onError(TAG, message);
        if (!TextUtils.isEmpty(message)) {
            if (message.contains("Failed to connect to") || message.contains("Connection Failed")) {
                //UiUtils.showMyToast("网络不可用!");
            }
            if (message.contains("after 60000ms")) {
                //UiUtils.showMyToast("当前网络状态不佳,请稍后重试!");
            }
        }
    }

    @Override
    public void getBody(T body) {
        if (body != null) {
            //成功,回调数据
            mView.onSuccess(TAG, "success", body);
        } else {
            mView.onEmpty(TAG);
        }
    }
}
