package com.ncu.bbs.wale.test;

import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.services.userService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 12:48
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    com.ncu.bbs.services.userService userService;

    @Test
    public void addSomHeadPic(){
        for(int i=0;i<20;i++){
            User user=new User();
            user.setuHeadpic("/bbs/statics/images/default.jpeg");
            UserExample userExample=new UserExample();
            UserExample.Criteria criteria=userExample.createCriteria();
            criteria.andUHeadpicIsNull();
            userMapper.updateByExampleSelective(user,userExample);
        }
    }

    @Test
    public void changeHeadPic(){
        userService.changeHeadPic(2,"1243");
    }
}
