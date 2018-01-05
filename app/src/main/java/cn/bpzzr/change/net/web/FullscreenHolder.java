package cn.bpzzr.change.net.web;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import cn.bpzzr.change.R;


/**
 *
 */

public class FullscreenHolder extends FrameLayout {

    public FullscreenHolder(Context ctx) {
        super(ctx);
        setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
