package cn.bpzzr.change.net.kaishu;

import cn.bpzzr.change.bean.kaishu.BaseResultBean;
import cn.bpzzr.change.bean.kaishu.ScatteredBean;
import cn.bpzzr.change.interf.kaishu.KaiHomeService;
import cn.bpzzr.change.interf.kaishu.KaiShuHost;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.net.callback.KaiObserver;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/3/1.
 * 初始化的请求
 */

public class KaiInitRequest {
    RetrofitTools retrofitTools;
    KaiHomeService appInitService;

    public KaiInitRequest() {
        retrofitTools = RetrofitTools.getInstance(KaiShuHost.BASE_URL_KAI_SHU_STORY_NORMAL);
        appInitService = retrofitTools
                .getRetrofit()
                .create(KaiHomeService.class);
    }

    public void getDeviceId(MVP.View view, RequestBody body) {
        appInitService
                .getDeviceId(body)
                .compose(RetrofitTools.<BaseResultBean<ScatteredBean>>setMainThread())
                .subscribe(new KaiObserver<ScatteredBean>(view, KaiHomeService.PATH_DEVICE_ID));
    }
}
