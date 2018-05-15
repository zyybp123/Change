package cn.xysxtzq.myuilibrary.adapter;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.xysxtzq.myuilibrary.R;
import cn.xysxtzq.myuilibrary.interf.SelectStatus;
import cn.xysxtzq.myuilibrary.page.BasePage;
import cn.xysxtzq.myuilibrary.util.LogUtil;

/**
 * Created by Administrator on 2018/5/15.
 * 单选适配器
 */

public class Adapter2Radio<T extends SelectStatus> extends RecyclerView.Adapter<Adapter2Radio<T>.MyViewHolder> {
    private List<T> dataList;
    private int selectColor = Color.parseColor("#259461");
    private int defaultColor = Color.parseColor("#999999");
    private BasePage.OnItemClickListener<T> listener;

    public Adapter2Radio(List<T> dataList) {
        this.dataList = dataList;
    }

    public Adapter2Radio(List<T> dataList, BasePage.OnItemClickListener<T> listener) {
        this(dataList);
        this.listener = listener;
    }

    public Adapter2Radio(List<T> dataList, BasePage.OnItemClickListener<T> listener, int selectColor, int defaultColor) {
        this(dataList, listener);
        this.selectColor = selectColor;
        this.defaultColor = defaultColor;
        LogUtil.e(selectColor + "..." + defaultColor);
    }

    @NonNull
    @Override
    public Adapter2Radio<T>.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_radio, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter2Radio<T>.MyViewHolder holder, int position) {
        T t = dataList.get(position);
        holder.ivSelect.setVisibility(t.isSelected() ? View.VISIBLE : View.INVISIBLE);
        holder.tvName.setText(t.toString());
        holder.tvName.setTextColor(t.isSelected() ? selectColor : defaultColor);
        holder.click(position);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSelect;
        TextView tvName;

        MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            ivSelect = itemView.findViewById(R.id.iv_select);
        }

        void click(final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //处理单选
                    for (int i = 0; i < dataList.size(); i++) {
                        dataList.get(i).setSelected(i == position);
                    }
                    notifyDataSetChanged();
                    if (listener != null) {
                        listener.onClick(getAdapterPosition(), dataList.get(position));
                    }
                }
            });
        }

    }


}
