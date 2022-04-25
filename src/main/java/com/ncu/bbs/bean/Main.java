package com.ncu.bbs.bean;

import java.util.Date;
import java.util.List;

public class Main {
    private Integer mMainid;

    private String mTitle;

    private String mContent;

    private Integer mMainerid;

    private Integer mSectionid;

    private Integer mIsontop;

    private Integer mIsperfect;

    private Date mMaindate;

    private Integer mPoint;

    private User user;//新增加一个该帖子的发布者的信息字段

    private List<Follow> follows;//新增一个所有跟帖者的信息字段

    private User latestPublish;//新增加该帖子对应的最新发表者的信息是谁

    private long latestTime;//最后发表信息的时间

    private Integer follownums;//跟帖者的数量

    private Section section;//所在版块的信息

    public Integer getmMainid() {
        return mMainid;
    }


    public void setmMainid(Integer mMainid) {
        this.mMainid = mMainid;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Integer getmMainerid() {
        return mMainerid;
    }

    public void setmMainerid(Integer mMainerid) {
        this.mMainerid = mMainerid;
    }

    public Integer getmSectionid() {
        return mSectionid;
    }

    public void setmSectionid(Integer mSectionid) {
        this.mSectionid = mSectionid;
    }

    public Integer getmIsontop() {
        return mIsontop;
    }

    public void setmIsontop(Integer mIsontop) {
        this.mIsontop = mIsontop;
    }

    public Integer getmIsperfect() {
        return mIsperfect;
    }

    public void setmIsperfect(Integer mIsperfect) {
        this.mIsperfect = mIsperfect;
    }

    public Date getmMaindate() {
        return mMaindate;
    }

    public void setmMaindate(Date mMaindate) {
        this.mMaindate = mMaindate;
    }

    public Integer getmPoint() {
        return mPoint;
    }

    public void setmPoint(Integer mPoint) {
        this.mPoint = mPoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Follow> getFollows() {
        return follows;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }

    public User getLatestPublish() {
        return latestPublish;
    }

    public void setLatestPublish(User latestPublish) {
        this.latestPublish = latestPublish;
    }

    public long getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(long latestTime) {
        this.latestTime = latestTime;
    }

    public Integer getFollownums() {
        return follownums;
    }

    public void setFollownums(Integer follownums) {
        this.follownums = follownums;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}