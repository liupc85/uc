package com.imxiaomai.persistence.domain;

import java.util.Date;

import com.imxiaomai.base.BaseDO;

public class StoreCollect extends BaseDO{
    private Integer id;

    private String schoolName;

    private String storeName;

    private String storeAddress;

    private Byte operateType;

    private Integer regionId;

    private Integer provinceId;

    private Integer cityId;

    private Integer storeSpace;

    private Integer storeWide;

    private Integer buildingStorey;

    private Byte storeLandlord;

    private String storeSign;

    private String storeLeader;

    private String phone;

    private String eMail;

    private String basicDecorate;

    private Byte needDecorate;

    private String decoratePurpose;

    private Integer expectFee;

    private Integer basicStaffNum;

    private Byte needStaff;

    private String staffPurpose;

    private Integer expectStaffNum;

    private Integer computeNum;

    private Integer bikeNum;

    private Integer phoneNum;

    private Integer baqiangNum;

    private Integer storageNum;

    private String otherInfo;

    private Byte needDevice;

    private Integer expectComputeNum;

    private Integer expectBikeNum;

    private Integer expectPhoneNum;

    private Integer expectBaqiangNum;

    private Integer expectStorageNum;

    private String expectOtherInfo;

    private String competitorInfo;

    private String schoolReceiveRetailer;

    private String schoolReceiveExpress;

    private String schoolDispatchRetailer;

    private String schoolDispatchExpress;

    private String storeReceiveRetailer;

    private String storeReceiveExpress;

    private String storeDispatchRetailer;

    private String storeDispatchExpress;

    private String startTime;

    private String endTime;

    private Integer rentFee;

    private Integer transferFee;

    private Integer depositFee;

    private String otherFee;

    private String divideModel;

    private String profitInfo;

    private String schoolDoorPicids;

    private String schoolSurroundPicids;

    private String storeDoorPicids;

    private String storeInnerPicids;

    private String storeModelPicids;

    private String otherPicids;

    private Integer createStaffId;

    private Date createTime;

    private Integer areaId;

    private Byte cityLevel;

    private Byte schoolLevel;

    private Integer schoolPersonNum;

    private String manWomen;

    private Integer schoolSpace;

    private Integer updateStaffId;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStoreSpace() {
        return storeSpace;
    }

    public void setStoreSpace(Integer storeSpace) {
        this.storeSpace = storeSpace;
    }

    public Integer getStoreWide() {
        return storeWide;
    }

    public void setStoreWide(Integer storeWide) {
        this.storeWide = storeWide;
    }

    public Integer getBuildingStorey() {
        return buildingStorey;
    }

    public void setBuildingStorey(Integer buildingStorey) {
        this.buildingStorey = buildingStorey;
    }

    public Byte getStoreLandlord() {
        return storeLandlord;
    }

    public void setStoreLandlord(Byte storeLandlord) {
        this.storeLandlord = storeLandlord;
    }

    public String getStoreSign() {
        return storeSign;
    }

    public void setStoreSign(String storeSign) {
        this.storeSign = storeSign == null ? null : storeSign.trim();
    }

    public String getStoreLeader() {
        return storeLeader;
    }

