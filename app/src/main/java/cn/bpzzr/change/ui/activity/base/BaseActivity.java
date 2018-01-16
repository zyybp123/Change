package cn.bpzzr.change.ui.activity.base;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bpzzr.change.R;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.ui.view.BottomBar;
import cn.bpzzr.change.util.KeyBoardUtils;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.UiUtil;

/**
 * Created by Administrator on 2018/1/4.
 * activity 基础类
 */

public abstract class BaseActivity extends AppCompatActivity implements MVP.View, MVP.Presenter, View.OnClickListener {
    //屏幕的宽高
    public int screenWidth;
    public int screenHeight;
    public String mLogTag;
    @BindView(R.id.ctb_iv_left)
    public ImageView ctbIvLeft;
    @BindView(R.id.custom_tb_left_container)
    public FrameLayout customTbLeftContainer;
    @BindView(R.id.ctb_tv_title)
    public TextView ctbTvTitle;
    @BindView(R.id.ctb_st_tab)
    public SegmentTabLayout ctbStTab;
    @BindView(R.id.custom_tb_center_container)
    public FrameLayout customTbCenterContainer;
    @BindView(R.id.ctb_iv_right_f)
    public ImageView ctbIvRightF;
    @BindView(R.id.ctb_iv_right_s)
    public ImageView ctbIvRightS;
    @BindView(R.id.ctb_ll_right)
    public LinearLayout ctbLlRight;
    @BindView(R.id.ctb_pb_loading)
    public ProgressBar ctbPbLoading;
    @BindView(R.id.custom_tb_right_container)
    public FrameLayout customTbRightContainer;
    @BindView(R.id.custom_tb_ll)
    public LinearLayout customTbLl;
    @BindView(R.id.base_root_view)
    public LinearLayout baseRootView;
    @BindView(R.id.frame_layout_container)
    public FrameLayout frameLayoutContainer;
    @BindView(R.id.base_bottom_bar)
    public BottomBar baseBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Point totalSize = UiUtil.totalSize(this);
        screenWidth = totalSize.x;
        screenHeight = totalSize.y;
        mLogTag = this.getClass().getSimpleName();
        LogUtil.e(mLogTag, "screenWidth..." + screenWidth + "...screenHeight..." + screenHeight);
        //初始化请求
        initialRequest();
        initView();
    }


    /**
     * 由子类实现的初始化方法
     */
    public abstract void initView();


    /**
     * 清除editText的焦点
     *
     * @param v   焦点所在View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
        }
    }

    /**
     * 隐藏键盘
     *
     * @param v   焦点所在View
     * @param ids 输入框
     * @return true代表焦点在edit上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    //是否触摸在指定view上面,对某个控件过滤
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) {
            return false;
        }
        int[] location = new int[2];
        for (View view : views) {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }
    //endregion

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) {
                return super.dispatchTouchEvent(ev);
            }
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0) {
                return super.dispatchTouchEvent(ev);
            }
            View v = getCurrentFocus();
            if (isFocusEditText(v, hideSoftByEditViewIds())) {
                //隐藏键盘
                KeyBoardUtils.hideInputForce(this);
                //clearViewFocus(v, hideSoftByEditViewIds());
            }
        }
        return super.dispatchTouchEvent(ev);

    }

    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理
     *
     * @return id 数组
     */
    public int[] hideSoftByEditViewIds() {
        return null;
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }
}
