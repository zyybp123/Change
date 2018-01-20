package cn.bpzzr.change.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.PagerAdapter;

import java.util.List;

import cn.bpzzr.change.adapter.base.BaseFragmentPagerAdapter;
import cn.bpzzr.change.bean.BaseFragmentPagerBean;

/**
 * Created by ZYY
 * on 2018/1/20 10:44.
 * Fragment Pager Adapter管理多页面
 * @author ZYY
 */

public class MyFragmentPagerAdapter<T> extends BaseFragmentPagerAdapter {
    private List<BaseFragmentPagerBean<T>> mFragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragmentPagerAdapter(FragmentManager fm, List<BaseFragmentPagerBean<T>> mFragmentList) {
        super(fm);
        this.mFragmentList = mFragmentList;
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).mFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentList.get(position).mTitleBean.toString();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
