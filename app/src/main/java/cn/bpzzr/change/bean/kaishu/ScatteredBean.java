package cn.bpzzr.change.bean.kaishu;

/**
 * Created by Administrator on 2018/2/28.
 * 接收一些零散的数据
 */

public class ScatteredBean {

    private String data;
    /**
     * 设备id号
     */
    private String deviceid;

    /**
     * session
     */
    private String sessioncode;
    /**
     * 令牌
     */
    private String token;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getSessioncode() {
        return sessioncode;
    }

    public void setSessioncode(String sessioncode) {
        this.sessioncode = sessioncode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
