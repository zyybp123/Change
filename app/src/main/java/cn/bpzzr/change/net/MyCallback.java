package cn.bpzzr.change.net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/5.
 *
 */

public class MyCallback<T> implements Callback<T> {
    private DataParse<T> dataParse;

    public MyCallback(DataParse<T> dataParse) {
        this.dataParse = dataParse;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {
            //[200..300),说明成功拿到数据
            T body = response.body();
            dataParse.getBody(body);
        } else {
            //像404这样的错误,或其它非预期响应
            onFailure(call, new RuntimeException(response.message()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        dataParse.onError(call, t.getMessage());
    }
}
