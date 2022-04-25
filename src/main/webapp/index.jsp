<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/7
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--
        web路径：
        1.不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
        2.以/开始的相对路径，找资源，以服务器的路径为标准，需要加上项目名称
    -->
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<script>

    <%--$(function(){--%>
    <%--    to_page(1);//首次加载页面时显示第一页--%>
    <%--});--%>
    <%--function to_page(pn){--%>
    <%--    $.ajax({--%>
    <%--        url:"${APP_PATH}/adm/findAll",--%>
    <%--        type:"post",--%>
    <%--        success:function (result) {--%>
    <%--            var s=result.extend.allAdmin;--%>
    <%--            $.each(s,function (index,item) {--%>
    <%--                //alert(item.aPassword);--%>
    <%--            });--%>
    <%--        }--%>
    <%--    });--%>
    <%--}--%>
</script>
<body>
    <h3>传统文件上传方式</h3>
    <form action="${APP_PATH}/upload/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
