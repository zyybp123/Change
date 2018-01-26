package cn.bpzzr.change.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.BaseItemBean;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.util.StringUtil;

/**
 * Created by Administrator on 2018/1/22.
 * 测试用Adapter
 */

public abstract class BaseAdapterHasMore<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public static final int ITEM_FOOTER = 0;
    private List<BaseItemBean<T>> mDataList;


    public BaseAdapterHasMore(List<BaseItemBean<T>> mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        BaseItemBean<T> tBaseItemBean = mDataList.get(position);
        return tBaseItemBean == null ? super.getItemViewType(position) : tBaseItemBean.getViewType();
    }

   /* @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ITEM_FOOTER) {
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_base_footer, parent, false);
        } else {
            view = getOtherView(parent, viewType);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapterHasMore.MyViewHolder holder, int position) {

    }*/

    private View getOtherView(ViewGroup parent, int viewType) {
        return null;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            //
        }

        public void initData(int position) {
            //

        }
    }
}
