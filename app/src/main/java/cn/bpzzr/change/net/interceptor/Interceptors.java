package cn.bpzzr.change.net.interceptor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.jetbrains.annotations.Contract;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.util.LogUtil;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ZYY
 * on 2018/1/8 21:39.
 */

public class Interceptors {
    public static String TAG = "--Interceptors--";

    //日志拦截器
    @NonNull
    public static HttpLoggingInterceptor getLogInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                //LogUtil.e(TAG, "log: " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }

    @NonNull
    public static Interceptor getHeaderInterceptor(Map<String, String> baseUrlMap, String baseUrl) {
        return new HeaderInterceptor(baseUrlMap, baseUrl);
    }
}
