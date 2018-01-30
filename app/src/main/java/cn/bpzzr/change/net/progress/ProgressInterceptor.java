package cn.bpzzr.change.net.progress;

import android.support.annotation.NonNull;

import java.io.IOException;

import cn.bpzzr.change.net.download.FileResponseBody;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/25.
 * 下载进度监听拦截器
 */

public class ProgressInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        String url = chain.request().url().toString();
        //返回写入了监听器的响应体
        return originalResponse.newBuilder()
                .body(new FileResponseBody(url, originalResponse.body()))
                .build();
    }
}
