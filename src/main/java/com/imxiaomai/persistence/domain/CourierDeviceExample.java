package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourierDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourierDeviceExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNull() {
            addCriterion("mobilePhone is null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNotNull() {
            addCriterion("mobilePhone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneEqualTo(String value) {
            addCriterion("mobilePhone =", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotEqualTo(String value) {
            addCriterion("mobilePhone <>", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThan(String value) {
            addCriterion("mobilePhone >", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobilePhone >=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThan(String value) {
            addCriterion("mobilePhone <", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThanOrEqualTo(String value) {
            addCriterion("mobilePhone <=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLike(String value) {
            addCriterion("mobilePhone like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotLike(String value) {
            addCriterion("mobilePhone not like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIn(List<String> values) {
            addCriterion("mobilePhone in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotIn(List<String> values) {
            addCriterion("mobilePhone not in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneBetween(String value1, String value2) {
            addCriterion("mobilePhone between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotBetween(String value1, String value2) {
            addCriterion("mobilePhone not between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(String value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(String value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(String value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(String value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(String value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLike(String value) {
            addCriterion("deviceId like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotLike(String value) {
            addCriterion("deviceId not like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<String> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<String> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(String value1, String value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(String value1, String value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNull() {
            addCriterion("channelId is null");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNotNull() {
            addCriterion("channelId is not null");
            return (Criteria) this;
        }

        public Criteria andChannelidEqualTo(String value) {
            addCriterion("channelId =", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotEqualTo(String value) {
            addCriterion("channelId <>", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThan(String value) {
            addCriterion("channelId >", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThanOrEqualTo(String value) {
            addCriterion("channelId >=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThan(String value) {
            addCriterion("channelId <", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThanOrEqualTo(String value) {
            addCriterion("channelId <=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLike(String value) {
            addCriterion("channelId like", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotLike(String value) {
            addCriterion("channelId not like", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidIn(List<String> values) {
            addCriterion("channelId in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotIn(List<String> values) {
            addCriterion("channelId not in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidBetween(String value1, String value2) {
            addCriterion("channelId between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotBetween(String value1, String value2) {
            addCriterion("channelId not between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
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

        public Criteria andSrcchannelIsNull() {
            addCriterion("srcChannel is null");
            return (Criteria) this;
        }

        public Criteria andSrcchannelIsNotNull() {
            addCriterion("srcChannel is not null");
            return (Criteria) this;
        }

        public Criteria andSrcchannelEqualTo(String value) {
            addCriterion("srcChannel =", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelNotEqualTo(String value) {
            addCriterion("srcChannel <>", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelGreaterThan(String value) {
            addCriterion("srcChannel >", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelGreaterThanOrEqualTo(String value) {
            addCriterion("srcChannel >=", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelLessThan(String value) {
            addCriterion("srcChannel <", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelLessThanOrEqualTo(String value) {
            addCriterion("srcChannel <=", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelLike(String value) {
            addCriterion("srcChannel like", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelNotLike(String value) {
            addCriterion("srcChannel not like", value, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelIn(List<String> values) {
            addCriterion("srcChannel in", values, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelNotIn(List<String> values) {
            addCriterion("srcChannel not in", values, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelBetween(String value1, String value2) {
            addCriterion("srcChannel between", value1, value2, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andSrcchannelNotBetween(String value1, String value2) {
            addCriterion("srcChannel not between", value1, value2, "srcchannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelIsNull() {
            addCriterion("lastUpdateChannel is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelIsNotNull() {
            addCriterion("lastUpdateChannel is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelEqualTo(String value) {
            addCriterion("lastUpdateChannel =", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelNotEqualTo(String value) {
            addCriterion("lastUpdateChannel <>", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelGreaterThan(String value) {
            addCriterion("lastUpdateChannel >", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelGreaterThanOrEqualTo(String value) {
            addCriterion("lastUpdateChannel >=", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelLessThan(String value) {
            addCriterion("lastUpdateChannel <", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelLessThanOrEqualTo(String value) {
            addCriterion("lastUpdateChannel <=", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelLike(String value) {
            addCriterion("lastUpdateChannel like", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelNotLike(String value) {
            addCriterion("lastUpdateChannel not like", value, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelIn(List<String> values) {
            addCriterion("lastUpdateChannel in", values, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelNotIn(List<String> values) {
            addCriterion("lastUpdateChannel not in", values, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelBetween(String value1, String value2) {
            addCriterion("lastUpdateChannel between", value1, value2, "lastupdatechannel");
            return (Criteria) this;
        }

        public Criteria andLastupdatechannelNotBetween(String value1, String value2) {
            addCriterion("lastUpdateChannel not between", value1, value2, "lastupdatechannel");
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

        public Criteria andBaiduuseridIsNull() {
            addCriterion("baiduUserId is null");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridIsNotNull() {
            addCriterion("baiduUserId is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridEqualTo(String value) {
            addCriterion("baiduUserId =", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridNotEqualTo(String value) {
            addCriterion("baiduUserId <>", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridGreaterThan(String value) {
            addCriterion("baiduUserId >", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridGreaterThanOrEqualTo(String value) {
            addCriterion("baiduUserId >=", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridLessThan(String value) {
            addCriterion("baiduUserId <", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridLessThanOrEqualTo(String value) {
            addCriterion("baiduUserId <=", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridLike(String value) {
            addCriterion("baiduUserId like", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridNotLike(String value) {
            addCriterion("baiduUserId not like", value, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridIn(List<String> values) {
            addCriterion("baiduUserId in", values, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridNotIn(List<String> values) {
            addCriterion("baiduUserId not in", values, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridBetween(String value1, String value2) {
            addCriterion("baiduUserId between", value1, value2, "baiduuserid");
            return (Criteria) this;
        }

        public Criteria andBaiduuseridNotBetween(String value1, String value2) {
            addCriterion("baiduUserId not between", value1, value2, "baiduuserid");
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