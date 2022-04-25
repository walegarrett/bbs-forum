package com.ncu.bbs.services;

import com.ncu.bbs.bean.Reply;

import java.util.List;

public interface replyService {
    public List<Reply> getReplyByFollowId(int followid);
    public void insertReply(Reply reply);
    public void deleteReply(int replyid);
}
