package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.ui.view.StateLayout;
import cn.bpzzr.change.util.LogUtil;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * Created by ZYY
 * on 2018/1/16 21:36.
 * 可刷新的Fragment页面基类
 *
 * @author ZYY
 */

public class BaseFragmentRefreshPage extends RxFragment {
    public String mFragmentTag = this.getClass().getSimpleName();
    //屏幕的宽高
    public int screenWidth;
    public int screenHeight;
    //recycler view
    public RecyclerView mRecyclerView;
    //下拉刷新的
    public PtrClassicFrameLayout mPtrClassicFrameLayout;

    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private List<String> mPhotos;
    private RecyclerView.Adapter adapter = null;
    private StateLayout mStateLayout;

    /**
     * 最早调用
     *
     * @param isVisibleToUser 对用户是否可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        LogUtil.e(mFragmentTag, " setUserVisibleHint() --> isVisibleToUser = " + isVisibleToUser);
        //对用户可见时，又不需要更新ui时的操作可在此处进行
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(mFragmentTag, " onCreate() --> isVisibleToUser = " + getUserVisibleHint());
        DisplayMetrics dm = getActivity().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        super.onCreate(savedInstanceState);
    }

    /**
     * 创建view，加载布局
     *
     * @param inflater           布局加载器
     * @param container          容器
     * @param savedInstanceState 保存fragment的状态
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.e(mFragmentTag, " onCreateView()");
        if (mStateLayout == null) {
            //创建状态层并添加基础布局
            mStateLayout = new StateLayout(container.getContext());
            mStateLayout.setSuccessView(R.layout.base_fragment_refresh);
        }
        return mStateLayout;
    }

    /**
     * 界面布局成功加载后
     *
     * @param view               根布局
     * @param savedInstanceState 保存fragment的状态
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.e(mFragmentTag, " onViewCreated()");
        mRecyclerView = view.findViewById(R.id.m_recycler_view);
        mPtrClassicFrameLayout = view.findViewById(R.id.m_ptr_classic_frame_layout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.e(mFragmentTag, " onActivityCreated()");

        //adapter = new MyAdapter(null, getActivity());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.e(mFragmentTag, " onStart()");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }
}
