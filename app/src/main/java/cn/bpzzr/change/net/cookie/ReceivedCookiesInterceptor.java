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
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/2/5.
 * 保存cookie的拦截器
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    private static final String TAG = "ReceivedCookiesInterceptor";
    private SharedPreferencesUtil cookies;

    public ReceivedCookiesInterceptor(Context context) {
        super();
        cookies = SharedPreferencesUtil.getInstance("cookies");
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        LogUtil.e(TAG, "originalResponse" + originalResponse.toString());
        if (!originalResponse.headers(SomeKeys.COOKIE_SET).isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();
            Observable.fromIterable(originalResponse.headers(SomeKeys.COOKIE_SET))
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(String s) throws Exception {
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];
                        }

                    })
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String cookie) throws Exception {
                            cookieBuffer.append(cookie).append(";");
                        }
                    });
            cookies.put(SomeKeys.COOKIE, cookieBuffer.toString());
            LogUtil.e(TAG, "cookie buffer:" + cookieBuffer.toString());
        }
        return originalResponse;
    }
}
