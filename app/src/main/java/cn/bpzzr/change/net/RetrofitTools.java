package cn.bpzzr.change.net;

import android.text.TextUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.bpzzr.change.Bean.BaseBean;
import cn.bpzzr.change.Bean.DoubanTest;
import cn.bpzzr.change.Bean.GankTest;
import cn.bpzzr.change.Bean.ResultBaseBean;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.util.LogUtil;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
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
    private Map<String, String> baseUrlMap;

    /**
     * 构造 初始化相应参数
     *
     * @param baseUrl 基础URL
     */
    private RetrofitTools(final String baseUrl) {
        baseUrlMap = new HashMap<>();
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
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request newRequest = chain.request();
                        Request.Builder builder = chain.request().newBuilder();
                        //builder.addHeader("","");为所有请求配上统一的请求头,在此设置
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
                    }
                })
                .build();
        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)// Baseurl 必须以/结尾
                .addConverterFactory(GsonConverterFactory.create())// 添加json转换器
                .client(okClient)
                .build();
        client = retrofit.create(RetrofitClient.class);
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

    public Call getTest(MVP.View view) {
        Call<ResultBaseBean<DoubanTest>> call = client.getTest();
        call.enqueue(new MyCallback<>(new MyDataParse<DoubanTest>(view, "")));
        return call;
    }

    public Call getTest2(MVP.View view) {
        Call<ResultBaseBean<GankTest>> call = client.getTest2();
        call.enqueue(new MyCallback<>(new MyDataParse<GankTest>(view, "")));
        return call;
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


    /**
     * 通用处理方法
     *
     * @param <T>
     */
    class MyDataParse<T> implements DataParse<ResultBaseBean<T>> {


        private MVP.View mView; //实现View接口的界面
        private String TAG;     //具体方法的标识

        public MyDataParse(MVP.View mView, String TAG) {
            this.mView = mView;
            this.TAG = TAG;
        }

        @Override
        public void onError(Call<ResultBaseBean<T>> call, String message) {
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
}
