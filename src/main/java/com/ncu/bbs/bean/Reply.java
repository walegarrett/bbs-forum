package com.ncu.bbs.bean;

import java.util.Date;

public class Reply {
    private Integer rReplyid;

    private String rContent;

    private Integer rReplyerid;

    private Integer rFollowid;

    private Date rReplydate;

    public Integer getrReplyid() {
        return rReplyid;
    }

    public void setrReplyid(Integer rReplyid) {
        this.rReplyid = rReplyid;
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent;
    }

    public Integer getrReplyerid() {
        return rReplyerid;
    }

    public void setrReplyerid(Integer rReplyerid) {
        this.rReplyerid = rReplyerid;
    }

    public Integer getrFollowid() {
        return rFollowid;
    }

    public void setrFollowid(Integer rFollowid) {
        this.rFollowid = rFollowid;
    }

    public Date getrReplydate() {
        return rReplydate;
    }

    public void setrReplydate(Date rReplydate) {
        this.rReplydate = rReplydate;
    }
}