package cn.bpzzr.change.interf.tzq;

import cn.bpzzr.change.interf.SomeKeys;

/**
 * Created by Administrator on 2018/5/10.
 * 投智圈
 */

public interface TzqHost {
    /**
     * TZQ
     */
    String TZQ_BASE_URL = "http://test.xytzq.cn:9199/";
    /**
     * baseUrl的key
     */
    String TAG_TZQ = "xytzq";
    /**
     * tzq通用区分baseUrl的header
     */
    String HEADER_TZQ = SomeKeys.URL_FLAG + ":" + TAG_TZQ;
}
