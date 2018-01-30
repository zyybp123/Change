package cn.bpzzr.change.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.net.download.ResInfo;
import cn.bpzzr.change.util.image.ImageLoad;

/**
 * Created by Administrator on 2018/1/24.
 * 测试Adapter
 */

public class Adapter2Test3 extends BaseQuickAdapter<ResInfo, BaseViewHolder> {

    public Adapter2Test3(int layoutResId, @Nullable List<ResInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResInfo item) {
        helper.addOnClickListener(R.id.frame_progress);
        ImageLoad.glideLoad(mContext, "http://picture.scloud.letv.com/97634558-contacticon/27abb207-c56f-4055-ab7a-7a5d4651c400/scale/w/1080/h/1920", (ImageView) helper.getView(R.id.iv_icon));
        //Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
        //ImageLoad.glideLoad(mContext, R.mipmap.ic_launcher, (ImageView) helper.getView(R.id.iv_icon));
       // helper.setText(R.id.tvTitle, item.getDesc());
    }
}
