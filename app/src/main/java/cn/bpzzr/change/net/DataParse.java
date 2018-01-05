package cn.bpzzr.change.net;

import retrofit2.Call;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface DataParse<T> {
    void onError(Call<T> call, String message);

    void getBody(T body);
}
