package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;

import butterknife.BindView;
import cn.bpzzr.change.R;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * Created by ZYY
 * on 2018/1/16 21:36.
 * 可刷新的Fragment页面基类
 *
 * @author ZYY
 */

public abstract class BaseFragmentRefreshPage extends BaseFragment {
    @BindView(R.id.ctb_iv_left)
    ImageView ctbIvLeft;
    @BindView(R.id.custom_tb_left_container)
    FrameLayout customTbLeftContainer;
    @BindView(R.id.ctb_tv_title)
    TextView ctbTvTitle;
    @BindView(R.id.ctb_st_tab)
    SegmentTabLayout ctbStTab;
    @BindView(R.id.custom_tb_center_container)
    FrameLayout customTbCenterContainer;
    @BindView(R.id.ctb_iv_right_f)
    ImageView ctbIvRightF;
    @BindView(R.id.ctb_iv_right_s)
    ImageView ctbIvRightS;
    @BindView(R.id.ctb_ll_right)
    LinearLayout ctbLlRight;
    @BindView(R.id.ctb_pb_loading)
    ProgressBar ctbPbLoading;
    @BindView(R.id.custom_tb_right_container)
    FrameLayout customTbRightContainer;
    @BindView(R.id.custom_tb_ll)
    LinearLayout customTbLl;
    @BindView(R.id.m_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.m_ptr_classic_frame_layout)
    PtrClassicFrameLayout mPtrClassicFrameLayout;

    @Override
    public int getRootViewLayoutId() {
        return R.layout.base_fragment_refresh;
    }
    public abstract boolean isNeedHeader();
    @Override
    public void initView() {
        //

    }
}
