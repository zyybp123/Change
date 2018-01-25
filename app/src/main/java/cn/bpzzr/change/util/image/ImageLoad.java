package cn.bpzzr.change.util.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import cn.bpzzr.change.manager.GlideApp;
import cn.bpzzr.change.manager.GlideRequest;

/**
 * Created by ZYY
 * on 2018/1/16 21:39.
 * 对Glide加载图片的再封装
 *
 * @author ZYY
 */

public class ImageLoad {

    public static final int CIRCLE = 0;
    public static final int FILLET = 1;
    private static RequestOptions requestOptions;

    public ImageLoad() {
        requestOptions = new RequestOptions();
    }

    public static GlideRequest<Drawable> load(Context context, String url) {
        return GlideApp.with(context).load(url);
    }

    public static GlideRequest<Drawable> load(Context context, File file) {
        return GlideApp.with(context).load(file);
    }

    /**
     * 图片的简单加载
     *
     * @param context   上下文
     * @param url       图片的链接
     * @param imageView 目标控件
     */
    public static void glideLoad(Context context, String url, @NonNull ImageView imageView) {
        load(context, url).into(imageView);
    }

    /**
     * 图片的简单加载，从本地文件中
     *
     * @param context   上下文
     * @param file      本地图片
     * @param imageView 目标控件
     */
    public static void glideLoad(Context context, File file, @NonNull ImageView imageView) {
        load(context, file).into(imageView);
    }

    /**
     * 图片带状态监听的加载
     *
     * @param context   上下文
     * @param url       图片的链接
     * @param imageView 目标控件
     */
    public static void glideLoad(Context context, String url, @NonNull ImageView imageView, RequestListener<Drawable> listener) {
        load(context, url).listener(listener).into(imageView);
    }

    /**
     * 图片带状态监听的加载
     *
     * @param context   上下文
     * @param file      本地文件
     * @param imageView 目标控件
     */
    public static void glideLoad(Context context, File file, @NonNull ImageView imageView, RequestListener<Drawable> listener) {
        load(context, file).listener(listener).into(imageView);
    }

    /**
     * 图片带进度监听的加载
     *
     * @param context   上下文
     * @param url       图片的链接
     * @param imageView 目标控件
     * @param shape     要显示的图片的形状
     */
    public static void glideLoad(Context context, String url, @NonNull ImageView imageView, int shape, int roundingRadius) {
        Transformation<Bitmap> transformation;
        GlideRequest<Drawable> load = load(context, url);
        //如有需要其背景也应该为对应的形状
        switch (shape) {
            case CIRCLE:
                //加载圆形图片，
                transformation = new CircleCrop();
                break;
            case FILLET:
                //加载全圆角图片，
                transformation = new RoundedCorners(roundingRadius);
                //transformation = new MyRoundCorners(context,roundingRadius, MyRoundCorners.CornerType.ALL);
                break;
            default:
                //默认无转换
                transformation = null;
                break;
        }
        if (transformation == null) {
            load.into(imageView);
        } else {
            load.transform(transformation)
                    .into(imageView);
        }
    }


}
