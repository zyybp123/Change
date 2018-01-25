package cn.bpzzr.change.adapter.base;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

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
        ImageLoad.glideLoad(mContext,
                "http://p7.pstatp.com/large/5931000196de8954e8bd",
                (ImageView) helper.getView(R.id.iv_icon), ImageLoad.FILLET, 8);
        helper.setText(R.id.tvTitle, item.getDesc());
    }
}
