package cn.bpzzr.change.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.global.Change;

/**
 * Created by Administrator on 2018/2/24.
 * 筛选条件单选的数据适配器
 */

public class Adapter2FilterSelectMore extends BaseMultiItemQuickAdapter<FilterRadioData, BaseViewHolder> {
    private int defaultColor;
    private int selectColor;
    /**
     * 标题类型条目
     */
    public static final int ITEM_TYPE_TITLE = 1;
    /**
     * 标签类型条目
     */
    public static final int ITEM_TYPE_TAG = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Adapter2FilterSelectMore(List<FilterRadioData> data) {
        super(data);
        addItemType(ITEM_TYPE_TITLE, R.layout.item_filter_select_more_title);
        addItemType(ITEM_TYPE_TAG, R.layout.item_filter_select_more_tag);
    }

    @Override
    protected void convert(BaseViewHolder helper, FilterRadioData item) {
        switch (helper.getItemViewType()) {
            case ITEM_TYPE_TITLE:

                break;
            case ITEM_TYPE_TAG:
                break;
        }
    }

}
