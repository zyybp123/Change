package cn.xysxtzq.audiolibrary.find;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

import cn.xysxtzq.audiolibrary.bean.AudioInfo;

/**
 * Created by Administrator on 2018/4/3.
 * 音频获取的子线程任务
 */

public class AudioGet implements Runnable {
    private Context mContext;

    public AudioGet(Context mContext) {
        this.mContext = mContext.getApplicationContext();
    }

    @Override
    public void run() {
        ArrayList<AudioInfo> externalAudioList = AudioInfo.getExternalAudioList(mContext);
        ArrayList<AudioInfo> internalAudioList = AudioInfo.getInternalAudioList(mContext);
        // 删除在list1中出现的元素
        externalAudioList.removeAll(internalAudioList);
        // 剩余list2的所有元素添加到list1中
        internalAudioList.addAll(externalAudioList);
        //取得无重复元素的并集internalAudioList将其回调到主线程


    }
}
