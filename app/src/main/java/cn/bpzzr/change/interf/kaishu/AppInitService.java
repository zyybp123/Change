package cn.bpzzr.change.interf.kaishu;


import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.bean.kaishu.ScatteredBean;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static cn.bpzzr.change.interf.kaishu.KaiShuHost.HEADER_KAI_SHU;

/**
 * Created by Administrator on 2018/2/28.
 * 应用初始化相关请求
 */

public interface AppInitService {
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

}
