package cn.bpzzr.change.interf.home;

import cn.bpzzr.change.bean.BaseBean;
import cn.bpzzr.change.bean.home.MhBaseBean;
import cn.bpzzr.change.bean.home.MhKeyBean;
import cn.bpzzr.change.interf.SomeKeys;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/2/5.
 * 首页
 */

public interface HomeService {

    String BANNER_TAG = "banner";
    String BASE_URL_HOME_BANNER = "https://api.mh.163.com/";
    String BANNER_PATH = "newRecommend.json";
    String LOGIN_PATH = "login/id_key_get.json";

    String HEADER_BANNER = SomeKeys.URL_FLAG + ":" + BANNER_TAG;


    /**
     * 获取登录的id与key
     *
     * @param deviceId 设备标识
     * @param encrypt  加密参数
     */
    @Headers({HEADER_BANNER})
    @GET(LOGIN_PATH)
    Observable<MhBaseBean<MhKeyBean>> getKey(
            @Query("deviceId") String deviceId,
            @Query("encrypt") String encrypt
    );

    /**
     * 网易漫画的推荐页
     *
     * @param gender 性别（0，男 1，女 默认为1）
     */
    @Headers({HEADER_BANNER})
    @GET(BANNER_PATH)
    Observable<BaseBean> getBanner(@Query("gender") int gender);

    String BAI_DU_TAG = "baiDuVedio";
    String BASE_URL_HOME_BAI_DU_VIDEO = "http://app.video.baidu.com/";
    String HOME_BAI_DU_VIDEO_PATH = "wiseselected/";

    String HEADER_BAI_DU_VIDEO = SomeKeys.URL_FLAG + ":" + BAI_DU_TAG;

    @Headers({HEADER_BAI_DU_VIDEO})
    @GET(HOME_BAI_DU_VIDEO_PATH)
    Observable<BaseBean> getHomeData(@Query("worktype") String workType,
                                     @Query("is_new_user") String isNewUser,
                                     @Query("mtj_cuid") String mtjCuid,
                                     @Query("mtj_timestamp") String timeStamp,
                                     @Query("mac_address") String macAddress,
                                     @Query("ados_ver") String osVersion,
                                     @Query("dev") String dev,
                                     @Query("lf") String lf,
                                     @Query("channel") String channel,
                                     @Query("version") String version
                                     );

    //http://app.video.baidu.com/
    // wiseselected/
    // ?worktype=adnativecomic
    // &is_new_user=1
    // &mtj_cuid=5B55296019F394E0DE0ED91FFABE58DE%7C399315720255968
    // &mtj_timestamp=1518145076682
    // &mac_address=02:00:00:00:00:00
    // &ados_ver=6.0
    // &dev=LeX620
    // &lf=eyJsb25naXR1ZGUiOiIxMTYuMjQwOTMxIiwibGF0aXR1ZGUiOiI0MC4wNzQxNDUifQ%3D%3D%0A
    // &channel=3516c
    // &version=8.1.2


}
