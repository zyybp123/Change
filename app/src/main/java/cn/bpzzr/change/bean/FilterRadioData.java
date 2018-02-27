package cn.bpzzr.change.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/2/24.
 * 带选中状态的筛选条件的数据实体
 */

public class FilterRadioData<T> implements MultiItemEntity {
    /**
     * 条目的数据，重写toString方法以便于显示名字
     */
    private T radioData;
    /**
     * 记录是否被选中
     */
    private boolean isSelected;
    /**
     * 记录条目的类型
     */
    private int itemType;

    public FilterRadioData(T radioData, boolean isSelected) {
        this.radioData = radioData;
        this.isSelected = isSelected;
    }

    public FilterRadioData(T radioData, boolean isSelected, int itemType) {
        this.radioData = radioData;
        this.isSelected = isSelected;
        this.itemType = itemType;
    }

    public T getRadioData() {
        return radioData;
    }

    public void setRadioData(T radioData) {
        this.radioData = radioData;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
