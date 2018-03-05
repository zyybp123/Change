package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2Test3;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.download.DownloadManager;
import cn.bpzzr.change.net.common.ResInfo;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.ListUtil;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/30.
 * 临时测试页
 */

public class Temp2 extends BaseFragmentRefreshPage<ResInfo> implements MVP.View{
    public static final String[] URLS = new String[]{
            "http://xytzq01.oss-cn-shanghai.aliyuncs.com/data/project/project_22019/resource/document/a41be61c2b8849a68c35461b916935e6.pdf",
            "http://appdlc.hicloud.com/dl/appdl/application/apk/9c/9cf5bc5a91d14d82a88a08f10cc359b2/cc.thedream.qinsmoon.HUAWEI.1712251337.apk",
            "http://appdl.hicloud.com/dl/appdl/application/apk/c6/c6733db75f724f6282034082e3a35ce1/com.ss.android.ugc.live.1801221453.apk",
            "http://yt-adv.nosdn.127.net/channel4/aqfs_20180129.mp4",
            "http://yt-adv.nosdn.127.net/channel4/awyx_20180129.mp4",
            "https://dongfeng.alicdn.com/201801/4f965e8bc0174f77b53e346711f36696.mp4",
            "https://dongfeng.alicdn.com/201801/8d88f7513e724f4888d2d904eeee28bf.mp4",
            "http://yt-adv.nosdn.127.net/channel6/atyw_20180105.mp4",
            "http://yt-adv.nosdn.127.net/channel6/azfz_20180105.mp4",
            "http://yt-adv.nosdn.127.net/channel6/atbo_20180102.mp4",
            "http://yt-adv.nosdn.127.net/channel6/aqju_20180102.mp4"
    };
    private DownloadManager downloadManager;

    @Override
    public boolean isShowLoadingFrist() {
        return true;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return new Adapter2Test3(R.layout.item_temp_download, mDataList);
    }

    @Override
    public void successViewBind() {
        //添加数据
        for (int i = 0; i < URLS.length; i++) {
            ResInfo info = new ResInfo();
            info.setResId(i);
            info.setFileDir(mActivity.getFilesDir().getAbsolutePath());
            info.setUrl(URLS[i]);
            info.setFullName(StringUtil.getFileName(URLS[i]));
            info.setResName(StringUtil.getFileName(URLS[i]));
            mDataList.add(info);
        }
        downloadManager = DownloadManager.getInstance(1);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        LogUtil.e(mFragmentTag, "onItemClick: ");
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
        switch (view.getId()) {
            case R.id.frame_progress:
                ResInfo resInfo = mDataList.get(position);
                downloadManager.downLoadClick(resInfo, mAdapter, position, new DownloadManager.StateChangeListener() {
                    @Override
                    public void stateChanged(int state) {
                        mDataList.get(position).setStatus(state);
                        mAdapter.notifyItemChanged(position);
                    }

                    @Override
                    public void openFile(String type) {
                        LogUtil.e("open the file " + type);
                    }
                });
                break;
        }
    }

    @Override
    protected void onceRequest() {
        //模拟数据请求
        retrofitTools.getTest(this);

    }

    @Override
    protected void refreshRequest() {

    }

    @Override
    protected void loadMoreRequested() {

    }

    @Override
    public void onRequestStart(String tag) {

    }

    @Override
    public void onError(String tag, String msg) {

    }

    DownloadManager instance = DownloadManager.getInstance(1);

    @Override
    public void onSuccess(String tag, String result, Object data) {

        //预处理数据，在子线程，可根据实际需求进行再封装
        Observable.just(mDataList)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Function<List<ResInfo>, List<ResInfo>>() {
                    @Override
                    public List<ResInfo> apply(List<ResInfo> resInfos) throws Exception {
                        LogUtil.e(mFragmentTag, "res...." + Thread.currentThread());
                        List<ResInfo> resInfoList = new ArrayList<>();
                        for (int i = 0; i < resInfos.size(); i++) {
                            ResInfo resInfo = resInfos.get(i);
                            if (resInfo != null) {
                                List<ResInfo> query = instance.query(resInfo);
                                if (ListUtil.nullOrEmpty(query)) {
                                    //没查到
                                    instance.insertOne(resInfo);
                                } else {
                                    //查到了,取数据库里的
                                    resInfo = query.get(0);
                                }
                                resInfoList.add(resInfo);
                            }
                        }
                        return resInfoList;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ResInfo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ResInfo> resInfos) {
                        showSuccess();
                        mDataList.clear();
                        mDataList.addAll(resInfos);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void onEmpty(String tag) {

    }
}
