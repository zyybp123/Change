package cn.bpzzr.change.ui.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2Home;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.ServerPath;
import cn.bpzzr.change.ui.activity.HomeActivity;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.ui.view.MyScrollListener;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.UiUtil;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static cn.bpzzr.change.adapter.Adapter2Home.ITEM_BANNER;
import static cn.bpzzr.change.adapter.Adapter2Home.ITEM_CARD;
import static cn.bpzzr.change.adapter.Adapter2Home.ITEM_NORMAL;

/**
 * Created by Administrator on 2018/1/27.
 * 主页
 */

public class HomeFragment extends BaseFragmentRefreshPage {

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(mActivity, VERTICAL);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return new Adapter2Home(mDataList, Temp.urls);
    }

    @Override
    public void successViewBind() {
        //为RecyclerView添加滑动状态监听器
        /*mRecyclerView.addOnScrollListener(new MyScrollListener(
                screenHeight - mActivity.getResources().getDimensionPixelSize(R.dimen.dp_62)
                , LinearLayoutManager.VERTICAL, mRecyclerView));*/
    }

    private void setTrans(float trans) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option;
            //仅在5.0以后才做此操作
            if (trans <= 0.2) {
                //如果是主页就透明状态栏
                option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

                mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                //不是主页就正常状态栏
                option = View.SYSTEM_UI_FLAG_VISIBLE;
                mActivity.getWindow().setStatusBarColor(mActivity.getTheme().getResources().getColor(R.color.colorPrimary));
            }
            decorView.setSystemUiVisibility(option);
        }
        //view不根据系统窗口来调整自己的布局
        ViewGroup mContentView = (ViewGroup) mActivity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            mChildView.setFitsSystemWindows(false);
            //ViewCompat.setFitsSystemWindows(mChildView, false);
            ViewCompat.requestApplyInsets(mChildView);
        }
    }

    @Override
    protected void onceRequest() {
        hasMore = false;
        //retrofitTools.getTest3(this);
    }

    @Override
    protected void refreshRequest() {
        retrofitTools.getTest3(this);
    }

    @Override
    protected void loadMoreRequested() {
    }

    @Override
    public void onError(String tag, String msg) {
        if (hasMore) {
            (mAdapter).loadMoreFail();
        } else {
            showFailure();
        }
    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        if (ServerPath.GANK_ANDROID.equals(tag)) {
            showSuccess();
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null && results.size() > 0) {
                    for (int i = 0; i < results.size(); i++) {
                        results.get(i).setItemType(ITEM_NORMAL);
                        mDataList.add(results.get(i));
                    }
                    mDataList.addAll(results);
                    GankTest.ResultsBean resultsBean = new GankTest.ResultsBean();
                    resultsBean.setItemType(ITEM_BANNER);
                    mDataList.add(0, resultsBean);

                    GankTest.ResultsBean resultsBean1 = new GankTest.ResultsBean();
                    resultsBean1.setItemType(ITEM_CARD);
                    mDataList.add(1, resultsBean1);
                    mAdapter.notifyDataSetChanged();
                } else {
                    showEmpty();
                }
                if (mDataList.size() == 0) {
                    showEmpty();
                }
            } else {
                showEmpty();
            }
        }
    }

    @Override
    public void onEmpty(String tag) {

    }

    /*new RecyclerView.OnScrollListener() {
        private int yLength;
        private int xLength;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            //状态值改变
            RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
            if (manager instanceof LinearLayoutManager) {
                //
                int position = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
                int itemViewType = manager.getItemViewType(recyclerView.getChildAt(position));
                LogUtil.e("itemViewType......" + itemViewType);
            }
        }

        *//**
     * RecyclerView的滑动回调
     * @param recyclerView RecyclerView
     * @param dx 每次滑动时，x轴的偏移量，大于0时向左
     * @param dy 每次滑动时，y轴的偏移量，大于0时向上
     *//*
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //将滑动距离进行叠加可以按百分比做一些处理
            yLength += dy;
            xLength += dx;
            //滑动监听
            LogUtil.e("scroll..." + dy);
            if (mActivity instanceof HomeActivity) {

                int bannerH = getResources().getDimensionPixelSize(R.dimen.dp200);
                float tran = 1;
                if (yLength <= bannerH) {
                    tran = Math.abs(yLength) * 1f / bannerH;
                }
                int i = UiUtil.changeAlpha(mActivity.getResources().getColor(android.R.color.transparent),
                        Math.abs(tran)
                );
                //((HomeActivity) mActivity).customTbLl.setBackgroundColor(i);
                //setTrans(tran);

            }
        }
    }*/


}
