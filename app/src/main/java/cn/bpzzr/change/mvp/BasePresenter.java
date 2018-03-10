package cn.bpzzr.change.mvp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bpzzr.change.mvp.interf.MView;
import cn.bpzzr.change.mvp.interf.Presenter;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/3/10.
 * 网络请求处理的基类
 */

public class BasePresenter implements Presenter {
    /**
     * 日志标签
     */
    public String logTag = this.getClass().getName();
    private MView mContractView;

    @Override
    public void attachView(MView view) {
        if (view == null) {
            //如果传入的对象为空，直接返回
            LogUtil.e(logTag, "views is null !");
            return;
        }
        this.mContractView = view;
    }

    @Override
    public void detachView() {
        //解除view的关联
        if (mContractView != null){
            mContractView = null;
        }
    }
}
