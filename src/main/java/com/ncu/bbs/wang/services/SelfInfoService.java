package com.ncu.bbs.wang.services;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SelfInfoService {
public void saveAllselfInfo(User user);
public List<User> selectUserByuserid(String userid);
public List<Main> selectMainByMainerid(String Mainerid);
public  void  deleteMainByMainid(String mainid );
}
