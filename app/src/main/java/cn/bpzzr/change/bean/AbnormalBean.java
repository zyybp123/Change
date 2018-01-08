package cn.bpzzr.change.bean;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2018/1/8.
 * 异常信息实体类
 */

public class AbnormalBean {
    private int code;
    private String msg;
    public static final String ABNORMAL_BEAN_IS_NULL = "异常信息为空";

    public AbnormalBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgStr(AbnormalBean bean) {
        String msgStr = "";
        if (bean != null) {
            Gson gson = new Gson();
            msgStr = gson.toJson(bean);
        } else {
            msgStr = ABNORMAL_BEAN_IS_NULL;
        }
        return msgStr;
    }

    public static AbnormalBean getMsgBean(String msgStr) {
        Gson gson = new Gson();
        return gson.fromJson(msgStr, AbnormalBean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AbnormalBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