    public void setStoreLeader(String storeLeader) {
        this.storeLeader = storeLeader == null ? null : storeLeader.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getBasicDecorate() {
        return basicDecorate;
    }

    public void setBasicDecorate(String basicDecorate) {
        this.basicDecorate = basicDecorate == null ? null : basicDecorate.trim();
    }

    public Byte getNeedDecorate() {
        return needDecorate;
    }

    public void setNeedDecorate(Byte needDecorate) {
        this.needDecorate = needDecorate;
    }

    public String getDecoratePurpose() {
        return decoratePurpose;
    }

    public void setDecoratePurpose(String decoratePurpose) {
        this.decoratePurpose = decoratePurpose == null ? null : decoratePurpose.trim();
    }

    public Integer getExpectFee() {
        return expectFee;
    }

    public void setExpectFee(Integer expectFee) {
        this.expectFee = expectFee;
    }

    public Integer getBasicStaffNum() {
        return basicStaffNum;
    }

    public void setBasicStaffNum(Integer basicStaffNum) {
        this.basicStaffNum = basicStaffNum;
    }

    public Byte getNeedStaff() {
        return needStaff;
    }

    public void setNeedStaff(Byte needStaff) {
        this.needStaff = needStaff;
    }

    public String getStaffPurpose() {
        return staffPurpose;
    }

    public void setStaffPurpose(String staffPurpose) {
        this.staffPurpose = staffPurpose == null ? null : staffPurpose.trim();
    }

    public Integer getExpectStaffNum() {
        return expectStaffNum;
    }

    public void setExpectStaffNum(Integer expectStaffNum) {
        this.expectStaffNum = expectStaffNum;
    }

    public Integer getComputeNum() {
        return computeNum;
    }

    public void setComputeNum(Integer computeNum) {
        this.computeNum = computeNum;
    }

    public Integer getBikeNum() {
        return bikeNum;
    }

    public void setBikeNum(Integer bikeNum) {
        this.bikeNum = bikeNum;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getBaqiangNum() {
        return baqiangNum;
    }

    public void setBaqiangNum(Integer baqiangNum) {
        this.baqiangNum = baqiangNum;
    }

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    public Byte getNeedDevice() {
        return needDevice;
    }

    public void setNeedDevice(Byte needDevice) {
        this.needDevice = needDevice;
    }

    public Integer getExpectComputeNum() {
        return expectComputeNum;
    }

    public void setExpectComputeNum(Integer expectComputeNum) {
        this.expectComputeNum = expectComputeNum;
    }

    public Integer getExpectBikeNum() {
        return expectBikeNum;
    }

    public void setExpectBikeNum(Integer expectBikeNum) {
        this.expectBikeNum = expectBikeNum;
    }

    public Integer getExpectPhoneNum() {
        return expectPhoneNum;
    }

    public void setExpectPhoneNum(Integer expectPhoneNum) {
        this.expectPhoneNum = expectPhoneNum;
    }

    public Integer getExpectBaqiangNum() {
        return expectBaqiangNum;
    }

    public void setExpectBaqiangNum(Integer expectBaqiangNum) {
        this.expectBaqiangNum = expectBaqiangNum;
    }

    public Integer getExpectStorageNum() {
        return expectStorageNum;
    }

    public void setExpectStorageNum(Integer expectStorageNum) {
        this.expectStorageNum = expectStorageNum;
    }

    public String getExpectOtherInfo() {
        return expectOtherInfo;
    }

    public void setExpectOtherInfo(String expectOtherInfo) {
        this.expectOtherInfo = expectOtherInfo == null ? null : expectOtherInfo.trim();
    }

    public String getCompetitorInfo() {
        return competitorInfo;
    }

    public void setCompetitorInfo(String competitorInfo) {
        this.competitorInfo = competitorInfo == null ? null : competitorInfo.trim();
    }

    public String getSchoolReceiveRetailer() {
        return schoolReceiveRetailer;
    }

    public void setSchoolReceiveRetailer(String schoolReceiveRetailer) {
        this.schoolReceiveRetailer = schoolReceiveRetailer == null ? null : schoolReceiveRetailer.trim();
    }

    public String getSchoolReceiveExpress() {
        return schoolReceiveExpress;
    }

    public void setSchoolReceiveExpress(String schoolReceiveExpress) {
        this.schoolReceiveExpress = schoolReceiveExpress == null ? null : schoolReceiveExpress.trim();
    }

    public String getSchoolDispatchRetailer() {
        return schoolDispatchRetailer;
    }

    public void setSchoolDispatchRetailer(String schoolDispatchRetailer) {
        this.schoolDispatchRetailer = schoolDispatchRetailer == null ? null : schoolDispatchRetailer.trim();
    }

    public String getSchoolDispatchExpress() {
        return schoolDispatchExpress;
    }

    public void setSchoolDispatchExpress(String schoolDispatchExpress) {
        this.schoolDispatchExpress = schoolDispatchExpress == null ? null : schoolDispatchExpress.trim();
    }

    public String getStoreReceiveRetailer() {
        return storeReceiveRetailer;
    }

    public void setStoreReceiveRetailer(String storeReceiveRetailer) {
        this.storeReceiveRetailer = storeReceiveRetailer == null ? null : storeReceiveRetailer.trim();
    }

    public String getStoreReceiveExpress() {
        return storeReceiveExpress;
    }

    public void setStoreReceiveExpress(String storeReceiveExpress) {
        this.storeReceiveExpress = storeReceiveExpress == null ? null : storeReceiveExpress.trim();
    }

    public String getStoreDispatchRetailer() {
        return storeDispatchRetailer;
    }

    public void setStoreDispatchRetailer(String storeDispatchRetailer) {
        this.storeDispatchRetailer = storeDispatchRetailer == null ? null : storeDispatchRetailer.trim();
    }

    public String getStoreDispatchExpress() {
        return storeDispatchExpress;
    }

    public void setStoreDispatchExpress(String storeDispatchExpress) {
        this.storeDispatchExpress = storeDispatchExpress == null ? null : storeDispatchExpress.trim();
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

    public Integer getRentFee() {
        return rentFee;
    }

    public void setRentFee(Integer rentFee) {
        this.rentFee = rentFee;
    }

    public Integer getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Integer transferFee) {
        this.transferFee = transferFee;
    }

    public Integer getDepositFee() {
        return depositFee;
    }

    public void setDepositFee(Integer depositFee) {
        this.depositFee = depositFee;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee == null ? null : otherFee.trim();
    }

    public String getDivideModel() {
        return divideModel;
    }

    public void setDivideModel(String divideModel) {
        this.divideModel = divideModel == null ? null : divideModel.trim();
    }

    public String getProfitInfo() {
        return profitInfo;
    }

    public void setProfitInfo(String profitInfo) {
        this.profitInfo = profitInfo == null ? null : profitInfo.trim();
    }

    public String getSchoolDoorPicids() {
        return schoolDoorPicids;
    }

    public void setSchoolDoorPicids(String schoolDoorPicids) {
        this.schoolDoorPicids = schoolDoorPicids == null ? null : schoolDoorPicids.trim();
    }

    public String getSchoolSurroundPicids() {
        return schoolSurroundPicids;
    }

    public void setSchoolSurroundPicids(String schoolSurroundPicids) {
        this.schoolSurroundPicids = schoolSurroundPicids == null ? null : schoolSurroundPicids.trim();
    }

    public String getStoreDoorPicids() {
        return storeDoorPicids;
    }

    public void setStoreDoorPicids(String storeDoorPicids) {
        this.storeDoorPicids = storeDoorPicids == null ? null : storeDoorPicids.trim();
    }

    public String getStoreInnerPicids() {
        return storeInnerPicids;
    }

    public void setStoreInnerPicids(String storeInnerPicids) {
        this.storeInnerPicids = storeInnerPicids == null ? null : storeInnerPicids.trim();
    }

    public String getStoreModelPicids() {
        return storeModelPicids;
    }

    public void setStoreModelPicids(String storeModelPicids) {
        this.storeModelPicids = storeModelPicids == null ? null : storeModelPicids.trim();
    }

    public String getOtherPicids() {
        return otherPicids;
    }

    public void setOtherPicids(String otherPicids) {
        this.otherPicids = otherPicids == null ? null : otherPicids.trim();
    }

    public Integer getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Integer createStaffId) {
        this.createStaffId = createStaffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Byte getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(Byte cityLevel) {
        this.cityLevel = cityLevel;
    }

    public Byte getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(Byte schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public Integer getSchoolPersonNum() {
        return schoolPersonNum;
    }

    public void setSchoolPersonNum(Integer schoolPersonNum) {
        this.schoolPersonNum = schoolPersonNum;
    }

    public String getManWomen() {
        return manWomen;
    }

    public void setManWomen(String manWomen) {
        this.manWomen = manWomen == null ? null : manWomen.trim();
    }

    public Integer getSchoolSpace() {
        return schoolSpace;
    }

    public void setSchoolSpace(Integer schoolSpace) {
        this.schoolSpace = schoolSpace;
    }

    public Integer getUpdateStaffId() {
        return updateStaffId;
    }

    public void setUpdateStaffId(Integer updateStaffId) {
        this.updateStaffId = updateStaffId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}