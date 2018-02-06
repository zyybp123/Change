package cn.bpzzr.change.net.cookie;

import android.support.annotation.NonNull;

import java.util.List;

import cn.bpzzr.change.util.LogUtil;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Administrator on 2018/2/6.
 * cookie管理
 */

public class MyCookieJar implements CookieJar {
    public static final String TAG = "MyCookieJar";

    @Override
    public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        LogUtil.e(TAG, "size:" + cookies.size());
    }

    @Override
    public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        return null;
    }
}
