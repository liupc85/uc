package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreCollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreCollectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("operate_type is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(Byte value) {
            addCriterion("operate_type =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(Byte value) {
            addCriterion("operate_type <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(Byte value) {
            addCriterion("operate_type >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("operate_type >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(Byte value) {
            addCriterion("operate_type <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("operate_type <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<Byte> values) {
            addCriterion("operate_type in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<Byte> values) {
            addCriterion("operate_type not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(Byte value1, Byte value2) {
            addCriterion("operate_type between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("operate_type not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Integer value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Integer value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Integer value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Integer value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Integer value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Integer> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Integer> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Integer value1, Integer value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceIsNull() {
            addCriterion("store_space is null");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceIsNotNull() {
            addCriterion("store_space is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceEqualTo(Integer value) {
            addCriterion("store_space =", value, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceNotEqualTo(Integer value) {
            addCriterion("store_space <>", value, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceGreaterThan(Integer value) {
            addCriterion("store_space >", value, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_space >=", value, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceLessThan(Integer value) {
            addCriterion("store_space <", value, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("store_space <=", value, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceIn(List<Integer> values) {
            addCriterion("store_space in", values, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceNotIn(List<Integer> values) {
            addCriterion("store_space not in", values, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceBetween(Integer value1, Integer value2) {
            addCriterion("store_space between", value1, value2, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("store_space not between", value1, value2, "storeSpace");
            return (Criteria) this;
        }

        public Criteria andStoreWideIsNull() {
            addCriterion("store_wide is null");
            return (Criteria) this;
        }

        public Criteria andStoreWideIsNotNull() {
            addCriterion("store_wide is not null");
            return (Criteria) this;
        }

        public Criteria andStoreWideEqualTo(Integer value) {
            addCriterion("store_wide =", value, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideNotEqualTo(Integer value) {
            addCriterion("store_wide <>", value, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideGreaterThan(Integer value) {
            addCriterion("store_wide >", value, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_wide >=", value, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideLessThan(Integer value) {
            addCriterion("store_wide <", value, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideLessThanOrEqualTo(Integer value) {
            addCriterion("store_wide <=", value, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideIn(List<Integer> values) {
            addCriterion("store_wide in", values, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideNotIn(List<Integer> values) {
            addCriterion("store_wide not in", values, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideBetween(Integer value1, Integer value2) {
            addCriterion("store_wide between", value1, value2, "storeWide");
            return (Criteria) this;
        }

        public Criteria andStoreWideNotBetween(Integer value1, Integer value2) {
            addCriterion("store_wide not between", value1, value2, "storeWide");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyIsNull() {
            addCriterion("building_storey is null");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyIsNotNull() {
            addCriterion("building_storey is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyEqualTo(Integer value) {
            addCriterion("building_storey =", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotEqualTo(Integer value) {
            addCriterion("building_storey <>", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyGreaterThan(Integer value) {
            addCriterion("building_storey >", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyGreaterThanOrEqualTo(Integer value) {
            addCriterion("building_storey >=", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyLessThan(Integer value) {
            addCriterion("building_storey <", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyLessThanOrEqualTo(Integer value) {
            addCriterion("building_storey <=", value, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyIn(List<Integer> values) {
            addCriterion("building_storey in", values, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotIn(List<Integer> values) {
            addCriterion("building_storey not in", values, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyBetween(Integer value1, Integer value2) {
            addCriterion("building_storey between", value1, value2, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andBuildingStoreyNotBetween(Integer value1, Integer value2) {
            addCriterion("building_storey not between", value1, value2, "buildingStorey");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordIsNull() {
            addCriterion("store_landlord is null");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordIsNotNull() {
            addCriterion("store_landlord is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordEqualTo(Byte value) {
            addCriterion("store_landlord =", value, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordNotEqualTo(Byte value) {
            addCriterion("store_landlord <>", value, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordGreaterThan(Byte value) {
            addCriterion("store_landlord >", value, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordGreaterThanOrEqualTo(Byte value) {
            addCriterion("store_landlord >=", value, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordLessThan(Byte value) {
            addCriterion("store_landlord <", value, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordLessThanOrEqualTo(Byte value) {
            addCriterion("store_landlord <=", value, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordIn(List<Byte> values) {
            addCriterion("store_landlord in", values, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordNotIn(List<Byte> values) {
            addCriterion("store_landlord not in", values, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordBetween(Byte value1, Byte value2) {
            addCriterion("store_landlord between", value1, value2, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreLandlordNotBetween(Byte value1, Byte value2) {
            addCriterion("store_landlord not between", value1, value2, "storeLandlord");
            return (Criteria) this;
        }

        public Criteria andStoreSignIsNull() {
            addCriterion("store_sign is null");
            return (Criteria) this;
        }

        public Criteria andStoreSignIsNotNull() {
            addCriterion("store_sign is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSignEqualTo(String value) {
            addCriterion("store_sign =", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignNotEqualTo(String value) {
            addCriterion("store_sign <>", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignGreaterThan(String value) {
            addCriterion("store_sign >", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignGreaterThanOrEqualTo(String value) {
            addCriterion("store_sign >=", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignLessThan(String value) {
            addCriterion("store_sign <", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignLessThanOrEqualTo(String value) {
            addCriterion("store_sign <=", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignLike(String value) {
            addCriterion("store_sign like", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignNotLike(String value) {
            addCriterion("store_sign not like", value, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignIn(List<String> values) {
            addCriterion("store_sign in", values, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignNotIn(List<String> values) {
            addCriterion("store_sign not in", values, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignBetween(String value1, String value2) {
            addCriterion("store_sign between", value1, value2, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreSignNotBetween(String value1, String value2) {
            addCriterion("store_sign not between", value1, value2, "storeSign");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderIsNull() {
            addCriterion("store_leader is null");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderIsNotNull() {
            addCriterion("store_leader is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderEqualTo(String value) {
            addCriterion("store_leader =", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderNotEqualTo(String value) {
            addCriterion("store_leader <>", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderGreaterThan(String value) {
            addCriterion("store_leader >", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("store_leader >=", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderLessThan(String value) {
            addCriterion("store_leader <", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderLessThanOrEqualTo(String value) {
            addCriterion("store_leader <=", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderLike(String value) {
            addCriterion("store_leader like", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderNotLike(String value) {
            addCriterion("store_leader not like", value, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderIn(List<String> values) {
            addCriterion("store_leader in", values, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderNotIn(List<String> values) {
            addCriterion("store_leader not in", values, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderBetween(String value1, String value2) {
            addCriterion("store_leader between", value1, value2, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andStoreLeaderNotBetween(String value1, String value2) {
            addCriterion("store_leader not between", value1, value2, "storeLeader");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEMailIsNull() {
            addCriterion("e_mail is null");
            return (Criteria) this;
        }

        public Criteria andEMailIsNotNull() {
            addCriterion("e_mail is not null");
            return (Criteria) this;
        }

        public Criteria andEMailEqualTo(String value) {
            addCriterion("e_mail =", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotEqualTo(String value) {
            addCriterion("e_mail <>", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThan(String value) {
            addCriterion("e_mail >", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThanOrEqualTo(String value) {
            addCriterion("e_mail >=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThan(String value) {
            addCriterion("e_mail <", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThanOrEqualTo(String value) {
            addCriterion("e_mail <=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLike(String value) {
            addCriterion("e_mail like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotLike(String value) {
            addCriterion("e_mail not like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailIn(List<String> values) {
            addCriterion("e_mail in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotIn(List<String> values) {
            addCriterion("e_mail not in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailBetween(String value1, String value2) {
            addCriterion("e_mail between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotBetween(String value1, String value2) {
            addCriterion("e_mail not between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateIsNull() {
            addCriterion("basic_decorate is null");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateIsNotNull() {
            addCriterion("basic_decorate is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateEqualTo(String value) {
            addCriterion("basic_decorate =", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateNotEqualTo(String value) {
            addCriterion("basic_decorate <>", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateGreaterThan(String value) {
            addCriterion("basic_decorate >", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateGreaterThanOrEqualTo(String value) {
            addCriterion("basic_decorate >=", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateLessThan(String value) {
            addCriterion("basic_decorate <", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateLessThanOrEqualTo(String value) {
            addCriterion("basic_decorate <=", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateLike(String value) {
            addCriterion("basic_decorate like", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateNotLike(String value) {
            addCriterion("basic_decorate not like", value, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateIn(List<String> values) {
            addCriterion("basic_decorate in", values, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateNotIn(List<String> values) {
            addCriterion("basic_decorate not in", values, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateBetween(String value1, String value2) {
            addCriterion("basic_decorate between", value1, value2, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andBasicDecorateNotBetween(String value1, String value2) {
            addCriterion("basic_decorate not between", value1, value2, "basicDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateIsNull() {
            addCriterion("need_decorate is null");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateIsNotNull() {
            addCriterion("need_decorate is not null");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateEqualTo(Byte value) {
            addCriterion("need_decorate =", value, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateNotEqualTo(Byte value) {
            addCriterion("need_decorate <>", value, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateGreaterThan(Byte value) {
            addCriterion("need_decorate >", value, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateGreaterThanOrEqualTo(Byte value) {
            addCriterion("need_decorate >=", value, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateLessThan(Byte value) {
            addCriterion("need_decorate <", value, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateLessThanOrEqualTo(Byte value) {
            addCriterion("need_decorate <=", value, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateIn(List<Byte> values) {
            addCriterion("need_decorate in", values, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateNotIn(List<Byte> values) {
            addCriterion("need_decorate not in", values, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateBetween(Byte value1, Byte value2) {
            addCriterion("need_decorate between", value1, value2, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andNeedDecorateNotBetween(Byte value1, Byte value2) {
            addCriterion("need_decorate not between", value1, value2, "needDecorate");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeIsNull() {
            addCriterion("decorate_purpose is null");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeIsNotNull() {
            addCriterion("decorate_purpose is not null");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeEqualTo(String value) {
            addCriterion("decorate_purpose =", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeNotEqualTo(String value) {
            addCriterion("decorate_purpose <>", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeGreaterThan(String value) {
            addCriterion("decorate_purpose >", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeGreaterThanOrEqualTo(String value) {
            addCriterion("decorate_purpose >=", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeLessThan(String value) {
            addCriterion("decorate_purpose <", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeLessThanOrEqualTo(String value) {
            addCriterion("decorate_purpose <=", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeLike(String value) {
            addCriterion("decorate_purpose like", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeNotLike(String value) {
            addCriterion("decorate_purpose not like", value, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeIn(List<String> values) {
            addCriterion("decorate_purpose in", values, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeNotIn(List<String> values) {
            addCriterion("decorate_purpose not in", values, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeBetween(String value1, String value2) {
            addCriterion("decorate_purpose between", value1, value2, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andDecoratePurposeNotBetween(String value1, String value2) {
            addCriterion("decorate_purpose not between", value1, value2, "decoratePurpose");
            return (Criteria) this;
        }

        public Criteria andExpectFeeIsNull() {
            addCriterion("expect_fee is null");
            return (Criteria) this;
        }

        public Criteria andExpectFeeIsNotNull() {
            addCriterion("expect_fee is not null");
            return (Criteria) this;
        }

        public Criteria andExpectFeeEqualTo(Integer value) {
            addCriterion("expect_fee =", value, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeNotEqualTo(Integer value) {
            addCriterion("expect_fee <>", value, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeGreaterThan(Integer value) {
            addCriterion("expect_fee >", value, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_fee >=", value, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeLessThan(Integer value) {
            addCriterion("expect_fee <", value, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeLessThanOrEqualTo(Integer value) {
            addCriterion("expect_fee <=", value, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeIn(List<Integer> values) {
            addCriterion("expect_fee in", values, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeNotIn(List<Integer> values) {
            addCriterion("expect_fee not in", values, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeBetween(Integer value1, Integer value2) {
            addCriterion("expect_fee between", value1, value2, "expectFee");
            return (Criteria) this;
        }

        public Criteria andExpectFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_fee not between", value1, value2, "expectFee");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumIsNull() {
            addCriterion("basic_staff_num is null");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumIsNotNull() {
            addCriterion("basic_staff_num is not null");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumEqualTo(Integer value) {
            addCriterion("basic_staff_num =", value, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumNotEqualTo(Integer value) {
            addCriterion("basic_staff_num <>", value, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumGreaterThan(Integer value) {
            addCriterion("basic_staff_num >", value, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic_staff_num >=", value, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumLessThan(Integer value) {
            addCriterion("basic_staff_num <", value, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumLessThanOrEqualTo(Integer value) {
            addCriterion("basic_staff_num <=", value, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumIn(List<Integer> values) {
            addCriterion("basic_staff_num in", values, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumNotIn(List<Integer> values) {
            addCriterion("basic_staff_num not in", values, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumBetween(Integer value1, Integer value2) {
            addCriterion("basic_staff_num between", value1, value2, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andBasicStaffNumNotBetween(Integer value1, Integer value2) {
            addCriterion("basic_staff_num not between", value1, value2, "basicStaffNum");
            return (Criteria) this;
        }

        public Criteria andNeedStaffIsNull() {
            addCriterion("need_staff is null");
            return (Criteria) this;
        }

        public Criteria andNeedStaffIsNotNull() {
            addCriterion("need_staff is not null");
            return (Criteria) this;
        }

        public Criteria andNeedStaffEqualTo(Byte value) {
            addCriterion("need_staff =", value, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffNotEqualTo(Byte value) {
            addCriterion("need_staff <>", value, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffGreaterThan(Byte value) {
            addCriterion("need_staff >", value, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffGreaterThanOrEqualTo(Byte value) {
            addCriterion("need_staff >=", value, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffLessThan(Byte value) {
            addCriterion("need_staff <", value, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffLessThanOrEqualTo(Byte value) {
            addCriterion("need_staff <=", value, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffIn(List<Byte> values) {
            addCriterion("need_staff in", values, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffNotIn(List<Byte> values) {
            addCriterion("need_staff not in", values, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffBetween(Byte value1, Byte value2) {
            addCriterion("need_staff between", value1, value2, "needStaff");
            return (Criteria) this;
        }

        public Criteria andNeedStaffNotBetween(Byte value1, Byte value2) {
            addCriterion("need_staff not between", value1, value2, "needStaff");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeIsNull() {
            addCriterion("staff_purpose is null");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeIsNotNull() {
            addCriterion("staff_purpose is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeEqualTo(String value) {
            addCriterion("staff_purpose =", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeNotEqualTo(String value) {
            addCriterion("staff_purpose <>", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeGreaterThan(String value) {
            addCriterion("staff_purpose >", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("staff_purpose >=", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeLessThan(String value) {
            addCriterion("staff_purpose <", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeLessThanOrEqualTo(String value) {
            addCriterion("staff_purpose <=", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeLike(String value) {
            addCriterion("staff_purpose like", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeNotLike(String value) {
            addCriterion("staff_purpose not like", value, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeIn(List<String> values) {
            addCriterion("staff_purpose in", values, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeNotIn(List<String> values) {
            addCriterion("staff_purpose not in", values, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeBetween(String value1, String value2) {
            addCriterion("staff_purpose between", value1, value2, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andStaffPurposeNotBetween(String value1, String value2) {
            addCriterion("staff_purpose not between", value1, value2, "staffPurpose");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumIsNull() {
            addCriterion("expect_staff_num is null");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumIsNotNull() {
            addCriterion("expect_staff_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumEqualTo(Integer value) {
            addCriterion("expect_staff_num =", value, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumNotEqualTo(Integer value) {
            addCriterion("expect_staff_num <>", value, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumGreaterThan(Integer value) {
            addCriterion("expect_staff_num >", value, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_staff_num >=", value, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumLessThan(Integer value) {
            addCriterion("expect_staff_num <", value, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumLessThanOrEqualTo(Integer value) {
            addCriterion("expect_staff_num <=", value, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumIn(List<Integer> values) {
            addCriterion("expect_staff_num in", values, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumNotIn(List<Integer> values) {
            addCriterion("expect_staff_num not in", values, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumBetween(Integer value1, Integer value2) {
            addCriterion("expect_staff_num between", value1, value2, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andExpectStaffNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_staff_num not between", value1, value2, "expectStaffNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumIsNull() {
            addCriterion("compute_num is null");
            return (Criteria) this;
        }

        public Criteria andComputeNumIsNotNull() {
            addCriterion("compute_num is not null");
            return (Criteria) this;
        }

        public Criteria andComputeNumEqualTo(Integer value) {
            addCriterion("compute_num =", value, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumNotEqualTo(Integer value) {
            addCriterion("compute_num <>", value, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumGreaterThan(Integer value) {
            addCriterion("compute_num >", value, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("compute_num >=", value, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumLessThan(Integer value) {
            addCriterion("compute_num <", value, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumLessThanOrEqualTo(Integer value) {
            addCriterion("compute_num <=", value, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumIn(List<Integer> values) {
            addCriterion("compute_num in", values, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumNotIn(List<Integer> values) {
            addCriterion("compute_num not in", values, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumBetween(Integer value1, Integer value2) {
            addCriterion("compute_num between", value1, value2, "computeNum");
            return (Criteria) this;
        }

        public Criteria andComputeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("compute_num not between", value1, value2, "computeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumIsNull() {
            addCriterion("bike_num is null");
            return (Criteria) this;
        }

        public Criteria andBikeNumIsNotNull() {
            addCriterion("bike_num is not null");
            return (Criteria) this;
        }

        public Criteria andBikeNumEqualTo(Integer value) {
            addCriterion("bike_num =", value, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumNotEqualTo(Integer value) {
            addCriterion("bike_num <>", value, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumGreaterThan(Integer value) {
            addCriterion("bike_num >", value, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bike_num >=", value, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumLessThan(Integer value) {
            addCriterion("bike_num <", value, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("bike_num <=", value, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumIn(List<Integer> values) {
            addCriterion("bike_num in", values, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumNotIn(List<Integer> values) {
            addCriterion("bike_num not in", values, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumBetween(Integer value1, Integer value2) {
            addCriterion("bike_num between", value1, value2, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andBikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("bike_num not between", value1, value2, "bikeNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(Integer value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(Integer value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(Integer value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(Integer value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(Integer value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<Integer> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<Integer> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(Integer value1, Integer value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumIsNull() {
            addCriterion("baqiang_num is null");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumIsNotNull() {
            addCriterion("baqiang_num is not null");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumEqualTo(Integer value) {
            addCriterion("baqiang_num =", value, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumNotEqualTo(Integer value) {
            addCriterion("baqiang_num <>", value, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumGreaterThan(Integer value) {
            addCriterion("baqiang_num >", value, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("baqiang_num >=", value, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumLessThan(Integer value) {
            addCriterion("baqiang_num <", value, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumLessThanOrEqualTo(Integer value) {
            addCriterion("baqiang_num <=", value, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumIn(List<Integer> values) {
            addCriterion("baqiang_num in", values, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumNotIn(List<Integer> values) {
            addCriterion("baqiang_num not in", values, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumBetween(Integer value1, Integer value2) {
            addCriterion("baqiang_num between", value1, value2, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andBaqiangNumNotBetween(Integer value1, Integer value2) {
            addCriterion("baqiang_num not between", value1, value2, "baqiangNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumIsNull() {
            addCriterion("storage_num is null");
            return (Criteria) this;
        }

        public Criteria andStorageNumIsNotNull() {
            addCriterion("storage_num is not null");
            return (Criteria) this;
        }

        public Criteria andStorageNumEqualTo(Integer value) {
            addCriterion("storage_num =", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumNotEqualTo(Integer value) {
            addCriterion("storage_num <>", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumGreaterThan(Integer value) {
            addCriterion("storage_num >", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_num >=", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumLessThan(Integer value) {
            addCriterion("storage_num <", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumLessThanOrEqualTo(Integer value) {
            addCriterion("storage_num <=", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumIn(List<Integer> values) {
            addCriterion("storage_num in", values, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumNotIn(List<Integer> values) {
            addCriterion("storage_num not in", values, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumBetween(Integer value1, Integer value2) {
            addCriterion("storage_num between", value1, value2, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_num not between", value1, value2, "storageNum");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIsNull() {
            addCriterion("other_info is null");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIsNotNull() {
            addCriterion("other_info is not null");
            return (Criteria) this;
        }

        public Criteria andOtherInfoEqualTo(String value) {
            addCriterion("other_info =", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotEqualTo(String value) {
            addCriterion("other_info <>", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoGreaterThan(String value) {
            addCriterion("other_info >", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoGreaterThanOrEqualTo(String value) {
            addCriterion("other_info >=", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLessThan(String value) {
            addCriterion("other_info <", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLessThanOrEqualTo(String value) {
            addCriterion("other_info <=", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLike(String value) {
            addCriterion("other_info like", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotLike(String value) {
            addCriterion("other_info not like", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIn(List<String> values) {
            addCriterion("other_info in", values, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotIn(List<String> values) {
            addCriterion("other_info not in", values, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoBetween(String value1, String value2) {
            addCriterion("other_info between", value1, value2, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotBetween(String value1, String value2) {
            addCriterion("other_info not between", value1, value2, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceIsNull() {
            addCriterion("need_device is null");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceIsNotNull() {
            addCriterion("need_device is not null");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceEqualTo(Byte value) {
            addCriterion("need_device =", value, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceNotEqualTo(Byte value) {
            addCriterion("need_device <>", value, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceGreaterThan(Byte value) {
            addCriterion("need_device >", value, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceGreaterThanOrEqualTo(Byte value) {
            addCriterion("need_device >=", value, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceLessThan(Byte value) {
            addCriterion("need_device <", value, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceLessThanOrEqualTo(Byte value) {
            addCriterion("need_device <=", value, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceIn(List<Byte> values) {
            addCriterion("need_device in", values, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceNotIn(List<Byte> values) {
            addCriterion("need_device not in", values, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceBetween(Byte value1, Byte value2) {
            addCriterion("need_device between", value1, value2, "needDevice");
            return (Criteria) this;
        }

        public Criteria andNeedDeviceNotBetween(Byte value1, Byte value2) {
            addCriterion("need_device not between", value1, value2, "needDevice");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumIsNull() {
            addCriterion("expect_compute_num is null");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumIsNotNull() {
            addCriterion("expect_compute_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumEqualTo(Integer value) {
            addCriterion("expect_compute_num =", value, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumNotEqualTo(Integer value) {
            addCriterion("expect_compute_num <>", value, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumGreaterThan(Integer value) {
            addCriterion("expect_compute_num >", value, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_compute_num >=", value, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumLessThan(Integer value) {
            addCriterion("expect_compute_num <", value, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumLessThanOrEqualTo(Integer value) {
            addCriterion("expect_compute_num <=", value, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumIn(List<Integer> values) {
            addCriterion("expect_compute_num in", values, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumNotIn(List<Integer> values) {
            addCriterion("expect_compute_num not in", values, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumBetween(Integer value1, Integer value2) {
            addCriterion("expect_compute_num between", value1, value2, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectComputeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_compute_num not between", value1, value2, "expectComputeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumIsNull() {
            addCriterion("expect_bike_num is null");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumIsNotNull() {
            addCriterion("expect_bike_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumEqualTo(Integer value) {
            addCriterion("expect_bike_num =", value, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumNotEqualTo(Integer value) {
            addCriterion("expect_bike_num <>", value, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumGreaterThan(Integer value) {
            addCriterion("expect_bike_num >", value, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_bike_num >=", value, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumLessThan(Integer value) {
            addCriterion("expect_bike_num <", value, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("expect_bike_num <=", value, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumIn(List<Integer> values) {
            addCriterion("expect_bike_num in", values, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumNotIn(List<Integer> values) {
            addCriterion("expect_bike_num not in", values, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumBetween(Integer value1, Integer value2) {
            addCriterion("expect_bike_num between", value1, value2, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectBikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_bike_num not between", value1, value2, "expectBikeNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumIsNull() {
            addCriterion("expect_phone_num is null");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumIsNotNull() {
            addCriterion("expect_phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumEqualTo(Integer value) {
            addCriterion("expect_phone_num =", value, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumNotEqualTo(Integer value) {
            addCriterion("expect_phone_num <>", value, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumGreaterThan(Integer value) {
            addCriterion("expect_phone_num >", value, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_phone_num >=", value, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumLessThan(Integer value) {
            addCriterion("expect_phone_num <", value, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumLessThanOrEqualTo(Integer value) {
            addCriterion("expect_phone_num <=", value, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumIn(List<Integer> values) {
            addCriterion("expect_phone_num in", values, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumNotIn(List<Integer> values) {
            addCriterion("expect_phone_num not in", values, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumBetween(Integer value1, Integer value2) {
            addCriterion("expect_phone_num between", value1, value2, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectPhoneNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_phone_num not between", value1, value2, "expectPhoneNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumIsNull() {
            addCriterion("expect_baqiang_num is null");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumIsNotNull() {
            addCriterion("expect_baqiang_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumEqualTo(Integer value) {
            addCriterion("expect_baqiang_num =", value, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumNotEqualTo(Integer value) {
            addCriterion("expect_baqiang_num <>", value, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumGreaterThan(Integer value) {
            addCriterion("expect_baqiang_num >", value, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_baqiang_num >=", value, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumLessThan(Integer value) {
            addCriterion("expect_baqiang_num <", value, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumLessThanOrEqualTo(Integer value) {
            addCriterion("expect_baqiang_num <=", value, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumIn(List<Integer> values) {
            addCriterion("expect_baqiang_num in", values, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumNotIn(List<Integer> values) {
            addCriterion("expect_baqiang_num not in", values, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumBetween(Integer value1, Integer value2) {
            addCriterion("expect_baqiang_num between", value1, value2, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectBaqiangNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_baqiang_num not between", value1, value2, "expectBaqiangNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumIsNull() {
            addCriterion("expect_storage_num is null");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumIsNotNull() {
            addCriterion("expect_storage_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumEqualTo(Integer value) {
            addCriterion("expect_storage_num =", value, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumNotEqualTo(Integer value) {
            addCriterion("expect_storage_num <>", value, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumGreaterThan(Integer value) {
            addCriterion("expect_storage_num >", value, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expect_storage_num >=", value, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumLessThan(Integer value) {
            addCriterion("expect_storage_num <", value, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumLessThanOrEqualTo(Integer value) {
            addCriterion("expect_storage_num <=", value, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumIn(List<Integer> values) {
            addCriterion("expect_storage_num in", values, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumNotIn(List<Integer> values) {
            addCriterion("expect_storage_num not in", values, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumBetween(Integer value1, Integer value2) {
            addCriterion("expect_storage_num between", value1, value2, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectStorageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expect_storage_num not between", value1, value2, "expectStorageNum");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoIsNull() {
            addCriterion("expect_other_info is null");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoIsNotNull() {
            addCriterion("expect_other_info is not null");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoEqualTo(String value) {
            addCriterion("expect_other_info =", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoNotEqualTo(String value) {
            addCriterion("expect_other_info <>", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoGreaterThan(String value) {
            addCriterion("expect_other_info >", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoGreaterThanOrEqualTo(String value) {
            addCriterion("expect_other_info >=", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoLessThan(String value) {
            addCriterion("expect_other_info <", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoLessThanOrEqualTo(String value) {
            addCriterion("expect_other_info <=", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoLike(String value) {
            addCriterion("expect_other_info like", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoNotLike(String value) {
            addCriterion("expect_other_info not like", value, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoIn(List<String> values) {
            addCriterion("expect_other_info in", values, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoNotIn(List<String> values) {
            addCriterion("expect_other_info not in", values, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoBetween(String value1, String value2) {
            addCriterion("expect_other_info between", value1, value2, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andExpectOtherInfoNotBetween(String value1, String value2) {
            addCriterion("expect_other_info not between", value1, value2, "expectOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoIsNull() {
            addCriterion("competitor_info is null");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoIsNotNull() {
            addCriterion("competitor_info is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoEqualTo(String value) {
            addCriterion("competitor_info =", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoNotEqualTo(String value) {
            addCriterion("competitor_info <>", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoGreaterThan(String value) {
            addCriterion("competitor_info >", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("competitor_info >=", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoLessThan(String value) {
            addCriterion("competitor_info <", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoLessThanOrEqualTo(String value) {
            addCriterion("competitor_info <=", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoLike(String value) {
            addCriterion("competitor_info like", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoNotLike(String value) {
            addCriterion("competitor_info not like", value, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoIn(List<String> values) {
            addCriterion("competitor_info in", values, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoNotIn(List<String> values) {
            addCriterion("competitor_info not in", values, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoBetween(String value1, String value2) {
            addCriterion("competitor_info between", value1, value2, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andCompetitorInfoNotBetween(String value1, String value2) {
            addCriterion("competitor_info not between", value1, value2, "competitorInfo");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerIsNull() {
            addCriterion("school_receive_retailer is null");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerIsNotNull() {
            addCriterion("school_receive_retailer is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerEqualTo(String value) {
            addCriterion("school_receive_retailer =", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerNotEqualTo(String value) {
            addCriterion("school_receive_retailer <>", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerGreaterThan(String value) {
            addCriterion("school_receive_retailer >", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerGreaterThanOrEqualTo(String value) {
            addCriterion("school_receive_retailer >=", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerLessThan(String value) {
            addCriterion("school_receive_retailer <", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerLessThanOrEqualTo(String value) {
            addCriterion("school_receive_retailer <=", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerLike(String value) {
            addCriterion("school_receive_retailer like", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerNotLike(String value) {
            addCriterion("school_receive_retailer not like", value, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerIn(List<String> values) {
            addCriterion("school_receive_retailer in", values, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerNotIn(List<String> values) {
            addCriterion("school_receive_retailer not in", values, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerBetween(String value1, String value2) {
            addCriterion("school_receive_retailer between", value1, value2, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveRetailerNotBetween(String value1, String value2) {
            addCriterion("school_receive_retailer not between", value1, value2, "schoolReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressIsNull() {
            addCriterion("school_receive_express is null");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressIsNotNull() {
            addCriterion("school_receive_express is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressEqualTo(String value) {
            addCriterion("school_receive_express =", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressNotEqualTo(String value) {
            addCriterion("school_receive_express <>", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressGreaterThan(String value) {
            addCriterion("school_receive_express >", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressGreaterThanOrEqualTo(String value) {
            addCriterion("school_receive_express >=", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressLessThan(String value) {
            addCriterion("school_receive_express <", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressLessThanOrEqualTo(String value) {
            addCriterion("school_receive_express <=", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressLike(String value) {
            addCriterion("school_receive_express like", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressNotLike(String value) {
            addCriterion("school_receive_express not like", value, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressIn(List<String> values) {
            addCriterion("school_receive_express in", values, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressNotIn(List<String> values) {
            addCriterion("school_receive_express not in", values, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressBetween(String value1, String value2) {
            addCriterion("school_receive_express between", value1, value2, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolReceiveExpressNotBetween(String value1, String value2) {
            addCriterion("school_receive_express not between", value1, value2, "schoolReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerIsNull() {
            addCriterion("school_dispatch_retailer is null");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerIsNotNull() {
            addCriterion("school_dispatch_retailer is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerEqualTo(String value) {
            addCriterion("school_dispatch_retailer =", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerNotEqualTo(String value) {
            addCriterion("school_dispatch_retailer <>", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerGreaterThan(String value) {
            addCriterion("school_dispatch_retailer >", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerGreaterThanOrEqualTo(String value) {
            addCriterion("school_dispatch_retailer >=", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerLessThan(String value) {
            addCriterion("school_dispatch_retailer <", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerLessThanOrEqualTo(String value) {
            addCriterion("school_dispatch_retailer <=", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerLike(String value) {
            addCriterion("school_dispatch_retailer like", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerNotLike(String value) {
            addCriterion("school_dispatch_retailer not like", value, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerIn(List<String> values) {
            addCriterion("school_dispatch_retailer in", values, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerNotIn(List<String> values) {
            addCriterion("school_dispatch_retailer not in", values, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerBetween(String value1, String value2) {
            addCriterion("school_dispatch_retailer between", value1, value2, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchRetailerNotBetween(String value1, String value2) {
            addCriterion("school_dispatch_retailer not between", value1, value2, "schoolDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressIsNull() {
            addCriterion("school_dispatch_express is null");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressIsNotNull() {
            addCriterion("school_dispatch_express is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressEqualTo(String value) {
            addCriterion("school_dispatch_express =", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressNotEqualTo(String value) {
            addCriterion("school_dispatch_express <>", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressGreaterThan(String value) {
            addCriterion("school_dispatch_express >", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressGreaterThanOrEqualTo(String value) {
            addCriterion("school_dispatch_express >=", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressLessThan(String value) {
            addCriterion("school_dispatch_express <", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressLessThanOrEqualTo(String value) {
            addCriterion("school_dispatch_express <=", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressLike(String value) {
            addCriterion("school_dispatch_express like", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressNotLike(String value) {
            addCriterion("school_dispatch_express not like", value, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressIn(List<String> values) {
            addCriterion("school_dispatch_express in", values, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressNotIn(List<String> values) {
            addCriterion("school_dispatch_express not in", values, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressBetween(String value1, String value2) {
            addCriterion("school_dispatch_express between", value1, value2, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andSchoolDispatchExpressNotBetween(String value1, String value2) {
            addCriterion("school_dispatch_express not between", value1, value2, "schoolDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerIsNull() {
            addCriterion("store_receive_retailer is null");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerIsNotNull() {
            addCriterion("store_receive_retailer is not null");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerEqualTo(String value) {
            addCriterion("store_receive_retailer =", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerNotEqualTo(String value) {
            addCriterion("store_receive_retailer <>", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerGreaterThan(String value) {
            addCriterion("store_receive_retailer >", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerGreaterThanOrEqualTo(String value) {
            addCriterion("store_receive_retailer >=", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerLessThan(String value) {
            addCriterion("store_receive_retailer <", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerLessThanOrEqualTo(String value) {
            addCriterion("store_receive_retailer <=", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerLike(String value) {
            addCriterion("store_receive_retailer like", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerNotLike(String value) {
            addCriterion("store_receive_retailer not like", value, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerIn(List<String> values) {
            addCriterion("store_receive_retailer in", values, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerNotIn(List<String> values) {
            addCriterion("store_receive_retailer not in", values, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerBetween(String value1, String value2) {
            addCriterion("store_receive_retailer between", value1, value2, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveRetailerNotBetween(String value1, String value2) {
            addCriterion("store_receive_retailer not between", value1, value2, "storeReceiveRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressIsNull() {
            addCriterion("store_receive_express is null");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressIsNotNull() {
            addCriterion("store_receive_express is not null");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressEqualTo(String value) {
            addCriterion("store_receive_express =", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressNotEqualTo(String value) {
            addCriterion("store_receive_express <>", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressGreaterThan(String value) {
            addCriterion("store_receive_express >", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressGreaterThanOrEqualTo(String value) {
            addCriterion("store_receive_express >=", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressLessThan(String value) {
            addCriterion("store_receive_express <", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressLessThanOrEqualTo(String value) {
            addCriterion("store_receive_express <=", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressLike(String value) {
            addCriterion("store_receive_express like", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressNotLike(String value) {
            addCriterion("store_receive_express not like", value, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressIn(List<String> values) {
            addCriterion("store_receive_express in", values, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressNotIn(List<String> values) {
            addCriterion("store_receive_express not in", values, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressBetween(String value1, String value2) {
            addCriterion("store_receive_express between", value1, value2, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreReceiveExpressNotBetween(String value1, String value2) {
            addCriterion("store_receive_express not between", value1, value2, "storeReceiveExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerIsNull() {
            addCriterion("store_dispatch_retailer is null");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerIsNotNull() {
            addCriterion("store_dispatch_retailer is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerEqualTo(String value) {
            addCriterion("store_dispatch_retailer =", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerNotEqualTo(String value) {
            addCriterion("store_dispatch_retailer <>", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerGreaterThan(String value) {
            addCriterion("store_dispatch_retailer >", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerGreaterThanOrEqualTo(String value) {
            addCriterion("store_dispatch_retailer >=", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerLessThan(String value) {
            addCriterion("store_dispatch_retailer <", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerLessThanOrEqualTo(String value) {
            addCriterion("store_dispatch_retailer <=", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerLike(String value) {
            addCriterion("store_dispatch_retailer like", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerNotLike(String value) {
            addCriterion("store_dispatch_retailer not like", value, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerIn(List<String> values) {
            addCriterion("store_dispatch_retailer in", values, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerNotIn(List<String> values) {
            addCriterion("store_dispatch_retailer not in", values, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerBetween(String value1, String value2) {
            addCriterion("store_dispatch_retailer between", value1, value2, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchRetailerNotBetween(String value1, String value2) {
            addCriterion("store_dispatch_retailer not between", value1, value2, "storeDispatchRetailer");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressIsNull() {
            addCriterion("store_dispatch_express is null");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressIsNotNull() {
            addCriterion("store_dispatch_express is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressEqualTo(String value) {
            addCriterion("store_dispatch_express =", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressNotEqualTo(String value) {
            addCriterion("store_dispatch_express <>", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressGreaterThan(String value) {
            addCriterion("store_dispatch_express >", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressGreaterThanOrEqualTo(String value) {
            addCriterion("store_dispatch_express >=", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressLessThan(String value) {
            addCriterion("store_dispatch_express <", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressLessThanOrEqualTo(String value) {
            addCriterion("store_dispatch_express <=", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressLike(String value) {
            addCriterion("store_dispatch_express like", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressNotLike(String value) {
            addCriterion("store_dispatch_express not like", value, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressIn(List<String> values) {
            addCriterion("store_dispatch_express in", values, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressNotIn(List<String> values) {
            addCriterion("store_dispatch_express not in", values, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressBetween(String value1, String value2) {
            addCriterion("store_dispatch_express between", value1, value2, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStoreDispatchExpressNotBetween(String value1, String value2) {
            addCriterion("store_dispatch_express not between", value1, value2, "storeDispatchExpress");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andRentFeeIsNull() {
            addCriterion("rent_fee is null");
            return (Criteria) this;
        }

        public Criteria andRentFeeIsNotNull() {
            addCriterion("rent_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRentFeeEqualTo(Integer value) {
            addCriterion("rent_fee =", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotEqualTo(Integer value) {
            addCriterion("rent_fee <>", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeGreaterThan(Integer value) {
            addCriterion("rent_fee >", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_fee >=", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLessThan(Integer value) {
            addCriterion("rent_fee <", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLessThanOrEqualTo(Integer value) {
            addCriterion("rent_fee <=", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeIn(List<Integer> values) {
            addCriterion("rent_fee in", values, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotIn(List<Integer> values) {
            addCriterion("rent_fee not in", values, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeBetween(Integer value1, Integer value2) {
            addCriterion("rent_fee between", value1, value2, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_fee not between", value1, value2, "rentFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeIsNull() {
            addCriterion("transfer_fee is null");
            return (Criteria) this;
        }

        public Criteria andTransferFeeIsNotNull() {
            addCriterion("transfer_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTransferFeeEqualTo(Integer value) {
            addCriterion("transfer_fee =", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeNotEqualTo(Integer value) {
            addCriterion("transfer_fee <>", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeGreaterThan(Integer value) {
            addCriterion("transfer_fee >", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_fee >=", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeLessThan(Integer value) {
            addCriterion("transfer_fee <", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_fee <=", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeIn(List<Integer> values) {
            addCriterion("transfer_fee in", values, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeNotIn(List<Integer> values) {
            addCriterion("transfer_fee not in", values, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeBetween(Integer value1, Integer value2) {
            addCriterion("transfer_fee between", value1, value2, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_fee not between", value1, value2, "transferFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeIsNull() {
            addCriterion("deposit_fee is null");
            return (Criteria) this;
        }

        public Criteria andDepositFeeIsNotNull() {
            addCriterion("deposit_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDepositFeeEqualTo(Integer value) {
            addCriterion("deposit_fee =", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeNotEqualTo(Integer value) {
            addCriterion("deposit_fee <>", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeGreaterThan(Integer value) {
            addCriterion("deposit_fee >", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deposit_fee >=", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeLessThan(Integer value) {
            addCriterion("deposit_fee <", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeLessThanOrEqualTo(Integer value) {
            addCriterion("deposit_fee <=", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeIn(List<Integer> values) {
            addCriterion("deposit_fee in", values, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeNotIn(List<Integer> values) {
            addCriterion("deposit_fee not in", values, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeBetween(Integer value1, Integer value2) {
            addCriterion("deposit_fee between", value1, value2, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("deposit_fee not between", value1, value2, "depositFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIsNull() {
            addCriterion("other_fee is null");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIsNotNull() {
            addCriterion("other_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFeeEqualTo(String value) {
            addCriterion("other_fee =", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotEqualTo(String value) {
            addCriterion("other_fee <>", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeGreaterThan(String value) {
            addCriterion("other_fee >", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeGreaterThanOrEqualTo(String value) {
            addCriterion("other_fee >=", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLessThan(String value) {
            addCriterion("other_fee <", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLessThanOrEqualTo(String value) {
            addCriterion("other_fee <=", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLike(String value) {
            addCriterion("other_fee like", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotLike(String value) {
            addCriterion("other_fee not like", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIn(List<String> values) {
            addCriterion("other_fee in", values, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotIn(List<String> values) {
            addCriterion("other_fee not in", values, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeBetween(String value1, String value2) {
            addCriterion("other_fee between", value1, value2, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotBetween(String value1, String value2) {
            addCriterion("other_fee not between", value1, value2, "otherFee");
            return (Criteria) this;
        }

        public Criteria andDivideModelIsNull() {
            addCriterion("divide_model is null");
            return (Criteria) this;
        }

        public Criteria andDivideModelIsNotNull() {
            addCriterion("divide_model is not null");
            return (Criteria) this;
        }

        public Criteria andDivideModelEqualTo(String value) {
            addCriterion("divide_model =", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelNotEqualTo(String value) {
            addCriterion("divide_model <>", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelGreaterThan(String value) {
            addCriterion("divide_model >", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelGreaterThanOrEqualTo(String value) {
            addCriterion("divide_model >=", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelLessThan(String value) {
            addCriterion("divide_model <", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelLessThanOrEqualTo(String value) {
            addCriterion("divide_model <=", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelLike(String value) {
            addCriterion("divide_model like", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelNotLike(String value) {
            addCriterion("divide_model not like", value, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelIn(List<String> values) {
            addCriterion("divide_model in", values, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelNotIn(List<String> values) {
            addCriterion("divide_model not in", values, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelBetween(String value1, String value2) {
            addCriterion("divide_model between", value1, value2, "divideModel");
            return (Criteria) this;
        }

        public Criteria andDivideModelNotBetween(String value1, String value2) {
            addCriterion("divide_model not between", value1, value2, "divideModel");
            return (Criteria) this;
        }

        public Criteria andProfitInfoIsNull() {
            addCriterion("profit_info is null");
            return (Criteria) this;
        }

        public Criteria andProfitInfoIsNotNull() {
            addCriterion("profit_info is not null");
            return (Criteria) this;
        }

        public Criteria andProfitInfoEqualTo(String value) {
            addCriterion("profit_info =", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotEqualTo(String value) {
            addCriterion("profit_info <>", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoGreaterThan(String value) {
            addCriterion("profit_info >", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoGreaterThanOrEqualTo(String value) {
            addCriterion("profit_info >=", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoLessThan(String value) {
            addCriterion("profit_info <", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoLessThanOrEqualTo(String value) {
            addCriterion("profit_info <=", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoLike(String value) {
            addCriterion("profit_info like", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotLike(String value) {
            addCriterion("profit_info not like", value, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoIn(List<String> values) {
            addCriterion("profit_info in", values, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotIn(List<String> values) {
            addCriterion("profit_info not in", values, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoBetween(String value1, String value2) {
            addCriterion("profit_info between", value1, value2, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andProfitInfoNotBetween(String value1, String value2) {
            addCriterion("profit_info not between", value1, value2, "profitInfo");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsIsNull() {
            addCriterion("school_door_picIds is null");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsIsNotNull() {
            addCriterion("school_door_picIds is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsEqualTo(String value) {
            addCriterion("school_door_picIds =", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsNotEqualTo(String value) {
            addCriterion("school_door_picIds <>", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsGreaterThan(String value) {
            addCriterion("school_door_picIds >", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsGreaterThanOrEqualTo(String value) {
            addCriterion("school_door_picIds >=", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsLessThan(String value) {
            addCriterion("school_door_picIds <", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsLessThanOrEqualTo(String value) {
            addCriterion("school_door_picIds <=", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsLike(String value) {
            addCriterion("school_door_picIds like", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsNotLike(String value) {
            addCriterion("school_door_picIds not like", value, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsIn(List<String> values) {
            addCriterion("school_door_picIds in", values, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsNotIn(List<String> values) {
            addCriterion("school_door_picIds not in", values, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsBetween(String value1, String value2) {
            addCriterion("school_door_picIds between", value1, value2, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolDoorPicidsNotBetween(String value1, String value2) {
            addCriterion("school_door_picIds not between", value1, value2, "schoolDoorPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsIsNull() {
            addCriterion("school_surround_picIds is null");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsIsNotNull() {
            addCriterion("school_surround_picIds is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsEqualTo(String value) {
            addCriterion("school_surround_picIds =", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsNotEqualTo(String value) {
            addCriterion("school_surround_picIds <>", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsGreaterThan(String value) {
            addCriterion("school_surround_picIds >", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsGreaterThanOrEqualTo(String value) {
            addCriterion("school_surround_picIds >=", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsLessThan(String value) {
            addCriterion("school_surround_picIds <", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsLessThanOrEqualTo(String value) {
            addCriterion("school_surround_picIds <=", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsLike(String value) {
            addCriterion("school_surround_picIds like", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsNotLike(String value) {
            addCriterion("school_surround_picIds not like", value, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsIn(List<String> values) {
            addCriterion("school_surround_picIds in", values, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsNotIn(List<String> values) {
            addCriterion("school_surround_picIds not in", values, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsBetween(String value1, String value2) {
            addCriterion("school_surround_picIds between", value1, value2, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andSchoolSurroundPicidsNotBetween(String value1, String value2) {
            addCriterion("school_surround_picIds not between", value1, value2, "schoolSurroundPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsIsNull() {
            addCriterion("store_door_picIds is null");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsIsNotNull() {
            addCriterion("store_door_picIds is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsEqualTo(String value) {
            addCriterion("store_door_picIds =", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsNotEqualTo(String value) {
            addCriterion("store_door_picIds <>", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsGreaterThan(String value) {
            addCriterion("store_door_picIds >", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsGreaterThanOrEqualTo(String value) {
            addCriterion("store_door_picIds >=", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsLessThan(String value) {
            addCriterion("store_door_picIds <", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsLessThanOrEqualTo(String value) {
            addCriterion("store_door_picIds <=", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsLike(String value) {
            addCriterion("store_door_picIds like", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsNotLike(String value) {
            addCriterion("store_door_picIds not like", value, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsIn(List<String> values) {
            addCriterion("store_door_picIds in", values, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsNotIn(List<String> values) {
            addCriterion("store_door_picIds not in", values, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsBetween(String value1, String value2) {
            addCriterion("store_door_picIds between", value1, value2, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreDoorPicidsNotBetween(String value1, String value2) {
            addCriterion("store_door_picIds not between", value1, value2, "storeDoorPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsIsNull() {
            addCriterion("store_inner_picIds is null");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsIsNotNull() {
            addCriterion("store_inner_picIds is not null");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsEqualTo(String value) {
            addCriterion("store_inner_picIds =", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsNotEqualTo(String value) {
            addCriterion("store_inner_picIds <>", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsGreaterThan(String value) {
            addCriterion("store_inner_picIds >", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsGreaterThanOrEqualTo(String value) {
            addCriterion("store_inner_picIds >=", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsLessThan(String value) {
            addCriterion("store_inner_picIds <", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsLessThanOrEqualTo(String value) {
            addCriterion("store_inner_picIds <=", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsLike(String value) {
            addCriterion("store_inner_picIds like", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsNotLike(String value) {
            addCriterion("store_inner_picIds not like", value, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsIn(List<String> values) {
            addCriterion("store_inner_picIds in", values, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsNotIn(List<String> values) {
            addCriterion("store_inner_picIds not in", values, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsBetween(String value1, String value2) {
            addCriterion("store_inner_picIds between", value1, value2, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreInnerPicidsNotBetween(String value1, String value2) {
            addCriterion("store_inner_picIds not between", value1, value2, "storeInnerPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsIsNull() {
            addCriterion("store_model_picIds is null");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsIsNotNull() {
            addCriterion("store_model_picIds is not null");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsEqualTo(String value) {
            addCriterion("store_model_picIds =", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsNotEqualTo(String value) {
            addCriterion("store_model_picIds <>", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsGreaterThan(String value) {
            addCriterion("store_model_picIds >", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsGreaterThanOrEqualTo(String value) {
            addCriterion("store_model_picIds >=", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsLessThan(String value) {
            addCriterion("store_model_picIds <", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsLessThanOrEqualTo(String value) {
            addCriterion("store_model_picIds <=", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsLike(String value) {
            addCriterion("store_model_picIds like", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsNotLike(String value) {
            addCriterion("store_model_picIds not like", value, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsIn(List<String> values) {
            addCriterion("store_model_picIds in", values, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsNotIn(List<String> values) {
            addCriterion("store_model_picIds not in", values, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsBetween(String value1, String value2) {
            addCriterion("store_model_picIds between", value1, value2, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andStoreModelPicidsNotBetween(String value1, String value2) {
            addCriterion("store_model_picIds not between", value1, value2, "storeModelPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsIsNull() {
            addCriterion("other_picIds is null");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsIsNotNull() {
            addCriterion("other_picIds is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsEqualTo(String value) {
            addCriterion("other_picIds =", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsNotEqualTo(String value) {
            addCriterion("other_picIds <>", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsGreaterThan(String value) {
            addCriterion("other_picIds >", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsGreaterThanOrEqualTo(String value) {
            addCriterion("other_picIds >=", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsLessThan(String value) {
            addCriterion("other_picIds <", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsLessThanOrEqualTo(String value) {
            addCriterion("other_picIds <=", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsLike(String value) {
            addCriterion("other_picIds like", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsNotLike(String value) {
            addCriterion("other_picIds not like", value, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsIn(List<String> values) {
            addCriterion("other_picIds in", values, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsNotIn(List<String> values) {
            addCriterion("other_picIds not in", values, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsBetween(String value1, String value2) {
            addCriterion("other_picIds between", value1, value2, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andOtherPicidsNotBetween(String value1, String value2) {
            addCriterion("other_picIds not between", value1, value2, "otherPicids");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNull() {
            addCriterion("create_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNotNull() {
            addCriterion("create_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdEqualTo(Integer value) {
            addCriterion("create_staff_id =", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotEqualTo(Integer value) {
            addCriterion("create_staff_id <>", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThan(Integer value) {
            addCriterion("create_staff_id >", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_staff_id >=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThan(Integer value) {
            addCriterion("create_staff_id <", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_staff_id <=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIn(List<Integer> values) {
            addCriterion("create_staff_id in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotIn(List<Integer> values) {
            addCriterion("create_staff_id not in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("create_staff_id between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_staff_id not between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andCityLevelIsNull() {
            addCriterion("city_level is null");
            return (Criteria) this;
        }

        public Criteria andCityLevelIsNotNull() {
            addCriterion("city_level is not null");
            return (Criteria) this;
        }

        public Criteria andCityLevelEqualTo(Byte value) {
            addCriterion("city_level =", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotEqualTo(Byte value) {
            addCriterion("city_level <>", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelGreaterThan(Byte value) {
            addCriterion("city_level >", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("city_level >=", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelLessThan(Byte value) {
            addCriterion("city_level <", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelLessThanOrEqualTo(Byte value) {
            addCriterion("city_level <=", value, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelIn(List<Byte> values) {
            addCriterion("city_level in", values, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotIn(List<Byte> values) {
            addCriterion("city_level not in", values, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelBetween(Byte value1, Byte value2) {
            addCriterion("city_level between", value1, value2, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andCityLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("city_level not between", value1, value2, "cityLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelIsNull() {
            addCriterion("school_level is null");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelIsNotNull() {
            addCriterion("school_level is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelEqualTo(Byte value) {
            addCriterion("school_level =", value, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelNotEqualTo(Byte value) {
            addCriterion("school_level <>", value, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelGreaterThan(Byte value) {
            addCriterion("school_level >", value, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("school_level >=", value, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelLessThan(Byte value) {
            addCriterion("school_level <", value, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelLessThanOrEqualTo(Byte value) {
            addCriterion("school_level <=", value, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelIn(List<Byte> values) {
            addCriterion("school_level in", values, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelNotIn(List<Byte> values) {
            addCriterion("school_level not in", values, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelBetween(Byte value1, Byte value2) {
            addCriterion("school_level between", value1, value2, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("school_level not between", value1, value2, "schoolLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumIsNull() {
            addCriterion("school_person_num is null");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumIsNotNull() {
            addCriterion("school_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumEqualTo(Integer value) {
            addCriterion("school_person_num =", value, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumNotEqualTo(Integer value) {
            addCriterion("school_person_num <>", value, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumGreaterThan(Integer value) {
            addCriterion("school_person_num >", value, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_person_num >=", value, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumLessThan(Integer value) {
            addCriterion("school_person_num <", value, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumLessThanOrEqualTo(Integer value) {
            addCriterion("school_person_num <=", value, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumIn(List<Integer> values) {
            addCriterion("school_person_num in", values, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumNotIn(List<Integer> values) {
            addCriterion("school_person_num not in", values, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumBetween(Integer value1, Integer value2) {
            addCriterion("school_person_num between", value1, value2, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andSchoolPersonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("school_person_num not between", value1, value2, "schoolPersonNum");
            return (Criteria) this;
        }

        public Criteria andManWomenIsNull() {
            addCriterion("man_women is null");
            return (Criteria) this;
        }

        public Criteria andManWomenIsNotNull() {
            addCriterion("man_women is not null");
            return (Criteria) this;
        }

        public Criteria andManWomenEqualTo(String value) {
            addCriterion("man_women =", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenNotEqualTo(String value) {
            addCriterion("man_women <>", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenGreaterThan(String value) {
            addCriterion("man_women >", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenGreaterThanOrEqualTo(String value) {
            addCriterion("man_women >=", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenLessThan(String value) {
            addCriterion("man_women <", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenLessThanOrEqualTo(String value) {
            addCriterion("man_women <=", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenLike(String value) {
            addCriterion("man_women like", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenNotLike(String value) {
            addCriterion("man_women not like", value, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenIn(List<String> values) {
            addCriterion("man_women in", values, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenNotIn(List<String> values) {
            addCriterion("man_women not in", values, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenBetween(String value1, String value2) {
            addCriterion("man_women between", value1, value2, "manWomen");
            return (Criteria) this;
        }

        public Criteria andManWomenNotBetween(String value1, String value2) {
            addCriterion("man_women not between", value1, value2, "manWomen");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceIsNull() {
            addCriterion("school_space is null");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceIsNotNull() {
            addCriterion("school_space is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceEqualTo(Integer value) {
            addCriterion("school_space =", value, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceNotEqualTo(Integer value) {
            addCriterion("school_space <>", value, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceGreaterThan(Integer value) {
            addCriterion("school_space >", value, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_space >=", value, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceLessThan(Integer value) {
            addCriterion("school_space <", value, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("school_space <=", value, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceIn(List<Integer> values) {
            addCriterion("school_space in", values, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceNotIn(List<Integer> values) {
            addCriterion("school_space not in", values, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceBetween(Integer value1, Integer value2) {
            addCriterion("school_space between", value1, value2, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andSchoolSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("school_space not between", value1, value2, "schoolSpace");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdIsNull() {
            addCriterion("update_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdIsNotNull() {
            addCriterion("update_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdEqualTo(Integer value) {
            addCriterion("update_staff_id =", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdNotEqualTo(Integer value) {
            addCriterion("update_staff_id <>", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdGreaterThan(Integer value) {
            addCriterion("update_staff_id >", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_staff_id >=", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdLessThan(Integer value) {
            addCriterion("update_staff_id <", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_staff_id <=", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdIn(List<Integer> values) {
            addCriterion("update_staff_id in", values, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdNotIn(List<Integer> values) {
            addCriterion("update_staff_id not in", values, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("update_staff_id between", value1, value2, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_staff_id not between", value1, value2, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}