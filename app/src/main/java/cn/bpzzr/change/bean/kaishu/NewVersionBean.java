package cn.bpzzr.change.bean.kaishu;

/**
 * Created by Administrator on 2018/3/1.
 * 新版本相关信息数据实体类
 */

public class NewVersionBean {

    /**
     * apptype : 1
     * appname : 凯叔讲故事
     * version : 4.2.0
     * versioncode : 420
     * downloadurl : https://cdn.kaishuhezi.com/kstory/app/kaishustory-Release-2018-02-06T14-ks.apk
     * isforce : 2
     * appsize : 57294556
     * prompt : 下载功能又升级啦(•̀ω•́)✧
     * 现在可多选内容批量下载哦～
     * 快更新App试试吧！
     * upgradedescription : 下载功能又升级啦(•̀ω•́)✧
     * 现在可多选内容批量下载哦～
     * 快更新App试试吧！
     * issuetime : 1517967996000
     */

    private String apptype;
    private String appname;
    private String version;
    private String versioncode;
    private String downloadurl;
    /**
     * 是否是强制更新
     */
    private String isforce;
    private String appsize;
    /**
     * 提示内容
     */
    private String prompt;
    /**
     * 升级描述
     */
    private String upgradedescription;
    /**
     * 发布时间
     */
    private long issuetime;

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(String versioncode) {
        this.versioncode = versioncode;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getIsforce() {
        return isforce;
    }

    public void setIsforce(String isforce) {
        this.isforce = isforce;
    }

    public String getAppsize() {
        return appsize;
    }

    public void setAppsize(String appsize) {
        this.appsize = appsize;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getUpgradedescription() {
        return upgradedescription;
    }

    public void setUpgradedescription(String upgradedescription) {
        this.upgradedescription = upgradedescription;
    }

    public long getIssuetime() {
        return issuetime;
    }

    public void setIssuetime(long issuetime) {
        this.issuetime = issuetime;
    }
}
