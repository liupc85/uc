package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class UpgradePloyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UpgradePloyExample() {
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

        public Criteria andOpidIsNull() {
            addCriterion("opid is null");
            return (Criteria) this;
        }

        public Criteria andOpidIsNotNull() {
            addCriterion("opid is not null");
            return (Criteria) this;
        }

        public Criteria andOpidEqualTo(Integer value) {
            addCriterion("opid =", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotEqualTo(Integer value) {
            addCriterion("opid <>", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidGreaterThan(Integer value) {
            addCriterion("opid >", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("opid >=", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLessThan(Integer value) {
            addCriterion("opid <", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLessThanOrEqualTo(Integer value) {
            addCriterion("opid <=", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidIn(List<Integer> values) {
            addCriterion("opid in", values, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotIn(List<Integer> values) {
            addCriterion("opid not in", values, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidBetween(Integer value1, Integer value2) {
            addCriterion("opid between", value1, value2, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotBetween(Integer value1, Integer value2) {
            addCriterion("opid not between", value1, value2, "opid");
            return (Criteria) this;
        }

        public Criteria andUpgradenameIsNull() {
            addCriterion("upgradeName is null");
            return (Criteria) this;
        }

        public Criteria andUpgradenameIsNotNull() {
            addCriterion("upgradeName is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradenameEqualTo(String value) {
            addCriterion("upgradeName =", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameNotEqualTo(String value) {
            addCriterion("upgradeName <>", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameGreaterThan(String value) {
            addCriterion("upgradeName >", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameGreaterThanOrEqualTo(String value) {
            addCriterion("upgradeName >=", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameLessThan(String value) {
            addCriterion("upgradeName <", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameLessThanOrEqualTo(String value) {
            addCriterion("upgradeName <=", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameLike(String value) {
            addCriterion("upgradeName like", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameNotLike(String value) {
            addCriterion("upgradeName not like", value, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameIn(List<String> values) {
            addCriterion("upgradeName in", values, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameNotIn(List<String> values) {
            addCriterion("upgradeName not in", values, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameBetween(String value1, String value2) {
            addCriterion("upgradeName between", value1, value2, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradenameNotBetween(String value1, String value2) {
            addCriterion("upgradeName not between", value1, value2, "upgradename");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueIsNull() {
            addCriterion("upgradeValue is null");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueIsNotNull() {
            addCriterion("upgradeValue is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueEqualTo(String value) {
            addCriterion("upgradeValue =", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueNotEqualTo(String value) {
            addCriterion("upgradeValue <>", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueGreaterThan(String value) {
            addCriterion("upgradeValue >", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueGreaterThanOrEqualTo(String value) {
            addCriterion("upgradeValue >=", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueLessThan(String value) {
            addCriterion("upgradeValue <", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueLessThanOrEqualTo(String value) {
            addCriterion("upgradeValue <=", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueLike(String value) {
            addCriterion("upgradeValue like", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueNotLike(String value) {
            addCriterion("upgradeValue not like", value, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueIn(List<String> values) {
            addCriterion("upgradeValue in", values, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueNotIn(List<String> values) {
            addCriterion("upgradeValue not in", values, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueBetween(String value1, String value2) {
            addCriterion("upgradeValue between", value1, value2, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andUpgradevalueNotBetween(String value1, String value2) {
            addCriterion("upgradeValue not between", value1, value2, "upgradevalue");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("isUse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("isUse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(Byte value) {
            addCriterion("isUse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(Byte value) {
            addCriterion("isUse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(Byte value) {
            addCriterion("isUse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(Byte value) {
            addCriterion("isUse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(Byte value) {
            addCriterion("isUse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(Byte value) {
            addCriterion("isUse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<Byte> values) {
            addCriterion("isUse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<Byte> values) {
            addCriterion("isUse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(Byte value1, Byte value2) {
            addCriterion("isUse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(Byte value1, Byte value2) {
            addCriterion("isUse not between", value1, value2, "isuse");
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