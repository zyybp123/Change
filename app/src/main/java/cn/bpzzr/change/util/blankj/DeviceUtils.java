package cn.bpzzr.change.util.blankj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;

import org.jetbrains.annotations.Contract;

import java.io.File;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import cn.bpzzr.change.global.Change;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/1
 *     desc  : 设备相关工具类
 * </pre>
 */
public final class DeviceUtils {
    /**
     * android.os.Build.BOARD：获取设备基板名称
     * android.os.Build.BOOTLOADER:获取设备引导程序版本号
     * android.os.Build.BRAND：获取设备品牌
     * android.os.Build.CPU_ABI：获取设备指令集名称（CPU的类型）
     * android.os.Build.CPU_ABI2：获取第二个指令集名称
     * android.os.Build.DEVICE：获取设备驱动名称
     * android.os.Build.DISPLAY：获取设备显示的版本包（在系统设置中显示为版本号）和ID一样
     * android.os.Build.FINGERPRINT：设备的唯一标识。由设备的多个信息拼接合成。
     * android.os.Build.HARDWARE：设备硬件名称,一般和基板名称一样（BOARD）
     * android.os.Build.HOST：设备主机地址
     * android.os.Build.ID:设备版本号。
     * android.os.Build.MODEL ：获取手机的型号 设备名称。
     * android.os.Build.MANUFACTURER:获取设备制造商
     * android:os.Build.PRODUCT：整个产品的名称
     * android:os.Build.RADIO：无线电固件版本号，通常是不可用的 显示unknown
     * android.os.Build.TAGS：设备标签。如release-keys 或测试的 test-keys
     * android.os.Build.TIME：时间
     * android.os.Build.TYPE:设备版本类型  主要为"user" 或"eng".
     * android.os.Build.USER:设备用户名 基本上都为android-build
     * android.os.Build.VERSION.RELEASE：获取系统版本字符串。如4.1.2 或2.2 或2.3等
     * android.os.Build.VERSION.CODENAME：设备当前的系统开发代号，一般使用REL代替
     * android.os.Build.VERSION.INCREMENTAL：系统源代码控制值，一个数字或者git hash值
     * android.os.Build.VERSION.SDK：系统的API级别 一般使用下面大的SDK_INT 来查看
     * android.os.Build.VERSION.SDK_INT：系统的API级别 数字表示
     */

    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 判断设备是否 root
     *
     * @return the boolean{@code true}: 是<br>{@code false}: 否
     */
    public static boolean isDeviceRooted() {
        String su = "su";
        String[] locations = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/",
                "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (String location : locations) {
            if (new File(location + su).exists()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取设备系统版本号
     *
     * @return 设备系统版本号
     */
    @Contract(pure = true)
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }


    /**
     * 获取设备 AndroidID
     *
     * @return AndroidID
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidID() {
        return Settings.Secure.getString(
                Change.mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID
        );
    }

    public static void getDeviceId() {
        /*TelephonyManager tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        tm.getDeviceId();*/
    }

    /**
     * 获取设备 MAC 地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />}</p>
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET" />}</p>
     *
     * @return MAC 地址
     */
    public static String getMacAddress() {
        String macAddress = getMacAddressByWifiInfo();
        if (!"02:00:00:00:00:00".equals(macAddress)) {
            return macAddress;
        }
        macAddress = getMacAddressByNetworkInterface();
        if (!"02:00:00:00:00:00".equals(macAddress)) {
            return macAddress;
        }
        macAddress = getMacAddressByFile();
        if (!"02:00:00:00:00:00".equals(macAddress)) {
            return macAddress;
        }
        return "please open wifi";
    }

    /**
     * 获取设备 MAC 地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />}</p>
     *
     * @return MAC 地址
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String getMacAddressByWifiInfo() {
        try {
            @SuppressLint("WifiManagerLeak")
            WifiManager wifi = (WifiManager) Change.mContext.getSystemService(Context.WIFI_SERVICE);
            if (wifi != null) {
                WifiInfo info = wifi.getConnectionInfo();
                if (info != null) return info.getMacAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    /**
     * 获取设备 MAC 地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET" />}</p>
     *
     * @return MAC 地址
     */
    @NonNull
    private static String getMacAddressByNetworkInterface() {
        try {
            List<NetworkInterface> nis = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface ni : nis) {
                if (!ni.getName().equalsIgnoreCase("wlan0")) continue;
                byte[] macBytes = ni.getHardwareAddress();
                if (macBytes != null && macBytes.length > 0) {
                    StringBuilder res1 = new StringBuilder();
                    for (byte b : macBytes) {
                        res1.append(String.format("%02x:", b));
                    }
                    return res1.deleteCharAt(res1.length() - 1).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    /**
     * 获取设备 MAC 地址
     *
     * @return MAC 地址
     */
    private static String getMacAddressByFile() {
        ShellUtils.CommandResult result = ShellUtils.execCmd("getprop wifi.interface", false);
        if (result.result == 0) {
            String name = result.successMsg;
            if (name != null) {
                result = ShellUtils.execCmd("cat /sys/class/net/" + name + "/address", false);
                if (result.result == 0) {
                    if (result.successMsg != null) {
                        return result.successMsg;
                    }
                }
            }
        }
        return "02:00:00:00:00:00";
    }

    /**
     * 获取设备厂商
     * <p>如 Xiaomi</p>
     *
     * @return 设备厂商
     */

    @Contract(pure = true)
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取设备型号
     * <p>如 MI2SC</p>
     *
     * @return 设备型号
     */
    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }

    /**
     * 关机
     * <p>需要 root 权限或者系统权限 {@code <android:sharedUserId="android.uid.system" />}</p>
     */
    public static void shutdown() {
        ShellUtils.execCmd("reboot -p", true);
        Intent intent = new Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN");
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        Change.mContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * 重启
     * <p>需要 root 权限或者系统权限 {@code <android:sharedUserId="android.uid.system" />}</p>
     */
    public static void reboot() {
        ShellUtils.execCmd("reboot", true);
        Intent intent = new Intent(Intent.ACTION_REBOOT);
        intent.putExtra("nowait", 1);
        intent.putExtra("interval", 1);
        intent.putExtra("window", 0);
        Change.mContext.sendBroadcast(intent);
    }

    /**
     * 重启
     * <p>需系统权限 {@code <android:sharedUserId="android.uid.system" />}</p>
     *
     * @param reason 传递给内核来请求特殊的引导模式，如"recovery"
     */
    public static void reboot(final String reason) {
        PowerManager mPowerManager =
                (PowerManager) Change.mContext.getSystemService(Context.POWER_SERVICE);
        try {
            if (mPowerManager == null) return;
            mPowerManager.reboot(reason);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 重启到 recovery
     * <p>需要 root 权限</p>
     */
    public static void reboot2Recovery() {
        ShellUtils.execCmd("reboot recovery", true);
    }

    /**
     * 重启到 bootloader
     * <p>需要 root 权限</p>
     */
    public static void reboot2Bootloader() {
        ShellUtils.execCmd("reboot bootloader", true);
    }
}
