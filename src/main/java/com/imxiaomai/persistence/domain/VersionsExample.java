package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class VersionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VersionsExample() {
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andPubtypeIsNull() {
            addCriterion("pubType is null");
            return (Criteria) this;
        }

        public Criteria andPubtypeIsNotNull() {
            addCriterion("pubType is not null");
            return (Criteria) this;
        }

        public Criteria andPubtypeEqualTo(String value) {
            addCriterion("pubType =", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeNotEqualTo(String value) {
            addCriterion("pubType <>", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeGreaterThan(String value) {
            addCriterion("pubType >", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeGreaterThanOrEqualTo(String value) {
            addCriterion("pubType >=", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeLessThan(String value) {
            addCriterion("pubType <", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeLessThanOrEqualTo(String value) {
            addCriterion("pubType <=", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeLike(String value) {
            addCriterion("pubType like", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeNotLike(String value) {
            addCriterion("pubType not like", value, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeIn(List<String> values) {
            addCriterion("pubType in", values, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeNotIn(List<String> values) {
            addCriterion("pubType not in", values, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeBetween(String value1, String value2) {
            addCriterion("pubType between", value1, value2, "pubtype");
            return (Criteria) this;
        }

        public Criteria andPubtypeNotBetween(String value1, String value2) {
            addCriterion("pubType not between", value1, value2, "pubtype");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIsNull() {
            addCriterion("downloadUrl is null");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIsNotNull() {
            addCriterion("downloadUrl is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadurlEqualTo(String value) {
            addCriterion("downloadUrl =", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotEqualTo(String value) {
            addCriterion("downloadUrl <>", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlGreaterThan(String value) {
            addCriterion("downloadUrl >", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlGreaterThanOrEqualTo(String value) {
            addCriterion("downloadUrl >=", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLessThan(String value) {
            addCriterion("downloadUrl <", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLessThanOrEqualTo(String value) {
            addCriterion("downloadUrl <=", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLike(String value) {
            addCriterion("downloadUrl like", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotLike(String value) {
            addCriterion("downloadUrl not like", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIn(List<String> values) {
            addCriterion("downloadUrl in", values, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotIn(List<String> values) {
            addCriterion("downloadUrl not in", values, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlBetween(String value1, String value2) {
            addCriterion("downloadUrl between", value1, value2, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotBetween(String value1, String value2) {
            addCriterion("downloadUrl not between", value1, value2, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andVersiondescIsNull() {
            addCriterion("versionDesc is null");
            return (Criteria) this;
        }

        public Criteria andVersiondescIsNotNull() {
            addCriterion("versionDesc is not null");
            return (Criteria) this;
        }

        public Criteria andVersiondescEqualTo(String value) {
            addCriterion("versionDesc =", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescNotEqualTo(String value) {
            addCriterion("versionDesc <>", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescGreaterThan(String value) {
            addCriterion("versionDesc >", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescGreaterThanOrEqualTo(String value) {
            addCriterion("versionDesc >=", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescLessThan(String value) {
            addCriterion("versionDesc <", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescLessThanOrEqualTo(String value) {
            addCriterion("versionDesc <=", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescLike(String value) {
            addCriterion("versionDesc like", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescNotLike(String value) {
            addCriterion("versionDesc not like", value, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescIn(List<String> values) {
            addCriterion("versionDesc in", values, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescNotIn(List<String> values) {
            addCriterion("versionDesc not in", values, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescBetween(String value1, String value2) {
            addCriterion("versionDesc between", value1, value2, "versiondesc");
            return (Criteria) this;
        }

        public Criteria andVersiondescNotBetween(String value1, String value2) {
            addCriterion("versionDesc not between", value1, value2, "versiondesc");
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