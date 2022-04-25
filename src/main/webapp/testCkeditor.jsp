<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/13
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //这个的路径是以斜线开始的，不以斜线结束
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <script src="${APP_PATH}/statics/js/ckeditor/ckeditor.js"></script>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    描述：
    <textarea name="content" id="content" placeholder="请输入信息"/>
    </textarea>
    <button>获取内容</button>
    <script type="text/javascript">
        $(function () {
            CKEDITOR.replace( 'content',{
                height:100,
                width:900
            });
        });
        function getContentData(){
            var content=CKEDITOR.instances.content.getData();//获取texarea的内容
            return content;
        }
        $("button").click(function () {
            alert(getContentData());
        });
    </script>
</body>
</html>