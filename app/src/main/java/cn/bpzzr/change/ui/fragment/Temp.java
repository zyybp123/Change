package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.bpzzr.change.adapter.Adapter2Test;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.net.ServerPath;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by ZYY
 * on 2018/1/19 23:07.
 */

public class Temp extends BaseFragmentRefreshPage {

    public static Temp newInstance(String text) {
        Temp fragmentOne = new Temp();
        Bundle bundle = new Bundle();
        bundle.putString("name", text);
        //fragment保存参数，传入一个Bundle对象
        fragmentOne.setArguments(bundle);
        return fragmentOne;
    }

    @Override
    public boolean isNeedLazy() {
        return true;
    }

    @Override
    public boolean isNeedHeader() {
        return false;
    }

    @Override
    public boolean isCanRefresh() {
        return true;
    }

    @Override
    public void initialRequest() {
        getRequest();
    }

    private void getRequest() {
        retrofitTools.getTest3(this);
    }

    @Override
    public void viewHasBind() {
        super.viewHasBind();
    }

    @Override
    public void onRequestStart(String tag) {
        //showLoading();
        autoRefresh();
    }

    @Override
    public void onError(String tag, String msg) {
        showFailure();
    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        LogUtil.e(mFragmentTag, "...result..." +
                data);
        showSuccess();
        if (ServerPath.GANK_ANDROID.equals(tag)) {
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null && results.size() > 0) {
                    mDataList.addAll(results);
                    mAdapter.notifyDataSetChanged();
                    hasMore = true;
                } else {
                    hasMore = false;
                }
                if (mDataList.size() == 0) {
                    mStateLayout.showEmpty();
                }
            } else {
                mStateLayout.showEmpty();
            }
        }
    }


    @Override
    public void onEmpty(String tag) {

    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL);
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new Adapter2Test(mDataList);
    }


    @Override
    protected void loadMore() {
        LogUtil.e("加载更多数据。。。。。");
    }
}
