package cn.bpzzr.change.net.download;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;

import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/30.
 * 上传或下载的数据实体类
 */
@Entity
public class ResInfo implements Parcelable {

    /**
     * 资源id
     */
    private int resId;
    /**
     * 资源名字，无后缀
     */
    private String resName;
    /**
     * 资源存放的目标文件夹
     */
    private String fileDir;
    /**
     * 资源的全名，带后缀
     */
    private String fullName;
    /**
     * 资源的总大小
     */
    private long totalSize;
    /**
     * 资源已经读/写的大小
     */
    private long currentSize;
    /**
     * 资源的下载或上传进度
     */
    private int progress;
    /**
     * 资源的下载路径
     */
    private String url;
    /**
     * 资源存放的绝对路径
     */
    private String absolutePath;
    /**
     * 当前下载所处的状态
     */
    private int status;
    /**
     * 文件的类型
     */
    private String type;


    public ResInfo() {
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(long currentSize) {
        this.currentSize = currentSize;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resId);
        dest.writeString(this.resName);
        dest.writeString(this.fileDir);
        dest.writeString(this.fullName);
        dest.writeLong(this.totalSize);
        dest.writeLong(this.currentSize);
        dest.writeInt(this.progress);
        dest.writeString(this.url);
        dest.writeString(this.absolutePath);
        dest.writeInt(this.status);
        dest.writeString(this.type);
    }

    protected ResInfo(Parcel in) {
        this.resId = in.readInt();
        this.resName = in.readString();
        this.fileDir = in.readString();
        this.fullName = in.readString();
        this.totalSize = in.readLong();
        this.currentSize = in.readLong();
        this.progress = in.readInt();
        this.url = in.readString();
        this.absolutePath = in.readString();
        this.status = in.readInt();
        this.type = in.readString();
    }

    @Generated(hash = 797803553)
    public ResInfo(int resId, String resName, String fileDir, String fullName,
                   long totalSize, long currentSize, int progress, String url,
                   String absolutePath, int status, String type) {
        this.resId = resId;
        this.resName = resName;
        this.fileDir = fileDir;
        this.fullName = fullName;
        this.totalSize = totalSize;
        this.currentSize = currentSize;
        this.progress = progress;
        this.url = url;
        this.absolutePath = absolutePath;
        this.status = status;
        this.type = type;
    }

    public static final Creator<ResInfo> CREATOR = new Creator<ResInfo>() {
        @Override
        public ResInfo createFromParcel(Parcel source) {
            return new ResInfo(source);
        }

        @Override
        public ResInfo[] newArray(int size) {
            return new ResInfo[size];
        }
    };
}
