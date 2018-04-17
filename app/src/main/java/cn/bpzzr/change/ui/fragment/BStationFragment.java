package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2Test3;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;

/**
 * Created by ZYY
 * on 2018/4/5 20:57.
 */

public class BStationFragment extends BaseFragmentRefreshPage {
    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return new Adapter2Test3(R.layout.item_temp_download, mDataList);
    }

    @Override
    protected void onceRequest() {

    }

    @Override
    protected void refreshRequest() {

    }

    @Override
    protected void loadMoreRequested() {

    }
}
