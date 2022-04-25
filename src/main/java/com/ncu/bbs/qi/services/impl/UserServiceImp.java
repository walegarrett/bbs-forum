package com.ncu.bbs.qi.services.impl;


import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.qi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@ContextConfiguration("classpath:applicationContext.xml")
class UserServiceImp implements UserService{

    @Autowired
    private UserMapper Usermapper;

    @Override
    public long countByExample(UserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(UserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return null;
    }

    @Override
    public User selectByPrimaryKey(Integer uId) {
        return Usermapper.selectByPrimaryKey(uId);
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    /**
     * 用户保存方法
     * @param
     */
    @Override
    public void saveUser(User User) {
        if(checkuUserid(User.getuUserid())){
            Usermapper.insertSelective(User);
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> getAll() {
        return Usermapper.selectByExample(null);
    }

    @Override
    public void deleteUser(Integer uId){
        Usermapper.deleteByPrimaryKey(uId);
    }

    /**
     * 通过Userid查找User自增id
     * @param banzhuUserid
     * @return
     */
    @Override
    public Integer getUIdByUserid(String banzhuUserid) {
        UserExample UserExamples=new UserExample();
        com.ncu.bbs.bean.UserExample.Criteria criteria=UserExamples.createCriteria();
        criteria.andUUseridEqualTo(banzhuUserid);
        List<User>list=Usermapper.selectByExample(UserExamples);
        return list.get(0).getuId();
    }

    /**
     * 根据用户名修改是否是版主
     * @param banzhuUserid
     */
    @Override
    public void changeIsBanzhu(Integer originid,String banzhuUserid) {
        UserExample UserExamples=new UserExample();
        com.ncu.bbs.bean.UserExample.Criteria criteria=UserExamples.createCriteria();
        criteria.andUUseridEqualTo(banzhuUserid);
        List<User>list=Usermapper.selectByExample(UserExamples);
        User users=new User();
        users.setuId(originid);
        users.setuIssectioner(0);
        Usermapper.updateByPrimaryKeySelective(users);
        if(list.size()>0){
            User user=list.get(0);
            Integer uid=user.getuId();
            user.setuIssectioner(1);
            UserExample UserExampless=new UserExample();
            com.ncu.bbs.bean.UserExample.Criteria criterias=UserExampless.createCriteria();
            criterias.andUIdEqualTo(uid);
            Usermapper.updateByExampleSelective(user,UserExampless);
        }
    }

    @Override
    public void updateUser(User user) {
        Usermapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUser(Integer uId) {
        User User = Usermapper.selectByPrimaryKey(uId);
        return User;
    }

    /**
     * 检验用户账号是否可用
     * @param
     * @return  true代表当前账号可用 false代表不可用
     */
    public boolean checkuUserid(String uUserid){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUUseridEqualTo(uUserid);
        long count = Usermapper.countByExample(example);
        return count==0;
    }

    @Override
    public boolean checkuId(Integer uId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(uId);
        long count = Usermapper.countByExample(example);
        if(count==0){
            return false;
        }else{
            updatesectioner(uId);
            return true;
        }
    }

    public void updatesectioner(Integer uId){
        User user = new User();
        int a = 1;
        user.setuIssectioner(a);
        user.setuId(uId);
        Usermapper.updateByPrimaryKeySelective(user);
    }
}
