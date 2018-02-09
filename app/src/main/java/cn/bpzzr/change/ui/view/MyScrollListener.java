package cn.bpzzr.change.ui.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import org.jetbrains.annotations.Contract;

import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/2/7.
 * RecyclerView的滑动处理监听器
 */

public class MyScrollListener extends RecyclerView.OnScrollListener {
    public static final String TAG = "MyScrollListener";
    /**
     * x方向的总偏移量
     */
    private int xOffSet;
    /**
     * y方向的总偏移量
     */
    private int yOffSet;
    /**
     * 一页的宽(左右)
     */
    private int mOnePageDistance;
    /**
     * 当前的页码
     */
    private int mCurrentItemPos;
    /**
     * 滑动的方向
     */
    private int orientation;
    /**
     * 默认不是水平方向
     */
    private boolean isVertical = false;

    private CardLinearSnapHelper mLinearSnapHelper = new CardLinearSnapHelper();

    /**
     * 构造
     *
     * @param mOnePageDistance 一页的宽或高
     * @param orientation      滑动的方向
     */
    public MyScrollListener(int mOnePageDistance, int orientation) {
        super();
        this.mOnePageDistance = mOnePageDistance;
        this.orientation = orientation;
        isVertical = orientation == LinearLayoutManager.VERTICAL;
    }
    /**
     * 构造
     *
     * @param mOnePageDistance 一页的宽或高
     * @param orientation      滑动的方向
     */
    public MyScrollListener(int mOnePageDistance, int orientation,RecyclerView recyclerView) {
        super();
        this.mOnePageDistance = mOnePageDistance;
        this.orientation = orientation;
        isVertical = orientation == LinearLayoutManager.VERTICAL;
        if (recyclerView != null){
            mLinearSnapHelper.attachToRecyclerView(recyclerView);
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                mLinearSnapHelper.mNoNeedToScroll = getAnXOrY() == 0 ||
                        getAnXOrY() == getDestItemOffset(adapter.getItemCount() - 1);
            }
        } else {
            mLinearSnapHelper.mNoNeedToScroll = false;
        }
    }

    @Contract(pure = true)
    private int getAnXOrY() {
        return isVertical ? yOffSet :xOffSet;
    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        xOffSet += dx;
        yOffSet += dy;
        computeCurrentItemPos();
    }

    @Contract(pure = true)
    private int getDestItemOffset(int destPos) {
        return mOnePageDistance * destPos;
    }

    /**
     * 计算页码
     */
    private void computeCurrentItemPos() {
        if (mOnePageDistance <= 0) {
            //一页的宽度小于等于零，不处理
            return;
        }
        //是否翻页的标识
        boolean pageChanged = false;
        //滑动超过一页说明已翻页
        if (Math.abs((getAnXOrY()) - mCurrentItemPos * mOnePageDistance) >= mOnePageDistance) {
            pageChanged = true;
        }
        if (pageChanged) {
            //如果已经翻页，记录当前页的索引
            int tempPos = mCurrentItemPos;
            mCurrentItemPos = (getAnXOrY()) / mOnePageDistance;
            LogUtil.e(TAG, String.format("tempPos=%s, mCurrentItemPos=%s", tempPos, mCurrentItemPos));
        }
    }

    public int getMCurrentItemPos() {
        return mCurrentItemPos;
    }

    public void setMCurrentItemPos(int mCurrentItemPos) {
        this.mCurrentItemPos = mCurrentItemPos;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    /**
     * 防止卡片在第一页和最后一页因无法"居中"而一直循环调用
     * onScrollStateChanged-->SnapHelper.snapToTargetExistingView-->onScrollStateChanged
     */
    public class CardLinearSnapHelper extends LinearSnapHelper {
        public boolean mNoNeedToScroll = false;

        @Override
        public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
            if (mNoNeedToScroll) {
                return new int[]{0, 0};
            } else {
                return super.calculateDistanceToFinalSnap(layoutManager, targetView);
            }
        }

    }
}
