package cn.bpzzr.change.ui.page;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2FilterSelectOne;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;

/**
 * Created by Administrator on 2018/2/27.
 */

public class FilterSelectMorePage extends BasePage<List<FilterRadioData>> {
    private Adapter2FilterSelectOne adapter;

    FilterSelectMorePage(Context context, List<FilterRadioData> data) {
        super(context, data);
    }

    @Override
    public View loadRootView() {
        View view = View.inflate(context, R.layout.drop_down_select_one, null);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        FlexboxLayoutManager layoutManager = BaseFragmentRefreshPage.getFlexBoxLayoutManager(context);
        //横向
        layoutManager.setFlexDirection(FlexDirection.ROW);
        //换行
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter2FilterSelectOne(R.layout.item_filter_select_more, data);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void initialRequest() {

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


}
