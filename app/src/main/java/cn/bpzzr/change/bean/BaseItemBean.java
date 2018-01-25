package cn.bpzzr.change.bean;

/**
 * Created by Administrator on 2018/1/24.
 * 列表条目的基类
 */

public class BaseItemBean<T> {
    /**
     * 条目类型
     */
    private int viewType;
    /**
     * 是否被选中
     */
    private boolean hasSelected;
    /**
     * 条目的数据
     */
    private T itemData;

    public BaseItemBean() {
    }

    public BaseItemBean(int viewType, T itemData) {
        this.viewType = viewType;
        this.itemData = itemData;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public boolean isHasSelected() {
        return hasSelected;
    }

    public void setHasSelected(boolean hasSelected) {
        this.hasSelected = hasSelected;
    }

    public T getItemData() {
        return itemData;
    }

    public void setItemData(T itemData) {
        this.itemData = itemData;
    }

    @Override
    public String toString() {
        return "BaseItemBean{" +
                "viewType=" + viewType +
                '}';
    }
}
