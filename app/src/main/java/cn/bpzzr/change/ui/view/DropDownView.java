package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2FilterSelectOne;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.LogUtil;
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
        mBtnReset.setOnClickListener(this);
        mBtnSure.setOnClickListener(this);
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
    }

    /**
     * 初始化popWindow
     *
     * @param v 相对于哪个控件显示
     */
    public void initPop(View v, View page) {
        if (mRootView == null) {
            //如果根布局为null直接返回，不做处理
            LogUtil.e(TAG, "root view is null !");
            return;
        }
        if (pw == null) {
            //如果pop对象为null则重新创建
            pw = new PopupWindow(mRootView, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
        }
        if (mLayoutParams == null) {
            //布局参数为null则重新创建
            mLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            //设置其离底部边距为屏幕高度的四分之一
            mLayoutParams.bottomMargin = UiUtil.totalSize(mContext).y / 4;
        }
        //不为null则不重新创建，并添加子页面
        mPageContainer.addView(page, mLayoutParams);
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
     * 获取单选的页面
     *
     * @param context 上下文
     * @param data    填充的数据
     * @return 返回页面对象
     */
    public View getSelectOnePage(Context context, List<FilterRadioData<String>> data) {
        View view = View.inflate(context, R.layout.drop_down_select_one, null);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(BaseFragmentRefreshPage.
                getLinearLayoutManager(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new Adapter2FilterSelectOne<>(R.layout.item_filter_select_one, data));
        return view;
    }

    public View getSelectTabPage(Context context) {
        View view = View.inflate(context, R.layout.drop_down_select_one, null);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
