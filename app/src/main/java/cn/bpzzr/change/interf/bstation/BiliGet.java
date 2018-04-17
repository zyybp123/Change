package cn.bpzzr.change.interf.bstation;

import cn.bpzzr.change.bean.bstation.PlayUrl;
import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static cn.bpzzr.change.interf.kaishu.KaiShuHost.HEADER_KAI_SHU;

/**
 * Created by ZYY
 * on 2018/4/5 20:59.
 */

public interface BiliGet {
    /**
     * 获取设备号的路径
     */
    String PATH_PLAY_URL = "player/api/v2/playurl";

    /**
     * 获取播放Url
     * qn=80
     * &platform=android
     * &expire=1525521999
     * &module=bangumi
     * &appkey=iVGUTjsxvpLeuDCf
     * &build=5240000
     * &type=any
     * &cid=29662087
     * &buvid=3B407294-0003-4406-8226-767C734EA9554748infoc
     * &season_type=1
     * &device=android
     * &access_key=cf044851b084d263d39373019996fb54
     * &mid=235020708
     * &track_path=0
     * &otype=json
     * &mobi_app=android
     * &npcybs=0
     * &sign=bc6cdf6ab6bbc6fd3f819206b443c78b
     */
    @Headers({HEADER_KAI_SHU})
    @GET(PATH_PLAY_URL)
    Observable<BaseResultBean<PlayUrl>> getDeviceId(@Body RequestBody body);
}
