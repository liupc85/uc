package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class Area extends BaseDO{
 
	private static final long serialVersionUID = 1636175320191023911L;

	private Integer id;

    private String name;

    private Integer cityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}