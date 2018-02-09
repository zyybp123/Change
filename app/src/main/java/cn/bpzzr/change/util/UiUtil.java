package cn.bpzzr.change.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;

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

    /**
     * 在不绘制textView的情况下算出textView的高度，并且根据最大行数得到应该显示最后一个字符的下标，
     * 请在主线程顺序执行，第一个返回值是最后一个字符的下标，第二个返回值是高度
     *
     * @param textView textView
     * @param content  文本内容
     * @param width    宽
     * @param maxLine  最大行数
     */
    public static int[] measureTextViewHeight(@NonNull TextView textView, String content, int width, int maxLine) {
        //LogUtil.e("Alex....", "宽度是" + width);
        TextPaint textPaint = textView.getPaint();
        float lineSpacingMultiplier = textView.getLineSpacingMultiplier();
        StaticLayout staticLayout = new StaticLayout(content, textPaint, width,
                Layout.Alignment.ALIGN_NORMAL, lineSpacingMultiplier, 0, false);
        int[] result = new int[2];
        if (staticLayout.getLineCount() > maxLine) {//如果行数超出限制
            int lastIndex = staticLayout.getLineStart(maxLine) - 1;
            result[0] = lastIndex;
            result[1] = new StaticLayout(content.substring(0, lastIndex), textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1, 0, false).getHeight();
            return result;
        } else {//如果行数没有超出限制
            result[0] = -1;
            result[1] = staticLayout.getHeight();
            return result;
        }
    }

    /**
     * 根据百分比改变颜色透明度
     *
     * @param color    初始的颜色
     * @param fraction 百分比
     */
    public static int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }
}
