package com.ncu.bbs.bean;

import java.util.ArrayList;
import java.util.List;

public class AdministratorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdministratorExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAAdminnameIsNull() {
            addCriterion("a_adminname is null");
            return (Criteria) this;
        }

        public Criteria andAAdminnameIsNotNull() {
            addCriterion("a_adminname is not null");
            return (Criteria) this;
        }

        public Criteria andAAdminnameEqualTo(String value) {
            addCriterion("a_adminname =", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameNotEqualTo(String value) {
            addCriterion("a_adminname <>", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameGreaterThan(String value) {
            addCriterion("a_adminname >", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameGreaterThanOrEqualTo(String value) {
            addCriterion("a_adminname >=", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameLessThan(String value) {
            addCriterion("a_adminname <", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameLessThanOrEqualTo(String value) {
            addCriterion("a_adminname <=", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameLike(String value) {
            addCriterion("a_adminname like", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameNotLike(String value) {
            addCriterion("a_adminname not like", value, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameIn(List<String> values) {
            addCriterion("a_adminname in", values, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameNotIn(List<String> values) {
            addCriterion("a_adminname not in", values, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameBetween(String value1, String value2) {
            addCriterion("a_adminname between", value1, value2, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAAdminnameNotBetween(String value1, String value2) {
            addCriterion("a_adminname not between", value1, value2, "aAdminname");
            return (Criteria) this;
        }

        public Criteria andAPasswordIsNull() {
            addCriterion("a_password is null");
            return (Criteria) this;
        }

        public Criteria andAPasswordIsNotNull() {
            addCriterion("a_password is not null");
            return (Criteria) this;
        }

        public Criteria andAPasswordEqualTo(String value) {
            addCriterion("a_password =", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotEqualTo(String value) {
            addCriterion("a_password <>", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordGreaterThan(String value) {
            addCriterion("a_password >", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("a_password >=", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLessThan(String value) {
            addCriterion("a_password <", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLessThanOrEqualTo(String value) {
            addCriterion("a_password <=", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLike(String value) {
            addCriterion("a_password like", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotLike(String value) {
            addCriterion("a_password not like", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordIn(List<String> values) {
            addCriterion("a_password in", values, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotIn(List<String> values) {
            addCriterion("a_password not in", values, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordBetween(String value1, String value2) {
            addCriterion("a_password between", value1, value2, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotBetween(String value1, String value2) {
            addCriterion("a_password not between", value1, value2, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAHeadpicIsNull() {
            addCriterion("a_headpic is null");
            return (Criteria) this;
        }

        public Criteria andAHeadpicIsNotNull() {
            addCriterion("a_headpic is not null");
            return (Criteria) this;
        }

        public Criteria andAHeadpicEqualTo(String value) {
            addCriterion("a_headpic =", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicNotEqualTo(String value) {
            addCriterion("a_headpic <>", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicGreaterThan(String value) {
            addCriterion("a_headpic >", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicGreaterThanOrEqualTo(String value) {
            addCriterion("a_headpic >=", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicLessThan(String value) {
            addCriterion("a_headpic <", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicLessThanOrEqualTo(String value) {
            addCriterion("a_headpic <=", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicLike(String value) {
            addCriterion("a_headpic like", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicNotLike(String value) {
            addCriterion("a_headpic not like", value, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicIn(List<String> values) {
            addCriterion("a_headpic in", values, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicNotIn(List<String> values) {
            addCriterion("a_headpic not in", values, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicBetween(String value1, String value2) {
            addCriterion("a_headpic between", value1, value2, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAHeadpicNotBetween(String value1, String value2) {
            addCriterion("a_headpic not between", value1, value2, "aHeadpic");
            return (Criteria) this;
        }

        public Criteria andAEmailIsNull() {
            addCriterion("a_email is null");
            return (Criteria) this;
        }

        public Criteria andAEmailIsNotNull() {
            addCriterion("a_email is not null");
            return (Criteria) this;
        }

        public Criteria andAEmailEqualTo(String value) {
            addCriterion("a_email =", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailNotEqualTo(String value) {
            addCriterion("a_email <>", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailGreaterThan(String value) {
            addCriterion("a_email >", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailGreaterThanOrEqualTo(String value) {
            addCriterion("a_email >=", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailLessThan(String value) {
            addCriterion("a_email <", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailLessThanOrEqualTo(String value) {
            addCriterion("a_email <=", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailLike(String value) {
            addCriterion("a_email like", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailNotLike(String value) {
            addCriterion("a_email not like", value, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailIn(List<String> values) {
            addCriterion("a_email in", values, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailNotIn(List<String> values) {
            addCriterion("a_email not in", values, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailBetween(String value1, String value2) {
            addCriterion("a_email between", value1, value2, "aEmail");
            return (Criteria) this;
        }

        public Criteria andAEmailNotBetween(String value1, String value2) {
            addCriterion("a_email not between", value1, value2, "aEmail");
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