package com.ncu.bbs.bean;

import java.util.ArrayList;
import java.util.List;

public class SectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SectionExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSSectionnameIsNull() {
            addCriterion("s_sectionname is null");
            return (Criteria) this;
        }

        public Criteria andSSectionnameIsNotNull() {
            addCriterion("s_sectionname is not null");
            return (Criteria) this;
        }

        public Criteria andSSectionnameEqualTo(String value) {
            addCriterion("s_sectionname =", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameNotEqualTo(String value) {
            addCriterion("s_sectionname <>", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameGreaterThan(String value) {
            addCriterion("s_sectionname >", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameGreaterThanOrEqualTo(String value) {
            addCriterion("s_sectionname >=", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameLessThan(String value) {
            addCriterion("s_sectionname <", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameLessThanOrEqualTo(String value) {
            addCriterion("s_sectionname <=", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameLike(String value) {
            addCriterion("s_sectionname like", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameNotLike(String value) {
            addCriterion("s_sectionname not like", value, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameIn(List<String> values) {
            addCriterion("s_sectionname in", values, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameNotIn(List<String> values) {
            addCriterion("s_sectionname not in", values, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameBetween(String value1, String value2) {
            addCriterion("s_sectionname between", value1, value2, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSSectionnameNotBetween(String value1, String value2) {
            addCriterion("s_sectionname not between", value1, value2, "sSectionname");
            return (Criteria) this;
        }

        public Criteria andSDescriptionIsNull() {
            addCriterion("s_description is null");
            return (Criteria) this;
        }

        public Criteria andSDescriptionIsNotNull() {
            addCriterion("s_description is not null");
            return (Criteria) this;
        }

        public Criteria andSDescriptionEqualTo(String value) {
            addCriterion("s_description =", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionNotEqualTo(String value) {
            addCriterion("s_description <>", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionGreaterThan(String value) {
            addCriterion("s_description >", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("s_description >=", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionLessThan(String value) {
            addCriterion("s_description <", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionLessThanOrEqualTo(String value) {
            addCriterion("s_description <=", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionLike(String value) {
            addCriterion("s_description like", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionNotLike(String value) {
            addCriterion("s_description not like", value, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionIn(List<String> values) {
            addCriterion("s_description in", values, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionNotIn(List<String> values) {
            addCriterion("s_description not in", values, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionBetween(String value1, String value2) {
            addCriterion("s_description between", value1, value2, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSDescriptionNotBetween(String value1, String value2) {
            addCriterion("s_description not between", value1, value2, "sDescription");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidIsNull() {
            addCriterion("s_banzhuid is null");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidIsNotNull() {
            addCriterion("s_banzhuid is not null");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidEqualTo(Integer value) {
            addCriterion("s_banzhuid =", value, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidNotEqualTo(Integer value) {
            addCriterion("s_banzhuid <>", value, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidGreaterThan(Integer value) {
            addCriterion("s_banzhuid >", value, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_banzhuid >=", value, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidLessThan(Integer value) {
            addCriterion("s_banzhuid <", value, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidLessThanOrEqualTo(Integer value) {
            addCriterion("s_banzhuid <=", value, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidIn(List<Integer> values) {
            addCriterion("s_banzhuid in", values, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidNotIn(List<Integer> values) {
            addCriterion("s_banzhuid not in", values, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidBetween(Integer value1, Integer value2) {
            addCriterion("s_banzhuid between", value1, value2, "sBanzhuid");
            return (Criteria) this;
        }

        public Criteria andSBanzhuidNotBetween(Integer value1, Integer value2) {
            addCriterion("s_banzhuid not between", value1, value2, "sBanzhuid");
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