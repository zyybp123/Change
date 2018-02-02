package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;

/**
 * Created by Administrator on 2018/1/27.
 * 主页
 */

public class HomeFragment extends BaseFragmentRefreshPage {

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return null;
    }

    @Override
    protected void onceRequest() {

    }


    @Override
    public void onError(String tag, String msg) {

    }

    @Override
    public void onSuccess(String tag, String result, Object data) {

    }

    @Override
    public void onEmpty(String tag) {

    }



    @Override
    protected void refreshRequest() {

    }

    @Override
    protected void loadMoreRequested() {

    }
}
