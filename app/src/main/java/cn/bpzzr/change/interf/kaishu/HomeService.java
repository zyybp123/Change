package cn.bpzzr.change.interf.kaishu;

import cn.bpzzr.change.bean.BaseBean;
import cn.bpzzr.change.interf.SomeKeys;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static cn.bpzzr.change.interf.kaishu.KaiShuHost.HEADER_KAI_SHU;

/**
 * Created by Administrator on 2018/2/28.
 * kai shu story api
 */

public interface HomeService {


    String PATH_AD_VER_LIST = "homeservice/adver/list";
    @Headers({HEADER_KAI_SHU})
    @GET(PATH_AD_VER_LIST)
    Observable<BaseBean> getAdVerList();

}
