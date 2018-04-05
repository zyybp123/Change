package cn.xysxtzq.audiolibrary.bean;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcel;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/2.
 * 音频播放的数据实体类
 */

public class AudioInfo extends FileInfo {
    private static final String TAG = "AudioInfo";
    /**
     * 从数据库里要查询的参数列表
     */
    public static final String[] AUDIO_INFO_COLUMNS = {
            //文件id
            MediaStore.Audio.Media._ID,
            //文件名
            MediaStore.Audio.Media.DISPLAY_NAME,
            //不带扩展名的文件名
            MediaStore.Audio.Media.TITLE,
            //资源时长
            MediaStore.Audio.Media.DURATION,
            //艺术家
            MediaStore.Audio.Media.ARTIST,
            //专辑封面
            MediaStore.Audio.Media.ALBUM,
            //专辑封面id，可通过其获取封面图片
            MediaStore.Audio.AudioColumns.ALBUM_ID,
            //年代
            MediaStore.Audio.Media.YEAR,
            //文件的类型
            MediaStore.Audio.Media.MIME_TYPE,
            //文件大小
            MediaStore.Audio.Media.SIZE,
            //文件的路径
            MediaStore.Audio.Media.DATA
    };
    /**
     * 音频外部Uri
     */
    private static final Uri AUDIO_URI_EXTERNAL = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    /**
     * 音频内部Uri
     */
    private static final Uri AUDIO_URI_INTERNAL = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
    /**
     * 要查询的文件大小 默认值 1M
     */
    private static final String[] DEFAULT_SIZE = new String[]{1024 * 1024 + ""};
    /**
     * 排序条件 默认按时间降序排序
     */
    private static final String DEFAULT_SORT_ORDER = MediaStore.Audio.Media.DATE_MODIFIED + " DESC";
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

    public AudioInfo() {
    }

    public AudioInfo(String title, String type, String data) {
        super(title, type, data);
    }

    public AudioInfo(String name, String type, String data, long dateModify, long size) {
        super(name, type, data, dateModify, size);
    }

    public AudioInfo(long fileId, String name, String type, String data, long dateModify, long size) {
        super(fileId, name, type, data, dateModify, size);
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

    /**
     * 获取数据库音频文件
     *
     * @param mContext  上下文
     * @param size      文件的大小数组 默认为1M new String[]{1024 * 1024 + ""}
     * @param sortOrder 排序条件 MediaStore.Audio.Media.DATE_MODIFIED + " DESC";
     * @return 返回包装了相关信息的数据实体集合
     */
    public static ArrayList<AudioInfo> getAudioList(Uri path, Context mContext, String[] size, String sortOrder) {
        ArrayList<AudioInfo> fileList = new ArrayList<>();
        if (path == null || !AUDIO_URI_EXTERNAL.equals(path) || !AUDIO_URI_INTERNAL.equals(path)) {
            Log.e(TAG, "Uri path is null or not a correct uri!");
            return fileList;
        }
        if (mContext == null) {
            Log.e(TAG, "Context is null !");
            return fileList;
        }
        if (size == null || size.length == 0) {
            Log.e(TAG, "Size array is null or empty !");
            size = DEFAULT_SIZE;
        }
        if (TextUtils.isEmpty(sortOrder)) {
            Log.e(TAG, "SortOrder is null, so not sort !");
            sortOrder = null;
        }
        Cursor cursor = null;
        try {
            cursor = mContext.getContentResolver().query(
                    //Uri路径
                    path,
                    //要查询的参数
                    AUDIO_INFO_COLUMNS,
                    //查询条件
                    "_size>?", size,
                    //排序条件
                    sortOrder);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                    String displayName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                    long fileSize = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                    String type = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE));
                    String data = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                    long duration = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                    String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                    String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                    String year = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.YEAR));
                    long dateModify = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATE_MODIFIED));
                    //设置数据
                    AudioInfo audioInfo = new AudioInfo();
                    audioInfo.setFileId(id);
                    audioInfo.setDisplayName(displayName);
                    audioInfo.setTitle(title);
                    audioInfo.setDuration(duration);
                    audioInfo.setType(type);
                    audioInfo.setData(data);
                    audioInfo.setArtist(artist);
                    audioInfo.setDateModify(dateModify);
                    audioInfo.setYear(year);
                    audioInfo.setSize(fileSize);
                    audioInfo.setAlbum(album);
                    fileList.add(audioInfo);
                    Log.e(TAG, "Name,Type,data,diaplayName--->" + title + " ," + type + ", " + data + ", " + displayName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "...文件....数据获取异常....." + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return fileList;
    }

    /**
     * 查询外部内存数据库列表
     *
     * @param mContext  上下文
     * @param size      大小
     * @param sortOrder 排序方式
     * @return 返回音频信息列表
     */
    public static ArrayList<AudioInfo> getExternalAudioList(Context mContext, String[] size, String sortOrder) {
        return getAudioList(AUDIO_URI_EXTERNAL, mContext, size, sortOrder);
    }

    /**
     * 默认方式查询外部内存数据库列表
     *
     * @param mContext 上下文
     * @return 返回音频信息列表
     */
    public static ArrayList<AudioInfo> getExternalAudioList(Context mContext) {
        return getAudioList(AUDIO_URI_EXTERNAL, mContext, DEFAULT_SIZE, DEFAULT_SORT_ORDER);
    }

    /**
     * 查询内部部内存数据库列表
     *
     * @param mContext  上下文
     * @param size      大小
     * @param sortOrder 排序方式
     * @return 返回音频信息列表
     */
    public static ArrayList<AudioInfo> getInternalAudioList(Context mContext, String[] size, String sortOrder) {
        return getAudioList(AUDIO_URI_INTERNAL, mContext, size, sortOrder);
    }

    /**
     * 默认方式查询内部内存数据库列表
     *
     * @param mContext 上下文
     * @return 返回音频信息列表
     */
    public static ArrayList<AudioInfo> getInternalAudioList(Context mContext) {
        return getAudioList(AUDIO_URI_INTERNAL, mContext, DEFAULT_SIZE, DEFAULT_SORT_ORDER);
    }

    /**
     * 从媒体库加载封面
     */
    private Bitmap loadCoverFromMediaStore(Context context,long albumId) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://media/external/audio/albumart");
        InputStream is;
        try {
            is = resolver.openInputStream(uri);
        } catch (FileNotFoundException ignored) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeStream(is, null, options);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.duration);
        dest.writeString(this.artist);
        dest.writeString(this.album);
        dest.writeString(this.year);
    }

    protected AudioInfo(Parcel in) {
        super(in);
        this.duration = in.readLong();
        this.artist = in.readString();
        this.album = in.readString();
        this.year = in.readString();
    }

    public static final Creator<AudioInfo> CREATOR = new Creator<AudioInfo>() {
        @Override
        public AudioInfo createFromParcel(Parcel source) {
            return new AudioInfo(source);
        }

        @Override
        public AudioInfo[] newArray(int size) {
            return new AudioInfo[size];
        }
    };
}
//22