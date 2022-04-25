package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.MainExample;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MainMapper mainMapper;
    public User login(String username, String pwd) {
        User user=new User();
        UserExample userExample = new UserExample();
        userExample.or();
        userExample.or().andUUseridEqualTo(username).andUPasswordEqualTo(pwd);
        List<User> result=userMapper.selectByExample(userExample);
        if (result.size()>0)
        user=result.get(0);
        else
            user=null;
        return user;
    }

    public User getUserByname(String username) {
        User user=new User();
        UserExample userExample = new UserExample();
        userExample.or();
        userExample.or().andUUseridEqualTo(username);
        List<User> result=userMapper.selectByExample(userExample);
        if (result.size()>0)
            user=result.get(0);
        else
            user=null;
        return user;
    }

    public User getUserById(int id) {
        User user=new User();
        UserExample userExample = new UserExample();
        userExample.or();
        userExample.or().andUIdEqualTo(id);
        List<User> result=userMapper.selectByExample(userExample);
        if (result.size()>0)
            user=result.get(0);
        else
            user=null;
        return user;
    }
    @Override
    public void addPoint(int mainid, int followerid, int point,int mainpoint) {
        //主帖减积分，用户加积分
        MainExample mainExample=new MainExample();
//        mainExample.or().andMMainidEqualTo(mainid);
//        Main main=new Main();
//        main.setmContent(content);
//        main.setmMainid(mainid);
//        mainMapper.updateByExampleSelective(main,mainExample);
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        Main main=new Main();
        main.setmPoint(mainpoint);
        main.setmMainid(mainid);
        mainMapper.updateByExampleSelective(main,mainExample);

        User user=getUserById(followerid);
        UserExample userExample=new UserExample();
        userExample.or();
        userExample.or().andUIdEqualTo(user.getuId());
        User user1=new User();
        user1.setuId(user.getuId());
        user1.setuPoints(user.getuPoints()+point);
        userMapper.updateByExampleSelective(user1,userExample);
    }

    /**
     * wale
     * @param latestuserid
     * @return
     */
    @Override
    public User getUserByUserId(Integer latestuserid) {

        return userMapper.selectByPrimaryKey(latestuserid);
    }

    /**
     * 根据关键词查找符合条件的用户，这里只匹配账号
     * @param keyword
     * @return
     */
    @Override
    public List<User> searchUsersByKeyWord(String keyword) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUUseridLike("%"+keyword+"%");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void changeHeadPic(int uid,String headpic) {
        UserExample userExample=new UserExample();
        userExample.or();
        userExample.or().andUIdEqualTo(uid);
        User user=new User();
        user.setuId(uid);
        user.setuHeadpic("/bbs/statics/images/upload/"+headpic);
        userMapper.updateByExampleSelective(user,userExample);
    }

    /**
     * 根据用户名获取用户的积分
     * @param userid
     * @return
     */
    @Override
    public int getPointByUId(int userid) {
        User user= userMapper.selectByPrimaryKey(userid);
        if(user!=null)
            return user.getuPoints();
        else return 0;
    }

    /**
     * 根据用户名进行积分删减功能
     * @param userid
     * @param finalPoints
     */
    @Override
    public void changePointByUserid(int userid, int finalPoints) {
        User user=new User();
        user.setuId(userid);
        user.setuPoints(finalPoints);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
