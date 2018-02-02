package cn.bpzzr.change.util;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.bpzzr.change.R;


/**
 * 吐司工具类
 */

public class ToastUtil {
    private static final String TAG = "ToastUtil";
    private Toast mToast;
    private TextView mTextView;
    private TimeCount timeCount;
    /**
     * 要显示的信息
     */
    private String message;
    private Handler mHandler = new Handler();
    private boolean canceled = true;

    /**
     * 构造
     *
     * @param context    显示toast的上下文
     * @param layoutId   布局id
     * @param textViewId 要显示的文本的textView的id
     * @param message    要显示的信息
     */
    public ToastUtil(@NonNull Context context, @LayoutRes int layoutId, @IdRes int textViewId, String message) {
        this.message = message;
        //加载自定义布局
        View view = LayoutInflater.from(context).inflate(layoutId, null);
        if (view == null) {
            //加载到的布局为空，就不做处理
            return;
        }
        //自定义toast文本
        mTextView = view.findViewById(textViewId);
        if (mTextView == null) {
            //没有显示文字的控件,不处理
            return;
        }
        mTextView.setText(message);
        LogUtil.e(TAG, "Toast start...");
        if (mToast == null) {
            //吐司为空才创建
            mToast = new Toast(context);
            LogUtil.e(TAG, "Toast create...");
        }
        //设置toast居中显示
        mToast.setGravity(Gravity.CENTER, 0, 0);
        //设置默认时长
        mToast.setDuration(Toast.LENGTH_LONG);
        //设置自定义布局
        mToast.setView(view);
    }

    /**
     * 显示toast
     */
    public void show() {
        mToast.show();
        LogUtil.e(TAG, "Toast show...");
    }

    /**
     * 自定义时长、居中显示toast
     *
     * @param duration 时长
     */
    public void show(int duration) {
        timeCount = new TimeCount(duration, 1000);
        Log.i("ToastUtil", "Toast show...");
        if (canceled) {
            timeCount.start();
            canceled = false;
            showUntilCancel();
        }
    }

    /**
     * 隐藏toast
     */
    private void hide() {
        if (mToast != null) {
            mToast.cancel();
        }
        canceled = true;
        LogUtil.e(TAG, "Toast that customer duration hide...");
    }

    /**
     *
     */
    private void showUntilCancel() {
        if (canceled) { //如果已经取消显示，就直接return
            return;
        }
        mToast.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ToastUtil", "Toast showUntilCancel...");
                showUntilCancel();
            }
        }, Toast.LENGTH_LONG);
    }

    /**
     * 动态设置文本
     *
     * @param message 显示文本
     */
    public void setText(String message) {
        this.message = message;
        if (mTextView != null && !StringUtil.isSpaceStr(message)) {
            mTextView.setText(message);
        }
    }

    /**
     * 自定义计时器
     */
    private class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            //millisInFuture总计时长，countDownInterval时间间隔(一般为500ms),500ms能保证计时的准确性
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTextView.setText(message + ": " + millisUntilFinished / 1000 + "s后消失");
        }

        @Override
        public void onFinish() {
            hide();
        }
    }
}