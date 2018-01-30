package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.net.URL;
import java.util.Arrays;

import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2Test3;
import cn.bpzzr.change.adapter.base.Adapter2Test2;
import cn.bpzzr.change.manager.ProgressManager;
import cn.bpzzr.change.net.download.DownloadManager;
import cn.bpzzr.change.net.download.ResInfo;
import cn.bpzzr.change.net.progress.ProgressCallback;
import cn.bpzzr.change.ui.fragment.base.BaseFragmentRefreshPage;
import cn.bpzzr.change.util.LogUtil;

import static cn.bpzzr.change.global.Change.mContext;

/**
 * Created by Administrator on 2018/1/30.
 * 临时测试页
 */

public class Temp2 extends BaseFragmentRefreshPage<ResInfo> {
    public static final String[] URLS = new String[]{
            "http://yt-adv.nosdn.127.net/channel4/aqfs_20180129.mp4",
            "http://yt-adv.nosdn.127.net/channel4/awyx_20180129.mp4",
            "https://dongfeng.alicdn.com/201801/4f965e8bc0174f77b53e346711f36696.mp4",
            "https://dongfeng.alicdn.com/201801/8d88f7513e724f4888d2d904eeee28bf.mp4",
            "http://yt-adv.nosdn.127.net/channel6/atyw_20180105.mp4",
            "http://yt-adv.nosdn.127.net/channel6/azfz_20180105.mp4",
            "http://yt-adv.nosdn.127.net/channel6/atbo_20180102.mp4",
            "http://yt-adv.nosdn.127.net/channel6/aqju_20180102.mp4"
    };

    @Override
    public boolean isShowLoadingFrist() {
        return false;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return BaseFragmentRefreshPage.getLinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        Adapter2Test3 adapter2Test3 = new Adapter2Test3(R.layout.item_temp_download, mDataList);
        adapter2Test3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final BaseQuickAdapter adapter, View view, int position) {
                LogUtil.e(mFragmentTag, "onItemClick: ");
                //Toast.makeText(ItemClickActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();

                DownloadManager.getInstance().startDownload(mDataList.get(position));
            }
        });
        return adapter2Test3;
    }

    @Override
    public void successViewBind() {
        mStateLayout.showSuccessView();

        for (int i = 0; i < URLS.length; i++) {
            ResInfo info = new ResInfo();
            info.setFileDir(mActivity.getFilesDir().getAbsolutePath());
            info.setUrl(URLS[i]);
            mDataList.add(info);
        }
        //mDataList.addAll(Arrays.asList(URLS));
        //mAdapter.setNewData(mDataList);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onceRequest() {
        //retrofitTools.getTest(this);

    }

    @Override
    protected void refreshRequest() {

    }

    @Override
    protected void loadMoreRequested() {

    }

    @Override
    public void onError(String tag, String msg) {

    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        //showSuccess();

    }

    @Override
    public void onEmpty(String tag) {

    }
}
