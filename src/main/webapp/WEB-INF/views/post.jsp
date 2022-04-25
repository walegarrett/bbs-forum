<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 18:22
  To change this template use File | Settings | File Templates.

--%>
<!--
    这里是具体的帖子对应的界面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>主帖显示</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        div{
            text-align:center;
        }
    </style>
</head>
<body>
    <div>
        标题：
        <div>
            ${mainPost.mTitle};
        </div>
    </div>
<%--    <div>--%>
<%--        <img src="${APP_PATH}/statics/images/中文.jpg">--%>
<%--    </div>--%>
    <div>
        正文：
        <div>
            ${mainPost.mContent};
        </div>
    </div>

</body>
</html>
