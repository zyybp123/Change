package cn.bpzzr.change.interf.tzq;

import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.bean.kaishu.ScatteredBean;
import cn.bpzzr.change.bean.tzq.BaseResult;
import cn.bpzzr.change.bean.tzq.ScatteredData;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static cn.bpzzr.change.interf.kaishu.KaiShuHost.HEADER_KAI_SHU;
import static cn.bpzzr.change.interf.tzq.TzqHost.HEADER_TZQ;

/**
 * Created by Administrator on 2018/5/10.
 * tzq
 */

public interface TzqService {
    //接口地址：https://www.xytzq.cn:9443/tzq/api/getSignToken
    String PATH_GET_SIGN_TOKEN = "tzq/api/getSignToken";

    /**
     * 获取签名令牌
     *
     * @param cooperationId 合作伙伴id
     */
    @Headers({HEADER_TZQ})
    @POST(PATH_GET_SIGN_TOKEN)
    @FormUrlEncoded
    Observable<BaseResult<ScatteredData>> getSignToken(
            @Field("cooperationid") String cooperationId
    );


    /**
     * 获取登录信息数据的路径
     */
    String PATH_GET_LOGIN_INFO = "tzq/api/getLoginInformation";

    /**
     * 获取登录信息
     *
     * @param signToken   签名令牌
     * @param phone       手机号
     * @param orgName     组织名称
     * @param collegeName 分院名称
     * @param role        角色
     * @param pwd         密码
     * @return 返回数据，其中Data为一串加密字符串
     */
    @Headers({HEADER_TZQ})
    @POST(PATH_GET_LOGIN_INFO)
    @FormUrlEncoded
    Observable<BaseResult<String>> getLoginInformation(
            @Field("signtoken") String signToken,
            @Field("phone") String phone,
            @Field("orgname") String orgName,
            @Field("collegename") String collegeName,
            @Field("role") String role,
            @Field("pwd") String pwd

    );
}
