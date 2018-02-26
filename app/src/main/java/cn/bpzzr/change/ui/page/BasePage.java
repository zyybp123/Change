package cn.bpzzr.change.ui.page;

import android.content.Context;
import android.view.View;

import cn.bpzzr.change.mvp.MVP;

/**
 * Created by Administrator on 2018/1/9.
 * 作为独立模块使用的页面基类
 */

public abstract class BasePage<T> implements MVP.Presenter, MVP.View {
    /**
     * 页面根布局
     */
    private View mRootView;
    /**
     * 上下文
     */
    protected Context context;
    public T data;

    BasePage(Context context, T data) {
        this.context = context;
        this.data = data;
        this.mRootView = loadRootView();
    }

    /**
     * 加载页面根布局
     *
     * @return 返回View对象
     */
    public abstract View loadRootView();

    /**
     * 获取页面根布局
     *
     * @return 返回根布局View对象
     */
    public View getMRootView() {
        return mRootView;
    }

    /**
     * 获取页面标识
     *
     * @return 返回当前类的类名
     */
    public String getPageTag() {
        return this.getClass().getSimpleName();
    }
}
