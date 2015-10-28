package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class Store extends BaseDO{
    private Integer id;

    private String name;

    private String shortName;

    private String owner;

    private String license;

    private Integer licenseActivateNum;

    private Integer licenseActivatedNum;

    private String phone;

    private String takeExpressPhone;

    private Integer status;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private Integer collegeId;

    private String address;

    private Integer isjoin;

    private Date createTime;

    private Integer isdel;

    private Integer isp2p;

    private String shortAddress;

    private String latestBusinessTime;

    private Integer collectId;

    private String code;

    private Byte operateType;

    private String space;

    private Byte level;

    private Integer regionId;

    private String receiveIds;

    private String dispatchIds;

    private String startTime;

    private String endTime;

    private Integer createStaffId;

    private Integer updateStaffId;

    private String ctIds;

    private Date updateTime;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTakeExpressPhone() {
        return takeExpressPhone;
    }

    public void setTakeExpressPhone(String takeExpressPhone) {
        this.takeExpressPhone = takeExpressPhone == null ? null : takeExpressPhone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
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

    public Integer getIsjoin() {
        return isjoin;
    }

    public void setIsjoin(Integer isjoin) {
        this.isjoin = isjoin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getIsp2p() {
        return isp2p;
    }

    public void setIsp2p(Integer isp2p) {
        this.isp2p = isp2p;
    }

    public String getShortAddress() {
        return shortAddress;
    }

    public void setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress == null ? null : shortAddress.trim();
    }

    public String getLatestBusinessTime() {
        return latestBusinessTime;
    }

    public void setLatestBusinessTime(String latestBusinessTime) {
        this.latestBusinessTime = latestBusinessTime == null ? null : latestBusinessTime.trim();
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

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
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

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds == null ? null : ctIds.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}