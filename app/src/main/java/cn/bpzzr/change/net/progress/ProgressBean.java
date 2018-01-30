package cn.bpzzr.change.net.progress;

/**
 * Created by Administrator on 2018/1/29.
 * 封装进度监听所要用到的一些数据的实体
 */

public class ProgressBean {
    //文件的总长度
    public long totalSize;
    //已读写的文件长度
    public long curSize;
    //当前的进度
    public int progress;
    //任务是否已经完成
    public boolean isDone;
    //

    public ProgressBean() {
    }

    public ProgressBean(long totalSize, long curSize, int progress, boolean isDone) {
        this.totalSize = totalSize;
        this.curSize = curSize;
        this.progress = progress;
        this.isDone = isDone;
    }
}
