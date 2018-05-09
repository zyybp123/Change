package cn.bpzzr.change.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bpzzr.change.R;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;
import cn.bpzzr.change.util.LogUtil;
import cn.xysxtzq.myuilibrary.entity.StrokeEntity;
import cn.xysxtzq.myuilibrary.util.BgResUtil;

/**
 * Created by Administrator on 2018/1/26.
 * 发现页
 */

public class DiscoveryFragment extends BaseFragment {
    @BindView(R.id.tv_discovery)
    TextView tvDiscovery;

    @Override
    public boolean isNeedLazy() {
        return false;
    }

    @Override
    public int getRootViewLayoutId() {
        return R.layout.fragment_discovery;
    }


    @Override
    public void viewHasBind() {
        StrokeEntity strokeEntity = new StrokeEntity(true);
        strokeEntity.width = 5;
        strokeEntity.color = getResources().getColor(R.color.black_a80);
        GradientDrawable recBg = BgResUtil
                .getRecBg(getResources().getColor(R.color.colorPrimary), strokeEntity);

        tvDiscovery.setBackground(recBg);

        tvDiscovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isTzqInstalled(mActivity)) {
                    Intent intent = new Intent();
                    intent.setAction("xysx.com.tzq.intent.action.HOME_PAGE");
                    intent.setData(Uri.parse("xysx://xysx.com.tzq/home"));
                    intent.putExtra("FROM_OUT", true);
                    //传入数据时：key为USER_DATA
                    // value为包含相应信息的Json串
                    intent.putExtra("USER_DATA", "");
                    if (null == intent.resolveActivity(mActivity.getPackageManager())) {
                        //避免找不到时采用隐式意图打开界面的错误
                    } else {
                        startActivity(intent);
                    }
                    //startActivity(intent);
                } else {
                    LogUtil.e(mFragmentTag, "未安装投智圈！");
                }


            }
        });
    }

    @Override
    public void initialRequest() {

    }

    public static boolean isTzqInstalled(@NonNull Context context) {
        PackageManager pm;
        if ((pm = context.getApplicationContext().getPackageManager()) == null) {
            return false;
        }
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            String name = info.packageName.toLowerCase(Locale.ENGLISH);
            if ("xysx.com.tzq".equals(name)) {
                return true;
            }
        }
        return false;
    }


}
