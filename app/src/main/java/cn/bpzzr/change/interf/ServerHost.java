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
    //今日头条的基础URL
    String BASE_URL_NEWS = "https://lf.snssdk.com/api/";



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

     https://lf.snssdk.com/api/
     //视频，搞笑
     news/feed/v75/
     ?list_count=8
     &category=subv_funny
     &refer=1
     &refresh_reason=1
     &session_refresh_idx=2
     &count=20
     &min_behot_time=1516852625
     &list_entrance=main_tab
     &last_refresh_sub_entrance_interval=1516852628
     &loc_mode=6
     &loc_time=1516852575
     &latitude=40.068384
     &longitude=116.234175
     &city=%E5%8C%97%E4%BA%AC%E5%B8%82
     &tt_from=pull
     &lac=4118
     &cid=3759993 手机平台版本
     &plugin_enable=3
     &iid=23121236427
     &device_id=36136351737
     &ac=wifi
     &channel=store_tengxun_wzl
     &aid=13
     &app_name=news_article
     &version_code=655
     &version_name=6.5.5
     &device_platform=android
     &ab_version=264280%2C259934%2C260976%2C265055%2C252767%2C249828%2C246859%2C218092%2C263256%2C263539%2C259468%2C249663%2C249684%2C249687%2C264641%2C264843%2C258977%2C264975%2C206076%2C249673%2C260608%2C264509%2C229304%2C249671%2C265167%2C259487%2C264477%2C265088%2C240868%2C263878%2C261489%2C185729%2C265138%2C251713%2C263185%2C263707%2C265111%2C31648%2C207253%2C263925%2C264918%2C262035%2C258356%2C247848%2C228168%2C263747%2C264450%2C260171%2C249045%2C210682%2C264991%2C244746%2C264622%2C249956%2C264613%2C265119%2C259463%2C263929%2C260651%2C250013%2C264481%2C241181%2C264292%2C261990%2C245085%2C232362%2C263276%2C259501%2C239096%2C257965%2C170988%2C258909%2C248082%2C258355%2C263530%2C263696%2C257284%2C261293%2C265122%2C263661%2C258603%2C262912&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7
     &ab_feature=94563%2C102749
     &abflag=3
     &ssmix=a
     &device_type=Le+X620
     &device_brand=LeEco
     &language=zh
     &os_api=23
     &os_version=6.0
     &uuid=869552027513993
     &openudid=727b9330e50cc7f8
     &manifest_version_code=655
     &resolution=1080*1920
     &dpi=420
     &update_version_code=65509
     &_rticket=1516852628750
     &plugin=10575
     &fp=TlTqL2H1cSceFlTZPlU1FYweFYFS
     &rom_version=23
     &ts=1516852633
     &as=a20545a69929aa45796125
     &cp=5da26a9c50594q1

     GET /api/news/feed/v75/?list_count=8&category=subv_funny&refer=1&refresh_reason=1&session_refresh_idx=2&count=20&min_behot_time=1516852625&list_entrance=main_tab&last_refresh_sub_entrance_interval=1516852628&loc_mode=6&loc_time=1516852575&latitude=40.068384&longitude=116.234175&city=%E5%8C%97%E4%BA%AC%E5%B8%82&tt_from=pull&lac=4118&cid=3759993&plugin_enable=3&iid=23121236427&device_id=36136351737&ac=wifi&channel=store_tengxun_wzl&aid=13&app_name=news_article&version_code=655&version_name=6.5.5&device_platform=android&ab_version=264280%2C259934%2C260976%2C265055%2C252767%2C249828%2C246859%2C218092%2C263256%2C263539%2C259468%2C249663%2C249684%2C249687%2C264641%2C264843%2C258977%2C264975%2C206076%2C249673%2C260608%2C264509%2C229304%2C249671%2C265167%2C259487%2C264477%2C265088%2C240868%2C263878%2C261489%2C185729%2C265138%2C251713%2C263185%2C263707%2C265111%2C31648%2C207253%2C263925%2C264918%2C262035%2C258356%2C247848%2C228168%2C263747%2C264450%2C260171%2C249045%2C210682%2C264991%2C244746%2C264622%2C249956%2C264613%2C265119%2C259463%2C263929%2C260651%2C250013%2C264481%2C241181%2C264292%2C261990%2C245085%2C232362%2C263276%2C259501%2C239096%2C257965%2C170988%2C258909%2C248082%2C258355%2C263530%2C263696%2C257284%2C261293%2C265122%2C263661%2C258603%2C262912&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=Le+X620&device_brand=LeEco&language=zh&os_api=23&os_version=6.0&uuid=869552027513993&openudid=727b9330e50cc7f8&manifest_version_code=655&resolution=1080*1920&dpi=420&update_version_code=65509&_rticket=1516852628750&plugin=10575&fp=TlTqL2H1cSceFlTZPlU1FYweFYFS&rom_version=23&ts=1516852633&as=a20545a69929aa45796125&cp=5da26a9c50594q1 HTTP/1.1
     Host: lf.snssdk.com
     Connection: keep-alive
     Cookie: odin_tt=06a6e831554527fb7db4b33bd6a2a60d919a40061b4683bc5cb80639ca69de0eae2713014983882e57cde2208f354b31; alert_coverage=84; install_id=23121236427; ttreq=1$8d6fe34b8d2c2213daa917e1cf624db4b053d506; qh[360]=1
     Accept-Encoding: gzip
     X-SS-REQ-TICKET: 1516852628754
     User-Agent: Dalvik/2.1.0 (Linux; U; Android 6.0; Le X620 Build/HEXCNFN5902812161S) NewsArticle/6.5.5 cronet/58.0.2991.0


     */
}
