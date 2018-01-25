package cn.bpzzr.change.util.image;


import android.support.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/1/25.
 */
class OkHttpFetcher implements DataFetcher<InputStream> {

    private final OkHttpClient client;
    private final GlideUrl url;
    private InputStream stream;
    private ResponseBody responseBody;
    private volatile boolean isCancelled;

    public OkHttpFetcher(OkHttpClient client, GlideUrl url) {
        this.client = client;
        this.url = url;
    }

    @Override
    public void loadData(Priority priority, DataCallback<? super InputStream> callback) {

    }

    @Override
    public void cleanup() {

    }

    @Override
    public void cancel() {

    }

    @NonNull
    @Override
    public Class<InputStream> getDataClass() {
        return null;
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
        return null;
    }
}