package cn.bpzzr.change.ui.activity.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.bean.HomeTabEntity;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.manager.MyActivityManager;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.ui.activity.DemonstrationActivity;
import cn.bpzzr.change.ui.activity.base.BaseActivity;
import cn.bpzzr.change.util.LogUtil;

public class HomeActivity extends BaseActivity implements MVP.View, MVP.Presenter {
    public static final int [] bgsSelected = new int[]{
            R.drawable.conversation,
            R.drawable.conversation,
            R.drawable.conversation,
            R.drawable.conversation
    };
    public static final int [] bgsUnSelected = new int[]{
            R.drawable.conversation,
            R.drawable.conversation,
            R.drawable.conversation,
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
        customTbLl.setVisibility(View.GONE);
        String[] titles = getResources().getStringArray(R.array.home_tab_title);
        ArrayList<CustomTabEntity> titleList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            titleList.add(new HomeTabEntity(titles[i],bgsSelected[i],bgsUnSelected[i]));
        }
        baseCtlBottom.setTabData(titleList);
        //两位数
        baseCtlBottom.showMsg(0, 55);
        baseCtlBottom.setMsgMargin(0, -5, 5);

        //三位数
        baseCtlBottom.showMsg(1, 100);
        baseCtlBottom.setMsgMargin(1, -5, 5);

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
