package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class ExpressPrice extends BaseDO{
    private Integer id;

    private Integer expressid;

    private Integer sourceprovinceid;

    private Integer sourcecityid;

    private Integer sourceareaid;

    private Integer sourcestoreid;

    private Integer targetprovinceid;

    private Integer targetcityid;

    private Integer targetareaid;

    private Integer targetstoreid;

    private Integer price1;

    private Integer price2;

    private Integer price3;

    private Integer price4;

    private Integer price5;

    private Date createtime;

    private Date updatetime;

    private Byte status;
    
    private long totalPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpressid() {
        return expressid;
    }

    public void setExpressid(Integer expressid) {
        this.expressid = expressid;
    }

    public Integer getSourceprovinceid() {
        return sourceprovinceid;
    }

    public void setSourceprovinceid(Integer sourceprovinceid) {
        this.sourceprovinceid = sourceprovinceid;
    }

    public Integer getSourcecityid() {
        return sourcecityid;
    }

    public void setSourcecityid(Integer sourcecityid) {
        this.sourcecityid = sourcecityid;
    }

    public Integer getSourceareaid() {
        return sourceareaid;
    }

    public void setSourceareaid(Integer sourceareaid) {
        this.sourceareaid = sourceareaid;
    }

    public Integer getSourcestoreid() {
        return sourcestoreid;
    }

    public void setSourcestoreid(Integer sourcestoreid) {
        this.sourcestoreid = sourcestoreid;
    }

    public Integer getTargetprovinceid() {
        return targetprovinceid;
    }

    public void setTargetprovinceid(Integer targetprovinceid) {
        this.targetprovinceid = targetprovinceid;
    }

    public Integer getTargetcityid() {
        return targetcityid;
    }

    public void setTargetcityid(Integer targetcityid) {
        this.targetcityid = targetcityid;
    }

    public Integer getTargetareaid() {
        return targetareaid;
    }

    public void setTargetareaid(Integer targetareaid) {
        this.targetareaid = targetareaid;
    }

    public Integer getTargetstoreid() {
        return targetstoreid;
    }

    public void setTargetstoreid(Integer targetstoreid) {
        this.targetstoreid = targetstoreid;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public Integer getPrice3() {
        return price3;
    }

    public void setPrice3(Integer price3) {
        this.price3 = price3;
    }

    public Integer getPrice4() {
        return price4;
    }

    public void setPrice4(Integer price4) {
        this.price4 = price4;
    }

    public Integer getPrice5() {
        return price5;
    }

    public void setPrice5(Integer price5) {
        this.price5 = price5;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
    
    
    
	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public  Long calcTotalPrice(double weight){

		long totalCost = 0;
		double baseWeight = 1.0;
		double addedWeight = weight - baseWeight;

		if (weight <= baseWeight) {
			totalCost = this.price1;
		} else {
			totalCost = (long)(this.price1 + addedWeight * this.price2);
		}
		
		return (long)Math.ceil(totalCost / 100d) * 100;
	
	}
    
}