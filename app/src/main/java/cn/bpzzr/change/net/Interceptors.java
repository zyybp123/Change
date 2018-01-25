package cn.bpzzr.change.net;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.jetbrains.annotations.Contract;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.net.progress.FileResponseBody;
import cn.bpzzr.change.net.progress.ProgressCallback;
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
    @Contract(pure = true)
    public static Interceptor getHeaderInterceptor(final Map<String, String> baseUrlMap, final String baseUrl) {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request newRequest = chain.request();
                Request.Builder builder = chain.request().newBuilder();
                //builder.addHeader("","");为所有请求配上统一的请求头,在此设置
                //假如token获取失败可在此处处理，重新获取
                //从request中获取headers，通过给定的键
                List<String> headerValues = newRequest.headers(SomeKeys.URL_FLAG);
                if (headerValues != null && headerValues.size() > 0) {
                    //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
                    builder.removeHeader(SomeKeys.URL_FLAG);
                    //匹配获得新的BaseUrl
                    String headerValue = headerValues.get(0);
                    LogUtil.e("headerValue..................." + headerValue);
                    HttpUrl newBaseUrl = null;
                    if (TextUtils.isEmpty(headerValue)) {
                        //为空值，取默认URL
                        newBaseUrl = HttpUrl.parse(baseUrl);
                    } else {
                        //不为空值，从map里取值
                        String url = baseUrlMap.get(headerValue);
                        if (TextUtils.isEmpty(url)) {
                            //取出来空值，取默认URL
                            newBaseUrl = HttpUrl.parse(baseUrl);
                        } else {
                            newBaseUrl = HttpUrl.parse(url);
                        }
                    }
                    if (newBaseUrl != null) {
                        //从request中获取原有的HttpUrl实例oldHttpUrl
                        HttpUrl oldHttpUrl = newRequest.url();
                        //重建新的HttpUrl，修改需要修改的url部分
                        HttpUrl newFullUrl = oldHttpUrl
                                .newBuilder()
                                .scheme(newBaseUrl.scheme())
                                .host(newBaseUrl.host())
                                .port(newBaseUrl.port())
                                .build();
                        //重建request，返回一个response至此结束修改
                        return chain.proceed(builder.url(newFullUrl).build());
                    } else {
                        return chain.proceed(newRequest);
                    }
                } else {
                    return chain.proceed(newRequest);
                }
            }
        };
    }

    /*@NonNull
    @Contract(pure = true)
    public static Interceptor getResponseInterceptor(final ProgressCallback progressCallback) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder()
                        .body(new FileResponseBody(originalResponse.body(), progressCallback))
                        .build();
            }
        };
    }*/
}
