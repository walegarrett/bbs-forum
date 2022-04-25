package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Section;
import com.ncu.bbs.bean.SectionExample;
import com.ncu.bbs.dao.SectionMapper;
import com.ncu.bbs.services.SectionService;
import com.ncu.bbs.services.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionMapper sectionMapper;

    @Autowired
    com.ncu.bbs.services.mainService mainService;
    /**
     * 查找主页显示的所有帖子,同时会查询到最多4个精华帖用于显示在主页
     * @return
     */
    public List<Section> findAllSections() {
        List<Section> finals=new ArrayList<Section>();
        List<Section>list=new ArrayList<Section>();
        SectionExample example=new SectionExample();
        SectionExample.Criteria criteria=example.createCriteria();
        criteria.andSBanzhuidIsNotNull();//只要版主id不为空就查询出来
        list=sectionMapper.selectByExample(example);
        for(int i=0;i<list.size();i++){
            Section section=list.get(i);
            List<Main> mainlist=mainService.getMainBySectionIdAndNum(section.getsId(),4);
            section.setSomeMain(mainlist);
            finals.add(section);
        }
        return finals;
    }

    /**
     * 根据版块id来查找某一个版块的基本信息,包括版块的所有回复和主帖数
     * @param sectionId
     * @return
     */
    public Section findSectionBySectionId(Integer sectionId) {
        Section section=sectionMapper.selectByPrimaryKey(sectionId);
        return section;
    }

    /**
     * 根据版主id查找该版主管理的所有版块信息
     * @param banzhuid
     * @return
     */
    @Override
    public List<Section> getSectionsByBanZhuId(Integer banzhuid) {
        SectionExample sectionExample=new SectionExample();
        SectionExample.Criteria criteria=sectionExample.createCriteria();
        criteria.andSBanzhuidEqualTo(banzhuid);
        return sectionMapper.selectByExample(sectionExample);
    }

    /**
     * 根据版块实例修改版块信息
     * @param section
     */
    @Override
    public void updateSectionBySection(Section section) {
        sectionMapper.updateByPrimaryKeySelective(section);
    }

}
