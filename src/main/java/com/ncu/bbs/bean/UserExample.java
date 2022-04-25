package com.ncu.bbs.bean;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUUseridIsNull() {
            addCriterion("u_userid is null");
            return (Criteria) this;
        }

        public Criteria andUUseridIsNotNull() {
            addCriterion("u_userid is not null");
            return (Criteria) this;
        }

        public Criteria andUUseridEqualTo(String value) {
            addCriterion("u_userid =", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridNotEqualTo(String value) {
            addCriterion("u_userid <>", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridGreaterThan(String value) {
            addCriterion("u_userid >", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridGreaterThanOrEqualTo(String value) {
            addCriterion("u_userid >=", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridLessThan(String value) {
            addCriterion("u_userid <", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridLessThanOrEqualTo(String value) {
            addCriterion("u_userid <=", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridLike(String value) {
            addCriterion("u_userid like", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridNotLike(String value) {
            addCriterion("u_userid not like", value, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridIn(List<String> values) {
            addCriterion("u_userid in", values, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridNotIn(List<String> values) {
            addCriterion("u_userid not in", values, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridBetween(String value1, String value2) {
            addCriterion("u_userid between", value1, value2, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUUseridNotBetween(String value1, String value2) {
            addCriterion("u_userid not between", value1, value2, "uUserid");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNull() {
            addCriterion("u_password is null");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNotNull() {
            addCriterion("u_password is not null");
            return (Criteria) this;
        }

        public Criteria andUPasswordEqualTo(String value) {
            addCriterion("u_password =", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotEqualTo(String value) {
            addCriterion("u_password <>", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThan(String value) {
            addCriterion("u_password >", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("u_password >=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThan(String value) {
            addCriterion("u_password <", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThanOrEqualTo(String value) {
            addCriterion("u_password <=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLike(String value) {
            addCriterion("u_password like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotLike(String value) {
            addCriterion("u_password not like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordIn(List<String> values) {
            addCriterion("u_password in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotIn(List<String> values) {
            addCriterion("u_password not in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordBetween(String value1, String value2) {
            addCriterion("u_password between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotBetween(String value1, String value2) {
            addCriterion("u_password not between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUNicknameIsNull() {
            addCriterion("u_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUNicknameIsNotNull() {
            addCriterion("u_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUNicknameEqualTo(String value) {
            addCriterion("u_nickname =", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotEqualTo(String value) {
            addCriterion("u_nickname <>", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameGreaterThan(String value) {
            addCriterion("u_nickname >", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("u_nickname >=", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameLessThan(String value) {
            addCriterion("u_nickname <", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameLessThanOrEqualTo(String value) {
            addCriterion("u_nickname <=", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameLike(String value) {
            addCriterion("u_nickname like", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotLike(String value) {
            addCriterion("u_nickname not like", value, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameIn(List<String> values) {
            addCriterion("u_nickname in", values, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotIn(List<String> values) {
            addCriterion("u_nickname not in", values, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameBetween(String value1, String value2) {
            addCriterion("u_nickname between", value1, value2, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUNicknameNotBetween(String value1, String value2) {
            addCriterion("u_nickname not between", value1, value2, "uNickname");
            return (Criteria) this;
        }

        public Criteria andUSexIsNull() {
            addCriterion("u_sex is null");
            return (Criteria) this;
        }

        public Criteria andUSexIsNotNull() {
            addCriterion("u_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUSexEqualTo(String value) {
            addCriterion("u_sex =", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotEqualTo(String value) {
            addCriterion("u_sex <>", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThan(String value) {
            addCriterion("u_sex >", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThanOrEqualTo(String value) {
            addCriterion("u_sex >=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThan(String value) {
            addCriterion("u_sex <", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThanOrEqualTo(String value) {
            addCriterion("u_sex <=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLike(String value) {
            addCriterion("u_sex like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotLike(String value) {
            addCriterion("u_sex not like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexIn(List<String> values) {
            addCriterion("u_sex in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotIn(List<String> values) {
            addCriterion("u_sex not in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexBetween(String value1, String value2) {
            addCriterion("u_sex between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotBetween(String value1, String value2) {
            addCriterion("u_sex not between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUEmailIsNull() {
            addCriterion("u_email is null");
            return (Criteria) this;
        }

        public Criteria andUEmailIsNotNull() {
            addCriterion("u_email is not null");
            return (Criteria) this;
        }

        public Criteria andUEmailEqualTo(String value) {
            addCriterion("u_email =", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotEqualTo(String value) {
            addCriterion("u_email <>", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailGreaterThan(String value) {
            addCriterion("u_email >", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailGreaterThanOrEqualTo(String value) {
            addCriterion("u_email >=", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLessThan(String value) {
            addCriterion("u_email <", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLessThanOrEqualTo(String value) {
            addCriterion("u_email <=", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLike(String value) {
            addCriterion("u_email like", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotLike(String value) {
            addCriterion("u_email not like", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailIn(List<String> values) {
            addCriterion("u_email in", values, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotIn(List<String> values) {
            addCriterion("u_email not in", values, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailBetween(String value1, String value2) {
            addCriterion("u_email between", value1, value2, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotBetween(String value1, String value2) {
            addCriterion("u_email not between", value1, value2, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUIntroIsNull() {
            addCriterion("u_intro is null");
            return (Criteria) this;
        }

        public Criteria andUIntroIsNotNull() {
            addCriterion("u_intro is not null");
            return (Criteria) this;
        }

        public Criteria andUIntroEqualTo(String value) {
            addCriterion("u_intro =", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroNotEqualTo(String value) {
            addCriterion("u_intro <>", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroGreaterThan(String value) {
            addCriterion("u_intro >", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroGreaterThanOrEqualTo(String value) {
            addCriterion("u_intro >=", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroLessThan(String value) {
            addCriterion("u_intro <", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroLessThanOrEqualTo(String value) {
            addCriterion("u_intro <=", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroLike(String value) {
            addCriterion("u_intro like", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroNotLike(String value) {
            addCriterion("u_intro not like", value, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroIn(List<String> values) {
            addCriterion("u_intro in", values, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroNotIn(List<String> values) {
            addCriterion("u_intro not in", values, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroBetween(String value1, String value2) {
            addCriterion("u_intro between", value1, value2, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUIntroNotBetween(String value1, String value2) {
            addCriterion("u_intro not between", value1, value2, "uIntro");
            return (Criteria) this;
        }

        public Criteria andUHeadpicIsNull() {
            addCriterion("u_headpic is null");
            return (Criteria) this;
        }

        public Criteria andUHeadpicIsNotNull() {
            addCriterion("u_headpic is not null");
            return (Criteria) this;
        }

        public Criteria andUHeadpicEqualTo(String value) {
            addCriterion("u_headpic =", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicNotEqualTo(String value) {
            addCriterion("u_headpic <>", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicGreaterThan(String value) {
            addCriterion("u_headpic >", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicGreaterThanOrEqualTo(String value) {
            addCriterion("u_headpic >=", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicLessThan(String value) {
            addCriterion("u_headpic <", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicLessThanOrEqualTo(String value) {
            addCriterion("u_headpic <=", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicLike(String value) {
            addCriterion("u_headpic like", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicNotLike(String value) {
            addCriterion("u_headpic not like", value, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicIn(List<String> values) {
            addCriterion("u_headpic in", values, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicNotIn(List<String> values) {
            addCriterion("u_headpic not in", values, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicBetween(String value1, String value2) {
            addCriterion("u_headpic between", value1, value2, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUHeadpicNotBetween(String value1, String value2) {
            addCriterion("u_headpic not between", value1, value2, "uHeadpic");
            return (Criteria) this;
        }

        public Criteria andUAgeIsNull() {
            addCriterion("u_age is null");
            return (Criteria) this;
        }

        public Criteria andUAgeIsNotNull() {
            addCriterion("u_age is not null");
            return (Criteria) this;
        }

        public Criteria andUAgeEqualTo(String value) {
            addCriterion("u_age =", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeNotEqualTo(String value) {
            addCriterion("u_age <>", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeGreaterThan(String value) {
            addCriterion("u_age >", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeGreaterThanOrEqualTo(String value) {
            addCriterion("u_age >=", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeLessThan(String value) {
            addCriterion("u_age <", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeLessThanOrEqualTo(String value) {
            addCriterion("u_age <=", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeLike(String value) {
            addCriterion("u_age like", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeNotLike(String value) {
            addCriterion("u_age not like", value, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeIn(List<String> values) {
            addCriterion("u_age in", values, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeNotIn(List<String> values) {
            addCriterion("u_age not in", values, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeBetween(String value1, String value2) {
            addCriterion("u_age between", value1, value2, "uAge");
            return (Criteria) this;
        }

        public Criteria andUAgeNotBetween(String value1, String value2) {
            addCriterion("u_age not between", value1, value2, "uAge");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceIsNull() {
            addCriterion("u_workplace is null");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceIsNotNull() {
            addCriterion("u_workplace is not null");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceEqualTo(String value) {
            addCriterion("u_workplace =", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceNotEqualTo(String value) {
            addCriterion("u_workplace <>", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceGreaterThan(String value) {
            addCriterion("u_workplace >", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("u_workplace >=", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceLessThan(String value) {
            addCriterion("u_workplace <", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceLessThanOrEqualTo(String value) {
            addCriterion("u_workplace <=", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceLike(String value) {
            addCriterion("u_workplace like", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceNotLike(String value) {
            addCriterion("u_workplace not like", value, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceIn(List<String> values) {
            addCriterion("u_workplace in", values, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceNotIn(List<String> values) {
            addCriterion("u_workplace not in", values, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceBetween(String value1, String value2) {
            addCriterion("u_workplace between", value1, value2, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkplaceNotBetween(String value1, String value2) {
            addCriterion("u_workplace not between", value1, value2, "uWorkplace");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyIsNull() {
            addCriterion("u_workproperty is null");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyIsNotNull() {
            addCriterion("u_workproperty is not null");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyEqualTo(String value) {
            addCriterion("u_workproperty =", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyNotEqualTo(String value) {
            addCriterion("u_workproperty <>", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyGreaterThan(String value) {
            addCriterion("u_workproperty >", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyGreaterThanOrEqualTo(String value) {
            addCriterion("u_workproperty >=", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyLessThan(String value) {
            addCriterion("u_workproperty <", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyLessThanOrEqualTo(String value) {
            addCriterion("u_workproperty <=", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyLike(String value) {
            addCriterion("u_workproperty like", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyNotLike(String value) {
            addCriterion("u_workproperty not like", value, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyIn(List<String> values) {
            addCriterion("u_workproperty in", values, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyNotIn(List<String> values) {
            addCriterion("u_workproperty not in", values, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyBetween(String value1, String value2) {
            addCriterion("u_workproperty between", value1, value2, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUWorkpropertyNotBetween(String value1, String value2) {
            addCriterion("u_workproperty not between", value1, value2, "uWorkproperty");
            return (Criteria) this;
        }

        public Criteria andUIssectionerIsNull() {
            addCriterion("u_issectioner is null");
            return (Criteria) this;
        }

        public Criteria andUIssectionerIsNotNull() {
            addCriterion("u_issectioner is not null");
            return (Criteria) this;
        }

        public Criteria andUIssectionerEqualTo(Integer value) {
            addCriterion("u_issectioner =", value, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerNotEqualTo(Integer value) {
            addCriterion("u_issectioner <>", value, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerGreaterThan(Integer value) {
            addCriterion("u_issectioner >", value, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_issectioner >=", value, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerLessThan(Integer value) {
            addCriterion("u_issectioner <", value, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerLessThanOrEqualTo(Integer value) {
            addCriterion("u_issectioner <=", value, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerIn(List<Integer> values) {
            addCriterion("u_issectioner in", values, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerNotIn(List<Integer> values) {
            addCriterion("u_issectioner not in", values, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerBetween(Integer value1, Integer value2) {
            addCriterion("u_issectioner between", value1, value2, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUIssectionerNotBetween(Integer value1, Integer value2) {
            addCriterion("u_issectioner not between", value1, value2, "uIssectioner");
            return (Criteria) this;
        }

        public Criteria andUPointsIsNull() {
            addCriterion("u_points is null");
            return (Criteria) this;
        }

        public Criteria andUPointsIsNotNull() {
            addCriterion("u_points is not null");
            return (Criteria) this;
        }

        public Criteria andUPointsEqualTo(Integer value) {
            addCriterion("u_points =", value, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsNotEqualTo(Integer value) {
            addCriterion("u_points <>", value, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsGreaterThan(Integer value) {
            addCriterion("u_points >", value, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_points >=", value, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsLessThan(Integer value) {
            addCriterion("u_points <", value, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsLessThanOrEqualTo(Integer value) {
            addCriterion("u_points <=", value, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsIn(List<Integer> values) {
            addCriterion("u_points in", values, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsNotIn(List<Integer> values) {
            addCriterion("u_points not in", values, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsBetween(Integer value1, Integer value2) {
            addCriterion("u_points between", value1, value2, "uPoints");
            return (Criteria) this;
        }

        public Criteria andUPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("u_points not between", value1, value2, "uPoints");
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