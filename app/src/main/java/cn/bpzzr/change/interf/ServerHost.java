package cn.bpzzr.change.interf;

/**
 * Created by Administrator on 2018/1/4.
 * 网络数据接口主机地址
 */

public interface ServerHost {

    String BASE_URL_VIDEO ="https://api.douban.com/";
    String BASE_URL_BOOK ="http://gank.io/";
    String BASE_URL_ONLINE ="http://gank.io/";
    String BASE_URL_AD="https://nex.163.com/";
    String BASE_URL_DOWNLOAD = "http://yt-adv.nosdn.127.net";

    /*https://lf.snssdk.com/api/news/feed/v76/*/

    /**
     * http://book.lzbook.net/v3/book/default
     * ?os=android
     * &packageName=cc.lianzainovel
     * &channelId=blf1298_12243_001
     * &cityCode=
     * &longitude=116.56810088640667
     * &udid=000ffa3704e045d49583226a27825350
     * &latitude=25.997978965531722
     * &version=12
     * &token=2JZRjZZ9WbhEbgj9IOeYVRNeI3R%2BqgeysNlMs6sSKO4%3D
     *
     * GET /v3/book/default?os=android&packageName=cc.lianzainovel&channelId=blf1298_12243_001&cityCode=&longitude=116.56810088640667&udid=000ffa3704e045d49583226a27825350&latitude=25.997978965531722&version=12&token=2JZRjZZ9WbhEbgj9IOeYVRNeI3R%2BqgeysNlMs6sSKO4%3D HTTP/1.1
     Accept-Encoding: gzip
     User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.4.2; Nexus 6 Build/KOT49H)
     Host: book.lzbook.net
     Connection: Keep-Alive

     http://yt-adv.nosdn.127.net/channel6/aaej_20180122.mp4

     https://nex.163.com/q

     {
     "version":"9.1.0"
     ,"is_test":false
     ,"urs":""
     ,"store":""
     ,"ext_param":{}
     ,"device":{"os":"android",
     "imei":"869552027513993",
     "device_id":"CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg%3D",
     "mac":"02:00:00:00:00:00",
     "galaxy_tag":"CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg%3D",
     "udid":"74f79d481fd1ee6e77e779c7aa6e8048dc435ac2",
     "network_status":"wifi",
     "dq":"1920:1080",
     "isp":"",
     "dt":"Le X620",
     "mcc":"460",
     "longitude":"116.234368",
     "latitude":"40.068366",
     "location_type":1,
     "city_code":"110108"
     },
     "adunit":{"category":"STARTUP","location":"1",
     "app":"7A16FBB6","app_version":"32.1",
     "province":"%E5%8C%97%E4%BA%AC","city":"%E5%8C%97%E4%BA%AC",
     "blacklist":""}}

     */
}
