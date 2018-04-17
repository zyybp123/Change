package cn.bpzzr.change.interf.bstation;

import cn.bpzzr.change.interf.SomeKeys;

/**
 * Created by ZYY
 * on 2018/4/5 20:52.
 */

public interface BiliHost {
    /**
     * 获取播url的主机
     */
    String BILI_BASE_URL = "https://bangumi.bilibili.com/";
    /**
     * baseUrl的key
     */
    String TAG_BILI = "bilibili";
    /**
     * kai shu 通用区分baseUrl的header
     */
    String HEADER_BILI = SomeKeys.URL_FLAG + ":" + TAG_BILI;
}
