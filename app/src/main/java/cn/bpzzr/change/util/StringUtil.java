package cn.bpzzr.change.util;

import android.text.TextUtils;

/**
 * Created by Administrator on 2018/1/12.
 * 处理字符串的工具类
 */

public class StringUtil {
    private StringUtil() {
    }

    /**
     * 获取一个不为null的字符串
     *
     * @param str 字符串
     * @return 如果为null就返回空串
     */
    public static String getNotNullStr(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /**
     * 判断一个字符串是否为空行
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串
     *
     * @param str 字符串
     * @return true 为空行，false 不为空行
     */
    public static boolean isSpaceStr(String str) {
        if (TextUtils.isEmpty(str)) {
            //为空直接返回true
            return true;
        }
        //不为空，替换掉所有空格、制表符、回车符、换行符为空串，再判断是否为空
        String replaceAll = str.replaceAll("(?m)^\\\\s*$(\\\\n|\\\\r\\\\n)", "");
        return TextUtils.isEmpty(replaceAll);
    }
}
