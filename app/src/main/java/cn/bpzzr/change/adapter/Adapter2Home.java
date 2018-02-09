package cn.bpzzr.change.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.base.Adapter2Test2;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.manager.GlideImageLoader;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.ui.view.MyScrollListener;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.image.ImageLoad;

import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

/**
 * Created by Administrator on 2018/2/6.
 * 首页的数据适配器
 */

public class Adapter2Home extends BaseMultiItemQuickAdapter<GankTest.ResultsBean, BaseViewHolder> {
    /**
     * 条目类型，为banner类型
     */
    public static final int ITEM_BANNER = 1;
    /**
     * 条目类型为选项卡类型
     */
    public static final int ITEM_CARD = 2;
    /**
     * 条目类型为普通类型（列表条目）
     */
    public static final int ITEM_NORMAL = 3;
    private String[] urls;
    private List<GankTest.ResultsBean> mList = new ArrayList<>();


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Adapter2Home(List<GankTest.ResultsBean> data, String[] urls) {
        super(data);
        this.urls = urls;
        addItemType(ITEM_BANNER, R.layout.base_banner_layout);
        addItemType(ITEM_CARD, R.layout.base_card_layout);
        addItemType(ITEM_NORMAL, R.layout.item_temp);
        for (int i = 2; i < 23; i++) {
            GankTest.ResultsBean resultsBean = new GankTest.ResultsBean();
            resultsBean.setDesc("card" + i);
            mList.add(resultsBean);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, GankTest.ResultsBean item) {
        switch (helper.getItemViewType()) {
            case ITEM_BANNER:
                Banner banner = helper.getView(R.id.base_banner);
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
                if (urls != null) {
                    banner.setImages(Arrays.asList(urls));
                }
                banner.start();
                break;
            case ITEM_CARD:
                ImageView ivCardImg = helper.getView(R.id.iv_card_show);
                ImageLoad.glideLoad(mContext, "http://h.hiphotos.baidu.com/image/pic/item/c2fdfc039245d688abf6c374afc27d1ed31b246d.jpg", ivCardImg);
                RecyclerView recyclerView = helper.getView(R.id.rv_card);
                recyclerView.setLayoutManager(BaseFragmentRefreshPage.getGridLayoutManager(mContext,
                        2,LinearLayoutManager.HORIZONTAL));
                recyclerView.setOnFlingListener(null);
                //处理RecyclerView的滑动
                recyclerView.addOnScrollListener(new MyScrollListener(
                        1080, LinearLayoutManager.HORIZONTAL, recyclerView
                ));
                LogUtil.e("mList....." + mList);
                recyclerView.setAdapter(new Adapter2Test2(R.layout.item_temp_h, mList));

                break;
            case ITEM_NORMAL:
                ImageLoad.glideLoad(mContext, R.mipmap.ic_launcher, (ImageView) helper.getView(R.id.iv_icon));
                helper.setText(R.id.tvTitle, item.getDesc());

                break;
        }

    }

    /**
     * 计算mCurrentItemOffset
     */
    /*private void computeCurrentItemPos() {
        if (mOnePageWidth <= 0) return;
        boolean pageChanged = false;
        // 滑动超过一页说明已翻页
        if (Math.abs(mCurrentItemOffset - mCurrentItemPos * mOnePageWidth) >= mOnePageWidth) {
            pageChanged = true;
        }
        if (pageChanged) {
            int tempPos = mCurrentItemPos;

            mCurrentItemPos = mCurrentItemOffset / mOnePageWidth;
            LogUtils.d(String.format("=======onCurrentItemPos Changed======= tempPos=%s, mCurrentItemPos=%s", tempPos, mCurrentItemPos));
        }
    }*/
}
