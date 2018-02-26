package cn.bpzzr.change.ui.page;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2FilterSelectOne;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/2/26.
 * 单选的筛选条件页面
 */

public class FilterSelectOnePage extends BasePage<List<FilterRadioData>> implements BaseQuickAdapter.OnItemClickListener {
    private Adapter2FilterSelectOne adapter;

    public FilterSelectOnePage(Context context, List<FilterRadioData> data) {
        super(context, data);
    }

    @Override
    public View loadRootView() {
        View view = View.inflate(context, R.layout.drop_down_select_one, null);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(BaseFragmentRefreshPage.
                getLinearLayoutManager(context, LinearLayoutManager.VERTICAL));
        adapter = new Adapter2FilterSelectOne(R.layout.item_filter_select_one, data);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void initialRequest() {
        //
    }

    @Override
    public void onRequestStart(String tag) {

    }

    @Override
    public void onError(String tag, String msg) {

    }

    @Override
    public void onSuccess(String tag, String result, Object data) {

    }

    @Override
    public void onEmpty(String tag) {

    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        LogUtil.e("position" + position);
        //处理单选点击事件
        for (int i = 0; i < data.size(); i++) {
            data.get(position).setSelected(i == position);
        }
        adapter.notifyDataSetChanged();

    }
}
