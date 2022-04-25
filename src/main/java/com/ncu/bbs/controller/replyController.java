package com.ncu.bbs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncu.bbs.bean.Reply;
import com.ncu.bbs.services.impl.replyServiceImpl;
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
@RequestMapping(value = "/reply")
public class replyController {
    @Autowired
    replyServiceImpl replyService;
    @RequestMapping(value = "/getreplybyfollowid",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getreplyById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String sfollowid=request.getParameter("followid");
        int followid=Integer.parseInt(sfollowid);
        List<Reply> list =replyService.getReplyByFollowId(followid);
        HashMap<String, List> hashMap = new HashMap();
        hashMap.put("list",list);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(hashMap);
        System.out.println(jsonStr);
        return jsonStr;
    }
    @RequestMapping(value = "/insertreply")
    @ResponseBody
    public String insertReply(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
//        data:{followid:followid,replycontent:reply_content,replyerid:replyerid
//            replydate:replydate},
        String sfollowid=request.getParameter("followid");
        int followid=Integer.parseInt(sfollowid);
        String replycontent=request.getParameter("replycontent");
        String sreplyerid=request.getParameter("replyerid");
        int replyerid=Integer.parseInt(sreplyerid);
        String sreplydate=request.getParameter("replydate");
        Long  replydate=Long.valueOf(sreplydate);
        Date date=new Date(replydate);
        Reply reply=new Reply();
        reply.setrContent(replycontent);
        reply.setrFollowid(followid);
        reply.setrReplydate(date);
        reply.setrReplyerid(replyerid);
        System.out.println(replycontent);
        replyService.insertReply(reply);
        return null;
    }
    @RequestMapping(value = "/deletereply")
    @ResponseBody
    public void  deleteReply(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
//        data:{followid:followid,replycontent:reply_content,replyerid:replyerid
//            replydate:replydate},
        String sreplyid=request.getParameter("replyid");
        int replyid=Integer.parseInt(sreplyid);
        replyService.deleteReply(replyid);
    }
}
