package cn.bpzzr.change.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.base.BaseLinearAdapter;
import cn.bpzzr.change.bean.FilterBarData;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.ui.view.DropDownView;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/2/23.
 * 筛选条数据适配器
 */

public class MyFilterBarAdapter<T> extends BaseLinearAdapter {
    private List<FilterBarData<T>> mDataList;
    private int defaultColor;
    private int selectColor;
    DropDownView dropDownView;
    List<FilterRadioData<String>> radioDataList = new ArrayList<>();
    private Activity activity;

    public MyFilterBarAdapter(List<FilterBarData<T>> mDataList, Activity mActivity) {
        this.mDataList = mDataList;
        this.activity = mActivity;
        defaultColor = mActivity.getResources().getColor(R.color.color_999);
        selectColor = mActivity.getResources().getColor(R.color.colorPrimary);
        dropDownView = new DropDownView(mActivity);
        for (int i = 0; i < 5; i++) {
            radioDataList.add(new FilterRadioData<>("data" + i, false));
        }
    }

    @Override
    public int getTabCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public View getTabView(LinearLayout parent, int position) {
        View itemView = View.inflate(parent.getContext(), R.layout.filter_tab_layout, null);
        TextView tvMenu = itemView.findViewById(R.id.tv_menu);
        FilterBarData filterBarData = mDataList.get(position);
        //设置菜单文字和颜色
        tvMenu.setText(filterBarData.getTabName());
        tvMenu.setTextColor(filterBarData.isShowPage() ? selectColor : defaultColor);
        ImageView ivArrow = itemView.findViewById(R.id.iv_arrow);
        //设置箭头的相关信息
        ivArrow.setImageResource(filterBarData.isShowPage() ? R.drawable.arrow_primary : R.drawable.arrow_gray);
        ivArrow.setVisibility(View.GONE);
        //ivArrow.setVisibility(filterBarData.isHasArrow() ? View.VISIBLE : View.GONE);
        //ivArrow.setRotation(filterBarData.isShowPage() ? -180 : 0);
        return itemView;
    }

    @Override
    public void onItemClick(View itemView, LinearLayout parent, int position) {
        LogUtil.e(msgTag, "click....." + position);
        //点击事件，根据显示状态改变三角形的方向
        boolean showPage = mDataList.get(position).isShowPage();
        //处理单选
        selectOne(position);
        notifyDataSetChanged();

        //决定下拉菜单的显示
        if (position % 2 == 0 && mDataList.get(position).isShowPage()) {
            View page = dropDownView.getSelectOnePage(activity, radioDataList);
            dropDownView.initPop(parent, page);
        }
    }

    private void selectOne(int position) {
        for (int i = 0; i < mDataList.size(); i++) {
                mDataList.get(i).setShowPage(i==position);
        }
    }
}
