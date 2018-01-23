package cn.bpzzr.change.net;

import java.util.List;
import java.util.Map;

import cn.bpzzr.change.bean.AdBean;
import cn.bpzzr.change.bean.BaseBean;
import cn.bpzzr.change.bean.DoubanTest;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.bean.ResultBaseBean;
import cn.bpzzr.change.interf.ServerPath;
import cn.bpzzr.change.interf.SomeKeys;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/1/4.
 * retrofit具体请求方法接口
 */

public interface RetrofitClient {
    /**
     * 以json格式提交参数的header
     */
    String HEADER_UP_JSON = "Content-type:application/json;charset=UTF-8";
    String HEADER_VIDEO = SomeKeys.URL_FLAG + ":" + SomeKeys.VIDEO_DATA;
    String HEADER_BOOK = SomeKeys.URL_FLAG + ":" + SomeKeys.BOOK_DATA;
    String HEADER_ONLINE = SomeKeys.URL_FLAG + ":" + SomeKeys.ONLINE_DATA;
    String HEADER_AD = SomeKeys.URL_FLAG + ":" + SomeKeys.AD_DATA;

    @Headers({HEADER_VIDEO})
    @GET(ServerPath.DOU_BAN_BOOK)
    Call<DoubanTest> getTest();

    @Headers({HEADER_BOOK})
    @GET(ServerPath.GANK_ANDROID)
    Call<GankTest> getTest2();

    @Headers({HEADER_BOOK})
    @GET(ServerPath.GANK_ANDROID)
    Observable<GankTest> getTest3();

    @Headers({HEADER_AD, HEADER_UP_JSON})
    @POST(ServerPath.WANG_YI_AD)
    Observable<AdBean> getAds(@Body RequestBody body);

    /**
     * 批量上传类型不同的文档
     *
     * @param projectId              项目id
     * @param accountId              用户id
     * @param projectResourceClassId 资料类别id
     * @param uuid                   设备标识
     * @param xyToken                令牌
     * @param map                    文件流
     */
    @Multipart
    @POST("mobile/project/resources/uploadFiles")
    Call<ResultBaseBean<List<BaseBean>>> uploadFiles(
            @Query("projectid") String projectId,
            @Query("accountid") String accountId,
            @Query("projectresourceclassid") String projectResourceClassId,
            @Query("uuid") String uuid,
            @Query("xytoken") String xyToken,
            @PartMap Map<String, RequestBody> map
    );

    /**
     * 大文件下载的方法
     *
     * @param url 下载的路径
     */
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);

}
