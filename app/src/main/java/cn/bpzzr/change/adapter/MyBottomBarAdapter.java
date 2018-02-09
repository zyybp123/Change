package cn.bpzzr.change.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.BottomBarBean;
import cn.bpzzr.change.ui.view.BottomBar;
import cn.bpzzr.change.ui.view.BottomBarTab;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;

/**
 * Created by Administrator on 2018/1/26.
 * 主页底部导航栏的数据适配器
 */

public class MyBottomBarAdapter extends BottomBar.BottomBarAdapter {
    private List<BottomBarBean> bottomBarBeen;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private OnSelectedListener listener;

    /**
     * 构造
     *
     * @param bottomBarBeen   底部导航栏相关数据
     * @param fragmentManager Fragment管理器
     * @param listener        点击事件监听器
     */
    public MyBottomBarAdapter(List<BottomBarBean> bottomBarBeen, FragmentManager fragmentManager,
                              OnSelectedListener listener) {
        this.bottomBarBeen = bottomBarBeen;
        this.fragmentManager = fragmentManager;
        this.listener = listener;
    }

    @Override
    public int getTabCount() {
        return bottomBarBeen == null ? 0 : bottomBarBeen.size();
    }

    @Override
    public View getTabView(BottomBar parent, int position) {
        BottomBarTab barTab = new BottomBarTab(parent.getContext());
        barTab.setBadgeHide();
        barTab.setDotHide();
        BottomBarBean bottomBarBean = bottomBarBeen.get(position);
        barTab.setMBottomBarBean(bottomBarBean);
        return barTab;
    }

    @Override
    public void onItemClick(View itemView, BottomBar parent, int position) {
        if (canDoIt(position)) {
            Fragment fragment = getFragment(position);
            //将选中事件带出
            if (listener != null) {
                listener.onSelected(itemView, fragment, bottomBarBeen.get(position), position);
            }
        }
    }

    @NonNull
    private Fragment getFragment(int position) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = bottomBarBeen.get(position).getFragment();
        String title = position + bottomBarBeen.get(position).getTitle();
        if (fragment.isAdded()) {
            if (currentFragment != null) {
                //隐藏之前的Fragment
                fragmentTransaction.hide(currentFragment);
            }
            //如果被点击的Fragment已经添加了,直接显示
            fragmentTransaction.show(fragment).commit();
        } else {
            if (currentFragment != null) {
                //隐藏之前的Fragment
                fragmentTransaction.hide(currentFragment);
            }
            //被点击Fragment还没添加,先添加,后显示
            fragmentTransaction.add(R.id.frame_layout_container, fragment, title).show(fragment).commit();
        }
        //将选中的Fragment置为当前Fragment
        currentFragment = fragment;
        return fragment;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    /**
     * 设置默认选中的标签
     *
     * @param position 索引
     */
    public void setDefaultPosition(int position) {
        if (canDoIt(position)) {
            getFragment(position);
        }
    }

    private boolean canDoIt(int position) {
        if (fragmentManager == null) {
            LogUtil.e(msgTag, "fragmentManager is null........");
            return false;
        }
        if (bottomBarBeen == null) {
            LogUtil.e(msgTag, "bottomBarBeen is null........");
            return false;
        }
        if (position < 0) {
            position = 0;
        }
        if (position >= bottomBarBeen.size()) {
            position = bottomBarBeen.size() - 1;
        }
        BottomBarBean bottomBarBean = bottomBarBeen.get(position);
        if (bottomBarBean == null) {
            LogUtil.e(msgTag, "bottomBarBean is null........");
            return false;
        }
        Fragment fragment = bottomBarBean.getFragment();
        if (fragment == null) {
            LogUtil.e(msgTag, "fragment is null........");
            return false;
        }
        return true;
    }

    /**
     * 选中监听器
     */
    public interface OnSelectedListener {
        /**
         * 选中回调
         *
         * @param itemView        条目View对象
         * @param currentFragment 当前fragment
         * @param bottomBarBean   此条目的数据
         * @param position        tab的索引
         */
        void onSelected(View itemView, Fragment currentFragment, BottomBarBean bottomBarBean, int position);
    }
}
