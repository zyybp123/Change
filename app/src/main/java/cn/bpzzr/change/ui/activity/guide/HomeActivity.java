package cn.bpzzr.change.ui.activity.guide;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.BottomBarBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.bean.HomeTabEntity;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.manager.MyActivityManager;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.ui.activity.base.BaseActivity;
import cn.bpzzr.change.ui.view.BottomBar;
import cn.bpzzr.change.ui.view.BottomBarTab;
import cn.bpzzr.change.util.LogUtil;

public class HomeActivity extends BaseActivity implements MVP.View, MVP.Presenter {
    public static final int [] bgsSelected = new int[]{
            R.drawable.maintab_stack_icon_press,
            R.drawable.maintab_category_icon_hover,
            R.drawable.maintab_city_icon_hover,
            R.drawable.conversation
    };
    public static final int [] bgsUnSelected = new int[]{
            R.drawable.maintab_stack_icon,
            R.drawable.maintab_category_icon,
            R.drawable.maintab_city_icon,
            R.drawable.conversation
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_home);

    }

    @Override
    public void initView() {
        /*Button nextStep = findViewById(R.id.btn_next_step);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DemonstrationActivity.class));
            }
        });
        initialRequest();*/
        final String[] titles = getResources().getStringArray(R.array.home_tab_title);

        final List<BottomBarBean> bottomBarBeen = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            bottomBarBeen.add(new BottomBarBean(bgsSelected[i], titles[i], i == 0));
        }
        BottomBar bottomBar = new BottomBar(this);
        bottomBar.setAdapter(new BottomBar.BottomBarAdapter() {
            @Override
            public int getTabCount() {
                return bottomBarBeen.size();
            }

            @Override
            public View getTabView(BottomBar parent, int position) {
                final BottomBarTab barTab = new BottomBarTab(parent.getContext());
                barTab.setBadgeHide();
                barTab.setDotHide();
                BottomBarBean bottomBarBean = bottomBarBeen.get(position);
                barTab.setIconAndTitle(bottomBarBean.getIconRes(), bottomBarBean.getTitle(),
                        R.color.color_999, R.color.colorPrimary);
                barTab.setSelect(bottomBarBean.isSelected());
                barTab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return barTab;
            }
        });

        frameLayoutContainer.addView(bottomBar,new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        ImageView imageView = new ImageView(this);
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg" +
                        "?image&quality=80&size=b9999_10000&sec=1516008734613&" +
                        "di=977c205c3028c99615cff479eec5ca24&imgtype=0&src=http%3A%2F%2" +
                        "Fuploads.xuexila.com%2Fallimg%2F1706%2F28-1F62G42237.jpg")
                .into(imageView);
        /*frameLayoutContainer.addView(imageView,new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));*/

        customTbLl.setVisibility(View.GONE);

        ArrayList<CustomTabEntity> titleList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            titleList.add(new HomeTabEntity(titles[i],bgsSelected[i],bgsUnSelected[i]));
        }
        //baseCtlBottom.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        baseCtlBottom.setTabData(titleList);


        /*//两位数
        baseCtlBottom.showMsg(0, 55);
        baseCtlBottom.setMsgMargin(0, -5, 5);

        //三位数
        baseCtlBottom.showMsg(1, 100);
        baseCtlBottom.setMsgMargin(1, -5, 5);*/

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
        instance = RetrofitTools.getInstance(ServerHost.BASE_URL);
        test = instance.getTest(this);
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
        if ("getTest3".equals(tag)) {
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
