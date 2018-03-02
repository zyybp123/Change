package cn.bpzzr.change.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bpzzr.change.R;
import cn.bpzzr.change.manager.GlideApp;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.image.ImageLoad;

/**
 * Created by Administrator on 2018/1/26.
 * 分类页
 */

public class CategoryFragment extends BaseFragment {
    @BindView(R.id.iv_test)
    ImageView ivTest;

    @Override
    public boolean isNeedLazy() {
        return false;
    }

    @Override
    public int getRootViewLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void viewHasBind() {
        /*LogUtil.e("绑定View........");
        ImageLoad.ss(this, "http://timgsa.baidu.com/timg" +
                "?image&quality=80&size=b10000_10000" +
                "&sec=1517809853" +
                "&di=04ed33f9cb11bc4afea50f2c544bc5fd" +
                "&imgtype=jpg" +
                "&src=http%3A%2F%2Fimg6.bdstatic.com%2Fimg%2Fimage%2Fpublic%2Fkuangor.jpg", ivTest);*/
    }

    @Override
    public void initialRequest() {

    }


}
