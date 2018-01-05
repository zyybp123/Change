package cn.bpzzr.change.net;

import android.database.Observable;

import java.util.List;
import java.util.Map;

import cn.bpzzr.change.Bean.BaseBean;
import cn.bpzzr.change.Bean.DoubanTest;
import cn.bpzzr.change.Bean.GankTest;
import cn.bpzzr.change.Bean.ResultBaseBean;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.interf.SomeKeys;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
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
    String HEADER_VIDEO = "{\"" + SomeKeys.URL_FLAG + ":" + SomeKeys.VIDEO_DATA + "\"}";
    String HEADER_BOOK = "{\"" + SomeKeys.URL_FLAG + ":" + SomeKeys.BOOK_DATA + "\"}";
    String HEADER_ONLINE = "{\"" + SomeKeys.URL_FLAG + ":" + SomeKeys.ONLINE_DATA + "\"}";

    @Headers(HEADER_VIDEO)
    @GET(ServerHost.TEST_PRE)
    Call<ResultBaseBean<DoubanTest>> getTest();

    @Headers(HEADER_BOOK)
    @GET(ServerHost.TEST_PRE_2)
    Call<ResultBaseBean<GankTest>> getTest2();

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
    Observable<ResponseBody> download(@Header("RANGE") String start, @Url String url);

}
