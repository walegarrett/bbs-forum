package com.ncu.bbs.services;

import com.ncu.bbs.bean.Follow;

import java.util.List;

public interface followService {
    List<Follow> getFollowByMainId(int mainid);
    void deleteFollowById(int followid);
    void insertFollow(Follow follow);
    List<Follow> getFollowPostByMainId(Integer mainId);
}
