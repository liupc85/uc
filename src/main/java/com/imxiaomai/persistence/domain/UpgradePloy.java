package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class UpgradePloy extends BaseDO{
    private Integer opid;

    private String upgradename;

    private String upgradevalue;

    private Byte isuse;

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }

    public String getUpgradename() {
        return upgradename;
    }

    public void setUpgradename(String upgradename) {
        this.upgradename = upgradename == null ? null : upgradename.trim();
    }

    public String getUpgradevalue() {
        return upgradevalue;
    }

    public void setUpgradevalue(String upgradevalue) {
        this.upgradevalue = upgradevalue == null ? null : upgradevalue.trim();
    }

    public Byte getIsuse() {
        return isuse;
    }

    public void setIsuse(Byte isuse) {
        this.isuse = isuse;
    }
}