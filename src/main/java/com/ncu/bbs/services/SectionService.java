package com.ncu.bbs.services;

import com.ncu.bbs.bean.Section;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

public interface SectionService {

    public List<Section> findAllSections();

    Section findSectionBySectionId(Integer sectionId);

    List<Section> getSectionsByBanZhuId(Integer banzhuid);

    void updateSectionBySection(Section section);
}
