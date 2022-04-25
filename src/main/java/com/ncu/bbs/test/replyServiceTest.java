package com.ncu.bbs.test;

import com.ncu.bbs.bean.Reply;
import com.ncu.bbs.services.impl.replyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class replyServiceTest {
    @Autowired
    replyServiceImpl  replyService;
    @Test
    public void getReplyByFollowIdTest(){
        List<Reply> list=replyService.getReplyByFollowId(2);
        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i).getrContent());
    }
    @Test
    public void insertReplyTest(){
        int s=123456;
        Date date=new Date(s);
        System.out.println(date);
    }
}
