package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class CourierDevice extends BaseDO{
    private Integer id;

    private Integer userid;

    private String mobilephone;

    private String deviceid;

    private String channelid;

    private String source;

    private String platform;

    private String version;

    private String srcchannel;

    private String lastupdatechannel;

    private Date createtime;

    private Date updatetime;

    private String baiduuserid;
    
    public CourierDevice(){}
    

    public CourierDevice( Integer userid, String mobilephone,
			String deviceid, String channelid, String source, String platform,
			String version, String srcchannel, String lastupdatechannel,
			Date createtime, Date updatetime, String baiduuserid) {
		super();
		this.userid = userid;
		this.mobilephone = mobilephone;
		this.deviceid = deviceid;
		this.channelid = channelid;
		this.source = source;
		this.platform = platform;
		this.version = version;
		this.srcchannel = srcchannel;
		this.lastupdatechannel = lastupdatechannel;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.baiduuserid = baiduuserid;
	}



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

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getSrcchannel() {
        return srcchannel;
    }

    public void setSrcchannel(String srcchannel) {
        this.srcchannel = srcchannel == null ? null : srcchannel.trim();
    }

    public String getLastupdatechannel() {
        return lastupdatechannel;
    }

    public void setLastupdatechannel(String lastupdatechannel) {
        this.lastupdatechannel = lastupdatechannel == null ? null : lastupdatechannel.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getBaiduuserid() {
        return baiduuserid;
    }

    public void setBaiduuserid(String baiduuserid) {
        this.baiduuserid = baiduuserid == null ? null : baiduuserid.trim();
    }
}