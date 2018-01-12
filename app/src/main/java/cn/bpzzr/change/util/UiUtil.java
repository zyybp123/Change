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
    private UiUtil(){

    }

    @NonNull
    public static Point totalSize(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int mTotalWidth = dm.widthPixels;
        int mTotalHeight = dm.heightPixels;
        return new Point(mTotalWidth, mTotalHeight);
    }
}
