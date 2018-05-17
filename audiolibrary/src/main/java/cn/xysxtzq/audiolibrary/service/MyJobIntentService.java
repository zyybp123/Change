package cn.xysxtzq.audiolibrary.service;

/**
 * Created by Administrator on 2018/5/7.
 * Android O 推荐服务用例
 */

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

/**
 * 每10秒弹出随机数字的吐司
 * <p>
 * 清单文件的配置
 * <service
 * android:name=".MyJobIntentService"
 * android:exported="false"  //是否允许其他应用访问
 * android:permission="android.permission.BIND_JOB_SERVICE"//必要的权限
 * />
 */
public class MyJobIntentService extends JobIntentService {

    /**
     * 服务的唯一码
     */
    static final int JOB_ID = 1000;
    final String TAG = "MyJobIntenetService";

    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * 用于给此服务开启后台任务的静态方法
     * <p>
     * Intent i = new Intent(getContext(), MyJobIntentService.class);  //is any of that needed?  idk.
     * //note, putExtra remembers type and I need this to be an integer.  so get an integer first.
     * i.putExtra("times", Integer.parseInt(et_input.getText().toString()));  //should do error checking here!
     * MyJobIntentService.enqueueWork(getContext(),i);
     */
    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, MyJobIntentService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        //此处为已经为子线程
        // 在此处直接执行所要进行的后台任务
        int top = intent.getIntExtra("times", 500);  //default is 5.
        int num;

        for (int i = 0; i < top; i++) {
            num = mGenerator.nextInt(100);
            toast("Random number is " + num);
            Log.e(TAG, "Random number is " + num);
            try {
                Thread.sleep(1000);  // 1000 is one second, ten seconds would be 10000
            } catch (InterruptedException e) {
                //捕获异常
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "All work complete");
        toast("All work complete");
    }

    final Handler mHandler = new Handler();

    // Helper for showing tests
    void toast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyJobIntentService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
