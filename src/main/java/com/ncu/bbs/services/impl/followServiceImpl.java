package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Follow;
import com.ncu.bbs.bean.FollowExample;
import com.ncu.bbs.dao.FollowMapper;
import com.ncu.bbs.services.followService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class followServiceImpl implements followService {
    @Autowired
    FollowMapper followMapper;
    public List<Follow> getFollowByMainId(int mainid) {
        FollowExample followExample=new FollowExample();
        followExample.setOrderByClause("f_followdate asc");
        followExample.or();
        followExample.or().andFMainidEqualTo(mainid);
        List<Follow> list=followMapper.selectByExample(followExample);
        return list;
    }

    public void deleteFollowById(int followid) {
        FollowExample followExample=new FollowExample();
        followExample.or();
        followExample.or().andFFollowidEqualTo(followid);
        followMapper.deleteByExample(followExample);
    }

    public void insertFollow(Follow follow) {
        followMapper.insert(follow);
    }
/**
 * wale
 */

    @Override
    public List<Follow> getFollowPostByMainId(Integer mainId) {
        FollowExample followExample=new FollowExample();
        FollowExample.Criteria criteria=followExample.createCriteria();
        criteria.andFMainidEqualTo(mainId);
        return followMapper.selectByExample(followExample);
    }
}
