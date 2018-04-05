package cn.xysxtzq.audiolibrary.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.xysxtzq.audiolibrary.bean.AudioInfo;
import cn.xysxtzq.audiolibrary.interf.PlayMode;
import cn.xysxtzq.audiolibrary.interf.PlayState;

/**
 * Created by Administrator on 2018/4/2.
 * MediaPlayer播放音频的播放控制类
 * <p>
 * MediaPlayer提供了对音频播放的各种控制，生命周期：
 * <p>
 * 支持：AAC、AMR、FLAC、MP3、MIDI、OGG、PCM等格式
 * <p>
 * 缺点：资源占用量较高、延迟时间较长、不支持多个音频同时播放等
 * //播放列表切换，切换播放音频，当前播放音频的播放状态的改变
 */

public class AudioMediaPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener {
    private static final String TAG = "AudioMediaPlayer";
    private static volatile AudioMediaPlayer mInstance;
    /**
     * 播放器,单例类会维持一个唯一的实例
     */
    private MediaPlayer mPlayer;
    /**
     * 当前的音频索引
     */
    private int mCurrentAudio = 0;
    /**
     * 播放状态
     */
    private int mPlayState;
    /**
     * 播放模式
     */
    private int mPlayMode;
    /**
     * 播放列表的id
     */
    private String mPlayListId;
    /**
     * 音频播放列表
     */
    private List<AudioInfo> mPlayList;

    /**
     * MediaPlayer 是否调用过 setDataSource，
     * 否则第一次调用 changeSong 里的 _.reset 方法时 MediaPlayer 会抛 IllegalStateException
     */
    private boolean hasMediaPlayerInit = false;
    /**
     * 是否是下一首
     */
    private boolean isNext = true;

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

