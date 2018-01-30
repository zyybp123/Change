package cn.bpzzr.change.net.download;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import java.io.IOException;

import cn.bpzzr.change.manager.ProgressManager;
import cn.bpzzr.change.net.progress.ProgressCallback;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by Administrator on 2017/12/22.
 * 文件下载响应体
 */

public class FileResponseBody extends ResponseBody {
    /**
     * 实际请求体
     */
    private ResponseBody mResponseBody;
    /**
     * 下载回调接口
     */
    private ProgressCallback mCallback;
    /**
     * BufferedSource
     */
    private BufferedSource mBufferedSource;

    public FileResponseBody(String url, ResponseBody responseBody) {
        super();
        this.mResponseBody = responseBody;
        this.mCallback = ProgressManager.LISTENER_MAP.get(url);
    }

    @Override
    public BufferedSource source() {
        if (mBufferedSource == null) {
            mBufferedSource = Okio.buffer(source(mResponseBody.source()));
        }
        return mBufferedSource;
    }

    @Override
    public long contentLength() {
        return mResponseBody.contentLength();
    }

    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    /**
     * 回调进度接口
     *
     * @param source
     * @return Source
     */
    @NonNull
    @Contract(pure = true)
    private Source source(Source source) {
        return new ForwardingSource(source) {
            long totalBytesRead = 0L;

            @Override
            public long read(@NonNull Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                if (mCallback != null) {
                    mCallback.onLoading(mResponseBody.contentLength(), totalBytesRead, bytesRead == -1);
                }
                return bytesRead;
            }
        };
    }
}
