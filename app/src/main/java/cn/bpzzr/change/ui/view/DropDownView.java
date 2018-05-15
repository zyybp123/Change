package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.HashMap;
import java.util.Map;

import cn.bpzzr.change.R;
import cn.bpzzr.change.ui.page.BasePage;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;
import cn.bpzzr.change.util.UiUtil;

import static cn.bpzzr.change.global.Change.mContext;

/**
 * Created by Administrator on 2018/2/24.
 * 封装一个利用popupWindow的下拉筛选显示控件
 */

public class DropDownView implements View.OnClickListener {
    private static final String TAG = "DropDownView";
    /**
     * popup
     */
    private PopupWindow pw;
    /**
     * 根布局
     */
    private View mRootView;
    /**
     * 页面容器，不同的菜单对应的页面会有所不同
     */
    private FrameLayout mPageContainer;
    /**
     * 重置按钮
     */
    private Button mBtnReset;
    /**
     * 确定按钮
     */
    private Button mBtnSure;
    /**
     * 按钮栏，底部栏容器
     */
    private LinearLayout mLLBottom;
    /**
     * 布局参数，将子页面添加进容器时用到
     */
    FrameLayout.LayoutParams mLayoutParams;
    /**
     * pop内的页面map，按筛选页面的标识存储
     */
    private Map<String, BasePage> pageMap;
    /**
     * 当前页面
     */
    private BasePage currentPage;

    public DropDownView(Context context) {
        //加载根布局
        mRootView = View.inflate(context, R.layout.drop_down_layout, null);
        //为根布局设置点击事件
        mRootView.setOnClickListener(this);
        //找到对应的控件
        mPageContainer = mRootView.findViewById(R.id.fl_page);
        mLLBottom = mRootView.findViewById(R.id.ll_bottom);
        mBtnReset = mRootView.findViewById(R.id.btn_reset);
        mBtnSure = mRootView.findViewById(R.id.btn_sure);
        //设置重置确定的点击事件
        //mBtnReset.setOnClickListener(this);
        //mBtnSure.setOnClickListener(this);
        //创建一个布局参数
        mLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置其离底部边距为屏幕高度的四分之一
        mLayoutParams.bottomMargin = UiUtil.totalSize(context).y / 4;
        //popupWindow引入根布局
        pw = new PopupWindow(mRootView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //设置出现的动画
        pw.setAnimationStyle(R.style.FilterPopupAnimation);
        //设置高度
        pw.setHeight(UiUtil.totalSize(context).y);
        //设置背景颜色
        pw.setBackgroundDrawable(new ColorDrawable(mContext.getResources().getColor(R.color.black_a50)));
        //设置点击空白是否消失
        //pw.setOutsideTouchable(true);
        //初始一个新的map
        pageMap = new HashMap<>();
    }

    /**
     * 初始化popWindow
     *
     * @param v 相对于哪个控件显示
     */
    public void initPop(View v, BasePage page) {
        if (mRootView == null) {
            //如果根布局为null直接返回，不做处理
            LogUtil.e(TAG, "root view is null !");
            return;
        }
        if (page == null) {
            //如果要添加的页面为空，则不处理
            LogUtil.e(TAG, "page is null !");
            return;
        }
        View pageMRootView = page.getMRootView();
        if (pageMRootView == null) {
            //如果要添加的页面的根布局为空则不处理
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
            //布局参数为null则重新创建
            mLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            //设置其离底部边距为屏幕高度的四分之一
            mLayoutParams.bottomMargin = UiUtil.totalSize(mContext).y / 4;
        }
        if (pageMap == null) {
            LogUtil.e(TAG, "pageMap is null !");
            //如果map为null则新建一个map
            pageMap = new HashMap<>();
        }
        if (!pageMap.containsValue(page)) {
            //如果map中没有此页面，则将页面添加到map，再加入容器
            pageMap.put(StringUtil.getNotNullStr(page.getPageTag()), page);
        }
        //如果已经包含了此页面，则直接添加进容器
        mPageContainer.removeAllViews();
        mPageContainer.addView(pageMRootView, mLayoutParams);
        //保存当前page实例
        currentPage = page;
        //不为null则不重新创建，并添加子页面
        if (!pw.isShowing()) {
            LogUtil.e(TAG, "SDK INT ...." + Build.VERSION.SDK_INT);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_root:
                //点击根布局，隐藏pop
                hidePop();
                break;
            case R.id.btn_reset:
                //点击重置

                break;
            case R.id.btn_sure:
                //点击确定
                break;
        }
    }
}
