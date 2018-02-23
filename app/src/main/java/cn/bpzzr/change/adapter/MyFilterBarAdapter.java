package cn.bpzzr.change.adapter;

import android.view.View;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.base.BaseLinearAdapter;
import cn.bpzzr.change.bean.FilterData;

/**
 * Created by Administrator on 2018/2/23.
 * 筛选条数据适配器
 */

public class MyFilterBarAdapter<T> extends BaseLinearAdapter {
    private List<FilterData<T>> mDataList;

    public MyFilterBarAdapter(List<FilterData<T>> mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getTabCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public View getTabView(LinearLayout parent, int position) {
        View itemView = View.inflate(parent.getContext(), R.layout.filter_tab_layout, null);
        TextView tvMenu = itemView.findViewById(R.id.tv_menu);
        FilterData filterData = mDataList.get(position);
        tvMenu.setText(filterData.getTabName());
        ImageView ivArrow = itemView.findViewById(R.id.iv_arrow);
        ivArrow.setVisibility(filterData.isHasArrow() ? View.VISIBLE : View.GONE);
        ivArrow.setRotation(filterData.isShowPage() ? -180 : 0);
        return itemView;
    }

    @Override
    public void onItemClick(View itemView, LinearLayout parent, int position) {
        //点击事件，根据显示状态改变三角形的方向
        boolean showPage = mDataList.get(position).isShowPage();
        for (int i = 0; i < mDataList.size(); i++) {
            if (i == position) {
                mDataList.get(position).setShowPage(!showPage);
            }else{
                mDataList.get(position).setShowPage(false);
            }
        }
        notifyDataSetChanged();
    }
}
