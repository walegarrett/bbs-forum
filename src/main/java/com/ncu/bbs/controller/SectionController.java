package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.Section;
import com.ncu.bbs.services.SectionService;
import com.ncu.bbs.services.followService;
import com.ncu.bbs.services.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @Autowired
    com.ncu.bbs.services.mainService mainService;
    @Autowired
    com.ncu.bbs.services.followService followService;
    //返回某一个版块的所有主贴数量
    private int findAllMainNumsInSection(Integer sectionId){
        return mainService.getMainBySectionId(sectionId).size();
    }
    //返回某一个版块的所有主贴数量
    private int findAllFollowNumsInSection(Integer sectionId){
        List<Main>list= mainService.getMainBySectionId(sectionId);
        int follow=0;
        for(int i=0;i<list.size();i++){
            follow+=followService.getFollowPostByMainId(list.get(i).getmMainid()).size();
        }
        return follow;
    }

    /**
     * 获取版块的信息
     * @param sectionId
     * @return
     */
    private Section getSessionBySessionId(Integer sectionId){
        Section section=sectionService.findSectionBySectionId(sectionId);
        int mainsInSection=findAllMainNumsInSection(sectionId);
        int followsInSection=findAllFollowNumsInSection(sectionId);
        section.setMainNums(mainsInSection);
        section.setFollowNums(followsInSection);
        //System.out.println(section.getMainNums());
        return section;
    }
    /**
     * 返回指定的一个版块的所有帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/thesection")
    public String toOneSection(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        //System.out.println(list);
        return "section";
    }

    /**
     * 查找所有的版块，另外附加板块中最多数量为4的帖子的一些信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody//记得一定要加上这个注解
    public Msg findAll(HttpSession session){
        List<Section> list=new ArrayList<Section>();
        list=sectionService.findAllSections();
        //--------------------任意指定一个session表示用户id
        //session.setAttribute("userid",1);//给一个session
        return Msg.success().add("sectionslist",list);
    }

    /**
     * 根据版块id找到精华帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/perfects")
    public String getPerfectMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "perfect";
    }
    /**
     * 根据版块id找到需求帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/needs")
    public String getNeedMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "need";
    }

    /**
     * 根据版块id找到热门帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/hots")
    public String gethotMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "hot";
    }

    /**
     * 根据版块id找到最新帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/news")
    public String getNewMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "new";
    }
    /**
     *跳转至搜索界面
     */
    @RequestMapping("/totalsearch")
    public String searchMain(Model model, HttpServletRequest request){
        model.addAttribute("searchcontent",request.getParameter("searchcontent"));
        return "search";
    }
    /**
     * 跳转至版主管理版块界面
     */
    @RequestMapping("/tochangesection")
    public String changeSectionInfo(@RequestParam("sectionId")Integer sectionId,Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "changeSectionInfo";
    }

    /**
     * 根据版主id查找版主管理的所有版块包括版块的基本信息和跟帖数量以及回复数量
     * @param banzhuid
     * @return
     */
    @RequestMapping("/findAllSections")
    @ResponseBody
    public Msg showAllSectionsByBanzhuId(@RequestParam("banzhuid")String banzhuid){
        List<Section>list=sectionService.getSectionsByBanZhuId(Integer.parseInt(banzhuid));
        for(int i=0;i<list.size();i++){
            Section section=getSessionBySessionId(list.get(i).getsId());
            list.set(i,section);
        }
        return Msg.success().add("list",list);
    }

//    /**
//     * 根据提交的表单信息修改版块信息
//     * @param
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("/updateSection")
//    public Msg updateSection(Integer sId,Integer sBanzhuid,String sSectionname,String sDescription){
//        //System.out.println(section.getsId()+" "+section.getsBanzhuid()+" "+section.getsSectionname()+" "+section.getsDescription());
//        Section section=new Section();
//        section.setsId(sId);
//        section.setsSectionname(sSectionname);
//        section.setsDescription(sDescription);
//        sectionService.updateSectionBySection(section);
//        return Msg.success();
//    }
    /**
     * 根据提交的表单信息修改版块信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSection")
    public Msg updateSection(Section section){
        System.out.println(section.getsId()+" "+section.getsBanzhuid()+" "+section.getsSectionname()+" "+section.getsDescription());

        sectionService.updateSectionBySection(section);
        return Msg.success();
    }
}
