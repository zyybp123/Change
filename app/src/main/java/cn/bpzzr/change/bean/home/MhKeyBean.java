package cn.bpzzr.change.bean.home;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/2/6.
 * 获取到登录的key和id
 */

public class MhKeyBean {

    /**
     * id : 006710a27952448e8928697132c63c4b
     * new : 0
     * key : c6fdc5685803c4b4aa54f2dbf37701f1
     */

    private String id;
    @SerializedName("new")
    private int newX;
    private String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNewX() {
        return newX;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
