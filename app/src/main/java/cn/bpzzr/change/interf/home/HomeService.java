package cn.bpzzr.change.interf.home;

import cn.bpzzr.change.bean.BaseBean;
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
    String BASE_URL_HOME_BANNER = "https://api.mh.163.com";
    String BANNER_PATH = "/newRecommend.json";

    String HEADER_BANNER = SomeKeys.URL_FLAG + ":" + BANNER_TAG;

    /**
     * 网易漫画的推荐页
     *
     * @param gender 性别（0，男 1，女 默认为1）
     */
    @Headers({HEADER_BANNER})
    @GET(BANNER_PATH)
    Observable<BaseBean> getBanner(@Query("gender") int gender);

}
