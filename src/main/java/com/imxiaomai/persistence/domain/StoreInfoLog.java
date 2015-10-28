package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class StoreInfoLog extends BaseDO{
    private Integer id;

    private Integer storeId;

    private Integer collectId;

    private String code;

    private String name;

    private String shortName;

    private String owner;

    private String license;

    private Integer licenseActivateNum;

    private Integer licenseActivatedNum;

    private Integer regionId;

    private Integer provinceId;

    private String takeExpressPhone;

    private Byte operateType;

    private String space;

    private Byte level;

    private Byte status;

    private String receiveIds;

    private String dispatchIds;

    private String startTime;

    private String endTime;

    private String latestBusinessTime;

    private Integer isdel;

    private Integer createStaffId;

    private Integer updateStaffId;

    private Integer cityId;

    private Integer areaId;

    private Integer collegeId;

    private String address;

    private String shortAddress;

    private String phone;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public Integer getLicenseActivateNum() {
        return licenseActivateNum;
    }

    public void setLicenseActivateNum(Integer licenseActivateNum) {
        this.licenseActivateNum = licenseActivateNum;
    }

    public Integer getLicenseActivatedNum() {
        return licenseActivatedNum;
    }

    public void setLicenseActivatedNum(Integer licenseActivatedNum) {
        this.licenseActivatedNum = licenseActivatedNum;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getTakeExpressPhone() {
        return takeExpressPhone;
    }

    public void setTakeExpressPhone(String takeExpressPhone) {
        this.takeExpressPhone = takeExpressPhone == null ? null : takeExpressPhone.trim();
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space == null ? null : space.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReceiveIds() {
        return receiveIds;
    }

    public void setReceiveIds(String receiveIds) {
        this.receiveIds = receiveIds == null ? null : receiveIds.trim();
    }

    public String getDispatchIds() {
        return dispatchIds;
    }

    public void setDispatchIds(String dispatchIds) {
        this.dispatchIds = dispatchIds == null ? null : dispatchIds.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getLatestBusinessTime() {
        return latestBusinessTime;
    }

    public void setLatestBusinessTime(String latestBusinessTime) {
        this.latestBusinessTime = latestBusinessTime == null ? null : latestBusinessTime.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Integer createStaffId) {
        this.createStaffId = createStaffId;
    }

    public Integer getUpdateStaffId() {
        return updateStaffId;
    }

    public void setUpdateStaffId(Integer updateStaffId) {
        this.updateStaffId = updateStaffId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShortAddress() {
        return shortAddress;
    }

    public void setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress == null ? null : shortAddress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}