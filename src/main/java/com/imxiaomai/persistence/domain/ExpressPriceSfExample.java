package com.imxiaomai.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpressPriceSfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpressPriceSfExample() {
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

        public Criteria andFromareaidIsNull() {
            addCriterion("fromAreaId is null");
            return (Criteria) this;
        }

        public Criteria andFromareaidIsNotNull() {
            addCriterion("fromAreaId is not null");
            return (Criteria) this;
        }

        public Criteria andFromareaidEqualTo(Integer value) {
            addCriterion("fromAreaId =", value, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidNotEqualTo(Integer value) {
            addCriterion("fromAreaId <>", value, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidGreaterThan(Integer value) {
            addCriterion("fromAreaId >", value, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fromAreaId >=", value, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidLessThan(Integer value) {
            addCriterion("fromAreaId <", value, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidLessThanOrEqualTo(Integer value) {
            addCriterion("fromAreaId <=", value, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidIn(List<Integer> values) {
            addCriterion("fromAreaId in", values, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidNotIn(List<Integer> values) {
            addCriterion("fromAreaId not in", values, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidBetween(Integer value1, Integer value2) {
            addCriterion("fromAreaId between", value1, value2, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andFromareaidNotBetween(Integer value1, Integer value2) {
            addCriterion("fromAreaId not between", value1, value2, "fromareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidIsNull() {
            addCriterion("toAreaId is null");
            return (Criteria) this;
        }

        public Criteria andToareaidIsNotNull() {
            addCriterion("toAreaId is not null");
            return (Criteria) this;
        }

        public Criteria andToareaidEqualTo(Integer value) {
            addCriterion("toAreaId =", value, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidNotEqualTo(Integer value) {
            addCriterion("toAreaId <>", value, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidGreaterThan(Integer value) {
            addCriterion("toAreaId >", value, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("toAreaId >=", value, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidLessThan(Integer value) {
            addCriterion("toAreaId <", value, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidLessThanOrEqualTo(Integer value) {
            addCriterion("toAreaId <=", value, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidIn(List<Integer> values) {
            addCriterion("toAreaId in", values, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidNotIn(List<Integer> values) {
            addCriterion("toAreaId not in", values, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidBetween(Integer value1, Integer value2) {
            addCriterion("toAreaId between", value1, value2, "toareaid");
            return (Criteria) this;
        }

        public Criteria andToareaidNotBetween(Integer value1, Integer value2) {
            addCriterion("toAreaId not between", value1, value2, "toareaid");
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

        public Criteria andLandprice1IsNull() {
            addCriterion("landPrice1 is null");
            return (Criteria) this;
        }

        public Criteria andLandprice1IsNotNull() {
            addCriterion("landPrice1 is not null");
            return (Criteria) this;
        }

        public Criteria andLandprice1EqualTo(Integer value) {
            addCriterion("landPrice1 =", value, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1NotEqualTo(Integer value) {
            addCriterion("landPrice1 <>", value, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1GreaterThan(Integer value) {
            addCriterion("landPrice1 >", value, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1GreaterThanOrEqualTo(Integer value) {
            addCriterion("landPrice1 >=", value, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1LessThan(Integer value) {
            addCriterion("landPrice1 <", value, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1LessThanOrEqualTo(Integer value) {
            addCriterion("landPrice1 <=", value, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1In(List<Integer> values) {
            addCriterion("landPrice1 in", values, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1NotIn(List<Integer> values) {
            addCriterion("landPrice1 not in", values, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1Between(Integer value1, Integer value2) {
            addCriterion("landPrice1 between", value1, value2, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice1NotBetween(Integer value1, Integer value2) {
            addCriterion("landPrice1 not between", value1, value2, "landprice1");
            return (Criteria) this;
        }

        public Criteria andLandprice2IsNull() {
            addCriterion("landPrice2 is null");
            return (Criteria) this;
        }

        public Criteria andLandprice2IsNotNull() {
            addCriterion("landPrice2 is not null");
            return (Criteria) this;
        }

        public Criteria andLandprice2EqualTo(Integer value) {
            addCriterion("landPrice2 =", value, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2NotEqualTo(Integer value) {
            addCriterion("landPrice2 <>", value, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2GreaterThan(Integer value) {
            addCriterion("landPrice2 >", value, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2GreaterThanOrEqualTo(Integer value) {
            addCriterion("landPrice2 >=", value, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2LessThan(Integer value) {
            addCriterion("landPrice2 <", value, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2LessThanOrEqualTo(Integer value) {
            addCriterion("landPrice2 <=", value, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2In(List<Integer> values) {
            addCriterion("landPrice2 in", values, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2NotIn(List<Integer> values) {
            addCriterion("landPrice2 not in", values, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2Between(Integer value1, Integer value2) {
            addCriterion("landPrice2 between", value1, value2, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice2NotBetween(Integer value1, Integer value2) {
            addCriterion("landPrice2 not between", value1, value2, "landprice2");
            return (Criteria) this;
        }

        public Criteria andLandprice3IsNull() {
            addCriterion("landPrice3 is null");
            return (Criteria) this;
        }

        public Criteria andLandprice3IsNotNull() {
            addCriterion("landPrice3 is not null");
            return (Criteria) this;
        }

        public Criteria andLandprice3EqualTo(Integer value) {
            addCriterion("landPrice3 =", value, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3NotEqualTo(Integer value) {
            addCriterion("landPrice3 <>", value, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3GreaterThan(Integer value) {
            addCriterion("landPrice3 >", value, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3GreaterThanOrEqualTo(Integer value) {
            addCriterion("landPrice3 >=", value, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3LessThan(Integer value) {
            addCriterion("landPrice3 <", value, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3LessThanOrEqualTo(Integer value) {
            addCriterion("landPrice3 <=", value, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3In(List<Integer> values) {
            addCriterion("landPrice3 in", values, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3NotIn(List<Integer> values) {
            addCriterion("landPrice3 not in", values, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3Between(Integer value1, Integer value2) {
            addCriterion("landPrice3 between", value1, value2, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice3NotBetween(Integer value1, Integer value2) {
            addCriterion("landPrice3 not between", value1, value2, "landprice3");
            return (Criteria) this;
        }

        public Criteria andLandprice4IsNull() {
            addCriterion("landPrice4 is null");
            return (Criteria) this;
        }

        public Criteria andLandprice4IsNotNull() {
            addCriterion("landPrice4 is not null");
            return (Criteria) this;
        }

        public Criteria andLandprice4EqualTo(Integer value) {
            addCriterion("landPrice4 =", value, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4NotEqualTo(Integer value) {
            addCriterion("landPrice4 <>", value, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4GreaterThan(Integer value) {
            addCriterion("landPrice4 >", value, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4GreaterThanOrEqualTo(Integer value) {
            addCriterion("landPrice4 >=", value, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4LessThan(Integer value) {
            addCriterion("landPrice4 <", value, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4LessThanOrEqualTo(Integer value) {
            addCriterion("landPrice4 <=", value, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4In(List<Integer> values) {
            addCriterion("landPrice4 in", values, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4NotIn(List<Integer> values) {
            addCriterion("landPrice4 not in", values, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4Between(Integer value1, Integer value2) {
            addCriterion("landPrice4 between", value1, value2, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice4NotBetween(Integer value1, Integer value2) {
            addCriterion("landPrice4 not between", value1, value2, "landprice4");
            return (Criteria) this;
        }

        public Criteria andLandprice5IsNull() {
            addCriterion("landPrice5 is null");
            return (Criteria) this;
        }

        public Criteria andLandprice5IsNotNull() {
            addCriterion("landPrice5 is not null");
            return (Criteria) this;
        }

        public Criteria andLandprice5EqualTo(Integer value) {
            addCriterion("landPrice5 =", value, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5NotEqualTo(Integer value) {
            addCriterion("landPrice5 <>", value, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5GreaterThan(Integer value) {
            addCriterion("landPrice5 >", value, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5GreaterThanOrEqualTo(Integer value) {
            addCriterion("landPrice5 >=", value, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5LessThan(Integer value) {
            addCriterion("landPrice5 <", value, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5LessThanOrEqualTo(Integer value) {
            addCriterion("landPrice5 <=", value, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5In(List<Integer> values) {
            addCriterion("landPrice5 in", values, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5NotIn(List<Integer> values) {
            addCriterion("landPrice5 not in", values, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5Between(Integer value1, Integer value2) {
            addCriterion("landPrice5 between", value1, value2, "landprice5");
            return (Criteria) this;
        }

        public Criteria andLandprice5NotBetween(Integer value1, Integer value2) {
            addCriterion("landPrice5 not between", value1, value2, "landprice5");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceIsNull() {
            addCriterion("waterBasicPrice is null");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceIsNotNull() {
            addCriterion("waterBasicPrice is not null");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceEqualTo(Integer value) {
            addCriterion("waterBasicPrice =", value, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceNotEqualTo(Integer value) {
            addCriterion("waterBasicPrice <>", value, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceGreaterThan(Integer value) {
            addCriterion("waterBasicPrice >", value, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("waterBasicPrice >=", value, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceLessThan(Integer value) {
            addCriterion("waterBasicPrice <", value, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceLessThanOrEqualTo(Integer value) {
            addCriterion("waterBasicPrice <=", value, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceIn(List<Integer> values) {
            addCriterion("waterBasicPrice in", values, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceNotIn(List<Integer> values) {
            addCriterion("waterBasicPrice not in", values, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceBetween(Integer value1, Integer value2) {
            addCriterion("waterBasicPrice between", value1, value2, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWaterbasicpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("waterBasicPrice not between", value1, value2, "waterbasicprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceIsNull() {
            addCriterion("waterAddedPrice is null");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceIsNotNull() {
            addCriterion("waterAddedPrice is not null");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceEqualTo(Integer value) {
            addCriterion("waterAddedPrice =", value, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceNotEqualTo(Integer value) {
            addCriterion("waterAddedPrice <>", value, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceGreaterThan(Integer value) {
            addCriterion("waterAddedPrice >", value, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("waterAddedPrice >=", value, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceLessThan(Integer value) {
            addCriterion("waterAddedPrice <", value, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceLessThanOrEqualTo(Integer value) {
            addCriterion("waterAddedPrice <=", value, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceIn(List<Integer> values) {
            addCriterion("waterAddedPrice in", values, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceNotIn(List<Integer> values) {
            addCriterion("waterAddedPrice not in", values, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceBetween(Integer value1, Integer value2) {
            addCriterion("waterAddedPrice between", value1, value2, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andWateraddedpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("waterAddedPrice not between", value1, value2, "wateraddedprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceIsNull() {
            addCriterion("airBasicPrice is null");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceIsNotNull() {
            addCriterion("airBasicPrice is not null");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceEqualTo(Integer value) {
            addCriterion("airBasicPrice =", value, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceNotEqualTo(Integer value) {
            addCriterion("airBasicPrice <>", value, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceGreaterThan(Integer value) {
            addCriterion("airBasicPrice >", value, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("airBasicPrice >=", value, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceLessThan(Integer value) {
            addCriterion("airBasicPrice <", value, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceLessThanOrEqualTo(Integer value) {
            addCriterion("airBasicPrice <=", value, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceIn(List<Integer> values) {
            addCriterion("airBasicPrice in", values, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceNotIn(List<Integer> values) {
            addCriterion("airBasicPrice not in", values, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceBetween(Integer value1, Integer value2) {
            addCriterion("airBasicPrice between", value1, value2, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAirbasicpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("airBasicPrice not between", value1, value2, "airbasicprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceIsNull() {
            addCriterion("airAddedPrice is null");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceIsNotNull() {
            addCriterion("airAddedPrice is not null");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceEqualTo(Integer value) {
            addCriterion("airAddedPrice =", value, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceNotEqualTo(Integer value) {
            addCriterion("airAddedPrice <>", value, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceGreaterThan(Integer value) {
            addCriterion("airAddedPrice >", value, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("airAddedPrice >=", value, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceLessThan(Integer value) {
            addCriterion("airAddedPrice <", value, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceLessThanOrEqualTo(Integer value) {
            addCriterion("airAddedPrice <=", value, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceIn(List<Integer> values) {
            addCriterion("airAddedPrice in", values, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceNotIn(List<Integer> values) {
            addCriterion("airAddedPrice not in", values, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceBetween(Integer value1, Integer value2) {
            addCriterion("airAddedPrice between", value1, value2, "airaddedprice");
            return (Criteria) this;
        }

        public Criteria andAiraddedpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("airAddedPrice not between", value1, value2, "airaddedprice");
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