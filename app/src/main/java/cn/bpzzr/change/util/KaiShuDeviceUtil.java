package cn.bpzzr.change.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import org.jetbrains.annotations.Contract;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.net.RetrofitTools;
import retrofit2.Retrofit;

import static cn.bpzzr.change.global.Change.mContext;
import static cn.bpzzr.change.net.RetrofitTools.APP_DEVELOP;
import static cn.bpzzr.change.net.RetrofitTools.APP_GAME;
import static cn.bpzzr.change.net.RetrofitTools.APP_NORMAL;
import static cn.bpzzr.change.net.RetrofitTools.APP_TEST;
import static cn.bpzzr.change.net.RetrofitTools.appEnvironment;

/**
 * Created by Administrator on 2018/2/28.
 * 获取系统等相关信息的工具类
 */

public class KaiShuDeviceUtil {
    private static final String TAG = "KaiShuDeviceUtil";
    public static final String APP_ID_KAI_TEST = "123456";
    public static final String APP_ID_KAI_NORMAL = "992099001";
    public static final String APP_SECRET_KAI_TEST = "aabbcc";
    public static final String APP_SECRET_KAI_NORMAL = "ODZDNjUzNkFGMzVFRUQ0ODIxNEJDQ0YzM0MzMzE0MEQ=";
    public static final String KAI_SHU = "kaishu";
    public static final String KAI_SHU_VERSION_NAME = "4.2.0";
    public static final int KAI_SHU_VERSION_CODE = 420;


    private KaiShuDeviceUtil() {
    }

    /**
     * 获取应用id
     *
     * @return 返回应用id，开发，测试环境或其他则返回123456
     */
    @NonNull
    @Contract(pure = true)
    public static String getAppId() {
        switch (appEnvironment) {
            case APP_TEST:
            case APP_DEVELOP:
                return APP_ID_KAI_TEST;
            case APP_GAME:
            case APP_NORMAL:
                return APP_ID_KAI_NORMAL;
            default:
                return APP_ID_KAI_TEST;
        }
    }

