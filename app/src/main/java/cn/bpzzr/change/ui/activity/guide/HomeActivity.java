package cn.bpzzr.change.ui.activity.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.BottomBarBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.manager.MyActivityManager;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.net.ServerPath;
import cn.bpzzr.change.ui.activity.base.BaseActivity;
import cn.bpzzr.change.ui.view.BottomBar;
import cn.bpzzr.change.ui.view.BottomBarTab;
import cn.bpzzr.change.ui.view.StateLayout;
import cn.bpzzr.change.util.LogUtil;

public class HomeActivity extends BaseActivity {
    public static final int[] BGS_SELECTED = new int[]{
            R.drawable.maintab_stack_icon_press,
            R.drawable.maintab_category_icon_hover,
            R.drawable.maintab_city_icon_hover
    };
    public static final int[] BGS_UN_SELECTED = new int[]{
            R.drawable.maintab_stack_icon,
            R.drawable.maintab_category_icon,
            R.drawable.maintab_city_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        String[] titles = getResources().getStringArray(R.array.home_tab_title);
        final List<BottomBarBean> bottomBarBeen = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            bottomBarBeen.add(new BottomBarBean(BGS_UN_SELECTED[i], BGS_SELECTED[i], titles[i], i == 0));
        }

        baseBottomBar.setAdapter(new BottomBar.BottomBarAdapter() {
            @Override
            public int getTabCount() {
                return bottomBarBeen.size();
            }

            @Override
            public View getTabView(BottomBar parent, final int position) {
                BottomBarTab barTab = new BottomBarTab(parent.getContext());
                barTab.setBadgeHide();
                barTab.setDotHide();
                BottomBarBean bottomBarBean = bottomBarBeen.get(position);
                barTab.setMBottomBarBean(bottomBarBean);
                return barTab;
            }

            @Override
            public void onItemClick(View itemView, BottomBar parent, int position) {
                //管理页面
                //BottomBarTab barTab = (BottomBarTab) itemView;
                //barTab.setDotShow();
            }

        });
        customTbLl.setVisibility(View.GONE);

        StateLayout stateLayout = new StateLayout(this);
        frameLayoutContainer.addView(stateLayout);
        //stateLayout.showLoading();
        //stateLayout.showEmpty(R.drawable.jc_error_normal,"暂无相关数据！");
        stateLayout.showSuccessView(R.layout.base_fragment_refresh);
    }

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

    public static void startSelf(Activity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 3000) {
                //UiUtils.showMyToast("再按一次退出程序");
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                MyActivityManager.getInstance().removeALLActivity();
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    RetrofitTools instance;
    String test = "";

    @Override
    public void initialRequest() {
        instance = RetrofitTools.getInstance(ServerHost.BASE_URL_BOOK);
        instance.getTest(this);
        instance.getTest2(this);
        instance.getTest3(this);
    }

    @Override
    public void onRequestStart(String tag) {

    }

    @Override
    public void onError(String tag, String msg) {

    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        LogUtil.e("...result..." + data);
        if (tag.equals(test)) {
            LogUtil.e("test........." + test);
        }
        if (ServerPath.GANK_ANDROID.equals(tag)) {
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null) {
                    for (int i = 0; i < results.size(); i++) {
                        GankTest.ResultsBean resultsBean = results.get(i);
                        LogUtil.e("resultsBean......" + resultsBean.getDesc());
                    }
                }
            }
        }
    }

    @Override
    public void onEmpty(String tag) {

    }

    @Override
    public void onClick(View v) {

    }
}
