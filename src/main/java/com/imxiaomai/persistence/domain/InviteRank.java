package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class InviteRank extends BaseDO{
    private Integer id;

    private Integer userid;

    private Integer gold;

    private String headimgurl;

    private Integer invitecount;

    private Integer index;

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

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public Integer getInvitecount() {
        return invitecount;
    }

    public void setInvitecount(Integer invitecount) {
        this.invitecount = invitecount;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}