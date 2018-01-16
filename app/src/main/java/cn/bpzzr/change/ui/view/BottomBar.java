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

    public void setAdapter(final BottomBarAdapter adapter) {
        if (adapter != null) {
            //adapter不为空
            adapter.setOnDataChanged(new OnDataChanged() {
                @Override
                public void onChange() {
                    LogUtil.e(LOG_TAG,"----data has changed----");
                    addTabView(adapter);
                }
            });
            addTabView(adapter);
        } else {
            LogUtil.e(LOG_TAG, "--------BottomBarAdapter is null !--------");
        }
    }

    private void addTabView(BottomBarAdapter adapter) {
        //控制标签数量在0-5之间
        int tabCount = adapter.getTabCount();
        if (tabCount < 0) {
            LogUtil.e(LOG_TAG, "--------The tab count can only be 0 to 5 !-------");
            tabCount = 0;
        }
        if (tabCount >= 5){
            LogUtil.e(LOG_TAG, "--------The tab count can only be 0 to 5 !-------");
            tabCount = 5;
        }
        //添加之前先移除所有子控件
        removeAllViews();
        for (int i = 0; i < tabCount; i++) {
            //获取标签View
            View tabView = adapter.getTabView(this, i);
            tabView.setOnClickListener(new ItemClickListener(adapter, i));
            addView(tabView, params);
        }
    }

    /**
     * 获取底部导航栏的标签对象
     *
     * @param position 索引
     * @return 返回标签对象，若无则返回null
     */
    public View getBarTab(int position) {
        if (position >= 0 && position < 5) {
            //在范围中
            return getChildAt(position);
        } else {
            //不在范围中
            LogUtil.e(LOG_TAG, "----position is out of index!----");
            return null;
        }
    }


    public abstract static class BottomBarAdapter {
        /**
         * 数据变化监听器
         */
        private OnDataChanged onDataChanged;

        /**
         * 获取标签的数量
         */
        public abstract int getTabCount();

        /**
         * 获取标签的View对象
         *
         * @param parent   容器
         * @param position 索引
         * @return 返回View对象
         */
        public abstract View getTabView(BottomBar parent, int position);

        /**
         * 设置条目点击事件
         *
         * @param itemView 条目View
         * @param parent   容器
         * @param position 索引
         */
        public abstract void onItemClick(View itemView, BottomBar parent, int position);

        /**
         * 数据源发生变化则调用对应的方法
         */
        public void notifyDataSetChanged() {
            onDataChanged.onChange();
        }

        public void setOnDataChanged(OnDataChanged onDataChanged) {
            this.onDataChanged = onDataChanged;
        }
    }

    public interface OnDataChanged {
        void onChange();
    }

    public class ItemClickListener implements OnClickListener {

        int selectPosition;
        BottomBarAdapter adapter;

        public ItemClickListener(BottomBarAdapter adapter, int selectPosition) {
            this.adapter = adapter;
            this.selectPosition = selectPosition;
        }

        @Override
        public void onClick(View v) {
            //处理单选
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = BottomBar.this.getChildAt(i);
                if (childAt != null) {
                    childAt.setSelected(selectPosition == i);
                }
            }
            //条目点击事件
            adapter.onItemClick(v, BottomBar.this, selectPosition);
        }
    }

}
