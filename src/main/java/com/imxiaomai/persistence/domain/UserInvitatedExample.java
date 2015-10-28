package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInvitatedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInvitatedExample() {
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

        public Criteria andInvitateduseridIsNull() {
            addCriterion("invitatedUserId is null");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridIsNotNull() {
            addCriterion("invitatedUserId is not null");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridEqualTo(Integer value) {
            addCriterion("invitatedUserId =", value, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridNotEqualTo(Integer value) {
            addCriterion("invitatedUserId <>", value, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridGreaterThan(Integer value) {
            addCriterion("invitatedUserId >", value, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitatedUserId >=", value, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridLessThan(Integer value) {
            addCriterion("invitatedUserId <", value, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridLessThanOrEqualTo(Integer value) {
            addCriterion("invitatedUserId <=", value, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridIn(List<Integer> values) {
            addCriterion("invitatedUserId in", values, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridNotIn(List<Integer> values) {
            addCriterion("invitatedUserId not in", values, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridBetween(Integer value1, Integer value2) {
            addCriterion("invitatedUserId between", value1, value2, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andInvitateduseridNotBetween(Integer value1, Integer value2) {
            addCriterion("invitatedUserId not between", value1, value2, "invitateduserid");
            return (Criteria) this;
        }

        public Criteria andUseridgoldIsNull() {
            addCriterion("userIdGold is null");
            return (Criteria) this;
        }

        public Criteria andUseridgoldIsNotNull() {
            addCriterion("userIdGold is not null");
            return (Criteria) this;
        }

        public Criteria andUseridgoldEqualTo(Integer value) {
            addCriterion("userIdGold =", value, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldNotEqualTo(Integer value) {
            addCriterion("userIdGold <>", value, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldGreaterThan(Integer value) {
            addCriterion("userIdGold >", value, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("userIdGold >=", value, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldLessThan(Integer value) {
            addCriterion("userIdGold <", value, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldLessThanOrEqualTo(Integer value) {
            addCriterion("userIdGold <=", value, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldIn(List<Integer> values) {
            addCriterion("userIdGold in", values, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldNotIn(List<Integer> values) {
            addCriterion("userIdGold not in", values, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldBetween(Integer value1, Integer value2) {
            addCriterion("userIdGold between", value1, value2, "useridgold");
            return (Criteria) this;
        }

        public Criteria andUseridgoldNotBetween(Integer value1, Integer value2) {
            addCriterion("userIdGold not between", value1, value2, "useridgold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldIsNull() {
            addCriterion("invitatedUserGold is null");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldIsNotNull() {
            addCriterion("invitatedUserGold is not null");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldEqualTo(Integer value) {
            addCriterion("invitatedUserGold =", value, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldNotEqualTo(Integer value) {
            addCriterion("invitatedUserGold <>", value, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldGreaterThan(Integer value) {
            addCriterion("invitatedUserGold >", value, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitatedUserGold >=", value, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldLessThan(Integer value) {
            addCriterion("invitatedUserGold <", value, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldLessThanOrEqualTo(Integer value) {
            addCriterion("invitatedUserGold <=", value, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldIn(List<Integer> values) {
            addCriterion("invitatedUserGold in", values, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldNotIn(List<Integer> values) {
            addCriterion("invitatedUserGold not in", values, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldBetween(Integer value1, Integer value2) {
            addCriterion("invitatedUserGold between", value1, value2, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andInvitatedusergoldNotBetween(Integer value1, Integer value2) {
            addCriterion("invitatedUserGold not between", value1, value2, "invitatedusergold");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andIsaddIsNull() {
            addCriterion("isAdd is null");
            return (Criteria) this;
        }

        public Criteria andIsaddIsNotNull() {
            addCriterion("isAdd is not null");
            return (Criteria) this;
        }

        public Criteria andIsaddEqualTo(Integer value) {
            addCriterion("isAdd =", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotEqualTo(Integer value) {
            addCriterion("isAdd <>", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddGreaterThan(Integer value) {
            addCriterion("isAdd >", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddGreaterThanOrEqualTo(Integer value) {
            addCriterion("isAdd >=", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLessThan(Integer value) {
            addCriterion("isAdd <", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLessThanOrEqualTo(Integer value) {
            addCriterion("isAdd <=", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddIn(List<Integer> values) {
            addCriterion("isAdd in", values, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotIn(List<Integer> values) {
            addCriterion("isAdd not in", values, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddBetween(Integer value1, Integer value2) {
            addCriterion("isAdd between", value1, value2, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotBetween(Integer value1, Integer value2) {
            addCriterion("isAdd not between", value1, value2, "isadd");
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

        public Criteria andOutidIsNull() {
            addCriterion("outId is null");
            return (Criteria) this;
        }

        public Criteria andOutidIsNotNull() {
            addCriterion("outId is not null");
            return (Criteria) this;
        }

        public Criteria andOutidEqualTo(String value) {
            addCriterion("outId =", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotEqualTo(String value) {
            addCriterion("outId <>", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThan(String value) {
            addCriterion("outId >", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThanOrEqualTo(String value) {
            addCriterion("outId >=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThan(String value) {
            addCriterion("outId <", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThanOrEqualTo(String value) {
            addCriterion("outId <=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLike(String value) {
            addCriterion("outId like", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotLike(String value) {
            addCriterion("outId not like", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidIn(List<String> values) {
            addCriterion("outId in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotIn(List<String> values) {
            addCriterion("outId not in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidBetween(String value1, String value2) {
            addCriterion("outId between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotBetween(String value1, String value2) {
            addCriterion("outId not between", value1, value2, "outid");
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