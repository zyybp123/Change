package cn.xysxtzq.audiolibrary.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;

/**
 * Created by Administrator on 2017/12/14.
 * 文件信息数据实体类
 */

public class FileInfo implements Parcelable {
    /**
     * 文件Id
     */
    public String fileId;
    /**
     * 文件名
     */
    public String displayName;
    /**
     * 文件名不带后缀
     */
    public String title;
    /**
     * 文件名带后缀
     */
    public String fullName;
    /**
     * 文件类型
     */
    public String type;
    /**
     * 文件路径
     */
    public String data;
    /**
     * 文件的最后修改日期
     */
    public long dateModify;
    /**
     * 文件的大小
     */
    public long size;
    /**
     * 文件是否选中的标识
     */
    public boolean isSelect;

    public FileInfo() {
    }

    public FileInfo(String title, String type, String data) {
        this.title = title;
        this.data = data;
        this.type = type;
        File file = new File(data);
        if (file.exists()) {
            this.fullName = file.getName();
        } else {
            this.fullName = title;
        }
    }

    public FileInfo(String name, String type, String data, long dateModify, long size) {
        this(name, type, data);
        this.dateModify = dateModify;
        this.size = size;
    }

    public FileInfo(String fileId, String name, String type, String data, long dateModify, long size) {
        this(name, type, data, dateModify, size);
        this.fileId = fileId;
    }


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getDateModify() {
        return dateModify;
    }

    public void setDateModify(long dateModify) {
        this.dateModify = dateModify;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    @Override
    public String toString() {
        return fileId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fileId);
        dest.writeString(this.displayName);
        dest.writeString(this.title);
        dest.writeString(this.type);
        dest.writeString(this.fullName);
        dest.writeString(this.data);
        dest.writeLong(this.dateModify);
        dest.writeLong(this.size);
        dest.writeByte(this.isSelect ? (byte) 1 : (byte) 0);
    }

    protected FileInfo(Parcel in) {
        this.fileId = in.readString();
        this.displayName = in.readString();
        this.title = in.readString();
        this.type = in.readString();
        this.fullName = in.readString();
        this.data = in.readString();
        this.dateModify = in.readLong();
        this.size = in.readLong();
        this.isSelect = in.readByte() != 0;
    }

}
