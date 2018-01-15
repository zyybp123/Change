package cn.bpzzr.change.net;

import android.support.annotation.Nullable;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;

import java.io.File;

/**
 * Created by Administrator on 2018/1/15.
 * 自定义的磁盘缓存策略
 */

public class MyDiskCache implements DiskCache {
    @Nullable
    @Override
    public File get(Key key) {
        return null;
    }

    @Override
    public void put(Key key, Writer writer) {
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public void clear() {

    }
}
