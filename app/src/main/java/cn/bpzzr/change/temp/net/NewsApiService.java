package cn.bpzzr.change.temp.net;

/*import com.will.weiyue.bean.NewsArticleBean;
import com.will.weiyue.bean.NewsCmppVideoBean;
import com.will.weiyue.bean.NewsDetail;
import com.will.weiyue.bean.NewsImagesBean;
import com.will.weiyue.bean.VideoChannelBean;
import com.will.weiyue.bean.VideoDetailBean;*/

import java.util.List;

import cn.bpzzr.change.bean.GankTest;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public interface NewsApiService {


//    @GET("ClientNews")
//    Observable<List<NewsDetail>> getNewsDetail(@Query("id") String id,
//                                               @Query("action") String action,
//                                               @Query("pullNum") String pullNum,
//                                               @Query("uid") String uid,
//                                               @Query("devid") String devid,
//                                               @Query("proid") String proid,
//                                               @Query("vt") String vt,
//                                               @Query("publishid") String publishid,
//                                               @Query("screen") String screen,
//                                               @Query("os") String os,
//                                               @Query("df") String df,
//                                               @Query("nw") String nw);

    @GET("ClientNews")
    Observable<List<GankTest>> getNewsDetail(@Query("id") String id,
                                             @Query("action") String action,
                                             @Query("pullNum") int pullNum
    );

    @GET("api_vampire_article_detail")
    Observable<GankTest> getNewsArticleWithSub(@Query("aid") String aid);

    @GET
    Observable<GankTest> getNewsArticleWithCmpp(@Url String url,
                                                       @Query("aid") String aid);

    @GET
    Observable<GankTest> getNewsImagesWithCmpp(@Url String url,
                                                     @Query("aid") String aid);

    @GET("NewRelativeVideoList")
    Observable<GankTest> getNewsVideoWithCmpp(@Url String url,
                                                       @Query("guid") String guid);

    @GET("ifengvideoList")
    Observable<List<GankTest>> getVideoChannel(@Query("page") int page);

    @GET("ifengvideoList")
    Observable<List<GankTest>> getVideoDetail(@Query("page") int page,
                                                     @Query("listtype") String listtype,
                                                     @Query("typeid") String typeid);


}
