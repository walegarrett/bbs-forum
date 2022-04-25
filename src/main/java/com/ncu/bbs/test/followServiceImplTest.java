package com.ncu.bbs.test;

import com.ncu.bbs.bean.Follow;
import com.ncu.bbs.bean.FollowExample;
import com.ncu.bbs.dao.FollowMapper;
import com.ncu.bbs.services.impl.followServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class followServiceImplTest {
    @Autowired
    followServiceImpl followService;
    @Autowired
    FollowMapper followMapper;
    @Test
    public void getFollowByMainIdTest(){
        List<Follow> list=followService.getFollowByMainId(1);
        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i).getfFollowdate());
    }
    @Test
    public void insertManyFollow(){
        FollowExample followExample=new FollowExample();
        followExample.or();
        followExample.or().andFFollowidEqualTo(1);
        List<Follow> list=followMapper.selectByExample(followExample);
        Follow follow=list.get(0);
        follow.setfFollowid(null);
        for (int i=0;i<50;i++)
        followService.insertFollow(follow);
    }
}
