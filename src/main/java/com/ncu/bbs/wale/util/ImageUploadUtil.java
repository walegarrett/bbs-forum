package com.ncu.bbs.wale.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @ClassName: ImageUploadUtil
 * @Description: 图片上传工具类，包括ckeditor操作
 * created by Vinne.WU
 * 2019.7.17 14:27
 */
public class ImageUploadUtil{
    // 图片类型
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }

    /**
     * 图片上传
     *
     * @Title upload
     * @param request
     * @param DirectoryName
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String upload(HttpServletRequest request, String DirectoryName) throws IllegalStateException,
            IOException {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // 图片名称
        String fileName = null;
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 记录上传过程起始时的时间，用来计算上传时间
                // int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 获得图片的原始名称
                        String originalFilename = file.getOriginalFilename();
                        // 获得图片后缀名称,如果后缀不为图片格式，则不上传
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
                        if (!fileTypes.contains(suffix)) {
                            continue;
                        }
                        // 获得上传路径的绝对路径地址(/upload)-->
                        String realPath = request.getSession().getServletContext().getRealPath("/statics/images/" + DirectoryName);
                        realPath="E:\\IDEA\\IdeaProjects\\bbs\\upload\\images";
                        //输出上传的路径
                        System.out.println(realPath);
                        // 如果路径不存在，则创建该路径
                        File realPathDirectory = new File(realPath);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        String uuid= UUID.randomUUID().toString().replace("-","");
                        // 重命名上传后的文件名 111112323.jpg
                        fileName =uuid+myFileName;
                        // 定义上传路径 .../upload/111112323.jpg
                        File uploadFile = new File(realPathDirectory + "\\" + fileName);
                        //输出上传图片的路径
                        System.out.println(fileName);
                        file.transferTo(uploadFile);//真正上传
                    }
                }
            }
        }
        return fileName;
    }

    /**
     * ckeditor文件上传功能，回调，传回图片路径，实现预览效果。
     * @Title ckeditor
     * @param request
     * @param response
     * @param DirectoryName
     * @throws IOException
     */
    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileName = upload(request, DirectoryName);
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        String imageContextPath =request.getContextPath()+"/statics/images/"+DirectoryName+"/"+fileName;
        //构建json回调消息

        //打印回调的地址
        System.out.println(imageContextPath);
        Map resultMap= new HashMap();
        resultMap.put("uploaded",1);
        resultMap.put("fileName",fileName);
        resultMap.put("url",imageContextPath);
//        String jsonStr=JSONUtils.toJSONString(resultMap);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(resultMap);
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}