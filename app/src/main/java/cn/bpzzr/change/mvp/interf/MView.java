package cn.bpzzr.change.mvp.interf;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Administrator on 2018/3/10.
 * mvp架构的视图层接口
 */

public interface MView {
    /**
     * 显示进度中
     */
    void showLoading();

    /**
     * 显示成功状态
     */
    void showSuccess();

    /**
     * 显示失败状态
     */
    void showFailure();

    /**
     * 显示当前网络不可用
     */
    void showNoNet();

    /**
     * 重试
     */
    void onRetry();

    /**
     * 绑定生命周期
     *
     * @param <T> 回调的数据泛型
     * @return 返回绑定生命周期的转换器
     */
    <T> LifecycleTransformer<T> bindToLife();
}
