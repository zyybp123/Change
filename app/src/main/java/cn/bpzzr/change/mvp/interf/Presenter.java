package cn.bpzzr.change.mvp.interf;

import cn.bpzzr.change.mvp.MvpControl;

/**
 * Created by Administrator on 2018/3/10.
 * MVP架构的控制器接口
 */

public interface Presenter {
    /**
     * 关联 view 层
     *
     * @param view view层
     */
    void attachView(MView view);

    /**
     * 解除对view层的关联
     */
    void detachView();
}
