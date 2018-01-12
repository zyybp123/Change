package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bpzzr.change.R;

/**
 * Created by Administrator on 2018/1/12.
 * 自定义的工具栏
 */

public class CustomToolBar extends LinearLayout {
    /**
     * 自定义工具栏模式 普通标题模式，tab切换模式，搜索框模式，默认普通标题模式
     */
    public static final String MODEL_TITLE = "modelTitle";
    public static final String MODEL_TAB = "modelTab";
    public static final String MODEL_SEARCH = "modelSearch";

    private String mModel = MODEL_TITLE;


    public CustomToolBar(@NonNull Context context) {
        this(context, null);
    }

    public CustomToolBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolBar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomToolBar, 0, 0);
        mModel = typeArray.getString(R.styleable.CustomToolBar_ctbModel);
        initView(context);
    }

    View mRootView;
    @BindView(R.id.custom_tb_left_container)
    FrameLayout customTbLeftContainer;
    @BindView(R.id.custom_tb_center_container)
    FrameLayout customTbCenterContainer;
    @BindView(R.id.custom_tb_right_container)
    FrameLayout customTbRightContainer;
    @BindView(R.id.ctb_iv_left)
    ImageView ctbIvLeft;
    @BindView(R.id.ctb_tv_title)
    TextView ctbTvTitle;
    @BindView(R.id.ctb_st_tab)
    SegmentTabLayout ctbStTab;
    @BindView(R.id.ctb_iv_right_f)
    ImageView ctbIvRightF;
    @BindView(R.id.ctb_iv_right_s)
    ImageView ctbIvRightS;
    @BindView(R.id.ctb_ll_right)
    LinearLayout ctbLlRight;
    @BindView(R.id.ctb_pb_loading)
    ProgressBar ctbPbLoading;

    private void initView(Context context) {
        mRootView = View.inflate(context, R.layout.custom_tool_bar, this);
        ButterKnife.bind(this, mRootView);
        switch (mModel) {
            case MODEL_TITLE:
                loadModelTitle(context);
                break;
            case MODEL_TAB:
                break;
            case MODEL_SEARCH:
                break;
            default:
                break;
        }
    }

    private void loadModelTitle(Context context) {
        //加载普通标题布局
        ctbStTab.setVisibility(GONE);
        int childCount = ctbLlRight.getChildCount();

    }
}
