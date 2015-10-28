package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class ExpresspriceDepricateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpresspriceDepricateExample() {
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

        public Criteria andExpressnameIsNull() {
            addCriterion("expressName is null");
            return (Criteria) this;
        }

        public Criteria andExpressnameIsNotNull() {
            addCriterion("expressName is not null");
            return (Criteria) this;
        }

        public Criteria andExpressnameEqualTo(String value) {
            addCriterion("expressName =", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotEqualTo(String value) {
            addCriterion("expressName <>", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameGreaterThan(String value) {
            addCriterion("expressName >", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameGreaterThanOrEqualTo(String value) {
            addCriterion("expressName >=", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameLessThan(String value) {
            addCriterion("expressName <", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameLessThanOrEqualTo(String value) {
            addCriterion("expressName <=", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameLike(String value) {
            addCriterion("expressName like", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotLike(String value) {
            addCriterion("expressName not like", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameIn(List<String> values) {
            addCriterion("expressName in", values, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotIn(List<String> values) {
            addCriterion("expressName not in", values, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameBetween(String value1, String value2) {
            addCriterion("expressName between", value1, value2, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotBetween(String value1, String value2) {
            addCriterion("expressName not between", value1, value2, "expressname");
            return (Criteria) this;
        }

        public Criteria andExampleweightIsNull() {
            addCriterion("exampleWeight is null");
            return (Criteria) this;
        }

        public Criteria andExampleweightIsNotNull() {
            addCriterion("exampleWeight is not null");
            return (Criteria) this;
        }

        public Criteria andExampleweightEqualTo(Integer value) {
            addCriterion("exampleWeight =", value, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightNotEqualTo(Integer value) {
            addCriterion("exampleWeight <>", value, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightGreaterThan(Integer value) {
            addCriterion("exampleWeight >", value, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightGreaterThanOrEqualTo(Integer value) {
            addCriterion("exampleWeight >=", value, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightLessThan(Integer value) {
            addCriterion("exampleWeight <", value, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightLessThanOrEqualTo(Integer value) {
            addCriterion("exampleWeight <=", value, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightIn(List<Integer> values) {
            addCriterion("exampleWeight in", values, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightNotIn(List<Integer> values) {
            addCriterion("exampleWeight not in", values, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightBetween(Integer value1, Integer value2) {
            addCriterion("exampleWeight between", value1, value2, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExampleweightNotBetween(Integer value1, Integer value2) {
            addCriterion("exampleWeight not between", value1, value2, "exampleweight");
            return (Criteria) this;
        }

        public Criteria andExamplepriceIsNull() {
            addCriterion("examplePrice is null");
            return (Criteria) this;
        }

        public Criteria andExamplepriceIsNotNull() {
            addCriterion("examplePrice is not null");
            return (Criteria) this;
        }

        public Criteria andExamplepriceEqualTo(Integer value) {
            addCriterion("examplePrice =", value, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceNotEqualTo(Integer value) {
            addCriterion("examplePrice <>", value, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceGreaterThan(Integer value) {
            addCriterion("examplePrice >", value, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("examplePrice >=", value, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceLessThan(Integer value) {
            addCriterion("examplePrice <", value, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceLessThanOrEqualTo(Integer value) {
            addCriterion("examplePrice <=", value, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceIn(List<Integer> values) {
            addCriterion("examplePrice in", values, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceNotIn(List<Integer> values) {
            addCriterion("examplePrice not in", values, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceBetween(Integer value1, Integer value2) {
            addCriterion("examplePrice between", value1, value2, "exampleprice");
            return (Criteria) this;
        }

        public Criteria andExamplepriceNotBetween(Integer value1, Integer value2) {
            addCriterion("examplePrice not between", value1, value2, "exampleprice");
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