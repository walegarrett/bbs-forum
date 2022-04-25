package com.ncu.bbs.services;

import com.ncu.bbs.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {
     public User login(String username, String pwd);
     public User getUserByname(String username);
     public User getUserById(int id);
     public void addPoint(int mainid, int followerid, int point,int mainpoint);

     /*
          wale
      */
     User getUserByUserId(Integer latestuserid);

     List<User> searchUsersByKeyWord(String keyword);

     void changeHeadPic(int uid,String headpic) ;

     int getPointByUId(int userid);

     void changePointByUserid(int parseInt, int finalPoints);
}