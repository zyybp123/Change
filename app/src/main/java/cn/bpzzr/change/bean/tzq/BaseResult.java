package cn.bpzzr.change.bean.tzq;

/**
 * Created by Administrator on 2018/5/10.
 * tzq 的返回数据的基本包装
 */

public class BaseResult<T> {
    private String result;
    private String code;
    private String describe;
    private T data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
