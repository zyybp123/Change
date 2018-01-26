package cn.bpzzr.change.adapter;

import android.view.View;

import java.util.List;

import cn.bpzzr.change.bean.BottomBarBean;
import cn.bpzzr.change.ui.view.BottomBar;
import cn.bpzzr.change.ui.view.BottomBarTab;

/**
 * Created by Administrator on 2018/1/26.
 * 主页底部导航栏的数据适配器
 */

public class MyBottomBarAdapter extends BottomBar.BottomBarAdapter {
    List<BottomBarBean> bottomBarBeen;

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
        //getSupportFragmentManager();
    }
}
