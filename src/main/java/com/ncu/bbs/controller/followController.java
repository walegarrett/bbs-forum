package com.ncu.bbs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bbs.bean.Follow;
import com.ncu.bbs.services.impl.followServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/follow")
public class followController {
    @Autowired
    followServiceImpl followService;
    @RequestMapping(value = "/getfollowbyid",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getMainById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String smainid=request.getParameter("mainid");
        int mainid=Integer.parseInt(smainid);
        String spn=request.getParameter("pn");
        int pn=Integer.parseInt(spn);
        PageHelper.startPage(pn,5);
        List<Follow> list =followService.getFollowByMainId(mainid);
        PageInfo page=new PageInfo(list,5);
        HashMap<String, PageInfo> hashMap = new HashMap();
        hashMap.put("pageInfo",page);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(hashMap);
        return jsonStr;
    }
    @RequestMapping(value = "/deletefollowbyid")
    @ResponseBody
    public void deleteFollowById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
         String sfollowid=request.getParameter("followid");
         int followid=Integer.parseInt(sfollowid);
         followService.deleteFollowById(followid);
    }
    @RequestMapping("/insertfollow")
    @ResponseBody
    public void insertFollow(HttpServletRequest request, HttpSession session)throws
    UnsupportedEncodingException, JsonProcessingException {
        String smainid=request.getParameter("mainid");
        System.out.println(smainid);
        int mainid=Integer.parseInt(smainid);
        String followcontent=request.getParameter("followcontent");
        String sfollowerid=request.getParameter("followerid");
        int followerid=Integer.parseInt(sfollowerid);
        String sfollowdate=request.getParameter("followdate");
        Long  followdate=Long.valueOf(sfollowdate);
        Date date=new Date(followdate);
        Follow follow=new Follow();
        follow.setfContent(followcontent);
        follow.setfMainid(mainid);
        follow.setfFollowdate(date);
        follow.setfFollowerid(followerid);
        System.out.println(followcontent);
        followService.insertFollow(follow);
    }
}
