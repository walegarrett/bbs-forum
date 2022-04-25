package com.ncu.bbs.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.wang.services.impl.SelfInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;
@Controller
public class selfInfoController {
    @Autowired
    SelfInfoServiceImpl selfInfoService;
    @Autowired
    UserMapper userMapper;


    /**点击进入个人信息修改与查看**/
    @RequestMapping("/self")
    public String self(){
        System.out.println("I am a Controller Successs!");
        return "selfInfo";
    }
//    个人信息查看
    @RequestMapping("/view")
    public String view(){
        return "selfView";
    }
    //修改密码
    @RequestMapping("/pass")
    public String pass(){
        return "newPassword";
    }
    //文章修改
    @RequestMapping("/article")
    public String article(){
        return "articleView";
    }
    //更换头像
    @RequestMapping("/pic")
    public String pic(){
        return "pictureChange";
    }
    //    **个人信息保存**//
    @RequestMapping(value = "/selfAjax")
    @ResponseBody
public void saveSelfInfo(HttpServletRequest request, HttpServletResponse response){

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        System.out.println(name);
        String nickname = request.getParameter("nickname");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String workproperty = request.getParameter("workproperty");
        String workplace = request.getParameter("workplace");
        String email = request.getParameter("email");
        String intro= request.getParameter("intro");

        User user1=new User();
        user1.setuUserid(userid);
        user1.setuPassword(password);
        user1.setuName(name);
        user1.setuNickname(nickname);
        user1.setuSex(sex);
        user1.setuAge(age);
        user1.setuEmail(email);
        user1.setuWorkproperty(workproperty);
        user1.setuWorkplace(workplace);
        user1.setuIntro(intro);
        selfInfoService.saveAllselfInfo(user1);

}
    //    **密码保存**//
    @RequestMapping(value = "/selfPass")
    @ResponseBody
    public void savePassInfo(HttpServletRequest request, HttpServletResponse response){
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        User user1=new User();
        user1.setuUserid(userid);
        user1.setuPassword(password);
        selfInfoService.saveAllselfInfo(user1);

    }
//用userid查询用户信息并传给前端
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public Msg selectUserByuserid(String userid) {
        System.out.println(userid);
        List<User> list=selfInfoService.selectUserByuserid(userid);
        return  Msg.success().add("all",list);
    }
//用userid查询密码并传给newPassword.jsp
@RequestMapping(value = "/getPassword")
@ResponseBody
public Msg selectPasswordByuserid(String userid) {
    System.out.println(userid);
    List<User> list=selfInfoService.selectUserByuserid(userid);
    return  Msg.success().add("paw",list);
}
    //用userid查询帖子信息并传给前端
    @RequestMapping(value = "/getArticle")
    @ResponseBody
   public  Msg selectMainByMainerid(String mainerid ){
        System.out.println(mainerid);
        List<Main> list3=selfInfoService.selectMainByMainerid(mainerid);
        return  Msg.success().add("main",list3);
    }
    //用mainid删除帖子信息并传给前端
    @RequestMapping(value = "/deleteArticle")
    @ResponseBody
    public  void deleteMainByMainid(HttpServletRequest request, HttpServletResponse response){
        String mainid=request.getParameter("mainid");
        selfInfoService.deleteMainByMainid(mainid);
    }
//    // 头像上传
//    @RequestMapping("/fileUpload.action")
//    @ResponseBody
//    public String upload(String userid, @RequestParam(value = "image") MultipartFile file,
//                         HttpServletRequest request) {
//        // 保存数据库的路径
//        String sqlPath = null;
//        // 定义文件保存的本地路径
//        String localPath = null;
//        // 定义 文件名
//        String filename = null;
//        if (!file.isEmpty()) {
//            localPath = request.getServletContext().getRealPath("/upload/images/");
//            File filePath = new File(localPath);
//            if (!filePath.exists()) {
//                filePath.mkdirs();
//            }
//            // 生成uuid作为文件名称
//            // String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            // 获得文件类型（可以判断如果不是图片，禁止上传）
//            String contentType = file.getContentType();
//            // 获得文件后缀名
//            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
//            // 得到 文件名
//            filename = userid + "." + suffixName;
//            // 文件保存路径
//            try {
//                file.transferTo(new File(localPath + filename));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(localPath);
//        // 把图片的相对路径保存至数据库
//        sqlPath = "images/" + filename;
//        System.out.println(sqlPath);
//        int recordNum = UserMapper.add(userid, sqlPath);
//        if (recordNum > 0) {
//            return "ok";
//        } else {
//            return "error";
//        }
//    }


}
