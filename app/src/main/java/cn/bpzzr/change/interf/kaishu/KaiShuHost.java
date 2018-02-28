package cn.bpzzr.change.interf.kaishu;

import cn.bpzzr.change.interf.SomeKeys;

/**
 * Created by Administrator on 2018/2/28.
 * kai shu server host
 */

public interface KaiShuHost {
    /**
     * 测试api
     */
    String BASE_URL_KAI_SHU_STORY_TEST = "http://tapi.kaishustory.com/";
    /**
     * 开发api
     */
    String BASE_URL_KAI_SHU_STORY_DEVELOP = "http://dapi.kaishustory.com/";
    /**
     * 游戏api
     */
    String BASE_URL_KAI_SHU_STORY_GAME = "http://gapi.kaishustory.com/";
    /**
     * 线上api
     */
    String BASE_URL_KAI_SHU_STORY_NORMAL = "https://api.kaishustory.com/";
    /**
     * baseUrl的key
     */
    String TAG_KAI_SHU = "kaiShu";
    /**
     * kai shu 通用区分baseUrl的header
     */
    String HEADER_KAI_SHU = SomeKeys.URL_FLAG + ":" + TAG_KAI_SHU;
    /**
     * 公共的请求头参数
     * token:
     * deviceid:
     * userid:
     * appid: 992099001
     * Content-Type: application/json; charset=utf-8
     * //非必需参数
     * apiver: 2.4
     * appversion: 4.2.0
     * channelid: yingyongbao
     */
    String HEADER_KAI_TOKEN = "token";
    String HEADER_KAI_DEVICE_ID = "deviceid";
    String HEADER_KAI_USER_ID = "userid";
    String HEADER_KAI_APP_ID = "appid";
    String HEADER_KAI_API_VER = "apiver";
    String HEADER_KAI_APP_VERSION = "appversion";
    String HEADER_KAI_CHANNEL_ID = "channelid";

}
