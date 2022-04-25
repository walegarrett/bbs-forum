package com.ncu.bbs.qi.services;

import com.ncu.bbs.bean.Section;
import com.ncu.bbs.bean.SectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SectionService {

    long countByExample(SectionExample example);

    int deleteByExample(SectionExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Section record);

    int insertSelective(Section record);

    List<Section> selectByExample(SectionExample example);

    Section selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") Section record, @Param("example") SectionExample example);

    int updateByExample(@Param("record") Section record, @Param("example") SectionExample example);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);

    List<Section> getAll();

    void deleteSection(Integer sId);

    Section getSection(Integer sId);

    void updateSection(Section Section);

    void addSection(Section section);
}
