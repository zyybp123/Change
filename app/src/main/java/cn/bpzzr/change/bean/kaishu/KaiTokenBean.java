package cn.bpzzr.change.bean.kaishu;

/**
 * Created by Administrator on 2018/3/1.
 * kai shu story 的token
 */

public class KaiTokenBean {
    /**
     * to : 2519870106004
     * rd : 331519870107004
     * il : false
     * aid : 992099001
     */

    private long to;
    private String rd;
    private boolean il;
    /**
     * app id
     */
    private String aid;

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public boolean isIl() {
        return il;
    }

    public void setIl(boolean il) {
        this.il = il;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
