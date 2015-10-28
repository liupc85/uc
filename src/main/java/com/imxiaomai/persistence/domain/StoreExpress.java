package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class StoreExpress extends BaseDO{
    private Integer storeid;

    private String deliveryexpids;

    private String receivedexpids;

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getDeliveryexpids() {
        return deliveryexpids;
    }

    public void setDeliveryexpids(String deliveryexpids) {
        this.deliveryexpids = deliveryexpids == null ? null : deliveryexpids.trim();
    }

    public String getReceivedexpids() {
        return receivedexpids;
    }

    public void setReceivedexpids(String receivedexpids) {
        this.receivedexpids = receivedexpids == null ? null : receivedexpids.trim();
    }
}