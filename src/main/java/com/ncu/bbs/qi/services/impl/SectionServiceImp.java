package com.ncu.bbs.qi.services.impl;

import com.ncu.bbs.bean.Section;
import com.ncu.bbs.bean.SectionExample;
import com.ncu.bbs.dao.SectionMapper;
import com.ncu.bbs.qi.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import sun.swing.SwingUtilities2;

import java.util.List;

@Service
@ContextConfiguration("classpath:applicationContext.xml")
public class SectionServiceImp implements SectionService {

    @Autowired
    private SectionMapper Sectionmapper;

    @Override
    public long countByExample(SectionExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(SectionExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer sId) {
        return 0;
    }

    @Override
    public int insert(Section record) {
        return 0;
    }

    @Override
    public int insertSelective(Section record) {
        return 0;
    }

    @Override
    public List<Section> selectByExample(SectionExample example) {
        return null;
    }

    @Override
    public Section selectByPrimaryKey(Integer sId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Section record, SectionExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Section record, SectionExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Section record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Section record) {
        return 0;
    }

    @Override
    public List<Section> getAll() {
        return Sectionmapper.selectByExample(null);
    }

    @Override
    public void deleteSection(Integer sId) {
        Sectionmapper.deleteByPrimaryKey(sId);
    }

    @Override
    public Section getSection(Integer sId) {
        Section Section = Sectionmapper.selectByPrimaryKey(sId);
        return Section;
    }

    @Override
    public void updateSection(Section Section) {
//        SectionExample SectionExample=new SectionExample();
//        SectionExample.or();
//        SectionExample.or().andSIdEqualTo(Section.getsId());
//        Section Section1=new Section();
//        Section1.setsBanzhuid(Section.getsBanzhuid());
//        Sectionmapper.selectByExample(SectionExample);
//        Sectionmapper.updateByExampleSelective(Section1,SectionExample);
        Sectionmapper.updateByPrimaryKeySelective(Section);
    }

    @Override
    public void addSection(Section section) {
        Sectionmapper.insertSelective(section);
    }
}
