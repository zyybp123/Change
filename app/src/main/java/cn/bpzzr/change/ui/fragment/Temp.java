package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.base.Adapter2Test2;
import cn.bpzzr.change.bean.AdBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.ServerPath;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.manager.ACache;
import cn.bpzzr.change.manager.GlideImageLoader;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.image.ImageLoad;
import cn.bpzzr.change.util.LogUtil;

import static cn.bpzzr.change.global.Change.mContext;

/**
 * Created by ZYY
 * on 2018/1/19 23:07.
 */

public class Temp extends BaseFragmentRefreshPage {
    public static final String[] urls = {
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499944746588&di=4d54d87b0559d7e82b2e813955d6bbc9&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2Fqk%2Fback_origin_pic%2F00%2F03%2F14%2Fc0391a6c1efab3fe00911b04e8cedca4.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499944746582&di=7c42a7baf940c16c8123bd0f2b439d46&imgtype=0&src=http%3A%2F%2Fimg2.3lian.com%2F2014%2Ff5%2F54%2Fd%2F73.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499944866874&di=264a24cecbe5f76780280c717da152bb&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201312%2F27%2F20131227231938_fiWVy.thumb.600_0.jpeg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499944866873&di=012e8d3ce636814e1b3f7d997bdf7536&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fa9d3fd1f4134970acfd58a2192cad1c8a7865d1e.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1499944866872&di=1abe5b182dd51b442d3fb01954e0262e&imgtype=0&src=http%3A%2F%2F2t.5068.com%2Fuploads%2Fallimg%2F151104%2F57-151104141235-50.jpg"

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
        Banner banner = (Banner) View.inflate(mContext, R.layout.base_banner_layout, null);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置自动轮播
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImages(Arrays.asList(urls));
        banner.start();
        mAdapter.setHeaderViewAsFlow(false);
        mAdapter.setHeaderView(banner);
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
