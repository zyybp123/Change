package cn.bpzzr.change.util;

import org.jetbrains.annotations.Contract;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 * 处理一些集合相关操作的工具类
 */

public class ListUtil {
    private ListUtil() {

    }

    /**
     * 集合判空的方法
     *
     * @param list 传入的集合
     * @return 如果集合为null或集合内没有元素则返回true
     */
    @Contract("null -> true")
    public static boolean nullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
