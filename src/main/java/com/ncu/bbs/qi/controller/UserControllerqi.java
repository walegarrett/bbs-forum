package com.ncu.bbs.qi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.qi.services.UserService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserControllerqi {

    @Autowired
    UserService Userservice;

//    @RequestMapping(value = "/updateUser/{uId}")
////    @ResponseBody
////    public Msg updateUser(User User){
////        System.out.println(User.getuId());
////        System.out.print(User.getuUserid());
////        Userservice.updateUser(User);
////        return Msg.success();
////    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Msg updateUser(@RequestParam("uId") Integer uId,
                          @RequestParam("uPassword") String uPassword,
                          @RequestParam("uNickname") String uNickname,
                          @RequestParam("uName") String uName,
                          @RequestParam("uEmail") String uEmail,
                          @RequestParam("uWorkplace") String uWorkplace){
        User user = new User();
        user.setuId(uId);
        user.setuPassword(uPassword);
        user.setuNickname(uNickname);
        user.setuName(uName);
        user.setuEmail(uEmail);
        user.setuWorkplace(uWorkplace);
        System.out.println(uId + " " + uPassword + " " + uNickname + " " + uName + " " + uEmail + " " + uWorkplace);
        Userservice.updateUser(user);
        return Msg.success();
    }

    @RequestMapping(value="/User/{uId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getUser(@PathVariable("uId")Integer uId){
        User User = Userservice.getUser(uId);
        return Msg.success().add("User",User);
    }

    @RequestMapping("/User")
    @ResponseBody
    public Msg getUserWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //????????????????????????
        //??????PageHelper????????????
        //?????????????????????,???????????????????????????????????????
        PageHelper.startPage(pn,5);
        //????????????
        List<User> User = Userservice.getAll();
        PageInfo<com.ncu.bbs.bean.User> page = new PageInfo<>(User,5);
        return Msg.success().add("pageInfo",page);
    }

    @RequestMapping("/Users")
    @ResponseBody
    public Msg deleteUserById(@RequestParam("uId")Integer uId){
        Userservice.deleteUser(uId);
        return Msg.success();
    }

    /**
     * ????????????????????????
     * @param
     * @return
     */

//    @RequestMapping(value="/regUser",method = RequestMethod.POST)
    @RequestMapping("/regUser")
    public String saveUser(@RequestParam("uName") String uName,
                           @RequestParam("uAge") String uAge,
                           @RequestParam("uUserid") String uUserid,
                           @RequestParam("uNickname") String uNickname,
                           @RequestParam("uEmail") String uEmail,
                           @RequestParam("uPassword") String uPassword,
                           @RequestParam("uSex") String uSex,
                           @RequestParam("uWorkplace") String uWorkplace){
        User User = new User();
        User.setuUserid(uUserid);
        User.setuAge(uAge);
        User.setuPassword(uPassword);
        User.setuNickname(uNickname);
        User.setuEmail(uEmail);
        User.setuName(uName);
        User.setuPoints(1000);//?????????????????????1000??????
        User.setuIssectioner(0);
        User.setuWorkplace(uWorkplace);
        User.setuSex(uSex);
        User.setuHeadpic("/bbs/statics/images/upload/default.jpeg");
        System.out.print(uName);
        Userservice.saveUser(User);
        return "login";
    }

    /**
     * ??????????????????????????????
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuUserid")
    public Msg checkuUserid(HttpServletRequest request){
        String uUserid = request.getParameter("uUserid");
        System.out.print(uUserid);
        boolean b=Userservice.checkuUserid(uUserid);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping("/checkuId")
    @ResponseBody
    public Msg checkUId(@RequestParam("uId")Integer uId){
          boolean a = Userservice.checkuId(uId);
          if(a){
              return Msg.success();
          }else{
              return  Msg.fail();
          }
    }
}
