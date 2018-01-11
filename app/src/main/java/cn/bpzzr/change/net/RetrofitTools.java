package cn.bpzzr.change.net;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.bpzzr.change.bean.BaseBean;
import cn.bpzzr.change.bean.DoubanTest;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.util.LogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/4.
 * retrofit请求方法统一管理类
 */

public class RetrofitTools {
    private static RetrofitTools mInstance = null;
    private RetrofitClient client;
    private OkHttpClient okClient;
    private Retrofit retrofit;
    //http://blog.csdn.net/gld824125233/article/details/52588275 抓包

    /**
     * 构造 初始化相应参数
     *
     * @param baseUrl 基础URL
     */
    private RetrofitTools(final String baseUrl) {
        Map<String, String> baseUrlMap = new HashMap<>();
        baseUrlMap.put(SomeKeys.VIDEO_DATA, ServerHost.BASE_URL_VIDEO);
        baseUrlMap.put(SomeKeys.BOOK_DATA, ServerHost.BASE_URL_BOOK);
        baseUrlMap.put(SomeKeys.ONLINE_DATA, ServerHost.BASE_URL_ONLINE);
        //设置OkHttpClitent;
        okClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.MINUTES)        //读取超时 60min
                .connectTimeout(1, TimeUnit.MINUTES)      //连接超时 1min
                .writeTimeout(60, TimeUnit.MINUTES)       //写超时   60min
                .retryOnConnectionFailure(true)                   //是否自动重连
                //.sslSocketFactory(sslContext.getSocketFactory())//证书配置
                .addInterceptor(Interceptors.getHeaderInterceptor(baseUrlMap, baseUrl))
                .addNetworkInterceptor(Interceptors.getLogInterceptor())
                .build();
        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)// Baseurl 必须以/结尾
                .addConverterFactory(GsonConverterFactory.create())// 添加json转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okClient)
                .build();
        client = retrofit.create(RetrofitClient.class);
    }

    /**
     * 获取client
     *
     * @return 返回RetrofitClient
     */
    public RetrofitClient getClient() {
        return client;
    }

    public RetrofitTools setBaseUrl(String baseUrl) {
        LogUtil.e("Retrofit tools base url set.........." + baseUrl);
        if (okClient != null) {
            if (retrofit != null) {
                retrofit = null;
            }
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)// Baseurl 必须以/结尾
                    .addConverterFactory(GsonConverterFactory.create())// 添加json转换器
                    .client(okClient)
                    .build();
            if (client != null) {
                client = null;
            }
            client = retrofit.create(RetrofitClient.class);
        }
        return this;
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

    public String getTest(MVP.View view) {
        Call<DoubanTest> call = client.getTest();
        HttpUrl url = call.request().url();
        LogUtil.e("http url......." + url.toString());
        call.enqueue(new MyCallback<>(new MyDataParseSimple<DoubanTest>(view, url.toString())));
        return url.toString();
    }

    public Call getTest2(MVP.View view) {
        Call<GankTest> call = client.getTest2();
        call.enqueue(new MyCallback<>(new MyDataParseSimple<GankTest>(view, "getTest2")));
        return call;
    }

    public void getTest3(MVP.View mView) {
        client.getTest3()
                //.subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .compose(this.<GankTest>setThread())
                .subscribe(new MyObserverSimple<GankTest>(mView, "getTest3"));

    }

    //批量上传文件的方法
    public Call uploadFiles(MVP.View mView, String projectId, String accountId,
                            String projectResourceClassId, String xyToken, Map<String, RequestBody> map) {
        // 执行请求
        String uuid = "";
        Call<ResultBaseBean<List<BaseBean>>> call = client
                .uploadFiles(projectId, accountId, projectResourceClassId, uuid, xyToken, map);
        call.enqueue(new MyCallback<>(new MyDataParse<List<BaseBean>>(mView, "")));
        return call;
    }
    public <T> ObservableTransformer<T,T> setThread(){
        return new ObservableTransformer<T,T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
