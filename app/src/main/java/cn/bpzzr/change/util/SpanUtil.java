package cn.bpzzr.change.util;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/2/5.
 * 富文本的处理工具类
 */

public class SpanUtil {
    public void suoJin(TextView tv, String text) {
        SpannableStringBuilder span = new SpannableStringBuilder("缩进" + text);
        span.setSpan(new ForegroundColorSpan(Color.TRANSPARENT), 0, 2,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(span);
    }

    public void suoJin(TextView tv, String text, String tibu) {
        SpannableStringBuilder span = new SpannableStringBuilder(tibu + text);
        span.setSpan(new ForegroundColorSpan(Color.TRANSPARENT), 0, tibu.length(),
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(span);
    }
}
