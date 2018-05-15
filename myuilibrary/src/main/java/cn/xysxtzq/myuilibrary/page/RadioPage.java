package cn.xysxtzq.myuilibrary.page;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.xysxtzq.myuilibrary.R;
import cn.xysxtzq.myuilibrary.adapter.Adapter2Radio;
import cn.xysxtzq.myuilibrary.interf.SelectStatus;
import cn.xysxtzq.myuilibrary.util.LogUtil;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;


/**
 * Created by Administrator on 2018/5/15.
 * 单选页面
 */

public class RadioPage<T extends SelectStatus> extends BasePage<T> {
    private Adapter2Radio<T> adapter;
    private static final String TAG = "RadioPage";

    public RadioPage(Context context, List<T> data, OnItemClickListener<T> listener, boolean isWrapcontent) {
        super(context, data, listener, isWrapcontent);
    }


    @Override
    public View loadRootView() {
        View view = View.inflate(context, R.layout.p_popup_radio_layout, null);
        RecyclerView recyclerView = view.findViewById(R.id.m_recycler_view);
        ViewGroup.LayoutParams params = recyclerView.getLayoutParams();
        LogUtil.e(TAG, "params--->" + params);
        if (params != null) {
            params.height = isWrapContent ? WRAP_CONTENT : MATCH_PARENT;
            recyclerView.setLayoutParams(params);
        }
        recyclerView.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter2Radio<>(data, listener);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void dataChanged(List<T> dataList) {
        if (data == null || dataList == null || dataList.size() == 0 || adapter == null) {
            LogUtil.e(TAG, "data is empty or adapter is null!" + adapter);
            return;
        }
        data.clear();
        data.addAll(dataList);
        adapter.notifyDataSetChanged();
    }


}
