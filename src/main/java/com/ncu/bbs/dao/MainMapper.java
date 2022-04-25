package com.ncu.bbs.dao;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.MainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainMapper {
    long countByExample(MainExample example);

    int deleteByExample(MainExample example);

    int deleteByPrimaryKey(Integer mMainid);

    int insert(Main record);

    int insertSelective(Main record);

    List<Main> selectByExample(MainExample example);

    Main selectByPrimaryKey(Integer mMainid);
    //带上相关该帖子发布者的信息
    List<Main> selectByExampleWithMainer(MainExample example);
    Main selectByPrimaryKeyWithMainer(Integer mMainid);

    //带上相关该帖子发布者的信息
    List<Main> selectByExampleWithFollowNums(MainExample example);

    int updateByExampleSelective(@Param("record") Main record, @Param("example") MainExample example);

    int updateByExample(@Param("record") Main record, @Param("example") MainExample example);

    int updateByPrimaryKeySelective(Main record);

    int updateByPrimaryKey(Main record);
}