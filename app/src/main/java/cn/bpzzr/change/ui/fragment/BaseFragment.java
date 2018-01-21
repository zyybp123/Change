package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.ui.view.StateLayout;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by ZYY
 * on 2018/1/16 21:36.
 * Fragment的基类，可以控制是否进行懒加载
 *
 * @author ZYY
 */

public abstract class BaseFragment extends RxFragment implements MVP.Presenter, MVP.View, StateLayout.RetryListener {
    public String mFragmentTag = this.getClass().getSimpleName();
    //屏幕的宽高
    public int screenWidth;
    public int screenHeight;
    /**
     * 以状态层布局作为根布局
     */
    public StateLayout mStateLayout;
    public Unbinder unbinder;
    /**
     * 是否需要懒加载,默认不需要，false，不需要
     */
    public boolean isNeedLazy;
    /**
     * 视图是否已经初初始化
     */
    protected boolean isInit = false;
    protected boolean isLoad = false;
    /**
     * 网络请求器
     */
    public RetrofitTools retrofitTools = RetrofitTools.getInstance(ServerHost.BASE_URL_BOOK);

    /**
     * 最早调用
     *
     * @param isVisibleToUser 对用户是否可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.e(mFragmentTag + getTag(), " setUserVisibleHint() --> isVisibleToUser = " + isVisibleToUser);
        //对用户可见时，又不需要更新ui时的操作可在此处进行
        if (isNeedLazy) {
            isCanLoadData();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(mFragmentTag + getTag(), " onCreate() --> isVisibleToUser = " + getUserVisibleHint());
        DisplayMetrics dm = getActivity().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        isNeedLazy = isNeedLazy();
    }

    /**
     * 是否需要懒加载，由子类实现
     *
     * @return 返回true则需要
     */
    public abstract boolean isNeedLazy();

    /**
     * 创建view，加载布局
     *
     * @param inflater           布局加载器
     * @param container          容器
     * @param savedInstanceState 保存fragment的状态
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.e(mFragmentTag + getTag(), " onCreateView()");
        //创建状态层并添加基础布局,butterKnife绑定控件
        if (mStateLayout == null) {
            //创建状态层并添加基础布局
            mStateLayout = new StateLayout(container.getContext());
            mStateLayout.setSuccessView(getRootViewLayoutId());
        }
        mStateLayout.showLoading();
        mStateLayout.setRetryListener(this);
        return mStateLayout;
    }

    /**
     * 如果需要停止请求，子类可以覆盖此方法处理
     */
    public void stopRequest() {

    }

    /**
     * 获取根布局，由子类来实现
     *
     * @return 返回根布局资源id
     */
    @LayoutRes
    public abstract int getRootViewLayoutId();

    /**
     * 界面布局成功加载后
     *
     * @param view               根布局
     * @param savedInstanceState 保存fragment的状态
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.e(mFragmentTag + getTag(), " onViewCreated()");
        LogUtil.e(mFragmentTag + getTag(), "" + mStateLayout.mSuccessView);
        unbinder = ButterKnife.bind(this, view);
        isInit = true;
        //初始化完成的时候去加载数据
        isCanLoadData();
        initView();
    }

    /**
     * 能否加载数据
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }
        if (isNeedLazy) {
            if (getUserVisibleHint() && !isLoad) {
                initialRequest();
                isLoad = true;
            } else {
                if (isLoad) {
                    stopRequest();
                }
            }
        } else {
            initialRequest();
        }
    }

    /**
     * 初始化界面，比如找到控件
     */
    public abstract void initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.e(mFragmentTag + getTag(), " onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.e(mFragmentTag + getTag(), " onStart()");
        LogUtil.e(mFragmentTag + getTag(), "getUserVisibleHint..." + getUserVisibleHint());
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.e(mFragmentTag + getTag(), " onResume()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        isInit = false;
        isLoad = false;
        LogUtil.e(mFragmentTag + getTag(), "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.e(mFragmentTag + getTag(), "onDestroy()");
    }

    /**
     * 点击重新加载的点击事件在此处理，由子类选择实现
     * 默认点击重新加载
     */
    @Override
    public void onRetry() {
        initialRequest();
    }
}
