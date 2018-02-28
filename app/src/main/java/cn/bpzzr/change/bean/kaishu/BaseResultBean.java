package cn.bpzzr.change.bean.kaishu;

/**
 * Created by Administrator on 2018/2/28.
 * kai shu story 基本数据实体
 */

public class BaseResultBean<T> {
    /**
     * 错误码
     */
    private int errcode;
    /**
     * 错误信息
     */
    private int errmsg;
    /**
     * 数据结果
     */
    private T result;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(int errmsg) {
        this.errmsg = errmsg;
    }
}
