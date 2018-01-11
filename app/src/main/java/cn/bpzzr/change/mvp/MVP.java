package cn.bpzzr.change.mvp;

/**
 * Created by Administrator on 2018/1/5.
 * MVP 的接口层
 */

public interface MVP {
    /**
     * Presenter 层接口,用于加载数据
     */
    interface Presenter {
        /**
         * 发起网络请求
         */
        void initialRequest();
    }

    /**
     * vew 层接口，用于更新界面的回调
     */
    interface View<T> {
        /**
         * 开始网络请求
         */
        void onRequestStart(String tag);

        /**
         * 请求失败的回调接口
         *
         * @param tag 请求的方法的标识
         * @param msg 失败的描述
         */
        void onError(String tag, String msg);

        /**
         * 请求成功的回调接口
         *
         * @param tag    请求的方法的标识
         * @param result 请求的结果码
         * @param data   请求成功后拿到的数据
         */
        void onSuccess(String tag, String result, T data);

        /**
         * 请求成功，但数据为空时
         *
         * @param tag 请求的方法的标识
         */
        void onEmpty(String tag);
    }
}
