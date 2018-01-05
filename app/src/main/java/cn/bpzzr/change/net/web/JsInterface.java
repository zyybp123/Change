package cn.bpzzr.change.net.web;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by Administrator on 2018/1/5.
 * js方法触发，原生来处理的类
 */

public class JsInterface {
    private Context mContext;

    public JsInterface(Context mContext) {
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void imageClick(String imgUrl, String hasLink) {
        //Toast.makeText(context, "----点击了图片", Toast.LENGTH_SHORT).show();
        // 查看大图
        //Intent intent = new Intent(context, ViewBigImageActivity.class);
        //context.startActivity(intent);
        Log.e("----点击了图片 url: ", "" + imgUrl);
    }
}
