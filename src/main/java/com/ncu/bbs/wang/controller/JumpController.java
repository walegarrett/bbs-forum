package com.ncu.bbs.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author WaleGarrett
 * @Date 2019/12/18 16:43
 */
@Controller
@RequestMapping("/jumpwang")
public class JumpController {

    @RequestMapping("/toSelfInfo")
    public String toAdminPost(){
        return "selfInfo";
    }
    @RequestMapping("/tofollow")
    public String toFollow(){
        return "follow";
    }

}
