package cn.bpzzr.change.manager;

import com.bumptech.glide.load.engine.GlideException;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bpzzr.change.net.callback.ProgressCallback;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/29.
 * 进度监听管理器
 */

public class ProgressManager {

    private ProgressManager() {
    }

    /**
     * 监听器map，会存在多个下载同时进行
     */
    public static final Map<String, ProgressCallback> LISTENER_MAP = new HashMap<>();

    public static void addListener(String url, ProgressCallback listener) {
        LISTENER_MAP.put(url, listener);
    }

    public static void removeListener(String url) {
        LISTENER_MAP.remove(url);
    }


    private static List<WeakReference<ProgressCallback>> listeners = Collections.synchronizedList(new ArrayList<WeakReference<ProgressCallback>>());
    private static OkHttpClient okHttpClient;


    private static final ProgressCallback LISTENER = new ProgressCallback() {
        @Override
        public void onLoading(long contentLength, long bytesWritten, boolean done) {

        }

        //@Override
        public void onProgress(String imageUrl, long bytesRead, long totalBytes, boolean isDone, GlideException exception) {
            if (listeners == null || listeners.size() == 0) return;

            for (int i = 0; i < listeners.size(); i++) {
                WeakReference<ProgressCallback> listener = listeners.get(i);
                ProgressCallback progressListener = listener.get();
                if (progressListener == null) {
                    listeners.remove(i);
                } else {
                    progressListener.onLoading(totalBytes, bytesRead, isDone);
                }
            }
        }
    };

    public static void addProgressListener(ProgressCallback progressListener) {
        if (progressListener == null) return;

        if (findProgressListener(progressListener) == null) {
            listeners.add(new WeakReference<>(progressListener));
        }
    }

    public static void removeProgressListener(ProgressCallback progressListener) {
        if (progressListener == null) return;

        WeakReference<ProgressCallback> listener = findProgressListener(progressListener);
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    private static WeakReference<ProgressCallback> findProgressListener(ProgressCallback listener) {
        if (listener == null) return null;
        if (listeners == null || listeners.size() == 0) return null;

        for (int i = 0; i < listeners.size(); i++) {
            WeakReference<ProgressCallback> progressListener = listeners.get(i);
            if (progressListener.get() == listener) {
                return progressListener;
            }
        }
        return null;
    }
}
