package cn.bpzzr.change.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.MyBottomBarAdapter;
import cn.bpzzr.change.bean.BottomBarBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.manager.MyActivityManager;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.interf.ServerPath;
import cn.bpzzr.change.ui.activity.base.BaseActivity;
import cn.bpzzr.change.ui.fragment.CategoryFragment;
import cn.bpzzr.change.ui.fragment.DiscoveryFragment;
import cn.bpzzr.change.ui.fragment.HomeFragment;
import cn.bpzzr.change.ui.fragment.MineFragment;
import cn.bpzzr.change.ui.fragment.Temp;
import cn.bpzzr.change.ui.fragment.Temp2;
import cn.bpzzr.change.util.LogUtil;

public class HomeActivity extends BaseActivity implements MyBottomBarAdapter.OnSelectedListener {
    /**
     * 主页选中图标
     */
    public static final int[] BGS_SELECTED = new int[]{
            R.drawable.maintab_stack_icon_press,
            R.drawable.maintab_category_icon_hover,
            R.drawable.maintab_city_icon_hover,
            R.drawable.maintab_stack_icon_press
    };
    /**
     * 主页未选中图标
     */
    public static final int[] BGS_UN_SELECTED = new int[]{
            R.drawable.maintab_stack_icon,
            R.drawable.maintab_category_icon,
            R.drawable.maintab_city_icon,
            R.drawable.maintab_stack_icon
    };
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        //获取主页的title数组
        String[] titles = getResources().getStringArray(R.array.home_tab_title);
        //fragment生成
        fragmentList = new ArrayList<>();
        //fragmentList.add(Temp.newInstance("1"));
        fragmentList.add(new HomeFragment());
        //fragmentList.add(new CategoryFragment());
        fragmentList.add(new Temp2());
        fragmentList.add(new DiscoveryFragment());
        fragmentList.add(new MineFragment());
        //fragment的数量必须和title的数量保持一致
        List<BottomBarBean> bottomBarBeen = new ArrayList<>();
        //数据填充
        for (int i = 0; i < titles.length; i++) {
            bottomBarBeen.add(new BottomBarBean(
                    BGS_UN_SELECTED[i], BGS_SELECTED[i], titles[i], i == 0, fragmentList.get(i)));
        }

        //设置Adapter
        MyBottomBarAdapter adapter = new MyBottomBarAdapter(bottomBarBeen, getFragmentManager(), this);
        baseBottomBar.setAdapter(adapter);
        //默认选中第一页
        adapter.setDefaultPosition(0);
        //不要toolbar
        customTbLl.setVisibility(View.GONE);
        //控制消息的数量
        /*BottomBarTab barTab = (BottomBarTab) baseBottomBar.getBarTab(2);
        barTab.setBadgeText(120);
        BottomBarTab barTab2 = (BottomBarTab) baseBottomBar.getBarTab(1);
        barTab2.setDotShow();*/
        //setTrans(adapter.getCurrentFragment());
    }

    /**
     * 动态切换状态栏
     *
     * @param fragment 当前的Fragment
     */
    private void setTrans(Fragment fragment) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option;
            //仅在5.0以后才做此操作
            if (fragment instanceof HomeFragment) {
                //如果是主页就透明状态栏
                option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                //不是主页就正常状态栏
                option = View.SYSTEM_UI_FLAG_VISIBLE;
                getWindow().setStatusBarColor(getTheme().getResources().getColor(R.color.colorPrimary));
            }
            decorView.setSystemUiVisibility(option);
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
        /*instance = RetrofitTools.getInstance(ServerHost.BASE_URL_BOOK);
        instance.getTest(this);
        instance.getTest2(this);
        instance.getTest3(this);*/
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

    @Override
    public void onSelected(View itemView, Fragment currentFragment, BottomBarBean bottomBarBean, int position) {
        //选中事件的监听
        /*if (position == 0) {
            //刷新首页数据
            if (currentFragment instanceof Temp) {
                ((Temp) currentFragment).autoRefresh();
            }
        }*/
        HomeFragment homeFragment = (HomeFragment) fragmentList.get(0);
        Banner banner = (Banner) homeFragment
                .getAdapter()
                .getViewByPosition(homeFragment.mRecyclerView, 0, R.id.base_banner);
        //setTrans(currentFragment);
        if (banner != null) {
            if (!(currentFragment instanceof HomeFragment)) {
                banner.stopAutoPlay();

            } else {
                banner.startAutoPlay();
            }
        }
    }
}
