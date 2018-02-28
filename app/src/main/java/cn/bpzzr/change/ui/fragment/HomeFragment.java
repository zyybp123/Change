package cn.bpzzr.change.ui.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2Home;
import cn.bpzzr.change.bean.AdBean;
import cn.bpzzr.change.bean.AdParam;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.ServerPath;
import cn.bpzzr.change.interf.kaishu.AppInitService;
import cn.bpzzr.change.interf.kaishu.KaiShuHost;
import cn.bpzzr.change.net.callback.MyObserverSimple;
import cn.bpzzr.change.net.common.FileRequestBody;
import cn.bpzzr.change.ui.activity.HomeActivity;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.ui.view.MyScrollListener;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.UiUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static cn.bpzzr.change.adapter.Adapter2Home.ITEM_BANNER;
import static cn.bpzzr.change.adapter.Adapter2Home.ITEM_CARD;
import static cn.bpzzr.change.adapter.Adapter2Home.ITEM_NORMAL;

/**
 * Created by Administrator on 2018/1/27.
 * 主页
 */

public class HomeFragment extends BaseFragmentRefreshPage {

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(mActivity, VERTICAL);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return new Adapter2Home(mDataList, Temp.urls);
    }

    @Override
    public void successViewBind() {

    }

    private void setTrans(float trans) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option;
            //仅在5.0以后才做此操作
            if (trans <= 0.2) {
                //如果是主页就透明状态栏
                option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

                mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                //不是主页就正常状态栏
                option = View.SYSTEM_UI_FLAG_VISIBLE;
                mActivity.getWindow().setStatusBarColor(mActivity.getTheme().getResources().getColor(R.color.colorPrimary));
            }
            decorView.setSystemUiVisibility(option);
        }
        //view不根据系统窗口来调整自己的布局
        ViewGroup mContentView = (ViewGroup) mActivity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            mChildView.setFitsSystemWindows(false);
            //ViewCompat.setFitsSystemWindows(mChildView, false);
            ViewCompat.requestApplyInsets(mChildView);
        }
    }

    @Override
    protected void onceRequest() {
        hasMore = false;
        //retrofitTools.getTest3(this);
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json;charset=UTF-8"),
                "{\"platform\":\"kaishu\",\"appversion\":\"V4.2.0\",\"sysversion\":\"23\",\"appid\":\"992099001\",\"channelid\":\"yingyongbao\",\"phonemodel\":\"Le X620\",\"phonedevicecode\":\"869552027513993\",\"channelmsg\":\"android\"}");
        retrofitTools
                .getRetrofit()
                .create(AppInitService.class)
                .getDeviceId(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserverSimple<>(this, AppInitService.PATH_DEVICE_ID));
    }

    @Override
    protected void refreshRequest() {
        retrofitTools.getTest3(this);
    }

    @Override
    protected void loadMoreRequested() {
    }

    @Override
    public void onError(String tag, String msg) {
        if (hasMore) {
            (mAdapter).loadMoreFail();
        } else {
            showFailure();
        }
    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        if (ServerPath.GANK_ANDROID.equals(tag)) {
            showSuccess();
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null && results.size() > 0) {
                    for (int i = 0; i < results.size(); i++) {
                        results.get(i).setItemType(ITEM_NORMAL);
                        mDataList.add(results.get(i));
                    }
                    mDataList.addAll(results);
                    GankTest.ResultsBean resultsBean = new GankTest.ResultsBean();
                    resultsBean.setItemType(ITEM_BANNER);
                    mDataList.add(0, resultsBean);

                    GankTest.ResultsBean resultsBean1 = new GankTest.ResultsBean();
                    resultsBean1.setItemType(ITEM_CARD);
                    mDataList.add(1, resultsBean1);
                    mAdapter.notifyDataSetChanged();
                }
                if (mDataList.size() == 0) {
                    showEmpty();
                }
            } else {
                showEmpty();
            }
        }
    }

    @Override
    public void onEmpty(String tag) {

    }

}
