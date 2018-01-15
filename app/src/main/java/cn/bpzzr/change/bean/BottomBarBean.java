package cn.bpzzr.change.bean;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * Created by Administrator on 2017/10/23.
 * 底部导航栏数据
 */

public class BottomBarBean {
    //普通图片资源，未选中
    @DrawableRes
    private int iconResNormal;
    //普通图片资源，选中
    @DrawableRes
    private int iconResSelect;
    //文字未选中的颜色
    @ColorRes
    private int textColorNormal;
    //文字选中的颜色
    @ColorRes
    private int textColorSelect;
    //网络资源，未选中
    private String iconUrlNormal;
    //网络资源，选中
    private String iconUrlSelect;
    //文字未选中的颜色
    private int textColorNormalNet;
    //文字选中的颜色
    private int textColorSelectNet;
    //tab的标题
    private String title;
    //tab是否选中的状态
    private boolean isSelected;
    //图片加载的标识
    private String loadTagImg;
    //文字加载的标识
    private String loadTagText;

    public BottomBarBean(int iconRes, String title) {
        this.title = title;
    }

    public BottomBarBean(int iconRes, String title, boolean isSelected) {
        this(iconRes, title);
        this.isSelected = isSelected;
    }

    public int getIconResNormal() {
        return iconResNormal;
    }

    public void setIconResNormal(int iconResNormal) {
        this.iconResNormal = iconResNormal;
    }

    public int getIconResSelect() {
        return iconResSelect;
    }

    public void setIconResSelect(int iconResSelect) {
        this.iconResSelect = iconResSelect;
    }

    public String getIconUrlNormal() {
        return iconUrlNormal;
    }

    public void setIconUrlNormal(String iconUrlNormal) {
        this.iconUrlNormal = iconUrlNormal;
    }

    public String getIconUrlSelect() {
        return iconUrlSelect;
    }

    public void setIconUrlSelect(String iconUrlSelect) {
        this.iconUrlSelect = iconUrlSelect;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getTextColorNormal() {
        return textColorNormal;
    }

    public void setTextColorNormal(int textColorNormal) {
        this.textColorNormal = textColorNormal;
    }

    public int getTextColorSelect() {
        return textColorSelect;
    }

    public void setTextColorSelect(int textColorSelect) {
        this.textColorSelect = textColorSelect;
    }

    public String getLoadTagImg() {
        return loadTagImg;
    }

    public void setLoadTagImg(String loadTagImg) {
        this.loadTagImg = loadTagImg;
    }

    public String getLoadTagText() {
        return loadTagText;
    }

    public void setLoadTagText(String loadTagText) {
        this.loadTagText = loadTagText;
    }

    public int getTextColorNormalNet() {
        return textColorNormalNet;
    }

    public void setTextColorNormalNet(int textColorNormalNet) {
        this.textColorNormalNet = textColorNormalNet;
    }

    public int getTextColorSelectNet() {
        return textColorSelectNet;
    }

    public void setTextColorSelectNet(int textColorSelectNet) {
        this.textColorSelectNet = textColorSelectNet;
    }
}
