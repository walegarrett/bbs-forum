package com.ncu.bbs.bean;

import java.util.Date;

public class Follow {
    private Integer fFollowid;

    private String fContent;

    private Integer fFollowerid;

    private Integer fMainid;

    private Date fFollowdate;

    public Integer getfFollowid() {
        return fFollowid;
    }

    public void setfFollowid(Integer fFollowid) {
        this.fFollowid = fFollowid;
    }

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public Integer getfFollowerid() {
        return fFollowerid;
    }

    public void setfFollowerid(Integer fFollowerid) {
        this.fFollowerid = fFollowerid;
    }

    public Integer getfMainid() {
        return fMainid;
    }

    public void setfMainid(Integer fMainid) {
        this.fMainid = fMainid;
    }

    public Date getfFollowdate() {
        return fFollowdate;
    }

    public void setfFollowdate(Date fFollowdate) {
        this.fFollowdate = fFollowdate;
    }
}