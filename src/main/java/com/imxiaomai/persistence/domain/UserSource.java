package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class UserSource extends BaseDO{
    private Integer userid;

    private Byte sourcecode;

    private String sourcedesc;
    
    private String mobilephone; 


	private Date createtime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Byte getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(Byte sourcecode) {
        this.sourcecode = sourcecode;
    }

    public String getSourcedesc() {
        return sourcedesc;
    }

    public void setSourcedesc(String sourcedesc) {
        this.sourcedesc = sourcedesc == null ? null : sourcedesc.trim();
    }

    public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
    
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}