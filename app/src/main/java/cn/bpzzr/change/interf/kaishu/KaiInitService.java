package cn.bpzzr.change.interf.kaishu;


import cn.bpzzr.change.bean.BaseBean;
import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.bean.kaishu.NewVersionBean;
import cn.bpzzr.change.bean.kaishu.ScatteredBean;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static cn.bpzzr.change.interf.kaishu.KaiShuHost.HEADER_KAI_SHU;

/**
 * Created by Administrator on 2018/2/28.
 * kai shu story 首页所需的请求
 */

public interface KaiInitService {
    /**
     * 获取设备号的路径
     */
    String PATH_DEVICE_ID = "appinitservice/generate/deviceid";

    /**
     * 获取设备id号
     *
     * @param body 提交json串
     *             {"platform":"kaishu",
     *             "appversion":"V4.2.0",
     *             "sysversion":"23",
     *             "appid":"992099001",
     *             "channelid":"yingyongbao",
     *             "phonemodel":"Le X620",
     *             "phonedevicecode":"869552027513993",
     *             "channelmsg":"android"}
     * @return 返回设备id
     */
    @Headers({HEADER_KAI_SHU})
    @POST(PATH_DEVICE_ID)
    Observable<BaseResultBean<ScatteredBean>> getDeviceId(@Body RequestBody body);

    /**
     * 获取session code的路径
     */
    String PATH_SESSION_CODE = "appinitservice/generate/sessioncode";

    /**
     * 获取session code
     *
     * @param body 提交json串
     *             {"deviceid":"",
     *             "channelmsg":"android",
     *             "platform":"kaishu"}
     * @return 返回session code
     */
    @Headers({HEADER_KAI_SHU})
    @POST(PATH_SESSION_CODE)
    Observable<BaseResultBean<ScatteredBean>> getSessionCode(@Body RequestBody body);

    /**
     * 获取token的路径
     */
    String PATH_PLATFORM_TOKEN = "appinitservice/generate/platformtoken";

    /**
     * 获取token
     *
     * @param body 提交json串
     *             {"appid":"",
     *             "channelmsg":"android",
     *             "platform":"kaishu"}
     * @return 返回token
     */
    @Headers({HEADER_KAI_SHU})
    @POST(PATH_PLATFORM_TOKEN)
    Observable<BaseResultBean<ScatteredBean>> getPlatformToken(@Body RequestBody body);

    /**
     * 获取初始化数据的路径
     */
    String PATH_INITIALIZE = "appinitservice/generate/initialize";

    /**
     * 获取初始化的数据
     *
     * @param body 提交json串
     *             {"data":"加密串"}
     *             加密串：
     *             {"channelid":"yinyongbao",
     *             "phonedevicecode":"869552027513993",
     *             "phonemodel":"Le X620",
     *             "sysversion":"23",
     *             "appversion":"V4.2.0",
     *             "appid":"992099001",
     *             "channelmsg":"android",
     *             "platform":"kaishu",
     *             }
     * @return 返回data,是一个AES加密后的加密串
     */
    @Headers({HEADER_KAI_SHU})
    @POST(PATH_INITIALIZE)
    Observable<BaseResultBean<ScatteredBean>> initialize(@Body RequestBody body);

    /**
     * 获取新版本信息
     */
    String PATH_NEW_VERSION = "appinitservice/generate/newversion";

    /**
     * 获取新版
     *
     * @param body 提交json串
     *             {"clienttype":"1",
     *             "appid":"",
     *             "appversion":"",
     *             "versioncode":"",
     *             "channelid":"",
     *             "osvsion":"android",
     *             }
     * @return 返回新版信息
     */
    @Headers({HEADER_KAI_SHU})
    @POST(PATH_NEW_VERSION)
    Observable<BaseResultBean<NewVersionBean>> getNewVersion(@Body RequestBody body);

    String PATH_AD_VER_LIST = "homeservice/adver/list";
    @Headers({HEADER_KAI_SHU})
    @GET(PATH_AD_VER_LIST)
    Observable<BaseBean> getAdVerList();
}
