package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.BottomBarBean;
import cn.bpzzr.change.interf.LogTag;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2017/10/20.
 * 底部导航栏标签
 */

public class BottomBarTab extends FrameLayout {
    /**
     * 图片从网络加载
     */
    public static final String IMG_LOAD_FROM_NET = "IMG_LOAD_FROM_NET";
    /**
     * 图片从本地加载
     */
    public static final String IMG_LOAD_LOCAL = "IMG_LOAD_LOCAL";
    /**
     * 文字从网络加载
     */
    public static final String TEXT_LOAD_FROM_NET = "TEXT_LOAD_FROM_NET";
    /**
     * 文字从本地加载
     */
    public static final String TEXT_LOAD_LOCAL = "TEXT_LOAD_LOCAL";
    /**
     * 根布局
     */
    public View mRootView;
    /**
     * 图片
     */
    private ImageView mBottomIcon;
    /**
     * 标题
     */
    private TextView mBottomTitle;
    /**
     * 消息红点
     */
    private TextView mBottomDot;
    /**
     * 消息数字
     */
    private TextView mBottomBadge;
    private FrameLayout mBottomIconFr;
    /**
     * 默认的文字选中的颜色
     */
    @ColorRes
    private int mTitleColorSelected = R.color.colorPrimary;
    /**
     * 默认的文字未选中的颜色
     */
    @ColorRes
    private int mTitleColorNormal = R.color.color_999;

    @DrawableRes
    int mBottomImage;      //图片资源,用状态选择器

    String logTag;

    public BottomBarTab(@NonNull Context context) {
        this(context, null);
    }

    public BottomBarTab(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBarTab(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        logTag = LogUtil.getLogTag(this);
        //加载基本布局,找到控件
        mRootView = LayoutInflater
                .from(getContext())
                .inflate(R.layout.bottom_bar_tab_layout, this, false);
        mBottomIcon = mRootView.findViewById(R.id.bottom_tab_icon);
        mBottomTitle = mRootView.findViewById(R.id.bottom_tab_title);
        mBottomDot = mRootView.findViewById(R.id.bottom_tab_dot);
        mBottomBadge = mRootView.findViewById(R.id.bottom_tab_badge);
        mBottomIconFr = mRootView.findViewById(R.id.bottom_tab_icon_fr);
        addView(mRootView);
    }

    //设置图标,标题,标题颜色(静态资源)
    public BottomBarTab setIconAndTitle(@DrawableRes int drawableRes, String title,
                                        @ColorRes int colorNormal, @ColorRes int colorSelected) {
        this.mBottomImage = drawableRes;
        mBottomIcon.setImageResource(drawableRes);
        mBottomTitle.setText(title);
        this.mTitleColorNormal = colorNormal;
        this.mTitleColorSelected = colorSelected;
        return this;
    }

    public BottomBarTab setStyle(BottomBarBean barBean) {
        if (barBean != null) {
            String loadTagImg = barBean.getLoadTagImg();
            boolean selected = barBean.isSelected();
            if (IMG_LOAD_FROM_NET.equals(loadTagImg)) {
                //加载网络图片
                String iconUrlNormal = barBean.getIconUrlNormal();
                String iconUrlSelect = barBean.getIconUrlSelect();
                setSelect(selected, iconUrlSelect, iconUrlNormal);
            } else if (IMG_LOAD_LOCAL.equals(loadTagImg)) {
                //加载本地图片
                int iconResNormal = barBean.getIconResNormal();
                int iconResSelect = barBean.getIconResSelect();
                setSelect(selected, iconResSelect, iconResNormal);
            } else {
                //默认加载本地图片
                int iconResNormal = barBean.getIconResNormal();
                int iconResSelect = barBean.getIconResSelect();
                setSelect(selected, iconResSelect, iconResNormal);
            }

            String loadTagText = barBean.getLoadTagText();
            if (TEXT_LOAD_FROM_NET.equals(loadTagImg)) {
                //加载网络文字

            } else if (TEXT_LOAD_LOCAL.equals(loadTagImg)) {
                //加载本地文字
            } else {
                //默认加载本地文字
            }

        } else {
            LogUtil.e(logTag, "BottomBarBean is null");
        }
        return this;
    }


    //设置选中状态
    public void setSelect(boolean isSelected) {
        if (isSelected) {
            //选中状态
            mBottomIcon.setSelected(true);
            mBottomTitle.setTextColor(getResources().getColor(mTitleColorSelected));
        } else {
            //未选中状态
            mBottomIcon.setSelected(false);
            mBottomTitle.setTextColor(getResources().getColor(mTitleColorNormal));
        }
    }

    /**
     * 设置网络图片选中状态
     *
     * @param isSelected  选中状态
     * @param selectedUrl 选中的图片
     * @param normalUrl   未选中的图片
     */
    public void setSelect(boolean isSelected, String selectedUrl, String normalUrl) {
        if (isSelected) {
            //选中状态
            //ImageLoad.getInstance().glideSimple(mContext, mBottomIcon, selectedUrl);
        } else {
            //未选中状态
            //ImageLoad.getInstance().glideSimple(mContext, mBottomIcon, normalUrl);
        }
    }


    /**
     * 设置本地图片选中状态
     *
     * @param isSelected       选中状态
     * @param selectedDrawable 选中的图片
     * @param normalDrawable   未选中的图片
     */
    public void setSelect(boolean isSelected, int selectedDrawable, int normalDrawable) {
        if (isSelected) {
            //选中状态
            mBottomIcon.setImageResource(selectedDrawable);
        } else {
            //未选中状态
            mBottomIcon.setImageResource(normalDrawable);
        }
    }

    /**
     * 设置文字选中状态
     *
     * @param isSelected  选中状态
     * @param selectedColor 选中的图片
     * @param normalColor   未选中的图片
     */
    public void setSelect(boolean isSelected, String title, int selectedColor, String normalColor) {
        mBottomTitle.setText(title);
        if (isSelected) {
            //选中状态
            //mBottomTitle.setTextColor();
        } else {
            //未选中状态
            //ImageLoad.getInstance().glideSimple(mContext, mBottomIcon, normalUrl);
        }
    }


    //隐藏文字
    public void setTitleHide() {
        mBottomTitle.setVisibility(GONE);
    }

    //隐藏红点
    public void setDotHide() {
        mBottomDot.setVisibility(GONE);
    }

    //显示红点
    public void setDotShow() {
        mBottomDot.setVisibility(VISIBLE);
    }

    //隐藏小图标
    public void setBadgeHide() {
        mBottomBadge.setVisibility(GONE);
    }

    //显示小图标
    public void setBadgeShow() {
        mBottomBadge.setVisibility(VISIBLE);
    }

    //设置小图标显示的数,小于等于零不显示,大于99显示···
    public void setBadgeText(int number) {
        if (number > 0) {
            mBottomBadge.setVisibility(View.VISIBLE);
            if (number > 99) {
                mBottomBadge.setText("···");
            } else {
                String text = "" + number;
                mBottomBadge.setText(text);
            }
        } else {
            mBottomBadge.setVisibility(View.GONE);
        }
    }

    //分别对外提供获取各控件的方法
    public ImageView getBottomIcon() {
        return mBottomIcon;
    }

    public TextView getBottomTitle() {
        return mBottomTitle;
    }

    public TextView getBottomDot() {
        return mBottomDot;
    }

    public TextView getBottomBadge() {
        return mBottomBadge;
    }

    public FrameLayout getBottomIconFr() {
        return mBottomIconFr;
    }

}