package cn.xysxtzq.myuilibrary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/5/7.
 * 自定义的textView
 * <p>
 * 1.指定圆角的大小。
 * 2.分别指定不同方向的圆角大小。
 * 3.支持分别指定背景色和边框色，指定颜色时支持使用 color 或 ColorStateList
 */

public class PTextView extends AppCompatTextView {
    /**
     * 圆角
     */
    float cornerRadius = 4;
    float leftTopRadius;
    float rightTopRadius;
    float rightBottomRadius;
    float leftBottomRadius;

    int color = Color.TRANSPARENT;
    ColorStateList colorStateList;

    int strokeWidth;
    int strokeColor;
    ColorStateList strokeColorStateList;
    //int

    public PTextView(Context context) {
        this(context, null);
    }

    public PTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public PTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.PTextView, 0, 0);
        color = typeArray.getColor(R.styleable.PTextView_strokeColor, color);
        colorStateList = typeArray.getColorStateList(R.styleable.PTextView_pColor);
        //mLeftImgRes = typeArray.getResourceId(R.styleable.CustomEditText_mLeftImgRes, R.drawable.phone);
    }
}
