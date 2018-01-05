/*
    ShengDao Android Client, BroadcastManager
    Copyright (c) 2015 ShengDao Tech Company Limited
*/

package cn.bpzzr.change.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.bpzzr.change.util.LogUtil;

/**
 * 广播接收者统筹管理类
 */
public class BroadcastManager {

    private static BroadcastManager instance;
    private LocalBroadcastManager manager;
    private Map<String, BroadcastReceiver> receiverMap;
    private Gson mGson;
    public static final String RESULT_OBJ_BY_JSON = "byJson";
    public static final String RESULT_STRING = "byString";
    public static final String RESULT_INT = "byInt";
    public static final String RESULT_OBJ_BY_SERIALIZE = "bySerializable";
    public static final String RESULT_OBJ_BY_PARCELABLE = "byParcelable";
    public static final String RESULT_PARCELABLE_LIST = "byParcelableList";

    /**
     * 构造方法
     *
     * @param context 获取广播接收者的上下文
     */
    private BroadcastManager(Context context) {
        receiverMap = new HashMap<>();
        mGson = new Gson();
        //获取应用内的广播接收者管理器
        manager = LocalBroadcastManager.getInstance(context);
    }

    /**
     * [获取BroadcastManager实例，单例模式实现]
     *
     * @param context 获取广播接收者的上下文
     * @return 返回本类单一实例
     */
    public static BroadcastManager getInstance(Context context) {
        if (instance == null) {
            synchronized (BroadcastManager.class) {
                if (instance == null) {
                    instance = new BroadcastManager(context);
                }
            }
        }
        return instance;
    }

    /**
     * 广播接收者注册方法，注册一个
     *
     * @param action   唯一码
     * @param receiver 接收者
     */
    public void addAction(String action, BroadcastReceiver receiver) {
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction(action);
            receiverMap.put(action, receiver);
            LogUtil.e("action......" + action);
            LogUtil.e("receiver...add...one..." + receiverMap.size());
            manager.registerReceiver(receiver, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 广播接收者注册方法，注册一个或多个
     *
     * @param receiver 接收者
     * @param action   唯一码,可变参数,允许多注册
     */
    public void addAction(BroadcastReceiver receiver, String... action) {
        try {
            IntentFilter filter = new IntentFilter();
            for (String anAction : action) {
                filter.addAction(anAction);
                receiverMap.put(anAction, receiver);
                LogUtil.e("action......" + anAction);
            }
            LogUtil.e("receiver..." + receiverMap.size());
            manager.registerReceiver(receiver, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送广播,携带空串
     *
     * @param action 唯一码
     */
    public void sendBroadcast(String action) {
        sendBroadcast(action, "");
    }

    /**
     * 发送广播,携带数据实体,通过json串
     *
     * @param action 唯一码
     * @param obj    参数
     */
    public void sendBroadcast(String action, Object obj) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(RESULT_OBJ_BY_JSON, mGson.toJson(obj));
        LogUtil.e("......sendBroadcast...by json..." + intent);
        manager.sendBroadcast(intent);
    }

    /**
     * 发送广播,携带实现了Serializable接口的数据实体
     *
     * @param action 唯一码
     * @param obj    参数
     */
    public void sendBroadcastSerializable(String action, Serializable obj) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(RESULT_OBJ_BY_SERIALIZE, obj);
        LogUtil.e("......sendBroadcast...by serializable..." + intent);
        manager.sendBroadcast(intent);

    }

    /**
     * 发送广播,携带实现了Parcelable接口的数据实体
     *
     * @param action 唯一码
     * @param obj    参数
     */
    public void sendBroadcastParcelable(String action, Parcelable obj) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(RESULT_OBJ_BY_PARCELABLE, obj);
        LogUtil.e("......sendBroadcast...by parcelable..." + intent);
        manager.sendBroadcast(intent);
    }

    /**
     * 发送广播,携带实现了Parcelable接口的数据实体的数据集合
     *
     * @param action 唯一码
     * @param list   参数
     */
    public void sendBroadcastParcelable(String action, ArrayList<? extends Parcelable> list) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putParcelableArrayListExtra(RESULT_PARCELABLE_LIST, list);
        LogUtil.e("......sendBroadcast...by parcelable list..." + intent);
        manager.sendBroadcast(intent);
    }

    /**
     * 发送参数为 String 的数据广播
     *
     * @param action 唯一码
     * @param s      字符串参数
     */
    public void sendBroadcast(String action, String s) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(RESULT_STRING, s);
        LogUtil.e("......sendBroadcast...by string..." + intent);
        manager.sendBroadcast(intent);
    }

    /**
     * 发送参数为 int 的数据广播
     *
     * @param action 唯一码
     * @param i      整型参数
     */
    public void sendBroadcast(String action, int i) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(RESULT_INT, i);
        LogUtil.e("......sendBroadcast...by int..." + intent);
        manager.sendBroadcast(intent);
    }

    /**
     * 销毁广播
     *
     * @param action 唯一码
     */
    public void destroy(String action) {
        if (receiverMap != null) {
            LogUtil.e("destroy..." + receiverMap.size());
            BroadcastReceiver receiver = receiverMap.remove(action);
            if (receiver != null) {
                LogUtil.e("destroy..." + receiver);
                manager.unregisterReceiver(receiver);
            }
        }
    }
}
