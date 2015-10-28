package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class Scorelist extends BaseDO {
    private Integer id;

    private Integer userid;

    private Integer score;

    private Integer type;

    private String tips;

    private Date time;

    private Integer identify;

    private Integer outid;

    
	public static final int GOLD_TYPE = 2;

	public static final int SCORE_TYPE = 1;

	public static final int SHOP_IDENTIFY = 1;

	public static final int QUJIAN_IDENTIFY = 2;

	public static final int JIJIAN_IDENTIFY = 3;

	public static final int ACTIVITY_IDENTIFY = 4;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIdentify() {
        return identify;
    }

    public void setIdentify(Integer identify) {
        this.identify = identify;
    }

    public Integer getOutid() {
        return outid;
    }

    public void setOutid(Integer outid) {
        this.outid = outid;
    }
}