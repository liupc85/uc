package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class UserInvitated extends BaseDO{
    private Integer id;

    private Integer userid;

    private Integer invitateduserid;

    private Integer useridgold;

    private Integer invitatedusergold;

    private Date time;

    private Integer isadd;

    private String type;

    private String outid;

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

    public Integer getInvitateduserid() {
        return invitateduserid;
    }

    public void setInvitateduserid(Integer invitateduserid) {
        this.invitateduserid = invitateduserid;
    }

    public Integer getUseridgold() {
        return useridgold;
    }

    public void setUseridgold(Integer useridgold) {
        this.useridgold = useridgold;
    }

    public Integer getInvitatedusergold() {
        return invitatedusergold;
    }

    public void setInvitatedusergold(Integer invitatedusergold) {
        this.invitatedusergold = invitatedusergold;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIsadd() {
        return isadd;
    }

    public void setIsadd(Integer isadd) {
        this.isadd = isadd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOutid() {
        return outid;
    }

    public void setOutid(String outid) {
        this.outid = outid == null ? null : outid.trim();
    }
}