package cn.bpzzr.change.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.util.StringUtil;

/**
 * Created by Administrator on 2018/1/22.
 * 测试用Adapter
 */

public class Adapter2Test extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_LOAD_MORE = 0;
    public static final int ITEM_NORMAL = 1;
    public LoadMoreBean loadMoreBean = new LoadMoreBean(LoadMoreBean.STATE_START);

    private List<GankTest.ResultsBean> mDataList;

    public Adapter2Test(List<GankTest.ResultsBean> mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 1 : mDataList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mDataList.size()) {
            return ITEM_LOAD_MORE;
        } else {
            return ITEM_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case ITEM_LOAD_MORE:
                view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_base_footer, parent, false);
                return new ItemLoadMoreHolder(view);
            case ITEM_NORMAL:
                view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_temp, parent, false);
                return new MyViewHolder(view);
            default:
                view = new TextView(parent.getContext());
                return new MyViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemLoadMoreHolder) {
            ((ItemLoadMoreHolder) holder).initData(position);
        }
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).initData(position);
        }
    }

    public class ItemLoadMoreHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.footer_pb)
        ProgressBar footerPb;
        @BindView(R.id.footer_tv)
        TextView footerTv;
        @BindView(R.id.footer_ll)
        LinearLayout footerLl;

        ItemLoadMoreHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void initData(int position) {
            int state = loadMoreBean.getState();
            switch (state) {
                case LoadMoreBean.STATE_START:
                    footerLl.setVisibility(View.GONE);
                    break;
                case LoadMoreBean.STATE_LOADING:
                    footerLl.setVisibility(View.VISIBLE);
                    break;
                case LoadMoreBean.STATE_FAILURE:
                    footerLl.setVisibility(View.VISIBLE);
                    footerPb.setVisibility(View.GONE);
                    footerTv.setText("加载更多失败，点击重新加载");
                    break;
                case LoadMoreBean.STATE_SUCCESS:
                    footerLl.setVisibility(View.GONE);
                    break;
                case LoadMoreBean.STATE_NO_MORE:
                    footerLl.setVisibility(View.VISIBLE);
                    footerPb.setVisibility(View.GONE);
                    footerTv.setText("没有更多内容了");
                    break;
                default:
                    footerLl.setVisibility(View.GONE);
                    break;
            }

        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void initData(int position) {
            //
            ivIcon.setImageResource(R.mipmap.ic_launcher);
            GankTest.ResultsBean resultsBean = mDataList.get(position);
            tvTitle.setText(StringUtil.getNotNullStr(resultsBean.getDesc()));
        }
    }
}
