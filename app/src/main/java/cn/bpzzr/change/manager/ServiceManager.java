package cn.bpzzr.change.manager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/**
 * Created by Administrator on 2018/5/7.
 * 服务管理器
 */

public class ServiceManager {
    private static volatile ServiceManager mInstance;

    private Context mContext;

    private ServiceManager(Context context) {
        //构造内部可以初始化相应参数
    }

    public static ServiceManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ServiceManager.class) {
                if (mInstance == null) {
                    mInstance = new ServiceManager(context);
                }
            }
        }
        return mInstance;
    }

    public void startService(Class<? extends Service> clazz) {
        Intent intent = new Intent(mContext, clazz);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //Android O 的启动,在服务内部还需要调用startForeground()方法
            mContext.startForegroundService(intent);
        } else {
            mContext.startService(intent);
        }
    }


}
