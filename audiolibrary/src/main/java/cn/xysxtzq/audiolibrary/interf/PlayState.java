package cn.xysxtzq.audiolibrary.interf;

/**
 * Created by Administrator on 2018/4/3.
 * 播放状态
 */

public interface PlayState {
    //未知错误
    int ERROR_UNKNOWN = -1;
    //文件无效
    int ERROR_INVALID = -2;
    //歌曲文件解码错误
    int ERROR_DECODE = -3;
    //没有指定歌曲
    int ERROR_NO_RESOURCE = -4;
    //正在播放
    int STATUS_PLAYING = 10;
    //播放结束
    int STATUS_COMPLETE = 11;
    //开始播放
    int STATUS_START = 12;
    //播放暂停
    int STATUS_PAUSE = 13;
    //停止
    int STATUS_STOP = 14;
}
