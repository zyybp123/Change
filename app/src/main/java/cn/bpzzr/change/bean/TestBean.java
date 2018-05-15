package cn.bpzzr.change.bean;

import android.text.TextUtils;

import cn.xysxtzq.myuilibrary.interf.SelectStatus;

/**
 * Created by Administrator on 2018/5/15.
 * 测试Bean
 */

public class TestBean implements SelectStatus {
    private boolean selected;
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return TextUtils.isEmpty(name) ? "" : name;
    }
}
