package cn.bpzzr.change.interf;

/**
 * Created by Administrator on 2018/1/4.
 * 网络数据接口主机地址
 */

public interface ServerHost {

    String BASE_URL_VIDEO ="https://api.douban.com/";
    String BASE_URL_BOOK ="http://gank.io/";
    String BASE_URL_ONLINE ="http://gank.io/";

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

     */
}
