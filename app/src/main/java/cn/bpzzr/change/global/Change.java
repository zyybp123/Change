package cn.bpzzr.change.global;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;

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
    /**
     * 静态的上下文，全局可用
     */
    @SuppressLint("StaticFieldLeak")
    public static Context mContext;
    /**
     * Activity管理器
     */
    private MyActivityManager mActivityManager;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        mContext = this;
        mActivityManager = MyActivityManager.getInstance();
        activityLifeManage();
    }

    private void activityLifeManage() {
        //注册Activity生命周期回调
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtil.e(activity, "onActivityCreated");
                // 添加Activity到集合
                mActivityManager.addActivity(activity);
                mActivityManager.setTopActivityWeakRef(activity);
                //通知栏的全局设置
                StatusBarCompat.compat(activity, getResources().getColor(R.color.colorPrimary));
            }


            @Override
            public void onActivityStarted(Activity activity) {
                LogUtil.e(activity, "onActivityStarted");
                mActivityManager.setTopActivityWeakRef(activity);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtil.e(activity, "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtil.e(activity, "onActivityResumed");
                mActivityManager.setTopActivityWeakRef(activity);
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
                // 结束Activity&从集合中移除
                mActivityManager.removeActivity(activity);
            }
        });
    }
}
