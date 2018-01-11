package cn.bpzzr.change.temp.net;

/*import com.will.weiyue.bean.FreshNewsArticleBean;
import com.will.weiyue.bean.FreshNewsBean;
import com.will.weiyue.bean.JdDetailBean;*/

import cn.bpzzr.change.bean.GankTest;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public interface JanDanApiService {

    @GET
    Observable<GankTest> getFreshNews(@Url String url, @Query("oxwlxojflwblxbsapi") String oxwlxojflwblxbsapi,
                                      @Query("include") String include,
                                      @Query("page") int page,
                                      @Query("custom_fields") String custom_fields,
                                      @Query("dev") String dev
    );


    @GET
    Observable<GankTest> getDetailData(@Url String url, @Query("oxwlxojflwblxbsapi") String oxwlxojflwblxbsapi,
                                           @Query("page") int page
    );

    @GET
    Observable<GankTest> getFreshNewsArticle(@Url String url, @Query("oxwlxojflwblxbsapi") String oxwlxojflwblxbsapi,
                                                         @Query("include") String include,
                                                         @Query("id") int id
    );

}
