package cn.bpzzr.change.net.callback;

import android.text.TextUtils;

import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.DataParse;
import cn.bpzzr.change.util.LogUtil;
import retrofit2.Call;

/**
 * 通用处理方法，统一返回数据风格并预处理
 *
 * @param <T>
 */
public class MyDataParse<T> implements DataParse<ResultBaseBean<T>> {


    private MVP.View mView; //实现View接口的界面
    private String TAG;     //具体方法的标识

    public MyDataParse(MVP.View mView, String TAG) {
        this.mView = mView;
        this.TAG = TAG;
    }

    @Override
    public void onError(Call<ResultBaseBean<T>> call, String code, String message) {
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
    public void getBody(ResultBaseBean<T> body) {
        if (body != null) {
            LogUtil.e("......response body......" + body);
            String version = body.getVersion();
            String result = body.getResult();
            String describe = TextUtils.isEmpty(body.getDescribe()) ? "" : body.getDescribe();
            int code = body.getCode();
            switch (code) {
                case -1:
                    //失败,未知原因
                    mView.onError(TAG, describe);
                    break;
                case 0:
                    //不成功
                    mView.onError(TAG, describe);
                    break;
                case 1:
                    if (body.getData() != null) {
                        //成功,回调数据
                        mView.onSuccess(TAG, result, body.getData());
                    } else {
                        //成功但是为空数据
                        mView.onEmpty(TAG);
                    }
                    break;
                case 1000:
                    //
                    break;
                default:
                    mView.onError(TAG, describe);
                    //其他情况,直接弹出提示
                    //UiUtils.showMyToast(describe);
                    break;
            }
        } else {
            mView.onError(TAG, "......response body is null......");
        }
    }
}
