package com.ncu.bbs.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyExample() {
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

        public Criteria andRReplyidIsNull() {
            addCriterion("r_replyid is null");
            return (Criteria) this;
        }

        public Criteria andRReplyidIsNotNull() {
            addCriterion("r_replyid is not null");
            return (Criteria) this;
        }

        public Criteria andRReplyidEqualTo(Integer value) {
            addCriterion("r_replyid =", value, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidNotEqualTo(Integer value) {
            addCriterion("r_replyid <>", value, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidGreaterThan(Integer value) {
            addCriterion("r_replyid >", value, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_replyid >=", value, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidLessThan(Integer value) {
            addCriterion("r_replyid <", value, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidLessThanOrEqualTo(Integer value) {
            addCriterion("r_replyid <=", value, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidIn(List<Integer> values) {
            addCriterion("r_replyid in", values, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidNotIn(List<Integer> values) {
            addCriterion("r_replyid not in", values, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidBetween(Integer value1, Integer value2) {
            addCriterion("r_replyid between", value1, value2, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRReplyidNotBetween(Integer value1, Integer value2) {
            addCriterion("r_replyid not between", value1, value2, "rReplyid");
            return (Criteria) this;
        }

        public Criteria andRContentIsNull() {
            addCriterion("r_content is null");
            return (Criteria) this;
        }

        public Criteria andRContentIsNotNull() {
            addCriterion("r_content is not null");
            return (Criteria) this;
        }

        public Criteria andRContentEqualTo(String value) {
            addCriterion("r_content =", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentNotEqualTo(String value) {
            addCriterion("r_content <>", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentGreaterThan(String value) {
            addCriterion("r_content >", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentGreaterThanOrEqualTo(String value) {
            addCriterion("r_content >=", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentLessThan(String value) {
            addCriterion("r_content <", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentLessThanOrEqualTo(String value) {
            addCriterion("r_content <=", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentLike(String value) {
            addCriterion("r_content like", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentNotLike(String value) {
            addCriterion("r_content not like", value, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentIn(List<String> values) {
            addCriterion("r_content in", values, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentNotIn(List<String> values) {
            addCriterion("r_content not in", values, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentBetween(String value1, String value2) {
            addCriterion("r_content between", value1, value2, "rContent");
            return (Criteria) this;
        }

        public Criteria andRContentNotBetween(String value1, String value2) {
            addCriterion("r_content not between", value1, value2, "rContent");
            return (Criteria) this;
        }

        public Criteria andRReplyeridIsNull() {
            addCriterion("r_replyerid is null");
            return (Criteria) this;
        }

        public Criteria andRReplyeridIsNotNull() {
            addCriterion("r_replyerid is not null");
            return (Criteria) this;
        }

        public Criteria andRReplyeridEqualTo(Integer value) {
            addCriterion("r_replyerid =", value, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridNotEqualTo(Integer value) {
            addCriterion("r_replyerid <>", value, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridGreaterThan(Integer value) {
            addCriterion("r_replyerid >", value, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_replyerid >=", value, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridLessThan(Integer value) {
            addCriterion("r_replyerid <", value, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridLessThanOrEqualTo(Integer value) {
            addCriterion("r_replyerid <=", value, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridIn(List<Integer> values) {
            addCriterion("r_replyerid in", values, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridNotIn(List<Integer> values) {
            addCriterion("r_replyerid not in", values, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridBetween(Integer value1, Integer value2) {
            addCriterion("r_replyerid between", value1, value2, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRReplyeridNotBetween(Integer value1, Integer value2) {
            addCriterion("r_replyerid not between", value1, value2, "rReplyerid");
            return (Criteria) this;
        }

        public Criteria andRFollowidIsNull() {
            addCriterion("r_followid is null");
            return (Criteria) this;
        }

        public Criteria andRFollowidIsNotNull() {
            addCriterion("r_followid is not null");
            return (Criteria) this;
        }

        public Criteria andRFollowidEqualTo(Integer value) {
            addCriterion("r_followid =", value, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidNotEqualTo(Integer value) {
            addCriterion("r_followid <>", value, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidGreaterThan(Integer value) {
            addCriterion("r_followid >", value, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_followid >=", value, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidLessThan(Integer value) {
            addCriterion("r_followid <", value, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidLessThanOrEqualTo(Integer value) {
            addCriterion("r_followid <=", value, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidIn(List<Integer> values) {
            addCriterion("r_followid in", values, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidNotIn(List<Integer> values) {
            addCriterion("r_followid not in", values, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidBetween(Integer value1, Integer value2) {
            addCriterion("r_followid between", value1, value2, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRFollowidNotBetween(Integer value1, Integer value2) {
            addCriterion("r_followid not between", value1, value2, "rFollowid");
            return (Criteria) this;
        }

        public Criteria andRReplydateIsNull() {
            addCriterion("r_replydate is null");
            return (Criteria) this;
        }

        public Criteria andRReplydateIsNotNull() {
            addCriterion("r_replydate is not null");
            return (Criteria) this;
        }

        public Criteria andRReplydateEqualTo(Date value) {
            addCriterion("r_replydate =", value, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateNotEqualTo(Date value) {
            addCriterion("r_replydate <>", value, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateGreaterThan(Date value) {
            addCriterion("r_replydate >", value, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("r_replydate >=", value, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateLessThan(Date value) {
            addCriterion("r_replydate <", value, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateLessThanOrEqualTo(Date value) {
            addCriterion("r_replydate <=", value, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateIn(List<Date> values) {
            addCriterion("r_replydate in", values, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateNotIn(List<Date> values) {
            addCriterion("r_replydate not in", values, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateBetween(Date value1, Date value2) {
            addCriterion("r_replydate between", value1, value2, "rReplydate");
            return (Criteria) this;
        }

        public Criteria andRReplydateNotBetween(Date value1, Date value2) {
            addCriterion("r_replydate not between", value1, value2, "rReplydate");
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