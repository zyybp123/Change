package cn.bpzzr.change.temp.net;

import android.support.annotation.StringDef;

/*import com.will.weiyue.bean.NewsArticleBean;
import com.will.weiyue.bean.NewsDetail;
import com.will.weiyue.bean.VideoChannelBean;
import com.will.weiyue.bean.VideoDetailBean;*/

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import cn.bpzzr.change.bean.GankTest;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public class NewsApi {

    public static final String ACTION_DEFAULT = "default";
    public static final String ACTION_DOWN = "down";
    public static final String ACTION_UP = "up";

    @StringDef({ACTION_DEFAULT,ACTION_DOWN,ACTION_UP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions{

    }

    public static NewsApi sInstance;

    private NewsApiService mService;

    public NewsApi(NewsApiService newsApiService) {
        this.mService = newsApiService;
    }

    public static NewsApi getInstance(NewsApiService newsApiService) {
        if (sInstance == null)
            sInstance = new NewsApi(newsApiService);
        return sInstance;
    }

    /**
     * 获取新闻详情
     *
     * @param id      频道ID值
     * @param action  用户操作方式
     *                1：下拉 down
     *                2：上拉 up
     *                3：默认 default
     * @param pullNum 操作次数 累加NewsDetail
     * @return
     */
    public Observable<GankTest> getNewsDetail(String id, @Actions String action, int pullNum) {
        return mService.getNewsDetail(id, action, pullNum)
                .flatMap(new Function<List<GankTest>, ObservableSource<GankTest>>() {
                    @Override
                    public ObservableSource<GankTest> apply(@NonNull List<GankTest> newsDetails) throws Exception {
                        return Observable.fromIterable(newsDetails);
                    }
                });
    }

    /**
     * 获取新闻文章详情
     * @param aid 文章aid  此处baseurl可能不同，需要特殊处理
     *          1：aid 以 cmpp 开头则调用 getNewsArticleWithCmpp
     * @return
     */
    public Observable<GankTest> getNewsArticle(String aid){
        if (aid.startsWith("sub")){
            return mService.getNewsArticleWithSub(aid);
        }else {
            return mService.getNewsArticleWithCmpp(ApiConstants.sGetNewsArticleCmppApi + ApiConstants.sGetNewsArticleDocCmppApi,aid);
        }
    }

    /**
     * 获取视频频道列表
     *
     * @return
     */
    public Observable<List<GankTest>> getVideoChannel(){
        return mService.getVideoChannel(1);
    }

    /**
     * 获取
     *
     * @param page
     * @param listtype
     * @param typeid
     * @return
     */
    public Observable<List<GankTest>> getVideoDetail(int page,String listtype,String typeid){
        return mService.getVideoDetail(page,listtype,typeid);
    }

}
