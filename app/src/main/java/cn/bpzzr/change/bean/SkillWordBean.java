package cn.bpzzr.change.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/2/27.
 * test select more tag
 */

public class SkillWordBean implements MultiItemEntity {
    private String name;
    private int id;
    private List<SubTagBean> tagBeans;
    private int itemType;

    public SkillWordBean(String name, int id, List<SubTagBean> tagBeans) {
        this.name = name;
        this.id = id;
        this.tagBeans = tagBeans;
    }

    public SkillWordBean(String name, int id, List<SubTagBean> tagBeans, int itemType) {
        this.name = name;
        this.id = id;
        this.tagBeans = tagBeans;
        this.itemType = itemType;
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

    public List<SubTagBean> getTagBeans() {
        return tagBeans;
    }

    public void setTagBeans(List<SubTagBean> tagBeans) {
        this.tagBeans = tagBeans;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
