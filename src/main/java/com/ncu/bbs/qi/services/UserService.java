package com.ncu.bbs.qi.services;

import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void saveUser(User User);

    boolean checkuUserid(String uUserid);

    List<User> getAll();

    void deleteUser(Integer uUserid);

    Integer getUIdByUserid(String banzhuUserid);

    void changeIsBanzhu(Integer originid,String banzhuUserid);

    void updateUser(User user);

    User getUser(Integer uId);

    boolean checkuId(Integer uId);
}
