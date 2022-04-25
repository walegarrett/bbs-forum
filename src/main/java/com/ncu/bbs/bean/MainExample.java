package com.ncu.bbs.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MainExample() {
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

        public Criteria andMMainidIsNull() {
            addCriterion("m_mainid is null");
            return (Criteria) this;
        }

        public Criteria andMMainidIsNotNull() {
            addCriterion("m_mainid is not null");
            return (Criteria) this;
        }

        public Criteria andMMainidEqualTo(Integer value) {
            addCriterion("m_mainid =", value, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidNotEqualTo(Integer value) {
            addCriterion("m_mainid <>", value, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidGreaterThan(Integer value) {
            addCriterion("m_mainid >", value, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_mainid >=", value, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidLessThan(Integer value) {
            addCriterion("m_mainid <", value, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidLessThanOrEqualTo(Integer value) {
            addCriterion("m_mainid <=", value, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidIn(List<Integer> values) {
            addCriterion("m_mainid in", values, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidNotIn(List<Integer> values) {
            addCriterion("m_mainid not in", values, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidBetween(Integer value1, Integer value2) {
            addCriterion("m_mainid between", value1, value2, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMMainidNotBetween(Integer value1, Integer value2) {
            addCriterion("m_mainid not between", value1, value2, "mMainid");
            return (Criteria) this;
        }

        public Criteria andMTitleIsNull() {
            addCriterion("m_title is null");
            return (Criteria) this;
        }

        public Criteria andMTitleIsNotNull() {
            addCriterion("m_title is not null");
            return (Criteria) this;
        }

        public Criteria andMTitleEqualTo(String value) {
            addCriterion("m_title =", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotEqualTo(String value) {
            addCriterion("m_title <>", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleGreaterThan(String value) {
            addCriterion("m_title >", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleGreaterThanOrEqualTo(String value) {
            addCriterion("m_title >=", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleLessThan(String value) {
            addCriterion("m_title <", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleLessThanOrEqualTo(String value) {
            addCriterion("m_title <=", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleLike(String value) {
            addCriterion("m_title like", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotLike(String value) {
            addCriterion("m_title not like", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleIn(List<String> values) {
            addCriterion("m_title in", values, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotIn(List<String> values) {
            addCriterion("m_title not in", values, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleBetween(String value1, String value2) {
            addCriterion("m_title between", value1, value2, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotBetween(String value1, String value2) {
            addCriterion("m_title not between", value1, value2, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMContentIsNull() {
            addCriterion("m_content is null");
            return (Criteria) this;
        }

        public Criteria andMContentIsNotNull() {
            addCriterion("m_content is not null");
            return (Criteria) this;
        }

        public Criteria andMContentEqualTo(String value) {
            addCriterion("m_content =", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotEqualTo(String value) {
            addCriterion("m_content <>", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentGreaterThan(String value) {
            addCriterion("m_content >", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentGreaterThanOrEqualTo(String value) {
            addCriterion("m_content >=", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentLessThan(String value) {
            addCriterion("m_content <", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentLessThanOrEqualTo(String value) {
            addCriterion("m_content <=", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentLike(String value) {
            addCriterion("m_content like", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotLike(String value) {
            addCriterion("m_content not like", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentIn(List<String> values) {
            addCriterion("m_content in", values, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotIn(List<String> values) {
            addCriterion("m_content not in", values, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentBetween(String value1, String value2) {
            addCriterion("m_content between", value1, value2, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotBetween(String value1, String value2) {
            addCriterion("m_content not between", value1, value2, "mContent");
            return (Criteria) this;
        }

        public Criteria andMMaineridIsNull() {
            addCriterion("m_mainerid is null");
            return (Criteria) this;
        }

        public Criteria andMMaineridIsNotNull() {
            addCriterion("m_mainerid is not null");
            return (Criteria) this;
        }

        public Criteria andMMaineridEqualTo(Integer value) {
            addCriterion("m_mainerid =", value, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridNotEqualTo(Integer value) {
            addCriterion("m_mainerid <>", value, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridGreaterThan(Integer value) {
            addCriterion("m_mainerid >", value, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_mainerid >=", value, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridLessThan(Integer value) {
            addCriterion("m_mainerid <", value, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridLessThanOrEqualTo(Integer value) {
            addCriterion("m_mainerid <=", value, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridIn(List<Integer> values) {
            addCriterion("m_mainerid in", values, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridNotIn(List<Integer> values) {
            addCriterion("m_mainerid not in", values, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridBetween(Integer value1, Integer value2) {
            addCriterion("m_mainerid between", value1, value2, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMMaineridNotBetween(Integer value1, Integer value2) {
            addCriterion("m_mainerid not between", value1, value2, "mMainerid");
            return (Criteria) this;
        }

        public Criteria andMSectionidIsNull() {
            addCriterion("m_sectionid is null");
            return (Criteria) this;
        }

        public Criteria andMSectionidIsNotNull() {
            addCriterion("m_sectionid is not null");
            return (Criteria) this;
        }

        public Criteria andMSectionidEqualTo(Integer value) {
            addCriterion("m_sectionid =", value, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidNotEqualTo(Integer value) {
            addCriterion("m_sectionid <>", value, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidGreaterThan(Integer value) {
            addCriterion("m_sectionid >", value, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_sectionid >=", value, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidLessThan(Integer value) {
            addCriterion("m_sectionid <", value, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidLessThanOrEqualTo(Integer value) {
            addCriterion("m_sectionid <=", value, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidIn(List<Integer> values) {
            addCriterion("m_sectionid in", values, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidNotIn(List<Integer> values) {
            addCriterion("m_sectionid not in", values, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidBetween(Integer value1, Integer value2) {
            addCriterion("m_sectionid between", value1, value2, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMSectionidNotBetween(Integer value1, Integer value2) {
            addCriterion("m_sectionid not between", value1, value2, "mSectionid");
            return (Criteria) this;
        }

        public Criteria andMIsontopIsNull() {
            addCriterion("m_isontop is null");
            return (Criteria) this;
        }

        public Criteria andMIsontopIsNotNull() {
            addCriterion("m_isontop is not null");
            return (Criteria) this;
        }

        public Criteria andMIsontopEqualTo(Integer value) {
            addCriterion("m_isontop =", value, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopNotEqualTo(Integer value) {
            addCriterion("m_isontop <>", value, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopGreaterThan(Integer value) {
            addCriterion("m_isontop >", value, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_isontop >=", value, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopLessThan(Integer value) {
            addCriterion("m_isontop <", value, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopLessThanOrEqualTo(Integer value) {
            addCriterion("m_isontop <=", value, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopIn(List<Integer> values) {
            addCriterion("m_isontop in", values, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopNotIn(List<Integer> values) {
            addCriterion("m_isontop not in", values, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopBetween(Integer value1, Integer value2) {
            addCriterion("m_isontop between", value1, value2, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsontopNotBetween(Integer value1, Integer value2) {
            addCriterion("m_isontop not between", value1, value2, "mIsontop");
            return (Criteria) this;
        }

        public Criteria andMIsperfectIsNull() {
            addCriterion("m_isperfect is null");
            return (Criteria) this;
        }

        public Criteria andMIsperfectIsNotNull() {
            addCriterion("m_isperfect is not null");
            return (Criteria) this;
        }

        public Criteria andMIsperfectEqualTo(Integer value) {
            addCriterion("m_isperfect =", value, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectNotEqualTo(Integer value) {
            addCriterion("m_isperfect <>", value, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectGreaterThan(Integer value) {
            addCriterion("m_isperfect >", value, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_isperfect >=", value, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectLessThan(Integer value) {
            addCriterion("m_isperfect <", value, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectLessThanOrEqualTo(Integer value) {
            addCriterion("m_isperfect <=", value, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectIn(List<Integer> values) {
            addCriterion("m_isperfect in", values, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectNotIn(List<Integer> values) {
            addCriterion("m_isperfect not in", values, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectBetween(Integer value1, Integer value2) {
            addCriterion("m_isperfect between", value1, value2, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMIsperfectNotBetween(Integer value1, Integer value2) {
            addCriterion("m_isperfect not between", value1, value2, "mIsperfect");
            return (Criteria) this;
        }

        public Criteria andMMaindateIsNull() {
            addCriterion("m_maindate is null");
            return (Criteria) this;
        }

        public Criteria andMMaindateIsNotNull() {
            addCriterion("m_maindate is not null");
            return (Criteria) this;
        }

        public Criteria andMMaindateEqualTo(Date value) {
            addCriterion("m_maindate =", value, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateNotEqualTo(Date value) {
            addCriterion("m_maindate <>", value, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateGreaterThan(Date value) {
            addCriterion("m_maindate >", value, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateGreaterThanOrEqualTo(Date value) {
            addCriterion("m_maindate >=", value, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateLessThan(Date value) {
            addCriterion("m_maindate <", value, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateLessThanOrEqualTo(Date value) {
            addCriterion("m_maindate <=", value, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateIn(List<Date> values) {
            addCriterion("m_maindate in", values, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateNotIn(List<Date> values) {
            addCriterion("m_maindate not in", values, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateBetween(Date value1, Date value2) {
            addCriterion("m_maindate between", value1, value2, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMMaindateNotBetween(Date value1, Date value2) {
            addCriterion("m_maindate not between", value1, value2, "mMaindate");
            return (Criteria) this;
        }

        public Criteria andMPointIsNull() {
            addCriterion("m_point is null");
            return (Criteria) this;
        }

        public Criteria andMPointIsNotNull() {
            addCriterion("m_point is not null");
            return (Criteria) this;
        }

        public Criteria andMPointEqualTo(Integer value) {
            addCriterion("m_point =", value, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointNotEqualTo(Integer value) {
            addCriterion("m_point <>", value, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointGreaterThan(Integer value) {
            addCriterion("m_point >", value, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_point >=", value, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointLessThan(Integer value) {
            addCriterion("m_point <", value, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointLessThanOrEqualTo(Integer value) {
            addCriterion("m_point <=", value, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointIn(List<Integer> values) {
            addCriterion("m_point in", values, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointNotIn(List<Integer> values) {
            addCriterion("m_point not in", values, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointBetween(Integer value1, Integer value2) {
            addCriterion("m_point between", value1, value2, "mPoint");
            return (Criteria) this;
        }

        public Criteria andMPointNotBetween(Integer value1, Integer value2) {
            addCriterion("m_point not between", value1, value2, "mPoint");
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