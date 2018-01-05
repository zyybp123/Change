package cn.bpzzr.change.ui.activity.guide;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import cn.bpzzr.change.R;
import cn.bpzzr.change.global.Change;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.manager.MyActivityManager;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.util.LogUtil;

public class HomeActivity extends AppCompatActivity implements MVP.View, MVP.Presenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialRequest();
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

    @Override
    public void initialRequest() {
        instance = RetrofitTools.getInstance(ServerHost.BASE_URL);
        instance.getTest(this);
        instance.getTest2(this);
    }

    @Override
    public void onError(String tag, String msg) {

    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        LogUtil.e("...result..." + data);
    }

    @Override
    public void onEmpty(String tag) {

    }
}
