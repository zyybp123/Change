package cn.bpzzr.change.ui.fragment;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2Home;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.home.ServerPath;
import cn.bpzzr.change.interf.kaishu.KaiInitService;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.callback.MyObserverSimple;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.AESUtil;
import cn.bpzzr.change.util.KaiShuDeviceUtil;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;
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

public class HomeFragment extends BaseFragmentRefreshPage implements MVP.View{

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
        //KotlinTest test = new KotlinTest("12", "HomePage.......");
        //String name = test.getName();
        LogUtil.e(mFragmentTag + getTag(),"is a http url..."+ StringUtil.isAHttpUrl("1234"));

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
                .create(KaiInitService.class)
                .getDeviceId(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserverSimple<>(this, KaiInitService.PATH_DEVICE_ID));

        AESUtil aesUtil = new AESUtil(KaiShuDeviceUtil.APP_SECRET_KAI_NORMAL);
        String decrypt = aesUtil.decrypt("wgWN92buwMm/je7gtXl0YPvMqUZfjBb3TYahBFb+WXrdjeLhiKI+fBv+AQnS2gdY0Vdv1yPwrs+M" +
                "CQxGUY2xWHtYy3a/ezym7SyuDeMpCaJBDkrDoao+S4DF6bjdoy8ogTTxxniH7lCzgVMzJxNHm+T5" +
                "2gBUKmEL7OwlDrD+uUa0t2yI9SNSmT8c+n3lEgs73qyZf/jhecXmdqUi4sZSi90x+1vO3LmUaUUt" +
                "gV763OeslebBJrp7xOULQH/3Cn8X");
        String decrypt2 = aesUtil.decrypt("9Wk6r7DBfdobfB+Zb2rWw2UoFAPMZ1KcG+/6UCmYuat2BZMAUPWzojkCByKhJ1uDNx7uMcZKbYTj" +
                "gip0kZ8oXxnlzPixOVZqahfGYCasTKtd1cjCqblx/1wcntJtRaM4CwS51gux7CrnnRJuj9FyFY7s" +
                "80tx7g8aqj+agqRGwwH6JvodLuZRAsBhndMrkvJR6uVcTKmI8+1fQfGhI7tsdf80YR+eM2vqAjld" +
                "SrQStHagpEfc5efN66MxeHX3S6N7mIG/d53DI+dxIEL2X+h9OOEpQpCaeOGu3IEdsf9wWAedRM6L" +
                "3RLKrQ/t8xd18P/DYGZSCL8kPdukGCDGp3ZBa6TKG2fesMox/ta4LDQlBNI=");
        LogUtil.e(mFragmentTag + getTag(), "解密 >> " + decrypt2);
    }

    @Override
    protected void refreshRequest() {
        retrofitTools.getTest3(this);
    }

    @Override
    protected void loadMoreRequested() {
    }

    @Override
    public void onRequestStart(String tag) {

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
