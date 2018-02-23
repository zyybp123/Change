package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.MyFilterBarAdapter;
import cn.bpzzr.change.bean.FilterData;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;
import cn.bpzzr.change.ui.view.LinearContainer;

/**
 * Created by Administrator on 2018/2/1.
 * 我的
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.btn_setting)
    AppCompatButton btnSetting;
    Unbinder unbinder;
    @BindView(R.id.lc_con)
    LinearContainer lcCon;

    @Override
    public boolean isNeedLazy() {
        return false;
    }

    @Override
    public int getRootViewLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void viewHasBind() {
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到下载管理页

            }
        });
        List<FilterData<String>> filterDataList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            filterDataList.add(new FilterData<>("条件" + i, "数据" + i));
        }
        lcCon.setAdapter(new MyFilterBarAdapter<>(filterDataList));

    }

    @Override
    public void initialRequest() {

    }

    @Override
    public void onRequestStart(String tag) {

    }

    @Override
    public void onError(String tag, String msg) {

    }

    @Override
    public void onSuccess(String tag, String result, Object data) {

    }

    @Override
    public void onEmpty(String tag) {

    }
}
