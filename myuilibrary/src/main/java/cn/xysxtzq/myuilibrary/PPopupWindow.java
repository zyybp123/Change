package cn.xysxtzq.myuilibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.HashMap;
import java.util.Map;

import cn.xysxtzq.myuilibrary.page.BasePage;
import cn.xysxtzq.myuilibrary.util.DimensionUtil;
import cn.xysxtzq.myuilibrary.util.LogUtil;


/**
 * Created by Administrator on 2018/2/24.
 * 封装一个利用popupWindow的显示控件（为全屏的pop）
 * TOP,相对于某控件显示（例如下拉筛选菜单）
 * CENTER,在屏幕中间
 * BOTTOM,在屏幕底部，例如底部筛选栏
 */

public class PPopupWindow {
    public static final int TOP = 0;
    public static final int CENTER = 1;
    public static final int BOTTOM = 2;
    private static final String TAG = "PPopupWindow";
    private PopupWindow pw;
    /**
     * 根布局
     */
    private View mRootView;
    /**
     * 页面容器，由外部实现
     */
    private FrameLayout mPageContainer;
    /**
     * 布局参数，将子页面添加进容器时用到
     */
    FrameLayout.LayoutParams mLayoutParams;
    /**
     * pop内的页面map，按筛选页面的标识存储
     */
    private Map<String, BasePage> pageMap;
    private BasePage currentPage;
    /**
     * 非透明区域距离容器的左上右下的边距
     */
    private int mLeftMargin = 0;
    private int mTopMargin = 0;
    private int mRightMargin = 0;
    private int mBottomMargin = 0;

    public PPopupWindow(Context context) {
        //加载根布局
        mRootView = View.inflate(context, R.layout.p_popup_base_layout, null);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击根布局，隐藏pop
                hidePop();
            }
        });
        mPageContainer = mRootView.findViewById(R.id.fl_page);
        createLayoutParam();
        //设置高度
        pw.setHeight(DimensionUtil.totalSize(context).y);
        //popupWindow引入根布局
        pw = new PopupWindow(mRootView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //初始一个新的map
        pageMap = new HashMap<>();
    }

    private PopupWindow getPopupWindow() {
        return pw;
    }


    private void setMLayoutParams(int mLeftMargin, int mTopMargin, int mRightMargin, int mBottomMargin) {
        if (mLayoutParams == null) {
            //创建一个布局参数
            mLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
        }
        this.mLeftMargin = mLeftMargin;
        this.mTopMargin = mTopMargin;
        this.mRightMargin = mRightMargin;
        this.mBottomMargin = mBottomMargin;
    }

    private void createLayoutParam() {
        //创建一个布局参数
        mLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    private void setMargin() {
        mLayoutParams.leftMargin = mLeftMargin;
        mLayoutParams.topMargin = mTopMargin;
        mLayoutParams.rightMargin = mRightMargin;
        mLayoutParams.bottomMargin = mBottomMargin;
    }

    public void setAnim(){
        //设置出现的动画
        //pw.setAnimationStyle(R.style.FilterPopupAnimation);
        //设置背景
        pw.setBackgroundDrawable(new ColorDrawable(Color.argb(127, 0, 0, 0)));
        //设置点击空白是否消失
        //pw.setOutsideTouchable(true);
    }

    public void setBackground(){

    }

    public  void setOutside(){

    }
    /**
     * 初始化popWindow
     *
     * @param v 相对于哪个控件显示
     */
    public void initPop(View v, BasePage page) {
        if (mRootView == null || page == null) {
            LogUtil.e(TAG, "root view or page is null !" + mRootView + "..." + page);
            return;
        }
        View pageMRootView = page.getMRootView();
        if (pageMRootView == null) {
            LogUtil.e(TAG, "pageMRootView is null !");
            return;
        }
        if (pw == null) {
            LogUtil.e(TAG, "popupWindow is null !");
            //如果pop对象为null则重新创建
            pw = new PopupWindow(mRootView, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
        }
        if (mLayoutParams == null) {
            LogUtil.e(TAG, "mLayoutParams is null !");
            //布局参数为空，重新创建
            createLayoutParam();
        }
        if (pageMap == null) {
            LogUtil.e(TAG, "pageMap is null !");
            //如果map为null则新建一个map
            pageMap = new HashMap<>();
        }
        if (!pageMap.containsValue(page)) {
            //如果map中没有此页面，则将页面添加到map，再加入容器
            pageMap.put(page.getPageTag(), page);
        }
        //如果已经包含了此页面，则直接添加进容器
        mPageContainer.removeAllViews();
        mPageContainer.addView(pageMRootView, mLayoutParams);
        //保存当前page实例
        currentPage = page;
        //不为null则不重新创建，并添加子页面
        if (!pw.isShowing()) {
            //如果pop不在显示中，就显示
            showAsDropDown(pw, v, 0, 0);
            //设置是否显示
            isShow = false;
        }
    }

    /**
     * 解决6.0以后pop的显示问题
     *
     * @param pw     popupWindow
     * @param anchor v
     * @param xOff   x轴偏移
     * @param yOff   y轴偏移
     */
    private void showAsDropDown(PopupWindow pw, View anchor, int xOff, int yOff) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Rect visibleFrame = new Rect();
            anchor.getGlobalVisibleRect(visibleFrame);
            int height = anchor.getResources().getDisplayMetrics().heightPixels - visibleFrame.bottom;
            pw.setHeight(height);
            pw.showAsDropDown(anchor, xOff, yOff);
        } else {
            pw.showAsDropDown(anchor, xOff, yOff);
        }
        isShow = true;
    }

    /**
     * 记录pop是否显示
     */
    private boolean isShow = true;

    /**
     * 隐藏pop的方法
     */
    public void hidePop() {
        if (pw != null) {
            pw.dismiss();
            isShow = false;
        }
    }

    /**
     * 获取当前pop里的页面对象
     *
     * @return 返回当前pop里的页面对象
     */
    public BasePage getCurrentPage() {
        return currentPage;
    }

}
