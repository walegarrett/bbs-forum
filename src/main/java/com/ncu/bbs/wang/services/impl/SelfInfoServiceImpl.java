package com.ncu.bbs.wang.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.MainExample;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.wang.services.SelfInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration("classpath:applicationContext.xml")
public class SelfInfoServiceImpl implements SelfInfoService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MainMapper mainMapper;
    public void saveAllselfInfo(User user){
        System.out.println(user.getuNickname());
        System.out.println(user.getuIntro());
        System.out.println(user.getuAge());
        System.out.println(user.getuWorkplace());
        UserExample example = new UserExample();
        example.or();
        example.or().andUUseridEqualTo(user.getuUserid());
        userMapper.updateByExampleSelective(user,example);
    }
    public List<User> selectUserByuserid(String userid){
        UserExample example = new UserExample();
        example.or();
        example.or().andUUseridEqualTo(userid);
        List<User>list = userMapper.selectByExample(example);
        System.out.println(list);
        System.out.println("example ！！！！");
        return list;
    }
    public List<Main> selectMainByMainerid(String Mainerid){
        UserExample example = new UserExample();
        example.or();
        example.or().andUUseridEqualTo(Mainerid);
        List<User>list = userMapper.selectByExample(example);
//       System.out.println(list.get(0));
       MainExample example2 = new MainExample();
        example2.or();
        example2.or().andMMaineridEqualTo(list.get(0).getuId());
        List<Main>list2 = mainMapper.selectByExample(example2);
        return list2;
    }
    public void  deleteMainByMainid(String mainid ){

        mainMapper.deleteByPrimaryKey(Integer.parseInt(mainid));

    }
}
