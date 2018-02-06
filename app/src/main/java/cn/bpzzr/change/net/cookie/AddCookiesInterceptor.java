package cn.bpzzr.change.net.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.SharedPreferencesUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/2/5.
 * 增添cookie的拦截器
 */

public class AddCookiesInterceptor implements Interceptor {
    private static final String TAG = "AddCookiesInterceptor";
    private String lang;
    private SharedPreferencesUtil cookies;

    public AddCookiesInterceptor(Context context, String lang) {
        super();
        this.lang = lang;
        cookies = SharedPreferencesUtil.getInstance(SomeKeys.COOKIE_FILE);

    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        Observable.just(cookies.get(SomeKeys.COOKIE, ""))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String cookie) throws Exception {
                        if (cookie.contains("lang=ch")) {
                            cookie = cookie.replace("lang=ch", "lang=" + lang);
                        }
                        if (cookie.contains("lang=en")) {
                            cookie = cookie.replace("lang=en", "lang=" + lang);
                        }
                        //添加cookie
                        LogUtil.e(TAG, cookie);
                        builder.addHeader("cookie", cookie);
                    }
                });
        return chain.proceed(builder.build());
    }
}