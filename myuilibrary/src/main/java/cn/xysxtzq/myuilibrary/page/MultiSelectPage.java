package cn.xysxtzq.myuilibrary.page;

import android.content.Context;
import android.view.View;

import java.util.List;

import cn.xysxtzq.myuilibrary.interf.SelectStatus;

/**
 * Created by Administrator on 2018/5/15.
 * 多选页
 */

public class MultiSelectPage<T extends SelectStatus> extends BasePage<T> {
    MultiSelectPage(Context context, List<T> data, OnItemClickListener<T> listener, boolean isWrapContent) {
        super(context, data, listener, isWrapContent);
    }

    @Override
    public View loadRootView() {
        return null;
    }
}
