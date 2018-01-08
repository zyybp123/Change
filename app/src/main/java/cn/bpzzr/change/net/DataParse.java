package cn.bpzzr.change.net;

import retrofit2.Call;

/**
 * Created by Administrator on 2018/1/5.
 * 数据解析接口
 */

public interface DataParse<T> {
    void onError(Call<T> call, String code, String message);

    void getBody(T body);
}
