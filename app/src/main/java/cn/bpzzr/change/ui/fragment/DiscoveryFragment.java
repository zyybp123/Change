package cn.bpzzr.change.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.tzq.BaseResult;
import cn.bpzzr.change.bean.tzq.ScatteredData;
import cn.bpzzr.change.interf.tzq.AESUtil;
import cn.bpzzr.change.interf.tzq.TzqService;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;
import cn.bpzzr.change.util.LogUtil;
import cn.xysxtzq.myuilibrary.entity.StrokeEntity;
import cn.xysxtzq.myuilibrary.util.BgResUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
                final TzqService tzqService = retrofitTools.getRetrofit().create(TzqService.class);
                tzqService
                        .getSignToken("123456")
                        .compose(RetrofitTools.<BaseResult<ScatteredData>>setMainThread())
                        .subscribe(new Observer<BaseResult<ScatteredData>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(final BaseResult<ScatteredData> scatteredDataBaseResult) {
                                ScatteredData data = scatteredDataBaseResult.getData();
                                if (data != null) {
                                    LogUtil.e(mFragmentTag, "token--->" + data.getSignToken());
                                    tzqService.getLoginInformation(
                                            data.getSignToken(),
                                            "15222776889",
                                            "北京大学",
                                            "马克思主义学院",
                                            "2",
                                            "a123456"
                                    ).compose(RetrofitTools.<BaseResult<String>>setMainThread())
                                            .subscribe(new Observer<BaseResult<String>>() {
                                                @Override
                                                public void onSubscribe(Disposable d) {

                                                }

                                                @Override
                                                public void onNext(BaseResult<String> stringBaseResultBean) {
                                                    LogUtil.e(mFragmentTag, "loginData--->"
                                                            + stringBaseResultBean.getData());
                                                    String decrypt = AESUtil.decrypt("2v07e5c73myr6v4a",
                                                            stringBaseResultBean.getData());
                                                    LogUtil.e(mFragmentTag, "解密串--->" + decrypt);
                                                    toOtherApp(stringBaseResultBean.getData());
                                                }

                                                @Override
                                                public void onError(Throwable e) {

                                                }

                                                @Override
                                                public void onComplete() {

                                                }
                                            })
                                    ;
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        })
                ;


            }
        });
    }

    private void toOtherApp(String data) {
        if (isTzqInstalled(mActivity)) {
            Intent intent = new Intent();
            intent.setAction("xysx.com.tzq.intent.action.HOME_PAGE");
            intent.setData(Uri.parse("xysx://xysx.com.tzq/home"));
            intent.putExtra("FROM_OUT", true);
            //传入数据时：key为USER_DATA
            // value为包含相应信息的Json串
            intent.putExtra("USER_DATA", data);
            if (null == intent.resolveActivity(mActivity.getPackageManager())) {
                //避免找不到时采用隐式意图打开界面的错误
                LogUtil.e(mFragmentTag, "no such activity !");
            } else {
                startActivity(intent);
            }
        } else {
            LogUtil.e(mFragmentTag, "未安装投智圈！");
        }
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
