package cn.bpzzr.change.adapter.base;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.util.image.ImageLoad;

/**
 * Created by Administrator on 2018/1/24.
 * 测试Adapter
 */

public class Adapter2Test2 extends BaseQuickAdapter<GankTest.ResultsBean, BaseViewHolder> {

    public Adapter2Test2(int layoutResId, @Nullable List<GankTest.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankTest.ResultsBean item) {
        //Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
        ImageLoad.glideLoad(mContext, R.mipmap.ic_launcher, (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tvTitle, item.getDesc());
    }
}
