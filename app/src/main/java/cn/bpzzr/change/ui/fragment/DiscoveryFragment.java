package cn.bpzzr.change.ui.fragment;

import cn.bpzzr.change.R;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/26.
 * 发现页
 */

public class DiscoveryFragment extends BaseFragment {
    @Override
    public boolean isNeedLazy() {
        return false;
    }

    @Override
    public int getRootViewLayoutId() {
        return R.layout.fragment_discovery;
    }


    @Override
    public void viewHasBind() {

    }

    @Override
    public void initialRequest() {

    }



}
