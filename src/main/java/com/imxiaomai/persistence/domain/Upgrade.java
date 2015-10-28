package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class Upgrade  extends BaseDO{
    private Integer opid;

    private Integer id;

    private String version;

    private Integer vid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }
}