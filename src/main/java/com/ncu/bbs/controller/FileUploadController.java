package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.services.userService;
import com.ncu.bbs.wale.util.ImageUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    @Autowired
    com.ncu.bbs.services.userService userService;
    /*
    springMVC文件上传
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传。。。");
        //使用fileupload组件完成文件上传
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        path="E:\\IDEA\\IdeaProjects\\bbs\\upload\\images";
        //判断，该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename= upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid= UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        //完成文件的上传
        upload.transferTo(new File(path,filename));
        System.out.println(path);//path在tomcat目录下，因为这里我选择的是：war,需要选择exploer
        return "login";
    }
    /*
        图片文件上传
     */
    @RequestMapping("/picture")
    @ResponseBody
    public Msg uploadPicture(HttpServletRequest request, @RequestParam( value="picture",required=false)MultipartFile upload) throws Exception {

        //使用fileupload组件完成文件上传
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/statics/images");//


        //判断，该路径是否存在
        File file=new File(path);//path
        if(!file.exists()){
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        if(upload!=null){
            String filename= upload.getOriginalFilename();
            int indexp=filename.lastIndexOf('.');
            filename=filename.substring(indexp);
            //把文件的名称设置唯一值，uuid
            String uuid= UUID.randomUUID().toString().replace("-","");
            filename=uuid+filename;
            //完成文件的上传
            upload.transferTo(new File(path,filename));//path
            //System.out.println("文件上传位置："+path+filename);
            return Msg.success().add("filename",filename);
        }else{
            return Msg.fail();
        }
    }



    /**
     * 新版本上传图片的方式返回json串
     * @param request
     * @param response
     */
    @RequestMapping(value = "/root/uploadSource")
    public void uploadSource(HttpServletRequest request, HttpServletResponse response){

        String DirectoryName = "upload";
        try {
            ImageUploadUtil.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping("/fileupload3")
    public String fileupload3(HttpServletRequest request, MultipartFile upload) throws Exception {
       // System.out.println("文件上传。。。");
        //使用fileupload组件完成文件上传
        //上传的位置
        HttpSession session1=request.getSession();
        int uid= (int) session1.getAttribute("userid");
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        path="E:\\IDEA\\IdeaProjects\\bbs\\upload\\images";
        //判断，该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename= upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid= UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        System.out.println("用户自增："+uid);
        userService.changeHeadPic(uid,filename);
        session1.removeAttribute("userheadpic");
        session1.setAttribute("userheadpic","/bbs/statics/images/upload/"+filename);
        //完成文件的上传
        upload.transferTo(new File(path,filename));
        System.out.println(path);//path在tomcat目录下，因为这里我选择的是：war,需要选择exploer
        return "pictureChange";
    }
}
