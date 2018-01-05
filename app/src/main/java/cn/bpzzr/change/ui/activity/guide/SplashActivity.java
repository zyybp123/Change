package cn.bpzzr.change.ui.activity.guide;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.bpzzr.change.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer.start();
    }

    //倒计时
    CountDownTimer timer = new CountDownTimer(2000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            //跳转
            HomeActivity.startSelf(SplashActivity.this);
        }
    };

    @Override
    public void onBackPressed() {
        //
    }
}
