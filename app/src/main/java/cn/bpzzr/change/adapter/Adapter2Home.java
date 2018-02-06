package cn.bpzzr.change.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import java.util.List;

import cn.bpzzr.change.bean.GankTest;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Administrator on 2018/2/6.
 * 首页的数据适配器
 */

public class Adapter2Home extends BaseMultiItemQuickAdapter<GankTest.ResultsBean, BaseViewHolder> {
    public static final int ITEM_BANNER = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Adapter2Home(List<GankTest.ResultsBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankTest.ResultsBean item) {

    }
}
