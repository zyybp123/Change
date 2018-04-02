package cn.bpzzr.change.bean;

import org.json.JSONObject;

import cn.bpzzr.change.interf.SomeKeys;
import cn.bpzzr.change.util.KaiShuDeviceUtil;
import cn.bpzzr.change.util.blankj.DeviceUtils;

/**
 * Created by Administrator on 2018/3/1.
 * 设备信息等相关数据实体类
 */

public class DeviceInfoBean {
    private String platform = KaiShuDeviceUtil.getPlatform();
    private String appversion = KaiShuDeviceUtil.getVersionNameWithV();
    private int sysversion = DeviceUtils.getSDKVersion();
    private String appid = KaiShuDeviceUtil.getAppId();
    private String channelid;
    private String phonemodel = KaiShuDeviceUtil.getDeviceModel();
    private String phonedevicecode;
    private String channelmsg = KaiShuDeviceUtil.getChannelMsg();
    private int osvsion = DeviceUtils.getSDKVersion();


    public String getDeviceIdParam (){
        JSONObject jsonObject = new JSONObject();
        return "";
    }


    /**
     * {"platform":"kaishu",
     *             "appversion":"V4.2.0",
     *             "sysversion":"23",
     *             "appid":"992099001",
     *             "channelid":"yingyongbao",
     *             "phonemodel":"Le X620",
     *             "phonedevicecode":"869552027513993",
     *             "channelmsg":"android"}
     */

    /**
     * {"deviceid":"",
     *             "channelmsg":"android",
     *             "platform":"kaishu"}
     */
    /**
     * {"appid":"",
     *             "channelmsg":"android",
     *             "platform":"kaishu"}
     */
    /**
     * {"data":"加密串"}
     *             加密串：
     *             {"channelid":"yinyongbao",
     *             "phonedevicecode":"869552027513993",
     *             "phonemodel":"Le X620",
     *             "sysversion":"23",
     *             "appversion":"V4.2.0",
     *             "appid":"992099001",
     *             "channelmsg":"android",
     *             "platform":"kaishu",
     *             }
     */
    /**
     * {"clienttype":"1",
     *             "appid":"",
     *             "appversion":"",
     *             "versioncode":"",
     *             "channelid":"",
     *             "osvsion":"android",
     *             }
     */
}
