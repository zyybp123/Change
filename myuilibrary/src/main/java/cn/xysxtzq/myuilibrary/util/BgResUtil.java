package cn.xysxtzq.myuilibrary.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;

/**
 * Created by Administrator on 2018/5/7.
 * 处理shape，状态选择器的工具类
 */

public class BgResUtil {

    private BgResUtil() {

    }

    /**
     * <shape xmlns:android="http://schemas.android.com/apk/res/android"
     * android:shape="ring"  //形状
     * android:useLevel="false" //是否当作drawable使用
     * android:dither="false" //抖动
     * android:innerRadius="20dp" //ring的特殊属性
     * android:innerRadiusRatio="3dp"
     * android:thickness="2dp"
     * android:thicknessRatio="3dp"
     * android:tint="@android:color/holo_red_light"
     * android:tintMode="src_over"
     * >
     * <corners
     * android:bottomLeftRadius="12dp"
     * android:bottomRightRadius="3dp"
     * android:topLeftRadius="3dp"
     * android:topRightRadius="12dp" />
     * <size
     * android:width="50dp"
     * android:height="50dp" />
     * <solid android:color="#396" />
     * <padding
     * android:bottom="1dp"
     * android:left="1dp"
     * android:right="1dp"
     * android:top="1dp" />
     * <stroke
     * android:width="1dp"
     * android:color="#234"
     * android:dashGap="3dp"
     * android:dashWidth="5dp" />
     * <gradient
     * android:angle="90"
     * android:centerColor="#FFF"
     * android:centerX="20"
     * android:centerY="20"
     * android:endColor="#963"
     * android:gradientRadius="25dp"
     * android:startColor="#369"
     * android:type="sweep"
     * android:useLevel="true" />
     * </shape>
     */

    private static GradientDrawable getDrawable(int shape, @ColorInt int color) {
        GradientDrawable drawable = new GradientDrawable();
        return drawable;
    }


    /**
     * 用代码的方式生成图片，对应XML中的shape
     *
     * @return 返回图片
     */
    public static GradientDrawable generateDrawable(int color, int strokeColor, int strokeWidth) {
        GradientDrawable drawable = new GradientDrawable();
        //设置形状，默认为矩形，RECTANGLE（矩形）, OVAL（圆）, LINE（线）, RING（环形）
        drawable.setShape(GradientDrawable.RECTANGLE);
        //shape的颜色
        drawable.setColor(color);
        //drawable.setCornerRadius(65);
        //shape的描边
        drawable.setStroke(strokeWidth, strokeColor);
        return drawable;
    }

    /**
     * 使用代码的方式生成状态选择器，对应XML中的Selector
     *
     * @return 返回状态选择器图片
     */
    public static StateListDrawable generateSelector(Drawable pressed, Drawable normal) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);//设置按下的图片
        drawable.addState(new int[]{android.R.attr.state_selected}, pressed);//设置按下的图片
        drawable.addState(new int[]{android.R.attr.state_checked}, pressed);//设置按下的图片
        drawable.addState(new int[]{}, normal);//设置默认的图片
        //添加渐变
        //drawable.setEnterFadeDuration(500);
        //drawable.setExitFadeDuration(500);
        return drawable;
    }

    public static ColorStateList getColorSelector(int pressed, int normal) {
        int[][] states = new int[][]{
                {android.R.attr.state_checked},
                {android.R.attr.state_pressed},
                {android.R.attr.state_selected},
                {}
        };
        int[] colors = new int[]{pressed, pressed, pressed, normal};
        return new ColorStateList(states, colors);
    }
}
