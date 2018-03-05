package cn.bpzzr.change.mvp.presenter;

import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.bean.kaishu.ScatteredBean;
import cn.bpzzr.change.interf.kaishu.KaiInitService;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.net.callback.KaiObserver;
import cn.bpzzr.change.util.LogUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/3/5.
 */

public class KaiAppInitPre {
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
                    result.getDeviceid();
                    break;
                case KaiInitService.PATH_SESSION_CODE:
                    result.getSessioncode();
                    break;
                case KaiInitService.PATH_PLATFORM_TOKEN:
                    result.getToken();
                    break;
                case KaiInitService.PATH_INITIALIZE:
                    result.getData();
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
