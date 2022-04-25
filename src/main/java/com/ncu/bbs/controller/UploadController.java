package com.ncu.bbs.controller;


import com.ncu.bbs.Util1.ImageUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/root")
public class UploadController {

    private ImageUploadUtil ImageUploadUtils;

    /**
     * 实现图片上传至本地
     * @param request
     * @param response
     */
    @RequestMapping(value = "/uploadSource")
    public void uploadSource(HttpServletRequest request, HttpServletResponse response){
        String DirectoryName = "upload";
        try {
            ImageUploadUtils.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
