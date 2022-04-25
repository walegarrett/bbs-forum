package com.ncu.bbs.test;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.services.impl.mainServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class mainServiceImplTest {
    @Autowired
    mainServiceImpl mainService;
    @Test
    public void getMainByIdTest(){
        Main main=mainService.getMainById(1);
        Date date=main.getmMaindate();
        System.out.println(date.toString());
    }
}
