package cn.bpzzr.change.ui.activity.guide;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.AdBean;
import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.manager.ACache;
import cn.bpzzr.change.net.ImageLoad;
import cn.bpzzr.change.util.LogUtil;
import cn.bpzzr.change.util.StringUtil;

import static cn.bpzzr.change.global.Change.mContext;

public class SplashActivity extends AppCompatActivity {
    ACache mCache;
    List<AdBean.AdsBean.ResourcesBean> resourcesBeanList;
    @BindView(R.id.splash_iv)
    ImageView splashIv;
    @BindView(R.id.splash_tv_count)
    TextView splashTvCount;
    @BindView(R.id.splash_sv)
    SurfaceView splashSv;
    /**
     * 媒体播放器
     */
    private MediaPlayer mMediaPlayer;
    /**
     * 默认三秒
     */
    private int countDownTime = 5000;
    /**
     * 倒计时，计时器
     */
    CountDownTimer timer;
    /**
     * 是否已经完成倒计时的标识
     */
    boolean hasFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mCache = ACache.get(this);
        resourcesBeanList = new Gson().fromJson(mCache.getAsString(SomeKeys.SPLASH_AD_CACHE),
                new TypeToken<List<AdBean.AdsBean.ResourcesBean>>() {
                }.getType());
        String asString = mCache.getAsString(SomeKeys.SPLASH_AD_ST);
        String adType = mCache.getAsString(SomeKeys.SPLASH_AD_TYPE);
        if (TextUtils.isEmpty(asString)) {
            asString = "5000";
        }
        countDownTime = Integer.parseInt(asString);
        //从缓存里拿数据，有数据，判断是视频还是图片
        if (resourcesBeanList != null) {

            String adUrlImg = "";
            String adUrlVideo = "";
            for (int i = 0; i < resourcesBeanList.size(); i++) {
                AdBean.AdsBean.ResourcesBean resourcesBean = resourcesBeanList.get(i);
                if (resourcesBean != null) {
                    int type = resourcesBean.getType();
                    //说明是图片
                    List<String> urls = resourcesBean.getUrls();
                    if (urls != null && urls.size() > 0) {
                        if (type == 0) {
                            adUrlImg = StringUtil.getNotNullStr(urls.get(0));
                        } else if (type == 1) {
                            //视频
                            adUrlVideo = StringUtil.getNotNullStr(urls.get(0));
                        }
                        LogUtil.e("url....." + adUrlImg + adUrlVideo);
                    }

                }
            }
            //有数据
            if ("1".equals(adType)) {
                splashSv.setVisibility(View.VISIBLE);
                splashIv.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams layoutParams = splashIv.getLayoutParams();
                if (layoutParams != null){
                    layoutParams.height = 1475;
                    splashIv.setLayoutParams(layoutParams);
                }
                splashIv.setBackgroundColor(Color.WHITE);
                splashTvCount.setVisibility(View.GONE);
                initSurfaceView(adUrlVideo);
            } else {
                splashSv.setVisibility(View.GONE);
                splashIv.setVisibility(View.VISIBLE);
                ImageLoad.glideLoad(mContext, adUrlImg, splashIv);
            }
        }
        timer = new CountDownTimer(countDownTime, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                hasFinish = false;
                //倒计时的操作在此进行
                long time = millisUntilFinished / 1000;
                //显示倒计时的时间
                splashTvCount.setText(time == 0 ? "跳过" : time + " 跳过");
            }

            @Override
            public void onFinish() {
                hasFinish = true;
                //跳转
                HomeActivity.startSelf(SplashActivity.this);
            }
        };
        if ("0".equals(adType)) {
            timer.start();
        }
        splashTvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳过
                HomeActivity.startSelf(SplashActivity.this);
            }
        });
    }

    private void initSurfaceView(final String url) {
        //保持屏幕常亮
        splashSv.getHolder().setKeepScreenOn(true);
        splashSv.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {


                initMediaPlayer(url);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {


            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (mMediaPlayer != null) {
                    //mMediaPlayer.stop();
                    mMediaPlayer.release();
                }
                LogUtil.e("SplashActivity", "....surfaceDestroyed");
            }
        });
    }

    private void initMediaPlayer(String url) {

        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.reset();//初始化
            mMediaPlayer.setDisplay(splashSv.getHolder());
            // 设置播放的视频源
            //AssetFileDescriptor fd = this.getAssets().openFd("ad_test.mp4");
            mMediaPlayer.setDataSource(this, Uri.parse(url));
            //mMediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),fd.getLength());
            mMediaPlayer.prepareAsync();
            //设置MediaPlayer的准备监听
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.start();
                    timer.start();
                }
            });
            mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START){
                        //隐藏缩略图
                        splashIv.setVisibility(View.GONE);
                        //
                        splashTvCount.setVisibility(View.VISIBLE);
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onDestroy() {
        if (!hasFinish) {
            timer.cancel();
        }
        if (mMediaPlayer != null) {
            //mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        if (splashSv != null) {
            splashSv.destroyDrawingCache();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        //
    }
}
