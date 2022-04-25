package com.ncu.bbs.wale.test;

import com.ncu.bbs.bean.Follow;
import com.ncu.bbs.dao.FollowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 9:03
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FollowTest {
    @Autowired
    FollowMapper followMapper;

    @Test
    public void addSomeFollows(){
        //1-49main
        //1-20user
        for(int i=0;i<20;i++){
            Follow follow=new Follow();
            follow.setfMainid((int)(Math.random()*10)+1);
            follow.setfFollowerid((int)(Math.random()*20)+1);
            follow.setfContent("这是跟帖内容：跟帖人是："+follow.getfFollowerid()+"跟的主帖是："+follow.getfMainid());
            follow.setfFollowdate(new Date());
            followMapper.insertSelective(follow);
        }
    }

}
