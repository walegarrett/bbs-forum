package com.ncu.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/jumpToLogin")
public class jumpToLoginController {
    @RequestMapping(value = "/login")//跳转到登陆页面
    public  String login(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
        System.out.println("dddddddddddddddddddddddddddddddddddddddddd");
        return "login";
    }
    @RequestMapping("/follow")
    public  String login(HttpServletResponse response,HttpServletRequest request)
            throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
        String mainId=request.getParameter("mainId");
        request.getSession().setAttribute("mainid",mainId);
        System.out.println(1);
        return "follow";
    }
    @RequestMapping("/follows")
    public  String logins(HttpServletResponse response,HttpServletRequest request)
            throws UnsupportedEncodingException {
        String mainId=request.getParameter("mainId");
        request.getSession().setAttribute("mainid",mainId);
        System.out.println(1);
        return "follow";
    }
    @RequestMapping("/toAdmin")
    public  String toAdmin(HttpServletResponse response,HttpServletRequest request)
            throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");

        return "adminlogin";
    }

    @RequestMapping("/toWhere")
    public  String toWhere(HttpServletResponse response,HttpServletRequest request)
            throws UnsupportedEncodingException {
        String s=request.getParameter("where");

        return s;
    }
    @RequestMapping(value = "/register")//跳转到登陆页面
    public  String register(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        return "forward:/register.jsp";
    }
    /**
     * wale
     */
    @RequestMapping("/toAdminPost")
    public String toAdminPost(){
        return "adminPost";
    }
}
