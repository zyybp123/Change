package cn.bpzzr.change.global;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import cn.bpzzr.change.R;
import cn.bpzzr.change.manager.AppManager;
import cn.bpzzr.change.manager.MyActivityManager;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StatusBarCompat;

/**
 * Created by Administrator on 2018/1/4.
 * application 类,初始化用
 */

public class Change extends Application {

    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        activityLifeManage();


    }

    private void activityLifeManage() {
        //注册Activity生命周期回调
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtil.e(activity, "onActivityCreated");
                // 添加Activity到堆栈
                //AppManager.getAppManager().addActivity(activity);
                MyActivityManager.getInstance().addActivity(activity);
                //通知栏的全局设置
                StatusBarCompat.compat(activity, getResources().getColor(R.color.colorPrimary));
            }


            @Override
            public void onActivityStarted(Activity activity) {
                LogUtil.e(activity, "onActivityStarted");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtil.e(activity, "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtil.e(activity, "onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtil.e(activity, "onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                LogUtil.e(activity, "onActivityStopped");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtil.e(activity, "onActivityDestroyed");
                // 结束Activity&从堆栈中移除
                //AppManager.getAppManager().finishActivity(activity);
                MyActivityManager.getInstance().removeActivity(activity);
            }
        });
    }
}
