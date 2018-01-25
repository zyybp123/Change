package cn.bpzzr.change.net.progress;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.bpzzr.change.net.progress.ProgressCallback;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/25.
 * 下载进度监听拦截器
 */

public class ProgressInterceptor implements Interceptor {
    /**
     * 监听器map，会存在多个下载同时进行
     */
    static final Map<String, ProgressCallback> LISTENER_MAP = new HashMap<>();

    public static void addListener(String url, ProgressCallback listener) {
        LISTENER_MAP.put(url, listener);
    }

    public static void removeListener(String url) {
        LISTENER_MAP.remove(url);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        String url = chain.request().url().toString();
        return originalResponse.newBuilder()
                .body(new FileResponseBody(url, originalResponse.body()))
                .build();
    }
}
