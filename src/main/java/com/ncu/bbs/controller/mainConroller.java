package com.ncu.bbs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bbs.bean.*;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.services.SectionService;
import com.ncu.bbs.services.followService;
import com.ncu.bbs.services.impl.mainServiceImpl;
import com.ncu.bbs.services.mainService;
import com.ncu.bbs.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping(value = "/main")
public class mainConroller {
    @Autowired
    mainServiceImpl mainService;
    @RequestMapping(value = "/getmainbyid",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getMainById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String smainid=request.getParameter("mainid");
        int mainid=Integer.parseInt(smainid);
        Main main=mainService.getMainById(mainid);
        HashMap<String, Main> hashMap = new HashMap();
        hashMap.put("main",main);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(hashMap);
        return jsonStr;
    }
    @RequestMapping(value = "/deletemainbyid")
    @ResponseBody
    public void deleteMainById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String smainid = request.getParameter("mainid");
        int mainid = Integer.parseInt(smainid);
        mainService.deleteMainById(mainid);
    }
    @RequestMapping(value = "/modifymaincontent")
    @ResponseBody
    public void modifyMainContentById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String smainid = request.getParameter("mainid");
        String main_content=request.getParameter("content");
        int mainid = Integer.parseInt(smainid);
        mainService.modifyMainContentById(main_content,mainid);
    }
    /**
     * wale
     */

    @Autowired
    MainMapper mainMapper;
    @Autowired
    SectionService sectionService;
    @Autowired
    com.ncu.bbs.services.followService followService;
    @Autowired
    com.ncu.bbs.services.userService userService;
    //返回某一个版块的所有主贴数量
    private int findAllMainNumsInSection(Integer sectionId){
        return mainService.getMainBySectionId(sectionId).size();
    }
    //返回某一个版块的所有主贴数量
    private int findAllFollowNumsInSection(Integer sectionId){
        List<Main> list= mainService.getMainBySectionId(sectionId);
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
     * 将发布的帖子记录存储
     * @param mMainerid
     * @param mSectionid
     * @param mTitle
     * @param mContent
     * @param mPoint
     * @return
     */
    @ResponseBody
    @RequestMapping("/publish")
    public Msg publishMain(String mMainerid, Integer mSectionid, String mTitle, String mContent, Integer mPoint, HttpSession session){
        //System.out.println(mMainerid+" "+mSectionid+" "+mTitle+" "+mContent+" "+mPoint);

        Map<String,Object> map=new HashMap<>();//用来存储错误的字段
        if(session.getAttribute("userid")==null){
            map.put("usernotlogin","您还未登录，请登录后进行发帖操作！");
            return Msg.fail().add("errorFields",map);
        }
        if(mTitle.length()>50){
            map.put("title","标题字数不得超过50个字");
            return Msg.fail().add("errorFields",map);
        }
        if(mContent.length()>3000){
            map.put("content","你的帖子中文内容太长，无法发表，请减少想要发表的内容！");
            return Msg.fail().add("errorFields",map);
        }
        if(mPoint>100){
            map.put("point","奖励的分数不能超过100");
            return Msg.fail().add("errorFields",map);
        }else{
            if(mPoint<0){
                map.put("point","奖励的分数必须大于0");
                return Msg.fail().add("errorFields",map);
            }
            if(mPoint<=100&&mPoint>0){
                int points=userService.getPointByUId(Integer.parseInt(mMainerid));
                if(points<mPoint){
                    map.put("point","您账户中的个人积分不足，无法发布积分奖励，请减少积分奖励数量或者发布普通帖子！");
                    return Msg.fail().add("errorFields",map);
                }else{
                    //如果该用户有足够的积分进行积分奖励，则从该用户的积分那里扣除积分
                    int finalPoints=points-mPoint;
                    userService.changePointByUserid(Integer.parseInt(mMainerid),finalPoints);
                }
            }
        }
        System.out.println("积分"+mPoint);
        Main main=new Main();
        main.setmSectionid(mSectionid);
        main.setmMaindate(new Date());
        main.setmPoint(mPoint);
        main.setmMainerid(Integer.parseInt(mMainerid));
        main.setmIsperfect(0);
        main.setmIsontop(0);
        main.setmContent(mContent);
        main.setmTitle(mTitle);
        mainService.addMainPost(main);

        return Msg.success().add("content",mContent);
    }
    /**
     * 返回到指定的jsp页面，并且返回所有的该板块帖子信息
     */
    @RequestMapping("/findAll")
    public String showAllMainPosts(@RequestParam("sectionId")Integer sectionId, @RequestParam("page")String page, Model model){
        List<Main> list=new ArrayList<Main>();
        list=mainService.getMainBySectionId(sectionId);
        model.addAttribute("mainlist",list);
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return page;
    }

    /**
     * 根据版块id查找所有非置顶帖的帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/findNotTop")
    @ResponseBody
    public Msg findAllNotMainPosts(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        //必须紧跟着后面查询！！！
        List<Main> list=mainService.getNotTopMainBySectionId(sectionId);//查找所有的非置顶帖
        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }
        model.addAttribute("section",getSessionBySessionId(sectionId));

        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page);

    }
    /**
     * 根据版块id查找所有非置顶帖的帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/notTop")
    public String showAllNotMainPosts(@RequestParam("sectionId")Integer sectionId, Model model){
        List<Main> list=new ArrayList<Main>();
        list=mainService.getNotTopMainBySectionId(sectionId);
        model.addAttribute("mainlist",list);
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "selectTop";
    }
    /**
     * 根据版块id查找所有非精华帖的帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/findNotPerfect")
    @ResponseBody
    public Msg findAllNotPerfectPosts(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        //必须紧跟着后面查询！！！
        List<Main> list=mainService.getNotPerfectMainBySectionId(sectionId);//查找所有的非置顶帖
        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }
        model.addAttribute("section",getSessionBySessionId(sectionId));

        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);

        return Msg.success().add("pageInfo",page);
    }
    /**
     * 根据版块id查找所有非精华帖的帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/notPerfect")
    public String showAllNotPerfectPosts(@RequestParam("sectionId")Integer sectionId, Model model){
        List<Main> list=new ArrayList<Main>();
        //list=mainService.getNotTopMainBySectionId(sectionId);
        list=mainService.getNotPerfectMainBySectionId(sectionId);
        model.addAttribute("mainlist",list);
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "selectPerfect";
    }

    /**
     * 根据帖子ids来置顶帖
     * @param tops
     * @return
     */
    @RequestMapping("/addTop")
    @ResponseBody
    public Msg addSomeTopMains(@RequestParam("tops")String tops,@RequestParam("sectionId")Integer sectionId,HttpSession session){
        Map<String,Object> map=new HashMap<>();//用来存储错误的字段

        if(session.getAttribute("userid")==null){
            map.put("usernotlogin","您还未登录，请登录后进行置顶操作！");
            return Msg.fail().add("errorFields",map);
        }
        int userid=(Integer)session.getAttribute("userid");
        Section section=sectionService.findSectionBySectionId(sectionId);

        if(userid!=section.getsBanzhuid()){
            map.put("notbanzhu","您不是该版的版主，无法进行置顶操作！");
            return Msg.fail().add("errorFields",map);
        }
        int numofTop=0;
        List<Main>list=new ArrayList<Main>();
        list=mainService.getTopMain(sectionId);
        System.out.println(list.size());
        if(list.size()>=4){
            //一个版块最多不超过4个置顶帖子
            return Msg.fail().add("error","该版块置顶帖数量已经达到最大允许值，不允许新增置顶贴！").add("errorFields",map);
        }
        if(tops.contains("-")){
            String[] str_ids=tops.split("-");
            //组装ids的数组
            List<Integer> del_ids=new ArrayList<Integer>();
            for(String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            if(del_ids.size()+list.size()>4){
                return Msg.fail().add("error","所选择的置顶帖数量太大，请减少需要置顶的主帖！").add("errorFields",map);
            }
            mainService.addTopBatch(del_ids);

        }else{
            //置顶单个帖子
            Integer id=Integer.parseInt(tops);
            mainService.addTop(id);
        }
        return Msg.success();
    }

    /**
     * 根据帖子ids来加精
     * @param perfects
     * @return
     */
    @RequestMapping("/addPerfect")
    @ResponseBody
    public Msg addSomePerfectMains(@RequestParam("perfects")String perfects,@RequestParam("sectionId")Integer sectionId,HttpSession session){
        Map<String,Object> map=new HashMap<>();//用来存储错误的字段

        if(session.getAttribute("userid")==null){
            map.put("usernotlogin","您还未登录，请登录后进行置顶操作！");
            return Msg.fail().add("errorFields",map);
        }
        int userid=(Integer)session.getAttribute("userid");
        Section section=sectionService.findSectionBySectionId(sectionId);

        if(userid!=section.getsBanzhuid()){
            map.put("notbanzhu","您不是该版的版主，无法进行置顶操作！");
            return Msg.fail().add("errorFields",map);
        }

        if(perfects.contains("-")){
            String[] str_ids=perfects.split("-");
            //组装ids的数组
            List<Integer> del_ids=new ArrayList<Integer>();
            for(String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            mainService.addPerfectBatch(del_ids);
        }else{
            //加精单个帖子
            Integer id=Integer.parseInt(perfects);
            mainService.addPerfect(id);
        }
        //return "selectPerfect";
        //return "forward:/section/thesection?sectionId="+sectionId;
        return Msg.success();
    }

    /**
     * 根据页号和版面号进行查询所有的帖子包括置顶帖（返回）
     * @param pn
     * @param sectionId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/findMainsInSection")
    public Msg findAllMainsInTheSection(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        //必须紧跟着后面查询！！！
        List<Main> list=mainService.getNotTopMainBySectionId(sectionId);//查找所有的非置顶帖

        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }

        List<Main> toplist=new ArrayList<Main>();
        toplist=mainService.getTopMain(sectionId);

        for(int i=0;i<toplist.size();i++){
            Main main=toplist.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            toplist.set(i,main);
        }
        model.addAttribute("section",getSessionBySessionId(sectionId));

        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page).add("toplist",toplist);
    }
    /**
     * 根据页号和版面号进行查询所有的精华帖
     * @param pn
     * @param sectionId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/findPerfectsInSection")
    public Msg findAllPerfectsInTheSection(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        //必须紧跟着后面查询！！！
        List<Main> list=mainService.getPerfectBySectionId(sectionId);//查找所有的非置顶帖

        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }

        model.addAttribute("section",getSessionBySessionId(sectionId));

        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 根据主帖id取消置顶
     * @param mainId
     * @return
     */
    @RequestMapping("/cancelTop")
    @ResponseBody
    public Msg cancelTop(@RequestParam("mainId")Integer mainId,HttpSession session){
        Map<String,Object> map=new HashMap<>();//用来存储错误的字段

        if(session.getAttribute("userid")==null){
            map.put("usernotlogin","您还未登录，请登录后进行置顶操作！");
            return Msg.fail().add("errorFields",map);
        }
        int userid=(Integer)session.getAttribute("userid");
        int sectionId=mainService.getSectionIdByMainId(mainId);
        Section section=sectionService.findSectionBySectionId(sectionId);
        if(userid!=section.getsBanzhuid()){
            map.put("notbanzhu","您不是该版的版主，无法进行置顶操作！");
            return Msg.fail().add("errorFields",map);
        }

        mainService.cancelTopByMainId(mainId);
        return Msg.success();
    }
    /**
     * 根据帖子ids来加精
     * @param perfects
     * @return
     */
    @RequestMapping("/cancelPerfects")
    @ResponseBody
    public Msg cancelSomePerfectMains(@RequestParam("perfects")String perfects,@RequestParam("sectionId")Integer sectionId,HttpSession session){
        Map<String,Object> map=new HashMap<>();//用来存储错误的字段

        if(session.getAttribute("userid")==null){
            map.put("usernotlogin","您还未登录，请登录后进行取消加精操作！");
            return Msg.fail().add("errorFields",map);
        }
        int userid=(Integer)session.getAttribute("userid");
        Section section=sectionService.findSectionBySectionId(sectionId);

        if(userid!=section.getsBanzhuid()){
            map.put("notbanzhu","您不是该版的版主，无法进行取消加精操作！");
            return Msg.fail().add("errorFields",map);
        }
        if(perfects.contains("-")){
            String[] str_ids=perfects.split("-");
            //组装ids的数组
            List<Integer> del_ids=new ArrayList<Integer>();
            for(String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            mainService.cancelPerfectBatch(del_ids);
        }else{
            //加精单个帖子
            Integer id=Integer.parseInt(perfects);
            mainService.cancelPerfect(id);
        }
        //return "selectPerfect";
        //return "forward:/section/thesection?sectionId="+sectionId;
        return Msg.success();
    }

    /**
     * 根据帖子id查找特定的一个帖子
     * @param mainId
     * @return
     */
    @RequestMapping("/theMain")
    public String showMainPost(@RequestParam("mainId") Integer mainId,Model model){
        Main main=mainService.getMainByMainId(mainId);
        model.addAttribute("mainPost",main);
        return "post";
    }

    /**
     * 根据版块id和页号查询某一页的所有需求帖
     * @param pn
     * @param sectionId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/findNeedsInSection")
    public Msg showNeedPostIntheSection(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        List<Main>list=new ArrayList<>();
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        list=mainService.getNeedPostBySectionId(sectionId);

        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }
        model.addAttribute("section",getSessionBySessionId(sectionId));
        //System.out.println(list);
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page);
    }
    /**
     * 根据版块id和页号查询某一页的所有热门帖
     * @param pn
     * @param sectionId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/findHotsInSection")
    public Msg showHotPostIntheSection(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        List<Main>list=new ArrayList<>();
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        list=mainService.getHotPostBySectionId(sectionId);

        //System.out.println(list.size());
        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();

            //查找主帖的所有跟帖
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            User user=userService.getUserByUserId(main.getmMainerid());
            main.setUser(user);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }
        model.addAttribute("section",getSessionBySessionId(sectionId));
        //System.out.println(list);
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);

        return Msg.success().add("pageInfo",page);
    }
    /**
     * 根据版块id和页号查询某一版块的最新帖
     * @param pn
     * @param sectionId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/findLatestsInSection")
    public Msg showLatestPostIntheSection(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("sectionId")Integer sectionId,Model model){
        List<Main>list=new ArrayList<>();
        Date date=new Date();
        long nowdate=date.getTime();

        //两天内的最新帖
        Date deadline=new Date(nowdate-2*24*60*60*1000);
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        list=mainService.getLatestPostBySectionId(sectionId,deadline);

        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }
        model.addAttribute("section",getSessionBySessionId(sectionId));
        //System.out.println(list);
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就可以了
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 根据页号和关键词查询相关的帖子
     * @param pn
     * @param keyword
     * @return
     */
    @RequestMapping("/searchMains")
    @ResponseBody
    public Msg searchMains(@RequestParam(value = "pn",defaultValue = "1")Integer pn,@RequestParam("keyword")String keyword){
        List<Main>list=new ArrayList<>();
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        list=mainService.searchMainsByKeyWord(keyword);
        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();

            //查找主帖的所有跟帖
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            User user=userService.getUserByUserId(main.getmMainerid());
            main.setUser(user);
            list.set(i,main);
            //System.out.println(main.getmMaindate().getTime());
        }
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page);
    }
    /**
     * 找到系统中所有的帖子
     * @param pn
     * @return
     */
    @RequestMapping("/findAllPost")
    @ResponseBody
    public Msg findAllPosts(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        List<Main>list=new ArrayList<>();
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,20);
        list = mainService.getAllPosts();
        //查找所有的跟帖回复
        for(int i=0;i<list.size();i++){
            Main main=list.get(i);
            List<Follow>followlist=new ArrayList<>();

            //查找主帖的所有跟帖
            followlist=followService.getFollowPostByMainId(main.getmMainid());
            main.setFollows(followlist);

            long longesttime=main.getmMaindate().getTime();
            //最新发表一开始是主帖发布者
            Integer latestuserid=main.getmMainerid();
            for (Follow follow:followlist) {
                if(follow.getfFollowdate().getTime()>longesttime){
                    latestuserid=follow.getfFollowerid();
                    longesttime=follow.getfFollowdate().getTime();
                }
            }
            //查找最新发表信息的人的信息
            User latestuser=userService.getUserByUserId(latestuserid);
            main.setLatestPublish(latestuser);
            main.setLatestTime(longesttime);//设置最新发表时间
            //System.out.println(latestuser);
            User user=userService.getUserByUserId(main.getmMainerid());
            main.setUser(user);
            //查找此帖所在版块的信息
            Section section=sectionService.findSectionBySectionId(main.getmSectionid());
            main.setSection(section);

            list.set(i,main);
        }
        PageInfo page=new PageInfo(list,20);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 获取需要修改的主帖的信息
     * @param mainId
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeMainByMainId")
    public Msg changeMainByMainId(@RequestParam("mainId")Integer mainId){
        Main main=mainService.getMainByMainId(mainId);
        return Msg.success().add("main",main);
    }

    /**
     * 更新帖子
     * @param mMainid
     * @param mTitle
     * @param mContent
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/submitChangeMain")
    public Msg updateMain(Integer mMainid,String mTitle, String mContent, HttpSession session){
        Map<String,Object> map=new HashMap<>();//用来存储错误的字段
        if(session.getAttribute("adminid")==null){
            map.put("adminnotlogin","您还未登录，请登录后进行更新帖子操作！");
            return Msg.fail().add("errorFields",map);
        }
        if(mTitle.length()>50){
            map.put("title","标题字数不得超过50个字");
            return Msg.fail().add("errorFields",map);
        }
        if(mContent.length()>3000){
            map.put("content","你的帖子中文内容太长，无法发表，请减少想要发表的内容！");
            return Msg.fail().add("errorFields",map);
        }
        Main main=new Main();
        main.setmMainid(mMainid);
        main.setmTitle(mTitle);
        main.setmContent(mContent);
//        main.setmPoint(mPoint);
        mainService.updateMainByMain(main);
        return Msg.success();
    }

    /**
     * 根据帖子ids来删除帖子
     * @param perfects
     * @return
     */
    @RequestMapping("/deleteMains")
    @ResponseBody
    public Msg deleteMains(@RequestParam("perfects")String perfects, HttpSession session){
        Map<String,Object> map=new HashMap<>();//用来存储错误的字段
        if(session.getAttribute("adminid")==null){
            map.put("adminnotlogin","您还未登录，请登录后进行删除帖子操作！");
            return Msg.fail().add("errorFields",map);
        }
        if(perfects.contains("-")){
            String[] str_ids=perfects.split("-");
            //组装ids的数组
            List<Integer> del_ids=new ArrayList<Integer>();
            for(String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            mainService.deleteMains(del_ids);
        }else{
            //加精单个帖子
            Integer id=Integer.parseInt(perfects);
            mainService.deleteMain(id);
        }
        return Msg.success();
    }

    /**
     * 判断该发帖用户是否有足够的积分来发布需求帖，也就是积分奖励
     * @param session
     * @param point
     * @return
     */
    @RequestMapping("hasEnoughPoint")
    @ResponseBody
    public Msg hasEnoughPoint(@RequestParam("point")Integer point,HttpSession session){
        if(session.getAttribute("userid")==null){
            return Msg.success();
        }else{
            int userid=(Integer)session.getAttribute("userid");
            int points=userService.getPointByUId(userid);
            if(points>=point){
                return Msg.success();
            }else return Msg.fail();
        }
    }
}
