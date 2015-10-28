package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class UserStat  extends BaseDO{
    private Integer userid;

    private String headimgurl;

    private Integer score;

    private Integer gold;

    private String versioncode;

    private String uid;

    private Date modifiedtime;

    private Byte isgift;

    private String mac;

    private String uuid;

    private Integer invitecount;

    private Integer invitehitcount;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(String versioncode) {
        this.versioncode = versioncode == null ? null : versioncode.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Byte getIsgift() {
        return isgift;
    }

    public void setIsgift(Byte isgift) {
        this.isgift = isgift;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getInvitecount() {
        return invitecount;
    }

    public void setInvitecount(Integer invitecount) {
        this.invitecount = invitecount;
    }

    public Integer getInvitehitcount() {
        return invitehitcount;
    }

    public void setInvitehitcount(Integer invitehitcount) {
        this.invitehitcount = invitehitcount;
    }
}