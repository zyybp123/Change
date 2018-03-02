package cn.bpzzr.change.bean.kaishu;

/**
 * Created by Administrator on 2018/3/1.
 * 初始化后获取到的数据
 */

public class InitialDataBean {

    /**
     * sessioncode :
     * deviceid :
     * token :
     */
    /**
     * sessioncode 48F8D7642AFCBD74DE6875AB989DE973
     */
    private String sessioncode;
    /**
     * 设备号 DD558A27736738530560EC4D2DE5F891
     */
    private String deviceid;
    /**
     * 令牌{"to":2519870106004,"rd":"331519870107004","il":false,"aid":"992099001"}
     * |QkI3RjlFRjQwRjFGMzQzQzFFRjU4RkM4OTQ3NTdBQTU=
     */
    private String token;

    public String getSessioncode() {
        return sessioncode;
    }

    public void setSessioncode(String sessioncode) {
        this.sessioncode = sessioncode;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
