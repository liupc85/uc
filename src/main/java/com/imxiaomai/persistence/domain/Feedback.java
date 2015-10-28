package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class Feedback extends BaseDO{
    private Integer id;

    private Integer userid;

    private String userinfo;

    private String username;

    private String telphone;

    private String date;

    private String feedtext;

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

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo == null ? null : userinfo.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getFeedtext() {
        return feedtext;
    }

    public void setFeedtext(String feedtext) {
        this.feedtext = feedtext == null ? null : feedtext.trim();
    }
}