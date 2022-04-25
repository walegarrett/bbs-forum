package com.ncu.bbs.test;

import com.ncu.bbs.bean.User;
import com.ncu.bbs.services.impl.userServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class userServiceImplTest {
    @Autowired
    userServiceImpl userService;
    @Test
    public void loginTest(){
        User user=userService.login("admi","123456");
        System.out.println(user);
    }
}




