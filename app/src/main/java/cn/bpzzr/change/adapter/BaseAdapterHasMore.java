package cn.bpzzr.change.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.util.StringUtil;

/**
 * Created by Administrator on 2018/1/22.
 * 测试用Adapter
 */

public class BaseAdapterHasMore extends RecyclerView.Adapter<BaseAdapterHasMore.MyViewHolder> {
    public static final int ITEM_FOOTER = 0;
    private List mDataList;


    public BaseAdapterHasMore(List mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        return new MyViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.initData(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public void initData(int position) {
            //

        }
    }
}
