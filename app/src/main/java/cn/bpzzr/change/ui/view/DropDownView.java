package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import cn.bpzzr.change.R;

/**
 * Created by Administrator on 2018/2/23.
 * 下拉筛选控件
 */

public class DropDownView extends LinearLayout {
    /**
     * 控件的最大高度
     */
    private int mMaxHeight;

    /**
     * 筛选菜单的容器
     */
    LinearLayout mFilterContainer;
    /**
     * 页面容器，不同的菜单对应的页面会有所不同
     */
    FrameLayout mPageContainer;
    /**
     * 重置按钮
     */
    Button mBtnReset;
    /**
     * 确定按钮
     */
    Button mBtnSure;
    /**
     * 按钮栏，底部栏容器
     */
    LinearLayout mLLBottom;
    /**
     * 是否显示底部按钮栏，true为显示
     */
    private boolean isShowBottom;

    ViewGroup.LayoutParams params;

    public DropDownView(Context context) {
        this(context, null);
    }

    public DropDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //设置布局方向，垂直布局
        setOrientation(VERTICAL);
        //Menu的布局参数
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 1);
        //加载基本布局，找到基本控件
        View rootView = View.inflate(context, R.layout.drop_down_layout, this);
        mFilterContainer = rootView.findViewById(R.id.ll_filter_condition);
        mPageContainer = rootView.findViewById(R.id.fl_page);
        mLLBottom = rootView.findViewById(R.id.ll_bottom);
        mBtnReset = rootView.findViewById(R.id.btn_reset);
        mBtnSure = rootView.findViewById(R.id.btn_sure);


    }


    public boolean isShowBottom() {
        return isShowBottom;
    }

    /**
     * 设置是否显示底部按钮栏
     *
     * @param showBottom 显示值
     */
    public void setShowBottom(boolean showBottom) {
        isShowBottom = showBottom;
    }

    /**
     * 显示筛选条件对应的页面
     */
    private void show() {
        mPageContainer.setVisibility(VISIBLE);
        mLLBottom.setVisibility(isShowBottom ? VISIBLE : GONE);
    }

    /**
     * 隐藏筛选条件对应的页面
     */
    private void hide() {
        mPageContainer.setVisibility(GONE);
        mLLBottom.setVisibility(GONE);
    }
}
