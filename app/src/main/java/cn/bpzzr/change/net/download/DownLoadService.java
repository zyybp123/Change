package cn.bpzzr.change.net.download;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/1/30.
 * 下载方法接口
 * <p>
 * 此处不采用RxJava的方式，因为拿到call可以做中断，取消
 */

public interface DownLoadService {

    /**
     * 大文件下载的方法
     *
     * @param url 下载的路径
     * @return 带响应体的call
     */
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url);

    /**
     * 断点下载的方法
     *
     * @param range range头，记录从哪开始下载
     * @param url   下载路径
     * @return 带响应体的call
     */
    @GET
    @Streaming
    Call<ResponseBody> download(@Header("Range") String range, @Url String url);
}
