package cn.bpzzr.change.bean;

import android.app.Fragment;

/**
 * Created by ZYY
 * on 2018/1/20 11:10.
 * 适配FragmentPager数据实体
 */

public class BaseFragmentPagerBean<T> {
    //要加载的Fragment
    public Fragment mFragment;
    //装载标题的实体，标签的toString方法必须实现以关联标题
    public T mTitleBean;

    public BaseFragmentPagerBean(Fragment mFragment, T mTitleBean) {
        this.mFragment = mFragment;
        this.mTitleBean = mTitleBean;
    }
}
