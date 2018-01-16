package cn.bpzzr.change.net;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ZYY
 * on 2018/1/16 21:39.
 * @author ZYY
 */

public class ImageLoad {
    public static void glideLoad(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
