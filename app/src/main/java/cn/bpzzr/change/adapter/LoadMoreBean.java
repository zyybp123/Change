package cn.bpzzr.change.adapter;

/**
 * Created by Administrator on 2018/1/26.
 * 上拉加载更多的数据实体
 */

public class LoadMoreBean {
    public static final int STATE_START = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE = 2;
    public static final int STATE_FAILURE = 3;
    public static final int STATE_SUCCESS = 4;

    private int state;

    public LoadMoreBean(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
