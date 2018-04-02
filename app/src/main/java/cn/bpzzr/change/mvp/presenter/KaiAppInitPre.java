package cn.bpzzr.change.mvp.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.bean.kaishu.ScatteredBean;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.interf.kaishu.KaiInitService;
import cn.bpzzr.change.mvp.BasePresenter;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.net.callback.KaiObserver;
import cn.bpzzr.change.temp.net.RxSchedulers;
import cn.bpzzr.change.util.AESUtil;
import cn.bpzzr.change.util.KaiShuDeviceUtil;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.SharedPreferencesUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/3/5.
 * kai shu story app init
 */

public class KaiAppInitPre extends BasePresenter {
    private String TAG = "KaiAppInitPresenter";
    private RetrofitTools retrofitTools;
    private KaiInitService initService;
    private static volatile KaiAppInitPre mInstance;

    private KaiAppInitPre() {
        //构造内部可以初始化相应参数
        initService = retrofitTools.getRetrofit()
                .create(KaiInitService.class);
    }

    public static KaiAppInitPre getInstance() {
        if (mInstance == null) {
            synchronized (KaiAppInitPre.class) {
                if (mInstance == null) {
                    mInstance = new KaiAppInitPre();
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取设备id
     *
     * @param body
     */
    public void getDeviceId(RequestBody body) {
        //body = new E
        getInitService();
        initService.getDeviceId(body)
                .compose(RetrofitTools.<BaseResultBean<ScatteredBean>>setMainThread())
                .subscribe(new KaiInitObserve(KaiInitService.PATH_DEVICE_ID));
    }

    /**
     * 获取session
     *
     * @param body
     */
    public void getSessionCode(RequestBody body) {
        getInitService();
        initService.getSessionCode(body)
                .compose(RetrofitTools.<BaseResultBean<ScatteredBean>>setMainThread())
                .subscribe(new KaiInitObserve(KaiInitService.PATH_SESSION_CODE));
    }

    /**
     * 获取token
     *
     * @param body
     */
    public void getPlatformToken(RequestBody body) {
        getInitService();
        initService.getPlatformToken(body)
                .compose(RetrofitTools.<BaseResultBean<ScatteredBean>>setMainThread())
                .subscribe(new KaiInitObserve(KaiInitService.PATH_PLATFORM_TOKEN));
    }

    /**
     * 获取初始化参数
     *
     * @param body
     */
    public void initialize(RequestBody body) {
        getInitService();
        initService.initialize(body)
                .compose(RetrofitTools.<BaseResultBean<ScatteredBean>>setMainThread())
                .subscribe(new KaiInitObserve(KaiInitService.PATH_INITIALIZE));
    }

    public void getNewVersion(RequestBody body) {
        getInitService();
        initService.initialize(body)
                .compose(RetrofitTools.<BaseResultBean<ScatteredBean>>setMainThread())
                .subscribe(new Observer<BaseResultBean<ScatteredBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResultBean<ScatteredBean> scatteredBeanBaseResultBean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getInitService() {
        if (initService == null) {
            initService = retrofitTools.getRetrofit()
                    .create(KaiInitService.class);
        }
    }

    public class KaiInitObserve extends KaiObserver<ScatteredBean> {

        public KaiInitObserve(String methodTag) {
            super(methodTag);
        }

        @Override
        protected void onRequestStart() {

        }

        @Override
        protected void onResultError(String methodTag, String errorMsg) {

        }

        @Override
        protected void onResultEmpty(String methodTag) {

        }

        @Override
        protected void onResult(String methodTag, ScatteredBean result) {
            switch (methodTag) {
                case KaiInitService.PATH_DEVICE_ID:
                    String deviceId = result.getDeviceid();
                    SharedPreferencesUtil
                            .getInstance(KaiShuDeviceUtil.KAI_SHU)
                            .put(SomeKeys.KAI_DEVICE_ID, deviceId);
                    break;
                case KaiInitService.PATH_SESSION_CODE:
                    String sessionCode = result.getSessioncode();
                    SharedPreferencesUtil
                            .getInstance(KaiShuDeviceUtil.KAI_SHU)
                            .put(SomeKeys.KAI_SESSION_CODE, sessionCode);
                    break;
                case KaiInitService.PATH_PLATFORM_TOKEN:
                    String token = result.getToken();
                    SharedPreferencesUtil
                            .getInstance(KaiShuDeviceUtil.KAI_SHU)
                            .put(SomeKeys.KAI_TOKEN, token);
                    break;
                case KaiInitService.PATH_INITIALIZE:
                    String data = result.getData();
                    AESUtil aesUtil = new AESUtil(KaiShuDeviceUtil.APP_SECRET_KAI_NORMAL);
                    String decrypt = aesUtil.decrypt(data);
                    BaseResultBean<ScatteredBean> resultBean = new Gson().fromJson(decrypt,
                            new TypeToken<BaseResultBean<ScatteredBean>>() {
                            }.getType());
                    if (resultBean != null) {
                        int errCode = resultBean.getErrcode();
                        if (errCode == 0) {
                            ScatteredBean scatteredBean = resultBean.getResult();
                            //代表获取成功
                            SharedPreferencesUtil
                                    .getInstance(KaiShuDeviceUtil.KAI_SHU)
                                    .put(SomeKeys.KAI_DEVICE_ID, scatteredBean.getDeviceid());
                            SharedPreferencesUtil
                                    .getInstance(KaiShuDeviceUtil.KAI_SHU)
                                    .put(SomeKeys.KAI_SESSION_CODE, scatteredBean.getSessioncode());
                            SharedPreferencesUtil
                                    .getInstance(KaiShuDeviceUtil.KAI_SHU)
                                    .put(SomeKeys.KAI_TOKEN, scatteredBean.getToken());
                        } else {
                            LogUtil.e(TAG, "methodTag ---> " + methodTag + " errorCode is " + errCode);
                        }
                    } else {
                        LogUtil.e(TAG, "methodTag ---> " + methodTag + " resultBean is null !");
                    }
                    break;
                default:
                    LogUtil.e(TAG, "methodTag ---> " + methodTag + " result ---> " + result);
                    break;
            }
        }

        @Override
        protected void onRequestEnd() {

        }
    }
}
