package cn.bpzzr.change.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/2/27.
 * test select more tag
 */

public class SkillWordBean {
    private String name;
    private int id;
    private List<SubTagBean> tagBeans;

    public SkillWordBean(String name, int id, List<SubTagBean> tagBeans) {
        this.name = name;
        this.id = id;
        this.tagBeans = tagBeans;
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
}
