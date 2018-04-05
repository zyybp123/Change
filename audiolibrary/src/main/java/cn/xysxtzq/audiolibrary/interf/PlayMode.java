package cn.xysxtzq.audiolibrary.interf;

/**
 * Created by Administrator on 2018/4/3.
 * 播放模式
 */

public interface PlayMode {
    //默认播放模式，列表播放，播放至列表末端时停止播放
    int MODE_DEFAULT = 20;
    //列表循环
    int MODE_LIST_LOOP = 21;
    //单曲循环
    int MODE_SINGLE_LOOP = 22;
    //随机播放
    int MODE_RANDOM = 23;
}
