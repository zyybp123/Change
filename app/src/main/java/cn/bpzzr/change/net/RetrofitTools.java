package cn.bpzzr.change.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/4.
 * retrofit请求方法统一管理类
 */

public class RetrofitTools {
    private static RetrofitTools mInstance = null;
    private RetrofitClient client;

    /**
     * 构造 初始化相应参数
     * @param baseUrl 基础URL
     */
    private RetrofitTools(String baseUrl) {
        //设置OkHttpClitent;
        OkHttpClient okClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.MINUTES)        //读取超时 60min
                .connectTimeout(1, TimeUnit.MINUTES)      //连接超时 1min
                .writeTimeout(60, TimeUnit.MINUTES)       //写超时   60min
                .retryOnConnectionFailure(true)                   //是否自动重连
                //.sslSocketFactory(sslContext.getSocketFactory())//证书配置
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //为所有请求配上统一的请求头
                        Request newRequest = chain.request().newBuilder()
                                //.addHeader(SomeKeys.XY_TOKEN, xytoken)
                                //.addHeader(SomeKeys.VERSION, currentVersion)
                                //.addHeader(SomeKeys.DEVICE, "ANDROID")
                                .build();
                        return chain.proceed(newRequest);
                    }
                })
                .build();
        // 初始化Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)// Baseurl 必须以/结尾
                .addConverterFactory(GsonConverterFactory.create())// 添加json转换器
                .client(okClient)
                .build();
        client = retrofit.create(RetrofitClient.class);
    }

    /**
     * 单例模式获取实例
     *
     * @param baseUrl 基础URL
     * @return 返回本类实例
     */
    public static RetrofitTools getInstance(String baseUrl) {
        if (mInstance == null) {
            synchronized (RetrofitTools.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitTools(baseUrl);
                }
            }
        }
        return mInstance;
    }
}
