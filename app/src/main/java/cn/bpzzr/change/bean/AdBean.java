package cn.bpzzr.change.bean;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/1/23.
 * 网易新闻的splash广告
 */

public class AdBean {

    /**
     * ads : [{"adid":"yt_122_115397","category":"STARTUP","constraint":[],"content":"网易传媒","expire":1520438399000,"ext_param":{"ext_info":"province=%E5%8C%97%E4%BA%AC;city=%E5%8C%97%E4%BA%AC;category=STARTUP;app=7A16FBB6","flight_id":122,"id":"115397","refresh_time":1516675503438},"from":5,"is_backup":2,"is_sense":0,"live_status":"","live_user":-1,"location":"1","monitor":[{"action":0,"type":"yitou","url":"https://g1.163.com/madfeedbackd"},{"action":1,"type":"yitou","url":"https://g1.163.com/madfeedbackd"},{"action":7,"type":"yitou","url":"https://g1.163.com/madfeedbackd"},{"action":0,"type":"yp","url":"https://nex.163.com/ssp/show?deviceType=2&category=STARTUP&style=2&industry=-&source=7A16FBB6&ctime=1516675503444&galaxyTag=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&t=K2DTt%2B8WSq8yiQNWQm5OjaKaWOHj%2BaeUVqDKAMNI8CuUpIx1vGkhnW2lb2Tk%2BIUFqdmwwN4H9BDFH7Linmqweg%3D%3D&u=ODY5NTUyMDI3NTEzOTkz&client_type=0&dsp_tag=100002&crid=122_115397&title=-&province=-&v=1&cuuid=951a0ad497d34e3db8b4f4b5dc76f080&app_version=MzIuMQ%3D%3D&logversion=3&location=1&dt=TGUgWDYyMA%3D%3D&subIndustry=-&nexSaleType=0&city=MTEwMTA4&dspid=100002&news_req_style=-&device_id=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&advertiserId=LQ%3D%3D&adPlanId=-&service=8&uuid=da66f0f37a8e4d42a36c58dee9df7ee7&rpid=20839&os=1&timeStamp=1516675503444&contractNumber=-&net_work=wifi"},{"action":1,"type":"yp","url":"https://nex.163.com/ssp/click?deviceType=2&category=STARTUP&style=2&industry=-&source=7A16FBB6&ctime=1516675503444&galaxyTag=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&t=K2DTt%2B8WSq8yiQNWQm5OjaKaWOHj%2BaeUVqDKAMNI8CuUpIx1vGkhnW2lb2Tk%2BIUFqdmwwN4H9BDFH7Linmqweg%3D%3D&u=ODY5NTUyMDI3NTEzOTkz&client_type=0&dsp_tag=100002&crid=122_115397&title=-&province=-&v=1&cuuid=951a0ad497d34e3db8b4f4b5dc76f080&app_version=MzIuMQ%3D%3D&logversion=3&location=1&dt=TGUgWDYyMA%3D%3D&subIndustry=-&nexSaleType=0&city=MTEwMTA4&dspid=100002&news_req_style=-&device_id=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&advertiserId=LQ%3D%3D&adPlanId=-&service=8&uuid=da66f0f37a8e4d42a36c58dee9df7ee7&rpid=20839&os=1&timeStamp=1516675503444&contractNumber=-&net_work=wifi"}],"norm_style":10,"position":6,"relatedActionLinks":[{"type":"landing_page","url":"https://hongcai.163.com/html/promotion.html?from=khdkpdt_lotterynews"}],"requestTime":1516675503444,"resources":[{"type":0,"urls":["https://yt-adp.nosdn.127.net/channel14/10801475_afkt_20180108.png"]}],"sdkad_id":"","st":2500,"style":2,"sub_title":"广告","title":"","usr_protect_time":0,"visibility":[{"rate_height":"1","type":"0"}]}]
     * result : 1
     */

