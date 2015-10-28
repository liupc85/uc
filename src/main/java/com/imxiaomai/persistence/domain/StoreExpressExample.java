package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class StoreExpressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExpressExample() {
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

        public Criteria andStoreidIsNull() {
            addCriterion("storeId is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(Integer value) {
            addCriterion("storeId =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(Integer value) {
            addCriterion("storeId <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(Integer value) {
            addCriterion("storeId >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("storeId >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(Integer value) {
            addCriterion("storeId <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(Integer value) {
            addCriterion("storeId <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<Integer> values) {
            addCriterion("storeId in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<Integer> values) {
            addCriterion("storeId not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(Integer value1, Integer value2) {
            addCriterion("storeId between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(Integer value1, Integer value2) {
            addCriterion("storeId not between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsIsNull() {
            addCriterion("deliveryExpIds is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsIsNotNull() {
            addCriterion("deliveryExpIds is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsEqualTo(String value) {
            addCriterion("deliveryExpIds =", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsNotEqualTo(String value) {
            addCriterion("deliveryExpIds <>", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsGreaterThan(String value) {
            addCriterion("deliveryExpIds >", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryExpIds >=", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsLessThan(String value) {
            addCriterion("deliveryExpIds <", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsLessThanOrEqualTo(String value) {
            addCriterion("deliveryExpIds <=", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsLike(String value) {
            addCriterion("deliveryExpIds like", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsNotLike(String value) {
            addCriterion("deliveryExpIds not like", value, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsIn(List<String> values) {
            addCriterion("deliveryExpIds in", values, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsNotIn(List<String> values) {
            addCriterion("deliveryExpIds not in", values, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsBetween(String value1, String value2) {
            addCriterion("deliveryExpIds between", value1, value2, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andDeliveryexpidsNotBetween(String value1, String value2) {
            addCriterion("deliveryExpIds not between", value1, value2, "deliveryexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsIsNull() {
            addCriterion("receivedExpIds is null");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsIsNotNull() {
            addCriterion("receivedExpIds is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsEqualTo(String value) {
            addCriterion("receivedExpIds =", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsNotEqualTo(String value) {
            addCriterion("receivedExpIds <>", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsGreaterThan(String value) {
            addCriterion("receivedExpIds >", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsGreaterThanOrEqualTo(String value) {
            addCriterion("receivedExpIds >=", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsLessThan(String value) {
            addCriterion("receivedExpIds <", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsLessThanOrEqualTo(String value) {
            addCriterion("receivedExpIds <=", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsLike(String value) {
            addCriterion("receivedExpIds like", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsNotLike(String value) {
            addCriterion("receivedExpIds not like", value, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsIn(List<String> values) {
            addCriterion("receivedExpIds in", values, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsNotIn(List<String> values) {
            addCriterion("receivedExpIds not in", values, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsBetween(String value1, String value2) {
            addCriterion("receivedExpIds between", value1, value2, "receivedexpids");
            return (Criteria) this;
        }

        public Criteria andReceivedexpidsNotBetween(String value1, String value2) {
            addCriterion("receivedExpIds not between", value1, value2, "receivedexpids");
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