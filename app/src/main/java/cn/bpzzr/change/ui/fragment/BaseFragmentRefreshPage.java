package cn.bpzzr.change.ui.fragment;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bpzzr.change.R;
import cn.bpzzr.change.ui.view.StateLayout;
import cn.bpzzr.change.util.LogUtil;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by ZYY
 * on 2018/1/16 21:36.
 * 可刷新的Fragment页面基类
 *
 * @author ZYY
 */

public abstract class BaseFragmentRefreshPage<T> extends BaseFragment {
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
    @BindView(R.id.m_recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.m_ptr_classic_frame_layout)
    public PtrClassicFrameLayout mPtrClassicFrameLayout;
    @BindView(R.id.m_state_layout)
    public StateLayout mStateLayout;
    public int currentPage = 1;
    public boolean isRefreshing;
    public boolean hasMore;
    /**
     * 数据列表
     */
    public List<T> mDataList = new ArrayList<>();
    /**
     * 数据适配器
     */
    public RecyclerView.Adapter mAdapter;
    /**
     * 布局管理器
     */
    public RecyclerView.LayoutManager mLayoutManager;

    @Override
    public int getRootViewLayoutId() {
        return R.layout.base_state_layout;
    }

    @Override
    public void initView() {
        mStateLayout = mRootView.findViewById(R.id.m_state_layout);
        //设置状态层，并添加列表展示页
        mStateLayout.setSuccessView(R.layout.base_fragment_refresh);
    }

