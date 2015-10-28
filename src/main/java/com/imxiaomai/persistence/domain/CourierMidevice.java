package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class CourierMidevice extends BaseDO{
    private Integer id;

    private Integer userid;

    private String mobilephone;

    private String deviceid;

    private String platform;

    private String version;

    private String srcchannel;

    private Date updatetime;

    private Date createtime;

    private String regid;
    

    public CourierMidevice() {
		super();
	}

	public CourierMidevice( Integer userid, String mobilephone,
			String deviceid, String platform, String version,
			String srcchannel, Date updatetime, Date createtime, String regid) {
		super();
		this.userid = userid;
		this.mobilephone = mobilephone;
		this.deviceid = deviceid;
		this.platform = platform;
		this.version = version;
		this.srcchannel = srcchannel;
		this.updatetime = updatetime;
		this.createtime = createtime;
		this.regid = regid;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid == null ? null : regid.trim();
    }
}