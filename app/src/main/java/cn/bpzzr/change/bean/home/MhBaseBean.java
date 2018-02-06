package cn.bpzzr.change.bean.home;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/2/6.
 * 网易漫画数据基类
 */

public class MhBaseBean<T> {

    /**
     * resCode : 0
     * data :
     * resReason : ok
     */

    private int resCode;
    private T data;
    private String resReason;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResReason() {
        return resReason;
    }

    public void setResReason(String resReason) {
        this.resReason = resReason;
    }

}
