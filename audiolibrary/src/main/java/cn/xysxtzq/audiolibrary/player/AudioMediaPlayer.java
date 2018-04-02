package cn.xysxtzq.audiolibrary.player;

/**
 * Created by Administrator on 2018/4/2.
 * MediaPlayer播放音频的播放控制类
 * <p>
 * MediaPlayer提供了对音频播放的各种控制，生命周期：
 * <p>
 * 支持：AAC、AMR、FLAC、MP3、MIDI、OGG、PCM等格式
 * <p>
 * 缺点：资源占用量较高、延迟时间较长、不支持多个音频同时播放等
 */

public class AudioMediaPlayer {
    private static final String TAG = "AudioMediaPlayer";
    private static volatile AudioMediaPlayer mInstance;

    private AudioMediaPlayer() {
        //初始化相应参数
    }

    public static AudioMediaPlayer getInstance() {
        if (mInstance == null) {
            synchronized (AudioMediaPlayer.class) {
                if (mInstance == null) {
                    mInstance = new AudioMediaPlayer();
                }
            }
        }
        return mInstance;
    }
}
