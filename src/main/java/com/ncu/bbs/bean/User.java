package com.ncu.bbs.bean;

public class User {
    private Integer uId;

    private String uUserid;

    private String uPassword;

    private String uNickname;

    private String uSex;

    private String uName;

    private String uEmail;

    private String uIntro;

    private String uHeadpic;

    private String uAge;

    private String uWorkplace;

    private String uWorkproperty;

    private Integer uIssectioner;

    private Integer uPoints;

    private Integer mainPostNums;//发帖的总数

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUserid() {
        return uUserid;
    }

    public void setuUserid(String uUserid) {
        this.uUserid = uUserid;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuIntro() {
        return uIntro;
    }

    public void setuIntro(String uIntro) {
        this.uIntro = uIntro;
    }

    public String getuHeadpic() {
        return uHeadpic;
    }

    public void setuHeadpic(String uHeadpic) {
        this.uHeadpic = uHeadpic;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    public String getuWorkplace() {
        return uWorkplace;
    }

    public void setuWorkplace(String uWorkplace) {
        this.uWorkplace = uWorkplace;
    }

    public String getuWorkproperty() {
        return uWorkproperty;
    }

    public void setuWorkproperty(String uWorkproperty) {
        this.uWorkproperty = uWorkproperty;
    }

    public Integer getuIssectioner() {
        return uIssectioner;
    }

    public void setuIssectioner(Integer uIssectioner) {
        this.uIssectioner = uIssectioner;
    }

    public Integer getuPoints() {
        return uPoints;
    }

    public void setuPoints(Integer uPoints) {
        this.uPoints = uPoints;
    }

    public Integer getMainPostNums() {
        return mainPostNums;
    }

    public void setMainPostNums(Integer mainPostNums) {
        this.mainPostNums = mainPostNums;
    }
}