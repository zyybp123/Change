package cn.bpzzr.change.manager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/21.
 * Glide全局配置
 */
@GlideModule
public class GlideManager extends AppGlideModule {

    private int memorySize = (int) (Runtime.getRuntime().maxMemory()) / 8;  // 取1/8最大内存作为最大缓存
    private RequestOptions requestOptions = new RequestOptions();

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // 自定义内存和图片池大小
        builder.setMemoryCache(new LruResourceCache(memorySize));
        builder.setBitmapPool(new LruBitmapPool(memorySize));
        //设置磁盘缓存大小300M
        int diskSize = 1024 * 1024 * 500;
        //磁盘缓存采用lruCache策略，指定数据的缓存地址(cache目录下的appImgCache)
        builder.setDiskCache(
                new InternalCacheDiskCacheFactory(context, "appImgCache", diskSize));
        //设置默认的缓存图片格式
        builder.setDefaultRequestOptions(requestOptions.format(DecodeFormat.PREFER_ARGB_8888));
        //设置日志级别,为调试模式
        builder.setLogLevel(Log.DEBUG);
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        //组件注册
        //registry.append(ContactsContract.CommonDataKinds.Photo.class, InputStream.class, new CustomModelLoader.Factory());
    }

}
