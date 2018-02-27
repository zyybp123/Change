package cn.bpzzr.change.ui.fragment.base;

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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SegmentTabLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;

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

public abstract class BaseFragmentRefreshPage<T> extends BaseFragment implements
        BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener,
        BaseQuickAdapter.OnItemChildLongClickListener, BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.OnItemLongClickListener {
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
    public BaseQuickAdapter mAdapter;
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
        mStateLayout.setRetryListener(this);
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
        BaseQuickAdapter adapter = getAdapter();
        if (adapter != null) {
            this.mAdapter = adapter;
            mRecyclerView.setAdapter(this.mAdapter);
            mAdapter.setOnLoadMoreListener(this, mRecyclerView);
            //未满一屏，直接关闭上拉加载更多
            mAdapter.disableLoadMoreIfNotFullPage();
            mAdapter.setOnItemChildClickListener(this);
            mAdapter.setOnItemChildClickListener(this);
            mAdapter.setOnItemLongClickListener(this);
            mAdapter.setOnItemChildLongClickListener(this);
        } else {
            LogUtil.e(mFragmentTag + getTag(), "............Adapter is null.........");
        }
        //屏蔽闪烁动画
        ((DefaultItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        successViewBind();
    }

    public void successViewBind() {
        //成功View绑定后
    }

    /**
     * 默认启用懒加载
     *
     * @return true为启用懒加载
     */
    @Override
    public boolean isNeedLazy() {
        return true;
    }

    /**
     * 是否需要toolBar,默认不需要
     *
     * @return true为需要
     */
    public boolean isNeedHeader() {
        return false;
    }

    /**
     * 是否能下拉刷新,默认可以下拉刷新
     *
     * @return true为可以下拉刷新
     */
    public boolean isCanRefresh() {
        return true;
    }

    /**
     * 是否一进入页面就自动刷新,默认不自动刷新
     *
     * @return true为是
     */
    public boolean isAutoRefresh() {
        return false;
    }

    /**
     * 设置布局管理器
     *
     * @return 返回布局管理器
     */
    public abstract RecyclerView.LayoutManager getLayoutManager();

    /**
     * 由外部传入adapter,给recyclerView设置数据
     */
    public abstract BaseQuickAdapter getAdapter();

    /**
     * 初始化请求
     */
    @Override
    public void initialRequest() {
        if (isAutoRefresh()) {
            //如果要自动刷新，调用一下自动刷新的方法
            autoRefresh();
        } else {
            if (isShowLoadingFrist()) {
                //显示加载中的状态
                showLoading();
            }
            refreshRequest();
        }
        //其它只需要发起一次的请求
        onceRequest();
    }

    public boolean isShowLoadingFrist() {
        return true;
    }

    /**
     * 只需要发起一次的请求
     */
    protected abstract void onceRequest();

    /**
     * 做下拉刷新的操作
     */
    public void doRefresh() {
        //发起同下拉刷新相关的请求
        refreshRequest();
        //标识成刷新中
        onRefreshing();
    }

    /**
     * 需要下拉刷新的请求
     */
    protected abstract void refreshRequest();

    /**
     * 在刷新中
     */
    public void onRefreshing() {
        //这里的作用是防止下拉刷新的时候还可以上拉加载
        mAdapter.setEnableLoadMore(false);
        isRefreshing = true;
        currentPage = 1;
    }


    @Override
    public void onRequestStart(String tag) {
        //不进行操作
    }

    /**
     * 重置数据集合，和刷新状态
     */
    public void reSetDataSet() {
        if (isRefreshing) {
            mDataList.clear();
            isRefreshing = false;
        }
    }

    /**
     * 下拉刷新完成
     */
    public void refreshComplete() {
        if (mPtrClassicFrameLayout != null) {
            mPtrClassicFrameLayout.refreshComplete();
        }
    }

    /**
     * 上拉加载更多的请求的发起
     */
    @Override
    public void onLoadMoreRequested() {
        mAdapter.setEnableLoadMore(!isRefreshing);
        if (hasMore) {
            currentPage++;
            //还有更多数据
            loadMoreRequested();
        } else {
            //没有更多数据了
            mAdapter.loadMoreEnd();
        }
    }

    /**
     * 加载更多的请求
     */
    protected abstract void loadMoreRequested();

    /**
     * 展示加载中
     */
    public void showLoading() {
        //没有下拉刷新或上拉加载时才显示
        if (!mPtrClassicFrameLayout.isRefreshing() && !hasMore) {
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
     * 条目子控件的点击事件（有header时要处理position）
     *
     * @param adapter  数据适配器
     * @param view     条目对象
     * @param position 条目索引
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    /**
     * 条目子控件的长按事件（有header时要处理position）
     *
     * @param adapter  数据适配器
     * @param view     条目对象
     * @param position 条目索引
     */
    @Override
    public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
        return false;
    }

    /**
     * 条目的点击事件（有header时要处理position）
     *
     * @param adapter  数据适配器
     * @param view     条目对象
     * @param position 条目索引
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    /**
     * 条目的点长按事件（有header时要处理position）
     *
     * @param adapter  数据适配器
     * @param view     条目对象
     * @param position 条目索引
     */
    @Override
    public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
        return false;
    }

    /**
     * 自动刷新
     */
    public void autoRefresh() {
        onRefreshing();
        mPtrClassicFrameLayout.autoRefresh();
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

    /**
     * 获取FlexBox布局管理器
     *
     * @param context 上下文
     */
    @NonNull
    public static FlexboxLayoutManager getFlexBoxLayoutManager(Context context) {
        return new FlexboxLayoutManager(context);
    }
}
