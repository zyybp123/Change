package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.base.Adapter2Test2;
import cn.bpzzr.change.bean.AdBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.home.ServerPath;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.manager.ACache;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.image.ImageLoad;
import cn.bpzzr.change.util.LogUtil;

import static cn.bpzzr.change.global.Change.mContext;

/**
 * Created by ZYY
 * on 2018/1/19 23:07.
 */

public class Temp extends BaseFragmentRefreshPage implements MVP.View{
    public static final String[] urls = {
            "http://a.hiphotos.baidu.com/image/pic/item/500fd9f9d72a6059f550a1832334349b023bbae3.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/a044ad345982b2b713b5ad7d3aadcbef76099b65.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/500fd9f9d72a6059099ccd5a2334349b023bbae5.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/060828381f30e924d7da088847086e061d95f709.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/503d269759ee3d6d453aab8b48166d224e4adef5.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/503d269759ee3d6db032f61b48166d224e4ade6e.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/f31fbe096b63f62493a948d38c44ebf81b4ca36e.jpg",

    };

    public static Temp newInstance(String text) {
        Temp fragmentOne = new Temp();
        Bundle bundle = new Bundle();
        bundle.putString("name", text);
        //fragment保存参数，传入一个Bundle对象
        fragmentOne.setArguments(bundle);
        return fragmentOne;
    }

    @Override
    public boolean isNeedLazy() {
        return true;
    }

    @Override
    public boolean isAutoRefresh() {
        return false;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL);
    }

    @Override
    public BaseQuickAdapter<GankTest.ResultsBean, BaseViewHolder> getAdapter() {
        return new Adapter2Test2(R.layout.item_temp, mDataList);
    }

    @Override
    public void successViewBind() {
    }

    @Override
    protected void onceRequest() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String name = arguments.getString("name");
            if ("1".equals(name)) {
                retrofitTools.getAds(this);
            }
        }
    }

    @Override
    protected void refreshRequest() {
        retrofitTools.getTest3(this);
    }

    @Override
    protected void loadMoreRequested() {
        LogUtil.e("currentPage......" + currentPage);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                //延时两秒，以观察效果
                refreshRequest();
            }
        }, 2000);
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
        LogUtil.e(mFragmentTag, "...result..." + data);
        listData(tag, data);
        adData(tag, data);
        if ("http://yt-adv.nosdn.127.net/channel6/aaej_20180122.mp4".equals(tag)) {


        }
    }

    private void listData(String tag, Object data) {
        if (ServerPath.GANK_ANDROID.equals(tag)) {
            showSuccess();
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null && results.size() > 0) {
                    if (isRefreshing) {
                        mAdapter.setNewData(results);
                    } else {
                        mAdapter.addData(results);
                        mAdapter.loadMoreComplete();
                    }
                    hasMore = currentPage < 2;
                } else {
                    hasMore = false;
                    showEmpty();
                }
                if (mDataList.size() == 0) {
                    showEmpty();
                }
            } else {
                showEmpty();
            }
        }
    }

    private void adData(String tag, Object data) {
        if (ServerPath.WANG_YI_AD.equals(tag)) {
            AdBean adBean = (AdBean) data;
            ACache aCache = ACache.get(getActivity());

            if (adBean != null) {
                List<AdBean.AdsBean> ads = adBean.getAds();
                if (ads != null && ads.size() > 0) {
                    //只拿第一条
                    AdBean.AdsBean adsBean = ads.get(0);
                    if (adsBean != null) {
                        //广告播放的时长
                        int st = adsBean.getSt();
                        aCache.put(SomeKeys.SPLASH_AD_ST, st + "");
                        //应该显示的广告
                        List<AdBean.AdsBean.VisibilityBean> visibility = adsBean.getVisibility();
                        if (visibility != null && visibility.size() > 0) {
                            //仅获取第一个
                            AdBean.AdsBean.VisibilityBean visibilityBean = visibility.get(0);
                            if (visibilityBean != null) {
                                String type = visibilityBean.getType();
                                if (!TextUtils.isEmpty(type)) {
                                    aCache.put(SomeKeys.SPLASH_AD_TYPE, type);
                                }
                            }
                            List<AdBean.AdsBean.ResourcesBean> resources = adsBean.getResources();
                            aCache.put(SomeKeys.SPLASH_AD_CACHE, new Gson().toJson(resources));
                            if (resources != null && resources.size() > 0) {
                                for (int j = 0; j < resources.size(); j++) {
                                    AdBean.AdsBean.ResourcesBean resourcesBean = resources.get(j);
                                    if (resourcesBean != null) {
                                        int type = resourcesBean.getType();
                                        List<String> urls = resourcesBean.getUrls();
                                        if (urls != null && urls.size() > 0) {
                                            if (type == 0) {
                                                //图片
                                                ImageLoad.glideLoad(mContext, urls.get(0), new ImageView(mContext));
                                            } else {
                                                //视频，需要下载
                                                LogUtil.e("video......" + urls.get(0));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    LogUtil.e("adBean..." + adBean.getResult());
                }
            }
        }
    }


    @Override
    public void onEmpty(String tag) {

    }


}
