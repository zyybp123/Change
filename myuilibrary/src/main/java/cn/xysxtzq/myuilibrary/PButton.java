package cn.xysxtzq.myuilibrary;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/5/7.
 * 自定义的按钮
 * <p>
 * 1.指定圆角的大小。
 * 2.分别指定不同方向的圆角大小。
 * 3.指定圆角的大小为高度的一半，并跟随高度变化自适应圆角大小。
 * 4.支持分别指定背景色和边框色，指定颜色时支持使用 color 或 ColorStateList
 */

public class PButton extends AppCompatButton {
    public PButton(Context context) {
        super(context);
    }

    public PButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
