package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Reply;
import com.ncu.bbs.bean.ReplyExample;
import com.ncu.bbs.dao.ReplyMapper;
import com.ncu.bbs.services.replyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class replyServiceImpl implements replyService {
    @Autowired
    ReplyMapper replyMapper;
    public List<Reply> getReplyByFollowId(int followid) {
        ReplyExample replyExample=new ReplyExample();
        replyExample.setOrderByClause("r_replydate asc");
        replyExample.or();
        replyExample.or().andRFollowidEqualTo(followid);
        List<Reply> list=replyMapper.selectByExample(replyExample);
        return list;
    }

    public void insertReply(Reply reply) {
        replyMapper.insert(reply);
    }

    public void deleteReply(int replyid) {
        ReplyExample replyExample=new ReplyExample();
        replyExample.or();
        replyExample.or().andRReplyidEqualTo(replyid);
        replyMapper.deleteByExample(replyExample);
    }

}
