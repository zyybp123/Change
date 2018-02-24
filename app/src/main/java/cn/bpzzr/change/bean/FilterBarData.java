package cn.bpzzr.change.bean;

/**
 * Created by Administrator on 2018/2/23.
 * 筛选条数据实体
 */

public class FilterBarData<T> {
    /**
     * 标签名
     */
    private String tabName;
    /**
     * 标签的附带数据（常见有，0，直接筛选，1，单选列表，2，标签式多选列表，
     * 3，级联式多选列表，4，级联式单选列表，5，多页面，6，跳转至新页面等等）
     */
    private T extraData;
    /**
     * 是否有向下的箭头
     */
    private boolean hasArrow = true;
    /**
     * 条件选择页面是否显示,true为显示，默认不显示
     */
    private boolean isShowPage;
    /**
     * 下拉筛选条显示的类型
     */
    private int menuType;

    /**
     * 构造
     *
     * @param tabName   标签名称
     * @param extraData 标签附带数据
     */
    public FilterBarData(String tabName, T extraData) {
        this.tabName = tabName;
        this.extraData = extraData;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public T getExtraData() {
        return extraData;
    }

    public void setExtraData(T extraData) {
        this.extraData = extraData;
    }

    public boolean isHasArrow() {
        return hasArrow;
    }

    public void setHasArrow(boolean hasArrow) {
        this.hasArrow = hasArrow;
    }

    public boolean isShowPage() {
        return isShowPage;
    }

    public void setShowPage(boolean showPage) {
        isShowPage = showPage;
    }

}
