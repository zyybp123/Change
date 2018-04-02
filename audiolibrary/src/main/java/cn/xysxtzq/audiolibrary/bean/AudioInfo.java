package cn.xysxtzq.audiolibrary.bean;

import android.os.Parcel;

/**
 * Created by Administrator on 2018/4/2.
 * 音频播放的数据实体类
 */

public class AudioInfo extends FileInfo {
    /**
     * 资源时长
     */
    private long duration;
    /**
     * 艺术家
     */
    private String artist;
    /**
     * 专辑封面
     */
    private String album;
    /**
     * 年代
     */
    private String year;

    public AudioInfo(String title, String type, String data) {
        super(title, type, data);
    }

    public AudioInfo(String name, String type, String data, long dateModify, long size) {
        super(name, type, data, dateModify, size);
    }

    public AudioInfo(String fileId, String name, String type, String data, long dateModify, long size) {
        super(fileId, name, type, data, dateModify, size);
    }

    protected AudioInfo(Parcel in) {
        super(in);
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
