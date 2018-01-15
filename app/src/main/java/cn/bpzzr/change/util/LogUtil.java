package cn.bpzzr.change.util;

import android.util.Log;

/**
 * Created by ZYY
 * on 2016/11/14 20:58.
 */

public class LogUtil {
    public static boolean isShowLog = true;
    private static String TAG = LogUtil.class.getSimpleName();

    public static void d(String tag, String msg) {
        if (isShowLog) {
            Log.d(tag, msg);
        }
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
