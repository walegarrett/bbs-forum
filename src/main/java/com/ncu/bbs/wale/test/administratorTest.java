package com.ncu.bbs.wale.test;

import com.ncu.bbs.bean.Administrator;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.AdministratorMapper;
import com.ncu.bbs.dao.UserMapper;

import com.ncu.bbs.services.impl.AdminServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class administratorTest {
    @Autowired
    AdminServiceImpl administratorService;
    @Autowired
    AdministratorMapper administratorMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 插入一个管理员
     */
    @Test
    public void insertAdministrator(){
        Administrator administrator=new Administrator();
        administrator.setaAdminname("管理员");
        administrator.setaEmail("bbb");
        administrator.setaHeadpic("ccc");
        administrator.setaPassword("123456");
        administratorService.insertAdministrator(administrator);
    }

    /**
     * 查询所有的管理员，删除第一个管理员
     */
    @Test
    public void  selectAllAdministrator(){
        List<Administrator> list=administratorService.selectAllAdministrator();
        administratorMapper.deleteByPrimaryKey(1);
        System.out.println(list.get(1));
    }

    /**
     * 自动生成增加一些用户
     */
    @Test
    public void addUsers(){
        for(int i=0;i<20;i++){
            String name= UUID.randomUUID().toString().substring(0,6);
            String nickname=name;
            User user=new User();
            user.setuAge("22");user.setuEmail(name+"@qq.com");user.setuIntro("开朗");
            user.setuNickname("昵称"+name);user.setuWorkplace("江西");user.setuPassword("123456");
            user.setuPoints(0);user.setuIssectioner(0);user.setuSex("男");user.setuWorkproperty("学生");
            user.setuUserid(name);user.setuName("真实名字："+name);
            userMapper.insertSelective(user);
            //userMapper.insertSelective(new User(null,name,"123456",nickname,"F",
            // name,name+"@qq.com","开朗，hello",null,"22","江西","学生",0,0));
        }
    }

    /**
     * 删除所有用户
     */
    @Test
    public void deleteAllUser(){
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUIdIsNotNull();
        userMapper.deleteByExample(example);
    }

    /**
     * 更新所有用户的性别
     */
    @Test
    public void updateUsersGender(){
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUSexEqualTo("F");
        User user=new User();
        user.setuSex("男");
        userMapper.updateByExampleSelective(user,example);
        //userMapper.updateByExampleSelective(new User(null,null,null,null,"男",null,null,null,null,null,null,null,null,null),example);
    }
}
