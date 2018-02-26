package cn.bpzzr.change.bean;

import cn.bpzzr.change.util.StringUtil;

/**
 * Created by Administrator on 2018/2/26.
 * 筛选条件，推荐、最新
 */

public class RecommendCondition {
    private String recommendId;
    private String recommendName;

    public RecommendCondition(String recommendId, String recommendName) {
        this.recommendId = recommendId;
        this.recommendName = recommendName;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName;
    }

    @Override
    public String toString() {
        return StringUtil.getNotNullStr(recommendName);
    }
}