    /**
     * 获取应用密钥
     *
     * @return 返回应用密钥，开发，测试，环境或其他返回aabbcc
     */
    @NonNull
    @Contract(pure = true)
    public static String getAppsecret() {
        switch (appEnvironment) {
            case APP_TEST:
            case APP_DEVELOP:
                return APP_SECRET_KAI_TEST;
            case APP_GAME:
            case APP_NORMAL:
                return APP_SECRET_KAI_NORMAL;
            default:
                return APP_SECRET_KAI_TEST;
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用版本号
     */
    @Contract(pure = true)
    public static int getVersionCode() {
        return KAI_SHU_VERSION_CODE;
    }

    /**
     * 获取版本名称
     *
     * @return 当前应用版本名称
     */
    @Contract(pure = true)
    public static String getVersionName() {
        return KAI_SHU_VERSION_NAME;
    }

    /**
     * 获取带V的版本名称
     *
     * @return 当前应用版本名称
     */
    @Contract(pure = true)
    @NonNull
    public static String getVersionNameWithV() {
        return "V" + getVersionName();
    }

    /**
     * 返回包名
     *
     * @return kaishu
     */
    @Contract(pure = true)
    public static String getPlatform() {
        return KAI_SHU;
    }

    /**
     * 获取通道信息
     *
     * @return 返回android
     */
    @NonNull
    @Contract(pure = true)
    public static String getChannelMsg() {
        return SomeKeys.ANDROID;
    }

    /**
     * 获取手机的型号 设备名称。
     *
     * @return 返回设备名称
     */
    @Contract(pure = true)
    public static String getDeviceModel() {
        return Build.MODEL;
    }

    /**
     * 获取ip地址
     *
     * @return 可能返回空
     */
    @Nullable
    public static String getIpAddress() {
        try {
            while (true) {
                Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
                while (true)
                    if (localEnumeration1.hasMoreElements()) {
                        Enumeration localEnumeration2 = ((NetworkInterface) localEnumeration1.nextElement()).getInetAddresses();
                        if (!localEnumeration2.hasMoreElements())
                            continue;
                        InetAddress localInetAddress = (InetAddress) localEnumeration2.nextElement();
                        if (localInetAddress.isLoopbackAddress())
                            break;
                        String str = localInetAddress.getHostAddress();
                        boolean bool = str.contains("::");
                        if (bool)
                            break;
                        return str;
                    }
            }
        } catch (SocketException localSocketException) {
            LogUtil.e(TAG, "ex ---> " + localSocketException.getMessage());
            localSocketException.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static String getDeviceSN() {
        try {
            Class localClass = Class.forName("android.os.SystemProperties");
            String str = (String) localClass.getMethod("get", new Class[]{String.class, String.class}).invoke(localClass, new Object[]{"ro.serialno", "unknown"});
            return str;
        } catch (Exception localException) {
        }
        return null;
    }

    public static String getSimIccId(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            //大于等于Android 5.1.0 L版本
            SubscriptionManager sub = (SubscriptionManager) context
                    .getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
            if (sub == null) {
                LogUtil.e(TAG, "SubscriptionManager is null !");
                return "";
            }
            List<SubscriptionInfo> info = sub.getActiveSubscriptionInfoList();
            if (info == null) {
                LogUtil.e(TAG, "infoList is null !");
                return "";
            }
            int count = sub.getActiveSubscriptionInfoCount();
            if (count > 0) {
                if (count > 1) {
                    //数量大于一，为双卡
                    String icc1 = info.get(0).getIccId();
                    String icc2 = info.get(1).getIccId();
                    return icc1 + "," + icc2;
                } else {
                    //数量等于一，为单卡
                    return info.get(0).getIccId();
                }
            } else {
                Log.d(TAG, " ----> 无SIM卡");
                return "";
            }
        } else {
            //小于5.1.0 以下的版本，需要权限
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return"";// tm.getSimSerialNumber();
        }
    }

    /*public static String getDeviceIdSameImei(Context paramContext) {
        String str1;
        if (paramContext == null)
            str1 = "";
        do {
            return str1;
            str1 = getUMId(paramContext);
        }
        while (!TextUtils.isEmpty(str1));
        TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
        if (localTelephonyManager == null)
            Log.w("kaishu", "No IMEI.");
        String str2 = "";
        try {
            if (checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
                str2 = localTelephonyManager.getDeviceId();
                putUMId(paramContext, str2);
            }
            if (TextUtils.isEmpty(str2)) {
                Log.w("kaishu", "No IMEI.");
                str3 = getMac(paramContext);
                if (!TextUtils.isEmpty(str3))
                    break label212;
                Log.w("kaishu", "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                str4 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
                Log.w("kaishu", "getDeviceId: Secure.ANDROID_ID: " + str4);
                if (TextUtils.isEmpty(str4))
                    str2 = "adrdsnmac:" + getDeviceSN() + getMacByJava();
            } else {
                return str2;
            }
        } catch (Exception localException) {
            while (true) {
                String str3;
                String str4;
                Log.w("kaishu", "No IMEI.", localException);
                continue;
                str2 = "adrdid:" + str4;
                continue;
                label212:
                str2 = "adrdmac:" + str3;
            }
        }
    }*/




/*    public static String getMac(Context paramContext) {
        String str = "";
        try {
            str = getMacShell();
            if (TextUtils.isEmpty(str))
                Log.w("kaishu", "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            if (TextUtils.isEmpty(str)) {
                str = getMacByJava();
                if (TextUtils.isEmpty(str))
                    Log.w("kaishu", "Could not get mac address by java");
            }
            if (TextUtils.isEmpty(str))
                str = SocializeSpUtils.getMac(paramContext);
            else
                SocializeSpUtils.putMac(paramContext, str);
        } catch (Exception localException) {
            Log.w("kaishu", "Could not get mac address." + localException.toString());
            return str;
        }
        return str;
    }*/

/*    private static String getMacByJava() {
        try {
            Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
            Object localObject;
            while (true) {
                boolean bool = localEnumeration.hasMoreElements();
                localObject = null;
                if (!bool)
                    break;
                NetworkInterface localNetworkInterface = (NetworkInterface) localEnumeration.nextElement();
                if (!"wlan0".equals(localNetworkInterface.getName()))
                    continue;
                byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
                localObject = null;
                if (arrayOfByte == null)
                    break;
                int i = arrayOfByte.length;
                localObject = null;
                if (i == 0)
                    break;
                StringBuilder localStringBuilder = new StringBuilder();
                int j = arrayOfByte.length;
                for (int k = 0; k < j; k++) {
                    byte b = arrayOfByte[k];
                    Object[] arrayOfObject = new Object[1];
                    arrayOfObject[0] = Byte.valueOf(b);
                    localStringBuilder.append(String.format("%02X:", arrayOfObject));
                }
                if (localStringBuilder.length() > 0)
                    localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
                String str = localStringBuilder.toString();
                localObject = str;
            }
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }*/

    /*private static String getMacShell() {
        String[] arrayOfString = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
        int i = 0;
        while (i < arrayOfString.length)
            try {
                String str = reaMac(arrayOfString[i]);
                if (str != null)
                    return str;
            } catch (Exception localException) {
                Log.e("kaishu", "open file  Failed", localException);
                i++;
            }
        return null;
    }*/


    public static String getUMId(Context paramContext) {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("uidspfile", 0);
        String str = null;
        if (localSharedPreferences != null)
            str = localSharedPreferences.getString("uid260v", (String) null);
        return str;
    }


    @Contract(pure = true)
    public static String getVersionRelease() {
        return Build.VERSION.RELEASE;
    }

    @NonNull
    @Contract(pure = true)
    public static String getVersionSDK() {
        return Build.VERSION.SDK_INT + "";
    }

    /**
     * 检测是否安装了qq客户端
     *
     * @return 未安装则返回false
     */
    public static boolean isQQClientAvailable() {
        List localList = mContext.getPackageManager().getInstalledPackages(0);
        if (localList != null)
            for (int i = 0; i < localList.size(); i++)
                if ("com.tencent.mobileqq".equals(((PackageInfo) localList.get(i)).packageName))
                    return true;
        return false;
    }

    public static boolean isSinaClientAvailable() {
        List localList = mContext.getPackageManager().getInstalledPackages(0);
        if (localList != null)
            for (int i = 0; i < localList.size(); i++)
                if ("com.sina.weibo".equals(((PackageInfo) localList.get(i)).packageName))
                    return true;
        return false;
    }

    public static boolean isWeixinAvilible() {
        List localList = mContext.getPackageManager().getInstalledPackages(0);
        if (localList != null)
            for (int i = 0; i < localList.size(); i++)
                if ("com.tencent.mm".equals(((PackageInfo) localList.get(i)).packageName))
                    return true;
        return false;
    }

    public static boolean putUMId(Context paramContext, String paramString) {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("uidspfile", 0);
        if (localSharedPreferences == null)
            return false;
        if (TextUtils.isEmpty(paramString))
            paramString = "";
        return localSharedPreferences.edit().putString("uid260v", paramString).commit();
    }


    // ERROR //
    /*private static String reaMac(String paramString)
            throws java.io.FileNotFoundException {

    }*/
}
