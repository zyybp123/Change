package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;

import cn.bpzzr.change.adapter.base.BaseLinearAdapter;
import cn.bpzzr.change.util.LogUtil;


/**
 * Created by Administrator on 2018/2/23.
 * 自适应布局容器
 * <p>flexDirection 主轴上的方向
 * row（默认值）：主轴为水平方向，起点在左端
 * row_reverse：主轴为水平方向，起点在右端。
 * column：主轴为垂直方向，起点在上沿
 * column_reverse：主轴为垂直方向，起点在下沿
 * <p>flexWrap 换行
 * nowrap ：不换行
 * wrap：按正常方向换行
 * wrap_reverse：按反方向换行
 * <p>justifyContent 主轴上的对齐方式
 * flex_start（默认值）：左对齐
 * flex_end：右对齐
 * center： 居中
 * space_between：两端对齐，项目之间的间隔都相等。
 * space_around：每个项目两侧的间隔相等。项目之间的间隔比项目与边框的间隔大一倍。
 * <p>alignItems 在副轴上的对齐方式
 * flex-start：交叉轴的起点对齐。
 * flex-end：交叉轴的终点对齐。
 * center：交叉轴的中点对齐。
 * baseline: 项目的第一行文字的基线对齐。
 * stretch（默认值）：如果项目未设置高度或设为auto，将占满整个容器的高度。
 *
 */

public class FlexContainer extends FlexboxLayout {
    public final String LOG_TAG = this.getClass().getSimpleName();
    /**
     * 添加标签时的参数
     */
    private ViewGroup.LayoutParams mParams;
    /**
     * 是否均分，默认均分，true为均分
     */
    private boolean mIsAverage = true;

    public FlexContainer(Context context) {
        this(context, null);
    }

    public FlexContainer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlexContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //获取此线性布局的方向,设置布局参数
        setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);
        /*int orientation = getOrientation();
        if (orientation == VERTICAL) {
            if (mIsAverage) {
                //垂直布局,均分
                mParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            } else {
                //垂直布局，不均分
                mParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        } else if (orientation == HORIZONTAL) {
            if (mIsAverage) {
                //水平布局,均分
                mParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT, 1);
            } else {
                //水平布局,不均分
                mParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            }
        }*/
    }

    /**
     * 设置适配器
     *
     * @param adapter 数据适配器
     */
    public void setAdapter(final BaseLinearAdapter adapter) {
        if (adapter != null) {
            //adapter不为空
            adapter.setOnDataChanged(new BaseLinearAdapter.OnDataChanged() {
                @Override
                public void onChange() {
                    LogUtil.e(LOG_TAG, "----data has changed----");
                    addTabView(adapter);
                }
            });
            addTabView(adapter);
        } else {
            LogUtil.e(LOG_TAG, "--------BottomBarAdapter is null !--------");
        }
    }

    /**
     * 添加标签
     *
     * @param adapter 数据适配器
     */
    public void addTabView(BaseLinearAdapter adapter) {
        //获取标签数量
        int tabCount = adapter.getTabCount();
        //添加之前先移除所有子控件
        removeAllViews();
        for (int i = 0; i < tabCount; i++) {
            //获取标签View,并添加到容器
            View tabView = adapter.getTabView(this, i);
            tabView.setOnClickListener(new ItemClickListener(adapter, i));
            addView(tabView, mParams);
        }
    }

    /**
     * 获取标签View对象
     *
     * @param position 索引
     * @return 返回标签对象，若无则返回null
     */
    public View getTab(int position) {
        int childCount = getChildCount();
        //容错
        if (position < 0) {
            position = 0;
        }
        if (position >= childCount) {
            position = childCount - 1;
        }
        //在范围中
        return getChildAt(position);
    }

    /**
     * 条目点击事件监听器
     */
    public class ItemClickListener implements OnClickListener {
        int selectPosition;
        BaseLinearAdapter adapter;

        ItemClickListener(BaseLinearAdapter adapter, int selectPosition) {
            this.adapter = adapter;
            this.selectPosition = selectPosition;
        }

        @Override
        public void onClick(View v) {
            //条目点击事件
            adapter.onItemClick(v, FlexContainer.this, selectPosition);
        }
    }
}
