package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.base.Adapter2Test2;
import cn.bpzzr.change.bean.AdBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.interf.ServerPath;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.manager.ACache;
import cn.bpzzr.change.util.image.ImageLoad;
import cn.bpzzr.change.net.progress.ProgressCallback;
import cn.bpzzr.change.util.LogUtil;
import okhttp3.ResponseBody;

import static cn.bpzzr.change.global.Change.mContext;

/**
 * Created by ZYY
 * on 2018/1/19 23:07.
 */

public class Temp extends BaseFragmentRefreshPage {

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
    protected void onceRequest() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String name = arguments.getString("name");
            if ("1".equals(name)) {
                retrofitTools.getAds(this);
            }
            if ("2".equals(name)) {
                retrofitTools
                        .downloadFile(this,
                                "http://yt-adv.nosdn.127.net/channel6/aaej_20180122.mp4",
                                new ProgressCallback() {
                                    @Override
                                    public void onLoading(long contentLength, long bytesWritten, boolean done) {
                                        int progress = (int) ((bytesWritten * 100f / contentLength) + 0.5f);
                                        //LogUtil.e("download...." + progress);
                                    }
                                });
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
        if ("download".equals(tag)) {
            ResponseBody body = (ResponseBody) data;
            InputStream is = null;
            byte[] buf = new byte[2048];
            int len;
            FileOutputStream fos = null;
            try {
                is = body.byteStream();
                File dir = new File(mActivity.getCacheDir(), "splash/mp4");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, "123.mp4");
                fos = new FileOutputStream(file);
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                    if (fos != null) fos.close();
                } catch (IOException e) {
                    LogUtil.e("saveFile", e.getMessage());
                }
            }

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
