package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/1/15.
 * 底部导航栏
 */

public class BottomBar extends LinearLayout {

    public final String LOG_TAG = this.getClass().getSimpleName();
    ViewGroup.LayoutParams params;

    public BottomBar(Context context) {
        this(context, null);
    }

    public BottomBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 1);
    }

    public void setAdapter(BottomBarAdapter adapter) {
        if (adapter != null) {
            //adapter不为空
            int tabCount = adapter.getTabCount();
            if (tabCount >= 0 && tabCount < 5) {
                //标签数量在0-5之间
                for (int i = 0; i < tabCount; i++) {
                    //获取标签View
                    View tabView = adapter.getTabView(this, i);
                    addView(tabView, params);
                }
            } else {
                LogUtil.e(LOG_TAG, "--------The tab count can only be 0 to 5 !-------");
            }
        } else {
            LogUtil.e(LOG_TAG, "--------BottomBarAdapter is null !--------");
        }
    }


    public abstract static class BottomBarAdapter {
        //获取标签的数量
        public abstract int getTabCount();

        //获取标签的View对象
        public abstract View getTabView(BottomBar parent, int position);
    }

}
