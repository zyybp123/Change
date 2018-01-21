package cn.bpzzr.change.ui.fragment;

import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.net.ServerPath;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;

/**
 * Created by ZYY
 * on 2018/1/19 23:07.
 */

public class Temp extends BaseFragment {


    @BindView(R.id.test_tv)
    TextView testTv;

    @Override
    public boolean isNeedLazy() {
        return true;
    }

    @Override
    public void initialRequest() {
        retrofitTools.getTest3(this);
    }

    @Override
    public void onRequestStart(String tag) {
        //mStateLayout.showLoading();
    }

    @Override
    public void onEmpty(String tag) {
        mStateLayout.showEmpty();
    }


    @Override
    public int getRootViewLayoutId() {
        return R.layout.test_layout;
    }

    @Override
    public void initView() {
        //
        //testTv = mStateLayout.findViewById(R.id.test_tv);

    }
    @Override
    public void onError(String tag, String msg) {
        mStateLayout.showFailure();
    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        LogUtil.e(mFragmentTag, "...result..." + data);
        mStateLayout.showSuccessView();
        if (ServerPath.GANK_ANDROID.equals(tag)) {
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null) {
                    for (int i = 0; i < results.size(); i++) {
                        //LogUtil.e("resultsBean......" + resultsBean.getDesc());
                        if (i == 0){
                            GankTest.ResultsBean resultsBean = results.get(i);
                            if (resultsBean != null) {
                                testTv.setText(StringUtil.getNotNullStr(resultsBean.getDesc()));
                            }
                        }

                    }
                }
            }
        }
    }

}
