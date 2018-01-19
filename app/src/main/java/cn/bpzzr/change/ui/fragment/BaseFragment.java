package cn.bpzzr.change.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bpzzr.change.R;

/**
 * Created by ZYY
 * on 2018/1/16 21:36.
 * @author ZYY
 */

public class BaseFragment extends RxFragment {
    protected Context mContext;
    protected View mRootView;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
           // mRootView = createView(inflater, container, savedInstanceState);
        }

        mContext = mRootView.getContext();
        return mRootView;
    }



    @Nullable
    @Override
    public View getView() {
        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }
}