    private AudioMediaPlayer() {
        //初始化相应参数
        mPlayState = PlayState.STATUS_STOP;
        mPlayer = new MediaPlayer();
        mPlayList = new ArrayList<>();
        mPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        //一首播放完成时的回调
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {
        //调用seekTo时异步操作跳转完成时的回调
    }

    /**
     * 获得播放模式
     */
    public int getPlayMode() {
        return this.mPlayMode;
    }

    /**
     * 设置播放模式
     */
    public void setPlayMode(int mode) {
        this.mPlayMode = mode;
    }

    /**
     * 返回播放列表
     */
    public List<AudioInfo> getAudioInfoList() {
        return mPlayList;
    }

    /**
     * 设置播放列表
     */
    public AudioInfo setPlayList(List<AudioInfo> audioInfoList, int current, String id) {
        this.mPlayList = audioInfoList;
        this.mPlayListId = id;

        mCurrentAudio = current;
        //changeSong();

        AudioInfo currentA = audioInfoList.get(mCurrentAudio);
        //mNotifyPlayListChanged.notify(currentS, current, id);

        return currentA;
    }

    /**
     * 获取当前播放列表的id
     */
    public String getPlayListId() {
        return mPlayListId;
    }

    /**
     * 当前正在播放曲目
     */
    public AudioInfo getCurrentAudio() {
        return mPlayList.size() == 0 ? null : mPlayList.get(mCurrentAudio);
    }

    /**
     * 获取当前播放的音频的索引
     */
    public int getCurrentAudioIndex() {
        return mCurrentAudio;
    }

    /**
     * 播放指定曲目
     *
     * @param audioInfo 指定曲目的信息
     */
    public int play(@NonNull AudioInfo audioInfo) {
        return play(mPlayList.indexOf(audioInfo));
    }

    /**
     * 音频播放的方法
     *
     * @param index 要播放的索引
     * @return 返回播放状态
     */
    public int play(int index) {
        int result = PlayState.ERROR_INVALID;
        if (index != -1) {
            //列表中有该歌曲
            if (mCurrentAudio != index) {
                //不是当前歌曲
                isNext = mCurrentAudio < index;
                mCurrentAudio = index;
                if (mPlayState != PlayState.STATUS_PLAYING) {
                    //mNotifyStatusChanged.notify(getCurrentSong(), mCurrentSong, PlayState.STATUS_START);
                    //切换并播放
                    mPlayState = PlayState.STATUS_PLAYING;
                }
                //result = changeSong();
            } else if (mPlayState != PlayState.STATUS_PLAYING) {
                // 是但没在播放
                mPlayState = PlayState.STATUS_PAUSE;
                //resume();//播放
            } else  // 是且已经在播放
                return 1;
        } else return PlayState.ERROR_NO_RESOURCE;
        return result;
    }

    /**
     * 音频准备的方法
     *
     * @param audioInfo 音频信息
     */
    public int prepare(@NonNull AudioInfo audioInfo) {
        int result = PlayState.ERROR_INVALID;
        int index = mPlayList.indexOf(audioInfo);
        if (index != -1) { //列表中有该歌曲
            if (mCurrentAudio != index) { //不是当前歌曲
                mCurrentAudio = index;
                if (mPlayState == PlayState.STATUS_PLAYING) {
                    //pause();
                }
                //result = changeSong();
            }
        } else return PlayState.ERROR_NO_RESOURCE;
        return result;
    }

    /**
     * 获得播放状态
     */
    public int getPlayState() {
        return mPlayState;
    }

    /**
     * 释放播放器，服务端停止时，该方法才应该被调用
     */
    public void releaseMediaPlayer() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayState = PlayState.STATUS_STOP;
            //sessionManager.release();
        }
    }

    /**
     * 上一首
     */
    public AudioInfo preAudio() {
        isNext = false;
        switch (mPlayMode) {
            case PlayMode.MODE_SINGLE_LOOP: {
                //changeSong();
                break;
            }
            case PlayMode.MODE_RANDOM: {
                int pre = new Random().nextInt(mPlayList.size());
                if (pre != mCurrentAudio) {
                    mCurrentAudio = pre;
                    //changeSong();
                }
                break;
            }
            case PlayMode.MODE_LIST_LOOP:
            default: {
                if (mCurrentAudio == 0) {
                    mCurrentAudio = mPlayList.size() - 1;
                } else {
                    mCurrentAudio--;
                }
                //changeSong();

                break;
            }
        }

        return mPlayList.size() == 0 ? null : mPlayList.get(mCurrentAudio);
    }

    //下一首
    public AudioInfo nextAudio() {
        isNext = true;
        switch (mPlayMode) {
            case PlayMode.MODE_SINGLE_LOOP: {
                //changeSong();
                break;
            }
            case PlayMode.MODE_LIST_LOOP: {
                if (mCurrentAudio == mPlayList.size() - 1) {
                    mCurrentAudio = 0;
                } else {
                    mCurrentAudio++;
                }
                //changeSong();
                break;
            }
            case PlayMode.MODE_RANDOM: {
                // UPDATE: 2017/8/26 修复 正在播放的歌单最后一首歌曲被移除歌单时 mPlayList.size() == 0 使 nextInt 方法出错
                int next = new Random().nextInt(mPlayList.size());
                if (next != mCurrentAudio) {
                    mCurrentAudio = next;
                    //changeSong();
                }
                break;
            }
            default: {
                if (mCurrentAudio == mPlayList.size() - 1) { // 最后一首
                    mCurrentAudio = 0;
                    //changeSong();
                    pause();//使暂停播放
                } else {
                    mCurrentAudio++;
                    //changeSong();
                }
                break;
            }
        }

        return mPlayList.size() == 0 ? null : mPlayList.get(mCurrentAudio);
    }

    /**
     * 暂停播放
     */
    public int pause() {
        if (mPlayState == PlayState.STATUS_PLAYING) {
            //sessionManager.updatePlaybackState();
            mPlayer.pause();
            mPlayState = PlayState.STATUS_PAUSE;

            // 放在最后 mPlayState 修改之后
            //mNotifyStatusChanged.notify(getCurrentAudio(), mCurrentAudio, PlayState.STATUS_STOP);
        }
        return mPlayState;
    }

    /**
     * 继续播放
     */
    public int resume() {
        if (mPlayState != PlayState.STATUS_PLAYING) {
            //focusManager.requestAudioFocus();
            //sessionManager.updatePlaybackState();
            mPlayer.start();
            mPlayState = PlayState.STATUS_PLAYING;

            //mNotifyStatusChanged.notify(getCurrentAudio(), mCurrentAudio, PlayState.STATUS_START);
        }
        return 1;
    }

    /**
     * 定位到
     */
    public int seekTo(int to) {
        //sessionManager.updatePlaybackState();
        mPlayer.seekTo(to);
        return 1;
    }

    /**
     * 获得播放进度
     */
    public int getProgress() {
        return mPlayer.getCurrentPosition();
    }

    /**
     * 切换曲目
     *
     * @return 切换成功返回 1
     */
    private synchronized int changeAudio() {

        if (mPlayState == PlayState.STATUS_PLAYING || mPlayState == PlayState.STATUS_PAUSE) {
            mPlayer.stop();
        }

        if (hasMediaPlayerInit) {
            mPlayer.reset();
        }

        if (mPlayList.size() == 0) {
            mCurrentAudio = 0;
            //mNotifySongChanged.notify(null, -1, isNext);
            return PlayState.ERROR_NO_RESOURCE;
        } else {
            String next = mPlayList.get(mCurrentAudio).data;
            try {
                //sessionManager.updateMetaData(next);
                mPlayer.setDataSource(next);
                if (!hasMediaPlayerInit) {
                    hasMediaPlayerInit = true;
                }
                mPlayer.prepare();

            } catch (IOException e) {
                e.printStackTrace();
                return PlayState.ERROR_DECODE;
            }

            if (mPlayState == PlayState.STATUS_PLAYING) {
                //focusManager.requestAudioFocus();
                //sessionManager.updatePlaybackState();
                mPlayer.start();
            }

            //mNotifySongChanged.notify(getCurrentSong(), mCurrentSong, isNext);
            return 1;
        }
    }

    /**
     * 用于提取频谱
     */
    public int getAudioSessionId() {
        return mPlayer.getAudioSessionId();
    }

    /**
     * 从列表移除音频
     *
     * @param audioInfo 音频信息
     */
    public void remove(AudioInfo audioInfo) {
        if (audioInfo == null) {
            return;
        }

        int index = mPlayList.indexOf(audioInfo);
        if (index != -1) {
            if (mCurrentAudio == index) {
                int tempS = mPlayMode;
                mPlayMode = PlayMode.MODE_LIST_LOOP;
                mPlayList.remove(index);
                mCurrentAudio--;
                nextAudio();
                mPlayMode = tempS;
            } else {
                mPlayList.remove(index);
                if (index < mCurrentAudio) {
                    mCurrentAudio--;
                }
            }

            if (mPlayList.size() == 0 || mCurrentAudio < 0) {
                // 服务器的播放列表是空的，这可能是因为仅有一首歌曲的播放列表被清空
                // 此时重新设置为【全部歌曲】，该过程在服务端完成，若在客户端的 onPlayListChange
                // 回调中重置播放列表会得到异常：beginBroadcast() called while already in a broadcast
                //setPlaySheet(MainSheetHelper.SHEET_ALL, 0);
            } else {
                //mNotifyPlayListChanged.notify(mPlayList.get(mCurrentAudio), mCurrentAudio, mPlayListId);
            }
        }
    }


    /**
     * Created by DuanJiaNing on 2017/5/23.
     */

    /*public class PlayController {

        private static final String TAG = "PlayController";

        private final Context context;
        private static volatile PlayController MANAGER = null;
        //private final AudioFocusManager focusManager;
        //private final MediaSessionManager sessionManager;


        private final MediaPlayer mPlayer;


        private int mPlayListId;

        // MediaPlayer 是否调用过 setDataSource，
        // 否则第一次调用 changeSong 里的 _.reset 方法时 MediaPlayer 会抛 IllegalStateException
        private boolean hasMediaPlayerInit = false;



        private final NotifySongChanged mNotifySongChanged;
        private final NotifyPlayListChanged mNotifyPlayListChanged;
        private final NotifyStatusChanged mNotifyStatusChanged;


        private int mPlayMode = MODE_DEFAULT;

        private PlayController(Context context, AudioFocusManager focusManager, MediaSessionManager sessionManager, NotifyStatusChanged sl, NotifySongChanged sc, NotifyPlayListChanged pl) {
            this.context = context;
            this.focusManager = focusManager;
            this.sessionManager = sessionManager;
            this.mNotifyStatusChanged = sl;
            this.mNotifySongChanged = sc;
            this.mNotifyPlayListChanged = pl;

            mPlayState = STATUS_STOP;
            mPlayer = new MediaPlayer();
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    nextSong();
                }
            });

        }

        public static PlayController getMediaController(Context context, AudioFocusManager focusManager, MediaSessionManager sessionManager, NotifyStatusChanged sl, NotifySongChanged sc, NotifyPlayListChanged pl) {
            if (MANAGER == null) {
                synchronized (PlayController.class) {
                    if (MANAGER == null)
                        MANAGER = new PlayController(context, focusManager, sessionManager, sl, sc, pl);
                }
            }
            return MANAGER;
        }
        public Song setPlaySheet(int sheetID, int current) {
            DBMusicocoController dbController = new DBMusicocoController(context, false);
            List<DBSongInfo> ds;
            if (sheetID < 0) {
                MainSheetHelper helper = new MainSheetHelper(context, dbController);
                ds = helper.getMainSheetSongInfo(sheetID);
            } else {
                ds = dbController.getSongInfos(sheetID);
            }
            dbController.close();

            if (ds == null || ds.size() == 0) {
                return null;
            }

            List<Song> list = new ArrayList<>();
            for (DBSongInfo d : ds) {
                Song song = new Song(d.path);
                list.add(song);
            }

            mPlayList = list;
            mPlayListId = sheetID;

            mCurrentSong = current;
            changeSong();

            Song currentS = mPlayList.get(mCurrentSong);
            mNotifyPlayListChanged.notify(currentS, current, sheetID);

            return currentS;
        }








    }*/


}
