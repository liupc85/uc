package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpressPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpressPriceExample() {
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

        public Criteria andExpressidIsNull() {
            addCriterion("expressId is null");
            return (Criteria) this;
        }

        public Criteria andExpressidIsNotNull() {
            addCriterion("expressId is not null");
            return (Criteria) this;
        }

        public Criteria andExpressidEqualTo(Integer value) {
            addCriterion("expressId =", value, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidNotEqualTo(Integer value) {
            addCriterion("expressId <>", value, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidGreaterThan(Integer value) {
            addCriterion("expressId >", value, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidGreaterThanOrEqualTo(Integer value) {
            addCriterion("expressId >=", value, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidLessThan(Integer value) {
            addCriterion("expressId <", value, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidLessThanOrEqualTo(Integer value) {
            addCriterion("expressId <=", value, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidIn(List<Integer> values) {
            addCriterion("expressId in", values, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidNotIn(List<Integer> values) {
            addCriterion("expressId not in", values, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidBetween(Integer value1, Integer value2) {
            addCriterion("expressId between", value1, value2, "expressid");
            return (Criteria) this;
        }

        public Criteria andExpressidNotBetween(Integer value1, Integer value2) {
            addCriterion("expressId not between", value1, value2, "expressid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidIsNull() {
            addCriterion("sourceProvinceId is null");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidIsNotNull() {
            addCriterion("sourceProvinceId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidEqualTo(Integer value) {
            addCriterion("sourceProvinceId =", value, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidNotEqualTo(Integer value) {
            addCriterion("sourceProvinceId <>", value, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidGreaterThan(Integer value) {
            addCriterion("sourceProvinceId >", value, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceProvinceId >=", value, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidLessThan(Integer value) {
            addCriterion("sourceProvinceId <", value, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidLessThanOrEqualTo(Integer value) {
            addCriterion("sourceProvinceId <=", value, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidIn(List<Integer> values) {
            addCriterion("sourceProvinceId in", values, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidNotIn(List<Integer> values) {
            addCriterion("sourceProvinceId not in", values, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidBetween(Integer value1, Integer value2) {
            addCriterion("sourceProvinceId between", value1, value2, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourceprovinceidNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceProvinceId not between", value1, value2, "sourceprovinceid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidIsNull() {
            addCriterion("sourceCityId is null");
            return (Criteria) this;
        }

        public Criteria andSourcecityidIsNotNull() {
            addCriterion("sourceCityId is not null");
            return (Criteria) this;
        }

        public Criteria andSourcecityidEqualTo(Integer value) {
            addCriterion("sourceCityId =", value, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidNotEqualTo(Integer value) {
            addCriterion("sourceCityId <>", value, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidGreaterThan(Integer value) {
            addCriterion("sourceCityId >", value, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceCityId >=", value, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidLessThan(Integer value) {
            addCriterion("sourceCityId <", value, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidLessThanOrEqualTo(Integer value) {
            addCriterion("sourceCityId <=", value, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidIn(List<Integer> values) {
            addCriterion("sourceCityId in", values, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidNotIn(List<Integer> values) {
            addCriterion("sourceCityId not in", values, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidBetween(Integer value1, Integer value2) {
            addCriterion("sourceCityId between", value1, value2, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourcecityidNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceCityId not between", value1, value2, "sourcecityid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidIsNull() {
            addCriterion("sourceAreaId is null");
            return (Criteria) this;
        }

        public Criteria andSourceareaidIsNotNull() {
            addCriterion("sourceAreaId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceareaidEqualTo(Integer value) {
            addCriterion("sourceAreaId =", value, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidNotEqualTo(Integer value) {
            addCriterion("sourceAreaId <>", value, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidGreaterThan(Integer value) {
            addCriterion("sourceAreaId >", value, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceAreaId >=", value, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidLessThan(Integer value) {
            addCriterion("sourceAreaId <", value, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidLessThanOrEqualTo(Integer value) {
            addCriterion("sourceAreaId <=", value, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidIn(List<Integer> values) {
            addCriterion("sourceAreaId in", values, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidNotIn(List<Integer> values) {
            addCriterion("sourceAreaId not in", values, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidBetween(Integer value1, Integer value2) {
            addCriterion("sourceAreaId between", value1, value2, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourceareaidNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceAreaId not between", value1, value2, "sourceareaid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidIsNull() {
            addCriterion("sourceStoreId is null");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidIsNotNull() {
            addCriterion("sourceStoreId is not null");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidEqualTo(Integer value) {
            addCriterion("sourceStoreId =", value, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidNotEqualTo(Integer value) {
            addCriterion("sourceStoreId <>", value, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidGreaterThan(Integer value) {
            addCriterion("sourceStoreId >", value, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceStoreId >=", value, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidLessThan(Integer value) {
            addCriterion("sourceStoreId <", value, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidLessThanOrEqualTo(Integer value) {
            addCriterion("sourceStoreId <=", value, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidIn(List<Integer> values) {
            addCriterion("sourceStoreId in", values, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidNotIn(List<Integer> values) {
            addCriterion("sourceStoreId not in", values, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidBetween(Integer value1, Integer value2) {
            addCriterion("sourceStoreId between", value1, value2, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andSourcestoreidNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceStoreId not between", value1, value2, "sourcestoreid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidIsNull() {
            addCriterion("targetProvinceId is null");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidIsNotNull() {
            addCriterion("targetProvinceId is not null");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidEqualTo(Integer value) {
            addCriterion("targetProvinceId =", value, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidNotEqualTo(Integer value) {
            addCriterion("targetProvinceId <>", value, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidGreaterThan(Integer value) {
            addCriterion("targetProvinceId >", value, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("targetProvinceId >=", value, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidLessThan(Integer value) {
            addCriterion("targetProvinceId <", value, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidLessThanOrEqualTo(Integer value) {
            addCriterion("targetProvinceId <=", value, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidIn(List<Integer> values) {
            addCriterion("targetProvinceId in", values, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidNotIn(List<Integer> values) {
            addCriterion("targetProvinceId not in", values, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidBetween(Integer value1, Integer value2) {
            addCriterion("targetProvinceId between", value1, value2, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetprovinceidNotBetween(Integer value1, Integer value2) {
            addCriterion("targetProvinceId not between", value1, value2, "targetprovinceid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidIsNull() {
            addCriterion("targetCityId is null");
            return (Criteria) this;
        }

        public Criteria andTargetcityidIsNotNull() {
            addCriterion("targetCityId is not null");
            return (Criteria) this;
        }

        public Criteria andTargetcityidEqualTo(Integer value) {
            addCriterion("targetCityId =", value, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidNotEqualTo(Integer value) {
            addCriterion("targetCityId <>", value, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidGreaterThan(Integer value) {
            addCriterion("targetCityId >", value, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("targetCityId >=", value, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidLessThan(Integer value) {
            addCriterion("targetCityId <", value, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidLessThanOrEqualTo(Integer value) {
            addCriterion("targetCityId <=", value, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidIn(List<Integer> values) {
            addCriterion("targetCityId in", values, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidNotIn(List<Integer> values) {
            addCriterion("targetCityId not in", values, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidBetween(Integer value1, Integer value2) {
            addCriterion("targetCityId between", value1, value2, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetcityidNotBetween(Integer value1, Integer value2) {
            addCriterion("targetCityId not between", value1, value2, "targetcityid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidIsNull() {
            addCriterion("targetAreaId is null");
            return (Criteria) this;
        }

        public Criteria andTargetareaidIsNotNull() {
            addCriterion("targetAreaId is not null");
            return (Criteria) this;
        }

        public Criteria andTargetareaidEqualTo(Integer value) {
            addCriterion("targetAreaId =", value, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidNotEqualTo(Integer value) {
            addCriterion("targetAreaId <>", value, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidGreaterThan(Integer value) {
            addCriterion("targetAreaId >", value, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("targetAreaId >=", value, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidLessThan(Integer value) {
            addCriterion("targetAreaId <", value, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidLessThanOrEqualTo(Integer value) {
            addCriterion("targetAreaId <=", value, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidIn(List<Integer> values) {
            addCriterion("targetAreaId in", values, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidNotIn(List<Integer> values) {
            addCriterion("targetAreaId not in", values, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidBetween(Integer value1, Integer value2) {
            addCriterion("targetAreaId between", value1, value2, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetareaidNotBetween(Integer value1, Integer value2) {
            addCriterion("targetAreaId not between", value1, value2, "targetareaid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidIsNull() {
            addCriterion("targetStoreId is null");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidIsNotNull() {
            addCriterion("targetStoreId is not null");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidEqualTo(Integer value) {
            addCriterion("targetStoreId =", value, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidNotEqualTo(Integer value) {
            addCriterion("targetStoreId <>", value, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidGreaterThan(Integer value) {
            addCriterion("targetStoreId >", value, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("targetStoreId >=", value, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidLessThan(Integer value) {
            addCriterion("targetStoreId <", value, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidLessThanOrEqualTo(Integer value) {
            addCriterion("targetStoreId <=", value, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidIn(List<Integer> values) {
            addCriterion("targetStoreId in", values, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidNotIn(List<Integer> values) {
            addCriterion("targetStoreId not in", values, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidBetween(Integer value1, Integer value2) {
            addCriterion("targetStoreId between", value1, value2, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andTargetstoreidNotBetween(Integer value1, Integer value2) {
            addCriterion("targetStoreId not between", value1, value2, "targetstoreid");
            return (Criteria) this;
        }

        public Criteria andPrice1IsNull() {
            addCriterion("price1 is null");
            return (Criteria) this;
        }

        public Criteria andPrice1IsNotNull() {
            addCriterion("price1 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice1EqualTo(Integer value) {
            addCriterion("price1 =", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotEqualTo(Integer value) {
            addCriterion("price1 <>", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1GreaterThan(Integer value) {
            addCriterion("price1 >", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1GreaterThanOrEqualTo(Integer value) {
            addCriterion("price1 >=", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1LessThan(Integer value) {
            addCriterion("price1 <", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1LessThanOrEqualTo(Integer value) {
            addCriterion("price1 <=", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1In(List<Integer> values) {
            addCriterion("price1 in", values, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotIn(List<Integer> values) {
            addCriterion("price1 not in", values, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1Between(Integer value1, Integer value2) {
            addCriterion("price1 between", value1, value2, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotBetween(Integer value1, Integer value2) {
            addCriterion("price1 not between", value1, value2, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice2IsNull() {
            addCriterion("price2 is null");
            return (Criteria) this;
        }

        public Criteria andPrice2IsNotNull() {
            addCriterion("price2 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice2EqualTo(Integer value) {
            addCriterion("price2 =", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2NotEqualTo(Integer value) {
            addCriterion("price2 <>", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2GreaterThan(Integer value) {
            addCriterion("price2 >", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2GreaterThanOrEqualTo(Integer value) {
            addCriterion("price2 >=", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2LessThan(Integer value) {
            addCriterion("price2 <", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2LessThanOrEqualTo(Integer value) {
            addCriterion("price2 <=", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2In(List<Integer> values) {
            addCriterion("price2 in", values, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2NotIn(List<Integer> values) {
            addCriterion("price2 not in", values, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2Between(Integer value1, Integer value2) {
            addCriterion("price2 between", value1, value2, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2NotBetween(Integer value1, Integer value2) {
            addCriterion("price2 not between", value1, value2, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice3IsNull() {
            addCriterion("price3 is null");
            return (Criteria) this;
        }

        public Criteria andPrice3IsNotNull() {
            addCriterion("price3 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice3EqualTo(Integer value) {
            addCriterion("price3 =", value, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3NotEqualTo(Integer value) {
            addCriterion("price3 <>", value, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3GreaterThan(Integer value) {
            addCriterion("price3 >", value, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3GreaterThanOrEqualTo(Integer value) {
            addCriterion("price3 >=", value, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3LessThan(Integer value) {
            addCriterion("price3 <", value, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3LessThanOrEqualTo(Integer value) {
            addCriterion("price3 <=", value, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3In(List<Integer> values) {
            addCriterion("price3 in", values, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3NotIn(List<Integer> values) {
            addCriterion("price3 not in", values, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3Between(Integer value1, Integer value2) {
            addCriterion("price3 between", value1, value2, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice3NotBetween(Integer value1, Integer value2) {
            addCriterion("price3 not between", value1, value2, "price3");
            return (Criteria) this;
        }

        public Criteria andPrice4IsNull() {
            addCriterion("price4 is null");
            return (Criteria) this;
        }

        public Criteria andPrice4IsNotNull() {
            addCriterion("price4 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice4EqualTo(Integer value) {
            addCriterion("price4 =", value, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4NotEqualTo(Integer value) {
            addCriterion("price4 <>", value, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4GreaterThan(Integer value) {
            addCriterion("price4 >", value, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4GreaterThanOrEqualTo(Integer value) {
            addCriterion("price4 >=", value, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4LessThan(Integer value) {
            addCriterion("price4 <", value, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4LessThanOrEqualTo(Integer value) {
            addCriterion("price4 <=", value, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4In(List<Integer> values) {
            addCriterion("price4 in", values, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4NotIn(List<Integer> values) {
            addCriterion("price4 not in", values, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4Between(Integer value1, Integer value2) {
            addCriterion("price4 between", value1, value2, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice4NotBetween(Integer value1, Integer value2) {
            addCriterion("price4 not between", value1, value2, "price4");
            return (Criteria) this;
        }

        public Criteria andPrice5IsNull() {
            addCriterion("price5 is null");
            return (Criteria) this;
        }

        public Criteria andPrice5IsNotNull() {
            addCriterion("price5 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice5EqualTo(Integer value) {
            addCriterion("price5 =", value, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5NotEqualTo(Integer value) {
            addCriterion("price5 <>", value, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5GreaterThan(Integer value) {
            addCriterion("price5 >", value, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5GreaterThanOrEqualTo(Integer value) {
            addCriterion("price5 >=", value, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5LessThan(Integer value) {
            addCriterion("price5 <", value, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5LessThanOrEqualTo(Integer value) {
            addCriterion("price5 <=", value, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5In(List<Integer> values) {
            addCriterion("price5 in", values, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5NotIn(List<Integer> values) {
            addCriterion("price5 not in", values, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5Between(Integer value1, Integer value2) {
            addCriterion("price5 between", value1, value2, "price5");
            return (Criteria) this;
        }

        public Criteria andPrice5NotBetween(Integer value1, Integer value2) {
            addCriterion("price5 not between", value1, value2, "price5");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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