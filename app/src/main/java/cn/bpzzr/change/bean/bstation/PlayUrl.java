package cn.bpzzr.change.bean.bstation;

import java.util.List;

/**
 * Created by ZYY
 * on 2018/4/5 20:50.
 * 播放Url列表
 */

public class PlayUrl {

    /**
     * accept_format : hdflv2,flv,flv720,flv480,flv360
     * accept_quality : [112,80,64,32,16]
     * bp : 0
     * code : 0
     * durl : [{"length":302781,"order":1,"size":78202999,"url":"http://27.221.106.19/vg2/7/22/29662087-1-80.flv?expires=1522939500&platform=android&ssig=y9bxlq4dK8cMl653MNY-Pw&oi=2071269990&nfa=VTtnXeacAlS5k6cLdWuWIA==&dynamic=1&hfa=2029338181&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=9ddc84565c994be5b41cd8a454616253"},{"length":349120,"order":2,"size":91485359,"url":"http://27.221.106.19/vg2/7/22/29662087-2-80.flv?expires=1522939500&platform=android&ssig=GK8z6s_C55RidSUwRlqOfQ&oi=2071269990&nfa=VTtnXeacAlS5k6cLdWuWIA==&dynamic=1&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=9ddc84565c994be5b41cd8a454616253"},{"length":436374,"order":3,"size":109129567,"url":"http://27.221.106.19/vg2/7/22/29662087-3-80.flv?expires=1522939500&platform=android&ssig=oCbIm0nEsfhQKV0rxBOYAg&oi=2071269990&nfa=VTtnXeacAlS5k6cLdWuWIA==&dynamic=1&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=9ddc84565c994be5b41cd8a454616253"},{"length":351936,"order":4,"size":90160229,"url":"http://27.221.106.19/vg2/7/22/29662087-4-80.flv?expires=1522939500&platform=android&ssig=Yi37tBxqHrNaAdr0u5BItQ&oi=2071269990&nfa=VTtnXeacAlS5k6cLdWuWIA==&dynamic=1&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=9ddc84565c994be5b41cd8a454616253"}]
     * format : flv
     * from : local
     * has_paid : false
     * quality : 80
     * result : suee
     * seek_param : start
     * seek_type : offset
     * status : 2
     * timelength : 1440211
     * vip_status : 0
     * vip_type : 0
     */

    private String accept_format;
    private int bp;
    private int code;
    private String format;
    private String from;
    private boolean has_paid;
    private int quality;
    private String result;
    private String seek_param;
    private String seek_type;
    private int status;
    private int timelength;
    private int vip_status;
    private int vip_type;
    private List<Integer> accept_quality;
    private List<DurlBean> durl;

    public String getAccept_format() {
        return accept_format;
    }

    public void setAccept_format(String accept_format) {
        this.accept_format = accept_format;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isHas_paid() {
        return has_paid;
    }

    public void setHas_paid(boolean has_paid) {
        this.has_paid = has_paid;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSeek_param() {
        return seek_param;
    }

    public void setSeek_param(String seek_param) {
        this.seek_param = seek_param;
    }

    public String getSeek_type() {
        return seek_type;
    }

    public void setSeek_type(String seek_type) {
        this.seek_type = seek_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTimelength() {
        return timelength;
    }

    public void setTimelength(int timelength) {
        this.timelength = timelength;
    }

    public int getVip_status() {
        return vip_status;
    }

    public void setVip_status(int vip_status) {
        this.vip_status = vip_status;
    }

    public int getVip_type() {
        return vip_type;
    }

    public void setVip_type(int vip_type) {
        this.vip_type = vip_type;
    }

    public List<Integer> getAccept_quality() {
        return accept_quality;
    }

    public void setAccept_quality(List<Integer> accept_quality) {
        this.accept_quality = accept_quality;
    }

    public List<DurlBean> getDurl() {
        return durl;
    }

    public void setDurl(List<DurlBean> durl) {
        this.durl = durl;
    }

    public static class DurlBean {
        /**
         * length : 302781
         * order : 1
         * size : 78202999
         * url : http://27.221.106.19/vg2/7/22/29662087-1-80.flv?expires=1522939500&platform=android&ssig=y9bxlq4dK8cMl653MNY-Pw&oi=2071269990&nfa=VTtnXeacAlS5k6cLdWuWIA==&dynamic=1&hfa=2029338181&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=9ddc84565c994be5b41cd8a454616253
         */

        private int length;
        private int order;
        private int size;
        private String url;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
