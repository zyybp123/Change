package cn.bpzzr.change.Bean;

/**
 * Created by Administrator on 2018/1/5.
 * 返回的数据统一包装
 */

public class ResultBaseBean<T> {
    private int code;          //状态码
    private String result;     //状态English
    private String describe;   //状态描述信息
    private String version;    //版本号
    private T data;            //数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
