package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import cn.bpzzr.change.R;

/**
 * Created by Administrator on 2018/1/11.
 * 自定义文本输入框
 */

public class CustomEditText extends LinearLayout {
    @DrawableRes
    private int mLeftImgRes;       //左边的图标
    @DrawableRes
    private int mRightImgResFirst; //右边第一个图标
    @DrawableRes
    private int mRightImgResSecond;//右边第二个图标
    private int mTextColor; //文字颜色
    private int mHintColor; //提示文字颜色
    private int mTextSize;  //文字大小
    private int mBackgroundColor; //背景颜色
    private int mPaddingStart; //输入框距左图的边距
    private int mPaddingEnd;   //输入框距右图的边距
    private int mPaddingBottom;//输入框距底部分割线的边距
    private boolean mShowDivideLine; //是否显示分割线，true 显示
    private boolean mShowImgLeft;   //是否显示左边的图标
    private boolean mShowImgRightF; //是否显示右边的第一个图标
    private boolean mShowImgRightS; //是否显示右边的第二个图标

    public CustomEditText(Context context) {
        this(context, null);
    }

    public CustomEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomEditText, 0, 0);
        mLeftImgRes = typeArray.getResourceId(R.styleable.CustomEditText_mLeftImgRes, R.drawable.phone);
        mRightImgResFirst = typeArray.getResourceId(R.styleable.CustomEditText_mRightImgResFirst, R.drawable.phone);
        mRightImgResSecond = typeArray.getColor(R.styleable.CustomEditText_mRightImgResSecond, R.drawable.phone);
        mTextColor = typeArray.getColor(R.styleable.CustomEditText_mTextColor,0xFFFFFF);
        mHintColor = typeArray.getColor(R.styleable.CustomEditText_mHintColor, 0x99FFFFFF);
//        mTextSize = typeArray.getBoolean(R.styleable.MyEditText_isShow, false);
//        mBackgroundColor = typeArray.getBoolean(R.styleable.MyEditText_isShowDivideLine, false);
//        mPaddingStart = typeArray.getBoolean(R.styleable.MyEditText_notShowImg2, false);
    }
}
