package cn.bpzzr.change.util;

import android.util.Log;


import cn.bpzzr.change.BuildConfig;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by ZYY
 * on 2016/11/14 20:58.
 */

public class LogUtil {
    public static boolean isShowLog = BuildConfig.LOG_DEBUG;
    private static String TAG = LogUtil.class.getSimpleName();

    public static void d(String tag, String msg) {
        if (isShowLog) {
            Log.d(tag, msg);
        }
    }

    public static void setPtrLog() {
        PtrFrameLayout.DEBUG = isShowLog;
    }

    /**
     * 打印e级别的log
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (isShowLog) {
            Log.e(tag, msg);
        }
    }

    /**
     * 打印log，外界可以传任何对象，我们帮它生产tag
     *
     * @param object
     * @param msg
     */
    public static void d(Object object, String msg) {
        if (isShowLog) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void e(Object object, String msg) {
        if (isShowLog) {
            Log.e(object.getClass().getSimpleName(), msg);
        }
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static String getLogTag(Object o) {
        return o == null ? TAG : o.getClass().getSimpleName();
    }
}
