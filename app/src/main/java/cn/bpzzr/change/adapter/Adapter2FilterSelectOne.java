package cn.bpzzr.change.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.*;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.global.Change;

/**
 * Created by Administrator on 2018/2/24.
 * 筛选条件单选的数据适配器
 */

public class Adapter2FilterSelectOne<T> extends BaseQuickAdapter<FilterRadioData<T>, BaseViewHolder> {
    private int defaultColor;
    private int selectColor;

    public Adapter2FilterSelectOne(int layoutResId, @Nullable List<FilterRadioData<T>> data) {
        super(layoutResId, data);
        defaultColor = Change.mContext.getResources().getColor(R.color.color_999);
        selectColor = Change.mContext.getResources().getColor(R.color.colorPrimary);
    }

    @Override
    protected void convert(BaseViewHolder helper, FilterRadioData<T> item) {
        helper.setText(R.id.tv_name, item.getRadioData().toString());
        TextView tvName = helper.getView(R.id.tv_name);
        tvName.setTextColor(item.isSelected() ? selectColor : defaultColor);
    }

}
