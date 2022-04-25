package com.ncu.bbs.qi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.Section;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.qi.services.SectionService;
import com.ncu.bbs.qi.services.UserService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SectionControllerqi {

    @Autowired
    SectionService Sectionservice;

    @Autowired
    UserService UserService;

//    @RequestMapping(value = "/Section/{sId}")
//    @ResponseBody
//    public Msg saveBanzhuid(Section Section){
//        System.out.println(Section.getsId());
//        System.out.println(Section.getsBanzhuid());
//        Sectionservice.updateSection(Section);
//        return Msg.success();
//    }

    /**
     * 修改版块所属的版主
     * @param banzhuUserid
     * @param Sectionid
     * @return
     */
    @RequestMapping("/findBanzhuId")
    @ResponseBody
    public Msg changeBanzhuid(@RequestParam("originid")Integer originid,
                              @RequestParam("banzhuUserid")String banzhuUserid,
                              @RequestParam("Sectionid")Integer Sectionid,
                              @RequestParam("sSectionname")String sSectionname,
                              @RequestParam("sDescription")String sDescription
                              ){

        Integer banzhuid=UserService.getUIdByUserid(banzhuUserid);//banzhuid是自增的id
        Section Sections=new Section();
        Sections.setsBanzhuid(banzhuid);
        Sections.setsId(Sectionid);
        Sections.setsSectionname(sSectionname);
        Sections.setsDescription(sDescription);

        //测试
        System.out.println(banzhuid+" "+banzhuUserid+" "+Sectionid);
        Sectionservice.updateSection(Sections);
        UserService.changeIsBanzhu(originid,banzhuUserid);//修改用户表是否是版主的字段
        return Msg.success();
    }

    @RequestMapping(value="/Section/{sId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getSection(@PathVariable("sId")Integer sId){
        Section Section = Sectionservice.getSection(sId);
        return Msg.success().add("Section",Section);
    }

    @RequestMapping("/Section")
    @ResponseBody
    public Msg getSectionWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //这是一个分页查询
        //引入PageHelper分页插件
        //在查询之前调用,传入页码，以及每一页的大小
        PageHelper.startPage(pn,5);
        //分页查询
        List<Section> Section = Sectionservice.getAll();
        List<User> Users=new ArrayList<>();
        for(int i=0;i<Section.size();i++){
            int banzhuId=Section.get(i).getsBanzhuid();
            User thisUser=UserService.selectByPrimaryKey(banzhuId);
            Users.add(thisUser);
        }
        PageInfo<com.ncu.bbs.bean.Section> page = new PageInfo<>(Section,5);
        return Msg.success().add("pageInfo",page).add("Userlist",Users);
    }

    @RequestMapping("/Sections")
    @ResponseBody
    public Msg deleteSectionById(@RequestParam("sId") Integer sId){
        Sectionservice.deleteSection(sId);
        return Msg.success();
    }

    @RequestMapping("/addSection")
    @ResponseBody
    public Msg addSection(@RequestParam("sBanzhuid") Integer sBanzhuid,
                          @RequestParam("sSectionname") String sSectionname,
                          @RequestParam("sDescription") String sDescription
                           ){
        Section section = new Section();
        section.setsBanzhuid(sBanzhuid);
        section.setsSectionname(sSectionname);
        section.setsDescription(sDescription);
        System.out.println(sBanzhuid + " " + sSectionname + " " + sDescription);
        Sectionservice.addSection(section);
        return Msg.success();
    }
}