    @Override
    public void viewHasBind() {
        //初始化控件
        if (!isNeedHeader()) {
            customTbLl.setVisibility(View.GONE);
        }
        //下拉刷新，开启调试，打印log
        LogUtil.setPtrLog();
        //设置刷新控制
        mPtrClassicFrameLayout.setPtrHandler(new MyPtrHandler(isCanRefresh(), mRecyclerView));
        //设置水平不冲突
        mPtrClassicFrameLayout.disableWhenHorizontalMove(true);
        //设置布局管理器
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            this.mLayoutManager = layoutManager;
            mRecyclerView.setLayoutManager(layoutManager);
        } else {
            LogUtil.e(mFragmentTag + getTag(), "............mLayoutManager is null..........");
        }
        //设置数据适配器
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            this.mAdapter = adapter;
            mRecyclerView.setAdapter(this.mAdapter);
        } else {
            LogUtil.e(mFragmentTag + getTag(), "............Adapter is null.........");
        }
        //屏蔽闪烁动画
        ((DefaultItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        //设置滑动状态监听器
        mRecyclerView.addOnScrollListener(new HasMoreDataScrollListener());
    }


    /**
     * 是否需要toolBar
     *
     * @return true为需要
     */
    public abstract boolean isNeedHeader();

    /**
     * 是否能下拉刷新
     *
     * @return true为可以下拉刷新
     */
    public abstract boolean isCanRefresh();

    /**
     * 设置布局管理器
     *
     * @return 返回布局管理器
     */
    public abstract RecyclerView.LayoutManager getLayoutManager();

    /**
     * 由外部传入adapter,给recyclerView设置数据
     */
    public abstract RecyclerView.Adapter getAdapter();

    /**
     * 做下拉刷新的操作
     */
    public void doRefresh() {
        refreshRequest();
        onRefreshing();
    }

    /**
     * 需要下拉刷新的请求
     */
    protected abstract void refreshRequest();

    /**
     * 在刷新
     */
    public void onRefreshing() {
        isRefreshing = true;
        currentPage = 1;
    }

    /**
     * 重置数据集合
     */
    public void reSetDataSet() {
        if (isRefreshing) {
            mDataList.clear();
            isRefreshing = false;
        }
    }

    /**
     * 刷新完成
     */
    public void refreshComplete() {
        if (mPtrClassicFrameLayout != null) {
            mPtrClassicFrameLayout.refreshComplete();
        }
    }

    /**
     * 展示加载中
     */
    public void showLoading() {
        if (!mPtrClassicFrameLayout.isRefreshing()) {
            mStateLayout.showLoading();
        }
    }

    /**
     * 展示加载中
     */
    public void showLoading(String tips) {
        if (!mPtrClassicFrameLayout.isRefreshing()) {
            mStateLayout.showLoading(tips);
        }
    }

    /**
     * 显示空界面
     *
     * @param imgResId 图片资源id
     * @param tips     提示语
     */
    public void showEmpty(@DrawableRes int imgResId, String tips) {
        if (mDataList.size() == 0) {
            mStateLayout.showEmpty(imgResId, tips);
        }
    }

    /**
     * 显示空界面
     */
    public void showEmpty() {
        if (mDataList.size() == 0) {
            mStateLayout.showEmpty();
        }
    }

    /**
     * 显示失败界面
     *
     * @param imgResId 图片资源id
     * @param tips     提示语
     */
    public void showFailure(@DrawableRes int imgResId, String tips) {
        mStateLayout.showFailure(imgResId, tips);
    }

    /**
     * 显示失败界面
     */
    public void showFailure() {
        mStateLayout.showFailure();
    }

    /**
     * 显示成功界面
     */
    public void showSuccess() {
        mStateLayout.showSuccessView();
        refreshComplete();
        reSetDataSet();
    }

    /**
     * 自动刷新
     */
    public void autoRefresh() {
        onRefreshing();
        mPtrClassicFrameLayout.autoRefresh();
    }

    /**
     * 上拉加载更多
     * 当滚动状态发生变化的时候被调用
     * newState 为 0 说明是 静止状态，为 1 说明是开始滚动，为 2 说明是开始惯性滚动
     */
    private class HasMoreDataScrollListener extends RecyclerView.OnScrollListener {
        @Override

        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            loadMore(recyclerView, newState);
            // 获取当前可见的最后一个条目位置
            RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
            if (manager instanceof LinearLayoutManager) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) manager;
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (mDataList != null && mDataList.size() > 0) {
                    if (newState == 0 && lastVisibleItemPosition == mDataList.size() - 1 && hasMore) {
                        // 如果状态变为 静止， 则直接加载下一页数据
                        currentPage++;
                        loadMore();
                    }
                }
            }
        }
    }

    /**
     * 由子类来实现的加载更多的方法
     * 线性布局管理器时
     */
    protected abstract void loadMore();

    /**
     * 允许子类自己复写，自定义上拉加载更多的方法
     *
     * @param recyclerView 控件
     * @param newState     状态
     */
    private void loadMore(RecyclerView recyclerView, int newState) {

    }


    /**
     * 实现PtrHandler接口的类，
     * 处理下拉刷新的上下滑动冲突以及控制是否下拉刷新
     */
    public class MyPtrHandler implements PtrHandler {
        private boolean isCanRefresh;
        private RecyclerView mRecyclerView;

        public MyPtrHandler(boolean isCanRefresh, RecyclerView mRecyclerView) {
            this.isCanRefresh = isCanRefresh;
            this.mRecyclerView = mRecyclerView;
        }

        @Override
        public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
            return isCanRefresh && !mRecyclerView.canScrollVertically(-1);
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            doRefresh();
        }
    }

    /**
     * 返回线性布局管理器
     *
     * @param context     上下文
     * @param orientation 布局方向
     */
    @NonNull
    public static LinearLayoutManager getLinearLayoutManager(Context context, int orientation) {
        return new LinearLayoutManager(context, orientation, false);
    }

    /**
     * 返回网格布局管理器
     *
     * @param context     上下文
     * @param spanCount   行或列的数目
     * @param orientation 布局方向
     */
    @NonNull
    public static GridLayoutManager getGridLayoutManager(Context context, int spanCount, int orientation) {
        return new GridLayoutManager(context, spanCount, orientation, false);
    }

    /**
     * 获取瀑布流布局管理器
     *
     * @param spanCount   行或列数
     * @param orientation 布局方向
     */
    @NonNull
    public static StaggeredGridLayoutManager getStaggeredGridLayoutManager(int spanCount, int orientation) {
        return new StaggeredGridLayoutManager(spanCount, orientation);
    }
}
