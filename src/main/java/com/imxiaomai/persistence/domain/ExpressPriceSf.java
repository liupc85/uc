package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class ExpressPriceSf extends BaseDO{
    private Integer id;

    private Integer fromareaid;

    private Integer toareaid;

    private Integer price1;

    private Integer price2;

    private Integer price3;

    private Integer price4;

    private Integer price5;

    private Integer landprice1;

    private Integer landprice2;

    private Integer landprice3;

    private Integer landprice4;

    private Integer landprice5;

    private Integer waterbasicprice;

    private Integer wateraddedprice;

    private Integer airbasicprice;

    private Integer airaddedprice;

    private Date createtime;

    private Byte status;
    
    private long totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromareaid() {
        return fromareaid;
    }

    public void setFromareaid(Integer fromareaid) {
        this.fromareaid = fromareaid;
    }

    public Integer getToareaid() {
        return toareaid;
    }

    public void setToareaid(Integer toareaid) {
        this.toareaid = toareaid;
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

    public Integer getLandprice1() {
        return landprice1;
    }

    public void setLandprice1(Integer landprice1) {
        this.landprice1 = landprice1;
    }

    public Integer getLandprice2() {
        return landprice2;
    }

    public void setLandprice2(Integer landprice2) {
        this.landprice2 = landprice2;
    }

    public Integer getLandprice3() {
        return landprice3;
    }

    public void setLandprice3(Integer landprice3) {
        this.landprice3 = landprice3;
    }

    public Integer getLandprice4() {
        return landprice4;
    }

    public void setLandprice4(Integer landprice4) {
        this.landprice4 = landprice4;
    }

    public Integer getLandprice5() {
        return landprice5;
    }

    public void setLandprice5(Integer landprice5) {
        this.landprice5 = landprice5;
    }

    public Integer getWaterbasicprice() {
        return waterbasicprice;
    }

    public void setWaterbasicprice(Integer waterbasicprice) {
        this.waterbasicprice = waterbasicprice;
    }

    public Integer getWateraddedprice() {
        return wateraddedprice;
    }

    public void setWateraddedprice(Integer wateraddedprice) {
        this.wateraddedprice = wateraddedprice;
    }

    public Integer getAirbasicprice() {
        return airbasicprice;
    }

    public void setAirbasicprice(Integer airbasicprice) {
        this.airbasicprice = airbasicprice;
    }

    public Integer getAiraddedprice() {
        return airaddedprice;
    }

    public void setAiraddedprice(Integer airaddedprice) {
        this.airaddedprice = airaddedprice;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

	public long calcTotalPrice(double weight) {
		long totalCost = 0;

		if (weight <= 1d) {
			totalCost = this.price1;
		} else if (weight <= 50d) {
			totalCost = (long)(this.price1 + (weight - 1) * this.price2);
		} else if (weight <= 100d) {
			totalCost = (long)(this.price1 + (weight - 1) * this.price3);
		} else if (weight <= 300d) {
			totalCost = (long)(this.price1 + (weight - 1) * this.price4);
		} else {
			totalCost = (long)(this.price1 + (weight - 1) * this.price5);
		}

		return (long)Math.ceil(totalCost / 100d) * 100;
	}
    
}