package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNull() {
            addCriterion("license is null");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNotNull() {
            addCriterion("license is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseEqualTo(String value) {
            addCriterion("license =", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotEqualTo(String value) {
            addCriterion("license <>", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThan(String value) {
            addCriterion("license >", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("license >=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThan(String value) {
            addCriterion("license <", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThanOrEqualTo(String value) {
            addCriterion("license <=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLike(String value) {
            addCriterion("license like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotLike(String value) {
            addCriterion("license not like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseIn(List<String> values) {
            addCriterion("license in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotIn(List<String> values) {
            addCriterion("license not in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseBetween(String value1, String value2) {
            addCriterion("license between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotBetween(String value1, String value2) {
            addCriterion("license not between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumIsNull() {
            addCriterion("license_activate_num is null");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumIsNotNull() {
            addCriterion("license_activate_num is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumEqualTo(Integer value) {
            addCriterion("license_activate_num =", value, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumNotEqualTo(Integer value) {
            addCriterion("license_activate_num <>", value, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumGreaterThan(Integer value) {
            addCriterion("license_activate_num >", value, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("license_activate_num >=", value, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumLessThan(Integer value) {
            addCriterion("license_activate_num <", value, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumLessThanOrEqualTo(Integer value) {
            addCriterion("license_activate_num <=", value, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumIn(List<Integer> values) {
            addCriterion("license_activate_num in", values, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumNotIn(List<Integer> values) {
            addCriterion("license_activate_num not in", values, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumBetween(Integer value1, Integer value2) {
            addCriterion("license_activate_num between", value1, value2, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivateNumNotBetween(Integer value1, Integer value2) {
            addCriterion("license_activate_num not between", value1, value2, "licenseActivateNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumIsNull() {
            addCriterion("license_activated_num is null");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumIsNotNull() {
            addCriterion("license_activated_num is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumEqualTo(Integer value) {
            addCriterion("license_activated_num =", value, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumNotEqualTo(Integer value) {
            addCriterion("license_activated_num <>", value, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumGreaterThan(Integer value) {
            addCriterion("license_activated_num >", value, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("license_activated_num >=", value, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumLessThan(Integer value) {
            addCriterion("license_activated_num <", value, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumLessThanOrEqualTo(Integer value) {
            addCriterion("license_activated_num <=", value, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumIn(List<Integer> values) {
            addCriterion("license_activated_num in", values, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumNotIn(List<Integer> values) {
            addCriterion("license_activated_num not in", values, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumBetween(Integer value1, Integer value2) {
            addCriterion("license_activated_num between", value1, value2, "licenseActivatedNum");
            return (Criteria) this;
        }

        public Criteria andLicenseActivatedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("license_activated_num not between", value1, value2, "licenseActivatedNum");
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

        public Criteria andTakeExpressPhoneIsNull() {
            addCriterion("take_express_phone is null");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneIsNotNull() {
            addCriterion("take_express_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneEqualTo(String value) {
            addCriterion("take_express_phone =", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneNotEqualTo(String value) {
            addCriterion("take_express_phone <>", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneGreaterThan(String value) {
            addCriterion("take_express_phone >", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("take_express_phone >=", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneLessThan(String value) {
            addCriterion("take_express_phone <", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneLessThanOrEqualTo(String value) {
            addCriterion("take_express_phone <=", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneLike(String value) {
            addCriterion("take_express_phone like", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneNotLike(String value) {
            addCriterion("take_express_phone not like", value, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneIn(List<String> values) {
            addCriterion("take_express_phone in", values, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneNotIn(List<String> values) {
            addCriterion("take_express_phone not in", values, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneBetween(String value1, String value2) {
            addCriterion("take_express_phone between", value1, value2, "takeExpressPhone");
            return (Criteria) this;
        }

        public Criteria andTakeExpressPhoneNotBetween(String value1, String value2) {
            addCriterion("take_express_phone not between", value1, value2, "takeExpressPhone");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(Integer value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(Integer value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(Integer value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(Integer value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<Integer> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<Integer> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIsjoinIsNull() {
            addCriterion("isjoin is null");
            return (Criteria) this;
        }

        public Criteria andIsjoinIsNotNull() {
            addCriterion("isjoin is not null");
            return (Criteria) this;
        }

        public Criteria andIsjoinEqualTo(Integer value) {
            addCriterion("isjoin =", value, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinNotEqualTo(Integer value) {
            addCriterion("isjoin <>", value, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinGreaterThan(Integer value) {
            addCriterion("isjoin >", value, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("isjoin >=", value, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinLessThan(Integer value) {
            addCriterion("isjoin <", value, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinLessThanOrEqualTo(Integer value) {
            addCriterion("isjoin <=", value, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinIn(List<Integer> values) {
            addCriterion("isjoin in", values, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinNotIn(List<Integer> values) {
            addCriterion("isjoin not in", values, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinBetween(Integer value1, Integer value2) {
            addCriterion("isjoin between", value1, value2, "isjoin");
            return (Criteria) this;
        }

        public Criteria andIsjoinNotBetween(Integer value1, Integer value2) {
            addCriterion("isjoin not between", value1, value2, "isjoin");
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

        public Criteria andIsdelIsNull() {
            addCriterion("isdel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isdel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsp2pIsNull() {
            addCriterion("isP2p is null");
            return (Criteria) this;
        }

        public Criteria andIsp2pIsNotNull() {
            addCriterion("isP2p is not null");
            return (Criteria) this;
        }

        public Criteria andIsp2pEqualTo(Integer value) {
            addCriterion("isP2p =", value, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pNotEqualTo(Integer value) {
            addCriterion("isP2p <>", value, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pGreaterThan(Integer value) {
            addCriterion("isP2p >", value, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pGreaterThanOrEqualTo(Integer value) {
            addCriterion("isP2p >=", value, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pLessThan(Integer value) {
            addCriterion("isP2p <", value, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pLessThanOrEqualTo(Integer value) {
            addCriterion("isP2p <=", value, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pIn(List<Integer> values) {
            addCriterion("isP2p in", values, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pNotIn(List<Integer> values) {
            addCriterion("isP2p not in", values, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pBetween(Integer value1, Integer value2) {
            addCriterion("isP2p between", value1, value2, "isp2p");
            return (Criteria) this;
        }

        public Criteria andIsp2pNotBetween(Integer value1, Integer value2) {
            addCriterion("isP2p not between", value1, value2, "isp2p");
            return (Criteria) this;
        }

        public Criteria andShortAddressIsNull() {
            addCriterion("short_address is null");
            return (Criteria) this;
        }

        public Criteria andShortAddressIsNotNull() {
            addCriterion("short_address is not null");
            return (Criteria) this;
        }

        public Criteria andShortAddressEqualTo(String value) {
            addCriterion("short_address =", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressNotEqualTo(String value) {
            addCriterion("short_address <>", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressGreaterThan(String value) {
            addCriterion("short_address >", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressGreaterThanOrEqualTo(String value) {
            addCriterion("short_address >=", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressLessThan(String value) {
            addCriterion("short_address <", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressLessThanOrEqualTo(String value) {
            addCriterion("short_address <=", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressLike(String value) {
            addCriterion("short_address like", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressNotLike(String value) {
            addCriterion("short_address not like", value, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressIn(List<String> values) {
            addCriterion("short_address in", values, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressNotIn(List<String> values) {
            addCriterion("short_address not in", values, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressBetween(String value1, String value2) {
            addCriterion("short_address between", value1, value2, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andShortAddressNotBetween(String value1, String value2) {
            addCriterion("short_address not between", value1, value2, "shortAddress");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeIsNull() {
            addCriterion("latest_business_time is null");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeIsNotNull() {
            addCriterion("latest_business_time is not null");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeEqualTo(String value) {
            addCriterion("latest_business_time =", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeNotEqualTo(String value) {
            addCriterion("latest_business_time <>", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeGreaterThan(String value) {
            addCriterion("latest_business_time >", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeGreaterThanOrEqualTo(String value) {
            addCriterion("latest_business_time >=", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeLessThan(String value) {
            addCriterion("latest_business_time <", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeLessThanOrEqualTo(String value) {
            addCriterion("latest_business_time <=", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeLike(String value) {
            addCriterion("latest_business_time like", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeNotLike(String value) {
            addCriterion("latest_business_time not like", value, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeIn(List<String> values) {
            addCriterion("latest_business_time in", values, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeNotIn(List<String> values) {
            addCriterion("latest_business_time not in", values, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeBetween(String value1, String value2) {
            addCriterion("latest_business_time between", value1, value2, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andLatestBusinessTimeNotBetween(String value1, String value2) {
            addCriterion("latest_business_time not between", value1, value2, "latestBusinessTime");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNull() {
            addCriterion("collect_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNotNull() {
            addCriterion("collect_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectIdEqualTo(Integer value) {
            addCriterion("collect_id =", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotEqualTo(Integer value) {
            addCriterion("collect_id <>", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThan(Integer value) {
            addCriterion("collect_id >", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_id >=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThan(Integer value) {
            addCriterion("collect_id <", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThanOrEqualTo(Integer value) {
            addCriterion("collect_id <=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdIn(List<Integer> values) {
            addCriterion("collect_id in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotIn(List<Integer> values) {
            addCriterion("collect_id not in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdBetween(Integer value1, Integer value2) {
            addCriterion("collect_id between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_id not between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andSpaceIsNull() {
            addCriterion("space is null");
            return (Criteria) this;
        }

        public Criteria andSpaceIsNotNull() {
            addCriterion("space is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceEqualTo(String value) {
            addCriterion("space =", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotEqualTo(String value) {
            addCriterion("space <>", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThan(String value) {
            addCriterion("space >", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("space >=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThan(String value) {
            addCriterion("space <", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThanOrEqualTo(String value) {
            addCriterion("space <=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLike(String value) {
            addCriterion("space like", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotLike(String value) {
            addCriterion("space not like", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceIn(List<String> values) {
            addCriterion("space in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotIn(List<String> values) {
            addCriterion("space not in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceBetween(String value1, String value2) {
            addCriterion("space between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotBetween(String value1, String value2) {
            addCriterion("space not between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Byte value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Byte value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Byte value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Byte value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Byte value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Byte> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Byte> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Byte value1, Byte value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("level not between", value1, value2, "level");
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

        public Criteria andReceiveIdsIsNull() {
            addCriterion("receive_ids is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsIsNotNull() {
            addCriterion("receive_ids is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsEqualTo(String value) {
            addCriterion("receive_ids =", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsNotEqualTo(String value) {
            addCriterion("receive_ids <>", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsGreaterThan(String value) {
            addCriterion("receive_ids >", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsGreaterThanOrEqualTo(String value) {
            addCriterion("receive_ids >=", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsLessThan(String value) {
            addCriterion("receive_ids <", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsLessThanOrEqualTo(String value) {
            addCriterion("receive_ids <=", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsLike(String value) {
            addCriterion("receive_ids like", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsNotLike(String value) {
            addCriterion("receive_ids not like", value, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsIn(List<String> values) {
            addCriterion("receive_ids in", values, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsNotIn(List<String> values) {
            addCriterion("receive_ids not in", values, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsBetween(String value1, String value2) {
            addCriterion("receive_ids between", value1, value2, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andReceiveIdsNotBetween(String value1, String value2) {
            addCriterion("receive_ids not between", value1, value2, "receiveIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsIsNull() {
            addCriterion("dispatch_ids is null");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsIsNotNull() {
            addCriterion("dispatch_ids is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsEqualTo(String value) {
            addCriterion("dispatch_ids =", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsNotEqualTo(String value) {
            addCriterion("dispatch_ids <>", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsGreaterThan(String value) {
            addCriterion("dispatch_ids >", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsGreaterThanOrEqualTo(String value) {
            addCriterion("dispatch_ids >=", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsLessThan(String value) {
            addCriterion("dispatch_ids <", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsLessThanOrEqualTo(String value) {
            addCriterion("dispatch_ids <=", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsLike(String value) {
            addCriterion("dispatch_ids like", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsNotLike(String value) {
            addCriterion("dispatch_ids not like", value, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsIn(List<String> values) {
            addCriterion("dispatch_ids in", values, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsNotIn(List<String> values) {
            addCriterion("dispatch_ids not in", values, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsBetween(String value1, String value2) {
            addCriterion("dispatch_ids between", value1, value2, "dispatchIds");
            return (Criteria) this;
        }

        public Criteria andDispatchIdsNotBetween(String value1, String value2) {
            addCriterion("dispatch_ids not between", value1, value2, "dispatchIds");
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

        public Criteria andCtIdsIsNull() {
            addCriterion("ct_ids is null");
            return (Criteria) this;
        }

        public Criteria andCtIdsIsNotNull() {
            addCriterion("ct_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCtIdsEqualTo(String value) {
            addCriterion("ct_ids =", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsNotEqualTo(String value) {
            addCriterion("ct_ids <>", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsGreaterThan(String value) {
            addCriterion("ct_ids >", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsGreaterThanOrEqualTo(String value) {
            addCriterion("ct_ids >=", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsLessThan(String value) {
            addCriterion("ct_ids <", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsLessThanOrEqualTo(String value) {
            addCriterion("ct_ids <=", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsLike(String value) {
            addCriterion("ct_ids like", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsNotLike(String value) {
            addCriterion("ct_ids not like", value, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsIn(List<String> values) {
            addCriterion("ct_ids in", values, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsNotIn(List<String> values) {
            addCriterion("ct_ids not in", values, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsBetween(String value1, String value2) {
            addCriterion("ct_ids between", value1, value2, "ctIds");
            return (Criteria) this;
        }

        public Criteria andCtIdsNotBetween(String value1, String value2) {
            addCriterion("ct_ids not between", value1, value2, "ctIds");
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