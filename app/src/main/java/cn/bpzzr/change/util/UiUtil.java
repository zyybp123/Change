package cn.bpzzr.change.util;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2018/1/12.
 * 处理界面相关问题的工具类
 */

public class UiUtil {
    /**
     * 以1080*1920为基准分辨率
     */

    private UiUtil() {

    }

    /**
     * 获取屏幕的宽高
     *
     * @param context 上下文
     * @return 返回 Point x为宽，y为高
     */
    @NonNull
    public static Point totalSize(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int mTotalWidth = dm.widthPixels;
        int mTotalHeight = dm.heightPixels;
        return new Point(mTotalWidth, mTotalHeight);
    }

    /**
     * 根据基准设备的宽获取目标设备的宽
     *
     * @param context             上下文
     * @param standardScreenValue 基准设备的屏幕宽度
     * @param standardValue       在基准设备上的值
     * @return 返回在目标设备上的宽
     */
    public static int getActualWidth(Context context, int standardScreenValue, int standardValue) {
        int targetScreenWidth = totalSize(context).x;
        return standardValue * targetScreenWidth / standardScreenValue;
    }

    /**
     * 根据基准设备的宽获取目标设备的高
     *
     * @param context             上下文
     * @param standardScreenValue 基准设备的屏幕高度
     * @param standardValue       在基准设备上的值
     * @return 返回在目标设备上的高
     */
    public static int getActualHeight(Context context, int standardScreenValue, int standardValue) {
        int targetScreenHeight = totalSize(context).y;
        return standardValue * targetScreenHeight / standardScreenValue;
    }
}
