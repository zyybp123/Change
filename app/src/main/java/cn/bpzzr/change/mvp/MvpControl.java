package cn.bpzzr.change.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Administrator on 2018/3/2.
 * 控制mvp的接口基类
 */

public interface MvpControl {
    interface BasePresenter {
        /**
         * 关联 view 层,一个presenter可以对应多个View
         *
         * @param views view层
         */
        void attachView(MvpControl.BaseView... views);

        /**
         * 解除对view层的关联
         */
        void detachView();
    }


    interface BaseView {

        //显示进度中
        void showLoading();

        //显示请求成功
        void showSuccess();

        //失败重试
        void showFaild();

        //显示当前网络不可用
        void showNoNet();

        //重试
        void onRetry();

        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();

    }
}