    private int result;
    private List<AdsBean> ads;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public static class AdsBean {
        /**
         * adid : yt_122_115397
         * category : STARTUP
         * constraint : []
         * content : 网易传媒
         * expire : 1520438399000
         * ext_param : {"ext_info":"province=%E5%8C%97%E4%BA%AC;city=%E5%8C%97%E4%BA%AC;category=STARTUP;app=7A16FBB6","flight_id":122,"id":"115397","refresh_time":1516675503438}
         * from : 5
         * is_backup : 2
         * is_sense : 0
         * live_status :
         * live_user : -1
         * location : 1
         * monitor : [{"action":0,"type":"yitou","url":"https://g1.163.com/madfeedbackd"},{"action":1,"type":"yitou","url":"https://g1.163.com/madfeedbackd"},{"action":7,"type":"yitou","url":"https://g1.163.com/madfeedbackd"},{"action":0,"type":"yp","url":"https://nex.163.com/ssp/show?deviceType=2&category=STARTUP&style=2&industry=-&source=7A16FBB6&ctime=1516675503444&galaxyTag=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&t=K2DTt%2B8WSq8yiQNWQm5OjaKaWOHj%2BaeUVqDKAMNI8CuUpIx1vGkhnW2lb2Tk%2BIUFqdmwwN4H9BDFH7Linmqweg%3D%3D&u=ODY5NTUyMDI3NTEzOTkz&client_type=0&dsp_tag=100002&crid=122_115397&title=-&province=-&v=1&cuuid=951a0ad497d34e3db8b4f4b5dc76f080&app_version=MzIuMQ%3D%3D&logversion=3&location=1&dt=TGUgWDYyMA%3D%3D&subIndustry=-&nexSaleType=0&city=MTEwMTA4&dspid=100002&news_req_style=-&device_id=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&advertiserId=LQ%3D%3D&adPlanId=-&service=8&uuid=da66f0f37a8e4d42a36c58dee9df7ee7&rpid=20839&os=1&timeStamp=1516675503444&contractNumber=-&net_work=wifi"},{"action":1,"type":"yp","url":"https://nex.163.com/ssp/click?deviceType=2&category=STARTUP&style=2&industry=-&source=7A16FBB6&ctime=1516675503444&galaxyTag=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&t=K2DTt%2B8WSq8yiQNWQm5OjaKaWOHj%2BaeUVqDKAMNI8CuUpIx1vGkhnW2lb2Tk%2BIUFqdmwwN4H9BDFH7Linmqweg%3D%3D&u=ODY5NTUyMDI3NTEzOTkz&client_type=0&dsp_tag=100002&crid=122_115397&title=-&province=-&v=1&cuuid=951a0ad497d34e3db8b4f4b5dc76f080&app_version=MzIuMQ%3D%3D&logversion=3&location=1&dt=TGUgWDYyMA%3D%3D&subIndustry=-&nexSaleType=0&city=MTEwMTA4&dspid=100002&news_req_style=-&device_id=Q1FrM01qZGlPVE16TUdVMU1HTmpOMlk0Q1V4Rk5qZEJNRFl4TlRBeU1UZ3lNamclM0Q%3D&advertiserId=LQ%3D%3D&adPlanId=-&service=8&uuid=da66f0f37a8e4d42a36c58dee9df7ee7&rpid=20839&os=1&timeStamp=1516675503444&contractNumber=-&net_work=wifi"}]
         * norm_style : 10
         * position : 6
         * relatedActionLinks : [{"type":"landing_page","url":"https://hongcai.163.com/html/promotion.html?from=khdkpdt_lotterynews"}]
         * requestTime : 1516675503444
         * resources : [{"type":0,"urls":["https://yt-adp.nosdn.127.net/channel14/10801475_afkt_20180108.png"]}]
         * sdkad_id :
         * st : 2500
         * style : 2
         * sub_title : 广告
         * title :
         * usr_protect_time : 0
         * visibility : [{"rate_height":"1","type":"0"}]
         */

        private String adid;
        private String category;
        private String content;
        private long expire;
        private ExtParamBean ext_param;
        private int from;
        private int is_backup;
        private int is_sense;
        private String live_status;
        private int live_user;
        private String location;
        private int norm_style;
        private int position;
        private long requestTime;
        private String sdkad_id;
        private int st;
        private int style;
        private String sub_title;
        private String title;
        private int usr_protect_time;
        private List<?> constraint;
        private List<MonitorBean> monitor;
        private List<RelatedActionLinksBean> relatedActionLinks;
        private List<ResourcesBean> resources;
        private List<VisibilityBean> visibility;

        public String getAdid() {
            return adid;
        }

        public void setAdid(String adid) {
            this.adid = adid;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public ExtParamBean getExt_param() {
            return ext_param;
        }

        public void setExt_param(ExtParamBean ext_param) {
            this.ext_param = ext_param;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getIs_backup() {
            return is_backup;
        }

        public void setIs_backup(int is_backup) {
            this.is_backup = is_backup;
        }

        public int getIs_sense() {
            return is_sense;
        }

        public void setIs_sense(int is_sense) {
            this.is_sense = is_sense;
        }

        public String getLive_status() {
            return live_status;
        }

        public void setLive_status(String live_status) {
            this.live_status = live_status;
        }

        public int getLive_user() {
            return live_user;
        }

        public void setLive_user(int live_user) {
            this.live_user = live_user;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getNorm_style() {
            return norm_style;
        }

        public void setNorm_style(int norm_style) {
            this.norm_style = norm_style;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public long getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(long requestTime) {
            this.requestTime = requestTime;
        }

        public String getSdkad_id() {
            return sdkad_id;
        }

        public void setSdkad_id(String sdkad_id) {
            this.sdkad_id = sdkad_id;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUsr_protect_time() {
            return usr_protect_time;
        }

        public void setUsr_protect_time(int usr_protect_time) {
            this.usr_protect_time = usr_protect_time;
        }

        public List<?> getConstraint() {
            return constraint;
        }

        public void setConstraint(List<?> constraint) {
            this.constraint = constraint;
        }

        public List<MonitorBean> getMonitor() {
            return monitor;
        }

        public void setMonitor(List<MonitorBean> monitor) {
            this.monitor = monitor;
        }

        public List<RelatedActionLinksBean> getRelatedActionLinks() {
            return relatedActionLinks;
        }

        public void setRelatedActionLinks(List<RelatedActionLinksBean> relatedActionLinks) {
            this.relatedActionLinks = relatedActionLinks;
        }

        public List<ResourcesBean> getResources() {
            return resources;
        }

        public void setResources(List<ResourcesBean> resources) {
            this.resources = resources;
        }

        public List<VisibilityBean> getVisibility() {
            return visibility;
        }

        public void setVisibility(List<VisibilityBean> visibility) {
            this.visibility = visibility;
        }

        public static class ExtParamBean {
            /**
             * ext_info : province=%E5%8C%97%E4%BA%AC;city=%E5%8C%97%E4%BA%AC;category=STARTUP;app=7A16FBB6
             * flight_id : 122
             * id : 115397
             * refresh_time : 1516675503438
             */

            private String ext_info;
            private int flight_id;
            private String id;
            private long refresh_time;

            public String getExt_info() {
                return ext_info;
            }

            public void setExt_info(String ext_info) {
                this.ext_info = ext_info;
            }

            public int getFlight_id() {
                return flight_id;
            }

            public void setFlight_id(int flight_id) {
                this.flight_id = flight_id;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public long getRefresh_time() {
                return refresh_time;
            }

            public void setRefresh_time(long refresh_time) {
                this.refresh_time = refresh_time;
            }
        }

        public static class MonitorBean {
            /**
             * action : 0
             * type : yitou
             * url : https://g1.163.com/madfeedbackd
             */

            private int action;
            private String type;
            private String url;

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class RelatedActionLinksBean {
            /**
             * type : landing_page
             * url : https://hongcai.163.com/html/promotion.html?from=khdkpdt_lotterynews
             */

            private String type;
            private String url;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ResourcesBean {
            /**
             * type : 0
             * urls : ["https://yt-adp.nosdn.127.net/channel14/10801475_afkt_20180108.png"]
             */

            private int type;
            private List<String> urls;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public List<String> getUrls() {
                return urls;
            }

            public void setUrls(List<String> urls) {
                this.urls = urls;
            }
        }

        public static class VisibilityBean {
            /**
             * rate_height : 1
             * type : 0
             */

            private String rate_height;
            private String type;

            public String getRate_height() {
                return rate_height;
            }

            public void setRate_height(String rate_height) {
                this.rate_height = rate_height;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
