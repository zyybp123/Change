package cn.bpzzr.change.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/2/27.
 * test select more tag   subTag
 */

public class SubTagBean implements MultiItemEntity {
    private String name;
    private int id;
    private int itemType;

    public SubTagBean(String name, int id, int itemType) {
        this.name = name;
        this.id = id;
        this.itemType = itemType;
    }

    public SubTagBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
