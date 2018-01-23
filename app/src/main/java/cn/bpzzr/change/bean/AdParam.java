package cn.bpzzr.change.bean;

/**
 * Created by Administrator on 2018/1/23.
 * 要获取广告需要提交的参数
 */

public class AdParam {

    /**
     * version : 9.1.0
     * is_test : false
     * urs :
     * store :
     * ext_param : {}
     * device : {"os":"android","imei":"869552027513993","device_id":"CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg%3D","mac":"02:00:00:00:00:00","galaxy_tag":"CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg%3D","udid":"74f79d481fd1ee6e77e779c7aa6e8048dc435ac2","network_status":"wifi","dq":"1920:1080","isp":"","dt":"Le X620","mcc":"460","longitude":"116.234368","latitude":"40.068366","location_type":1,"city_code":"110108"}
     * adunit : {"category":"STARTUP","location":"1","app":"7A16FBB6","app_version":"32.1","province":"%E5%8C%97%E4%BA%AC","city":"%E5%8C%97%E4%BA%AC","blacklist":""}
     */

    private String version = "9.1.0";
    private boolean is_test = false;
    private String urs = "";
    private String store = "";
    private ExtParamBean ext_param = new ExtParamBean();
    private DeviceBean device = new DeviceBean();
    private AdunitBean adunit = new AdunitBean();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isIs_test() {
        return is_test;
    }

    public void setIs_test(boolean is_test) {
        this.is_test = is_test;
    }

    public String getUrs() {
        return urs;
    }

    public void setUrs(String urs) {
        this.urs = urs;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public ExtParamBean getExt_param() {
        return ext_param;
    }

    public void setExt_param(ExtParamBean ext_param) {
        this.ext_param = ext_param;
    }

    public DeviceBean getDevice() {
        return device;
    }

    public void setDevice(DeviceBean device) {
        this.device = device;
    }

    public AdunitBean getAdunit() {
        return adunit;
    }

    public void setAdunit(AdunitBean adunit) {
        this.adunit = adunit;
    }

    public static class ExtParamBean {
    }

    public static class DeviceBean {
        /**
         * os : android
         * imei : 869552027513993
         * device_id : CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg%3D
         * mac : 02:00:00:00:00:00
         * galaxy_tag : CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg%3D
         * udid : 74f79d481fd1ee6e77e779c7aa6e8048dc435ac2
         * network_status : wifi
         * dq : 1920:1080
         * isp :
         * dt : Le X620
         * mcc : 460
         * longitude : 116.234368
         * latitude : 40.068366
         * location_type : 1
         * city_code : 110108
         */

        private String os = "android";
        private String imei = "869552027513993";
        private String device_id = "CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg";
        private String mac = "02:00:00:00:00:00";
        private String galaxy_tag = "CQk3MjdiOTMzMGU1MGNjN2Y4CUxFNjdBMDYxNTAyMTgyMjg";
        private String udid = "74f79d481fd1ee6e77e779c7aa6e8048dc435ac2";
        private String network_status = "wifi";
        private String dq = "1920:1080";
        private String isp = "";
        private String dt = "Le X620";
        private String mcc = "460";
        private String longitude = "116.234368";
        private String latitude = "40.068366";
        private int location_type = 1;
        private String city_code = "110108";

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getGalaxy_tag() {
            return galaxy_tag;
        }

        public void setGalaxy_tag(String galaxy_tag) {
            this.galaxy_tag = galaxy_tag;
        }

        public String getUdid() {
            return udid;
        }

        public void setUdid(String udid) {
            this.udid = udid;
        }

        public String getNetwork_status() {
            return network_status;
        }

        public void setNetwork_status(String network_status) {
            this.network_status = network_status;
        }

        public String getDq() {
            return dq;
        }

        public void setDq(String dq) {
            this.dq = dq;
        }

        public String getIsp() {
            return isp;
        }

        public void setIsp(String isp) {
            this.isp = isp;
        }

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }

        public String getMcc() {
            return mcc;
        }

        public void setMcc(String mcc) {
            this.mcc = mcc;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public int getLocation_type() {
            return location_type;
        }

        public void setLocation_type(int location_type) {
            this.location_type = location_type;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }
    }

    public static class AdunitBean {
        /**
         * category : STARTUP
         * location : 1
         * app : 7A16FBB6
         * app_version : 32.1
         * province : %E5%8C%97%E4%BA%AC
         * city : %E5%8C%97%E4%BA%AC
         * blacklist :
         */

        private String category = "STARTUP";
        private String location = "1";
        private String app = "7A16FBB6";
        private String app_version = "32.1";
        private String province = "北京";
        private String city = "北京";
        private String blacklist = "";

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getApp_version() {
            return app_version;
        }

        public void setApp_version(String app_version) {
            this.app_version = app_version;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getBlacklist() {
            return blacklist;
        }

        public void setBlacklist(String blacklist) {
            this.blacklist = blacklist;
        }
    }
}
