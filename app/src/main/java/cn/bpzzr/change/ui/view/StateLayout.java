package cn.bpzzr.change.ui.view;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.bpzzr.change.R;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/1/19.
 * 状态层用于控制显示状态
 */

public class StateLayout extends FrameLayout {
    public String stateTag = getClass().getSimpleName();
    //根布局
    public View mRootView;
    //进度条
    public ProgressBar mStatePbLoading;
    //状态提示的图
    public ImageView mStateIv;
    //状态提示的文字
    public TextView mStateTv;
    //包裹状态提示的容器
    public LinearLayout mStateLlUnSuccess;
    private String mDefaultTipsLoading;
    private String mDefaultTipsFailure;
    private String mDefaultTipsEmpty;
    //成功的布局
    public View mSuccessView;
    /**
     * 当前是否显示的是成功的布局
     */
    private boolean isSuccessShow;
    private RetryListener retryListener;

    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //将状态层布局加载进来
        mRootView = View.inflate(context, R.layout.state_on_common, this);
        mStatePbLoading = mRootView.findViewById(R.id.state_pb_loading);
        mStateIv = mRootView.findViewById(R.id.state_iv);
        mStateTv = mRootView.findViewById(R.id.state_tv);
        mStateLlUnSuccess = mRootView.findViewById(R.id.state_ll_un_success);
        //加载默认的提示文字
        mDefaultTipsLoading = getResources().getString(R.string.state_on_loading);
        mDefaultTipsFailure = getResources().getString(R.string.state_on_failure);
        mDefaultTipsEmpty = getResources().getString(R.string.state_on_empty);
        //设置点击事件
        mStateLlUnSuccess.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSuccessShow) {
                    //为非成功布局则设置点击事件的回调
                    if (retryListener != null) {
                        retryListener.onRetry();
                    }
                }
            }
        });
    }

    /**
     * 设置点击重新加载或别的操作的监听器
     *
     * @param retryListener 监听器
     */
    public void setRetryListener(RetryListener retryListener) {
        this.retryListener = retryListener;
    }

    /**
     * 展示加载中状态
     */
    public void showLoading() {
        LogUtil.e(stateTag, "on loading......");
        //隐藏图片，显示进度条
        mStatePbLoading.setVisibility(VISIBLE);
        mStateIv.setVisibility(GONE);
        mStateTv.setText(mDefaultTipsLoading);
        hideSuccessView();
    }

    /**
     * 展示加载中状态
     *
     * @param tips 状态提示的文字
     */
    public void showLoading(String tips) {
        showLoading();
        //设置文字
        mStateTv.setText(tips);
    }

    private void showUnSuccess(boolean isEmpty) {
        LogUtil.e(stateTag, "on unSuccess......isEmpty..." + isEmpty);
        //隐藏进度条，显示图片
        mStatePbLoading.setVisibility(GONE);
        mStateIv.setVisibility(VISIBLE);
        mStateTv.setText(isEmpty ? mDefaultTipsEmpty : mDefaultTipsFailure);
    }

    /**
     * 展示加载失败状态
     */
    public void showFailure() {
        //隐藏进度条，显示图片
        showUnSuccess(false);
        hideSuccessView();
    }

    /**
     * 展示加载失败状态
     *
     * @param imgResId 图片资源id
     * @param tips     状态提示文字
     */
    public void showFailure(@DrawableRes int imgResId, String tips) {
        showFailure();
        mStateIv.setImageResource(imgResId);
        mStateTv.setText(tips);
    }

    /**
     * 展示加载空数据状态
     */
    public void showEmpty() {
        //隐藏进度条，显示图片
        showUnSuccess(true);
        hideSuccessView();
    }

    /**
     * 展示加载空数据状态
     *
     * @param imgResId 图片资源id
     * @param tips     状态提示文字
     */
    public void showEmpty(@DrawableRes int imgResId, String tips) {
        showEmpty();
        mStateIv.setImageResource(imgResId);
        mStateTv.setText(tips);
    }

    /**
     * 添加加载成功的布局
     *
     * @param successLayoutId 数据界面的布局id
     */
    public void setSuccessView(@LayoutRes int successLayoutId) {
        if (mSuccessView == null) {
            mSuccessView = View.inflate(getContext(), successLayoutId, null);
        }
        if (getChildCount() == 1) {
            addView(mSuccessView);
        } else {
            LogUtil.e(stateTag, "child count more than 1");
        }
    }

    /**
     * 展示加载成功的布局
     */
    public void showSuccessView() {
        LogUtil.e(stateTag, "on success......");
        mStateLlUnSuccess.setVisibility(GONE);
        if (mSuccessView != null) {
            isSuccessShow = true;
            mSuccessView.setVisibility(VISIBLE);
        }
    }

    /**
     * 隐藏成功层
     */
    public void hideSuccessView() {
        isSuccessShow = false;
        if (mSuccessView != null) {
            mSuccessView.setVisibility(GONE);
        }
    }

    public interface RetryListener {
        void onRetry();
    }
}
