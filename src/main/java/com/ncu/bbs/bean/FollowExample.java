package com.ncu.bbs.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FollowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowExample() {
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

        public Criteria andFFollowidIsNull() {
            addCriterion("f_followid is null");
            return (Criteria) this;
        }

        public Criteria andFFollowidIsNotNull() {
            addCriterion("f_followid is not null");
            return (Criteria) this;
        }

        public Criteria andFFollowidEqualTo(Integer value) {
            addCriterion("f_followid =", value, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidNotEqualTo(Integer value) {
            addCriterion("f_followid <>", value, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidGreaterThan(Integer value) {
            addCriterion("f_followid >", value, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_followid >=", value, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidLessThan(Integer value) {
            addCriterion("f_followid <", value, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidLessThanOrEqualTo(Integer value) {
            addCriterion("f_followid <=", value, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidIn(List<Integer> values) {
            addCriterion("f_followid in", values, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidNotIn(List<Integer> values) {
            addCriterion("f_followid not in", values, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidBetween(Integer value1, Integer value2) {
            addCriterion("f_followid between", value1, value2, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFFollowidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_followid not between", value1, value2, "fFollowid");
            return (Criteria) this;
        }

        public Criteria andFContentIsNull() {
            addCriterion("f_content is null");
            return (Criteria) this;
        }

        public Criteria andFContentIsNotNull() {
            addCriterion("f_content is not null");
            return (Criteria) this;
        }

        public Criteria andFContentEqualTo(String value) {
            addCriterion("f_content =", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotEqualTo(String value) {
            addCriterion("f_content <>", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentGreaterThan(String value) {
            addCriterion("f_content >", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_content >=", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentLessThan(String value) {
            addCriterion("f_content <", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentLessThanOrEqualTo(String value) {
            addCriterion("f_content <=", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentLike(String value) {
            addCriterion("f_content like", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotLike(String value) {
            addCriterion("f_content not like", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentIn(List<String> values) {
            addCriterion("f_content in", values, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotIn(List<String> values) {
            addCriterion("f_content not in", values, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentBetween(String value1, String value2) {
            addCriterion("f_content between", value1, value2, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotBetween(String value1, String value2) {
            addCriterion("f_content not between", value1, value2, "fContent");
            return (Criteria) this;
        }

        public Criteria andFFolloweridIsNull() {
            addCriterion("f_followerid is null");
            return (Criteria) this;
        }

        public Criteria andFFolloweridIsNotNull() {
            addCriterion("f_followerid is not null");
            return (Criteria) this;
        }

        public Criteria andFFolloweridEqualTo(Integer value) {
            addCriterion("f_followerid =", value, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridNotEqualTo(Integer value) {
            addCriterion("f_followerid <>", value, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridGreaterThan(Integer value) {
            addCriterion("f_followerid >", value, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_followerid >=", value, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridLessThan(Integer value) {
            addCriterion("f_followerid <", value, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridLessThanOrEqualTo(Integer value) {
            addCriterion("f_followerid <=", value, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridIn(List<Integer> values) {
            addCriterion("f_followerid in", values, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridNotIn(List<Integer> values) {
            addCriterion("f_followerid not in", values, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridBetween(Integer value1, Integer value2) {
            addCriterion("f_followerid between", value1, value2, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFFolloweridNotBetween(Integer value1, Integer value2) {
            addCriterion("f_followerid not between", value1, value2, "fFollowerid");
            return (Criteria) this;
        }

        public Criteria andFMainidIsNull() {
            addCriterion("f_mainid is null");
            return (Criteria) this;
        }

        public Criteria andFMainidIsNotNull() {
            addCriterion("f_mainid is not null");
            return (Criteria) this;
        }

        public Criteria andFMainidEqualTo(Integer value) {
            addCriterion("f_mainid =", value, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidNotEqualTo(Integer value) {
            addCriterion("f_mainid <>", value, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidGreaterThan(Integer value) {
            addCriterion("f_mainid >", value, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_mainid >=", value, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidLessThan(Integer value) {
            addCriterion("f_mainid <", value, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidLessThanOrEqualTo(Integer value) {
            addCriterion("f_mainid <=", value, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidIn(List<Integer> values) {
            addCriterion("f_mainid in", values, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidNotIn(List<Integer> values) {
            addCriterion("f_mainid not in", values, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidBetween(Integer value1, Integer value2) {
            addCriterion("f_mainid between", value1, value2, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFMainidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_mainid not between", value1, value2, "fMainid");
            return (Criteria) this;
        }

        public Criteria andFFollowdateIsNull() {
            addCriterion("f_followdate is null");
            return (Criteria) this;
        }

        public Criteria andFFollowdateIsNotNull() {
            addCriterion("f_followdate is not null");
            return (Criteria) this;
        }

        public Criteria andFFollowdateEqualTo(Date value) {
            addCriterion("f_followdate =", value, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateNotEqualTo(Date value) {
            addCriterion("f_followdate <>", value, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateGreaterThan(Date value) {
            addCriterion("f_followdate >", value, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateGreaterThanOrEqualTo(Date value) {
            addCriterion("f_followdate >=", value, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateLessThan(Date value) {
            addCriterion("f_followdate <", value, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateLessThanOrEqualTo(Date value) {
            addCriterion("f_followdate <=", value, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateIn(List<Date> values) {
            addCriterion("f_followdate in", values, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateNotIn(List<Date> values) {
            addCriterion("f_followdate not in", values, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateBetween(Date value1, Date value2) {
            addCriterion("f_followdate between", value1, value2, "fFollowdate");
            return (Criteria) this;
        }

        public Criteria andFFollowdateNotBetween(Date value1, Date value2) {
            addCriterion("f_followdate not between", value1, value2, "fFollowdate");
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