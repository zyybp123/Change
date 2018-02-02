package cn.bpzzr.change.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.net.State;
import cn.bpzzr.change.net.common.ResInfo;
import cn.bpzzr.change.util.image.ImageLoad;

/**
 * Created by Administrator on 2018/1/24.
 * 测试Adapter
 */

public class Adapter2Test3 extends BaseQuickAdapter<ResInfo, BaseViewHolder> {

    public Adapter2Test3(int layoutResId, @Nullable List<ResInfo> data) {
        super(layoutResId, data);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void convert(BaseViewHolder helper, ResInfo resInfo) {
        helper.addOnClickListener(R.id.frame_progress);
        ImageLoad.load(mContext,
                "http://picture.scloud.letv.com/97634558-contacticon/" +
                        "27abb207-c56f-4055-ab7a-7a5d4651c400/scale/w/1080/h/1920"
        ).centerCrop().into((ImageView) helper.getView(R.id.iv_icon));

        TextView tvProgress = helper.getView(R.id.tv_progress);
        tvProgress.setTextColor(Color.BLACK);
        FrameLayout frameLayout = helper.getView(R.id.frame_progress);
        int status = resInfo.getStatus();
        int progress = resInfo.getProgress();
        ProgressBar progressBar = helper.getView(R.id.pb_progress);
        progressBar.setProgress(progress);
        tvProgress.setText(progress + "%");
        switch (status) {
            case State.START:
                tvProgress.setText("点击下载");
                break;
            case State.LOADING:

                break;
            case State.WAIT:
                tvProgress.setText("等待");
                break;
            case State.PAUSE:
                tvProgress.setText("继续");

                break;
            case State.FAIL:
                tvProgress.setText("失败");
                tvProgress.setTextColor(Color.RED);
                break;
            case State.SUCCESS:
                tvProgress.setText("打开");
                break;
        }

    }
}
