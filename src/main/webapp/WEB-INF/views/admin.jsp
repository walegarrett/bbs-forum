<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/17
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理员页面</title>
    <link rel="stylesheet" href="${APP_PATH}/statics/css/layui.css">
    <script src="${APP_PATH}/statics/js/layui.js"></script>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/statics/ckeditor/ckeditor.js"></script>
    <script src="${APP_PATH}/statics/js/common.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/bbs/statics/images/upload/f1c3d132ffad4c17a32b985cbf8ef24c_PictureUnlock_54077.pictureunlock.jpg" class="layui-nav-img">
                    ${adminname}
                </a>
            </li>
            <li class="layui-nav-item"><a href="${APP_PATH}/index1.jsp">网站首页</a></li>
            <li class="layui-nav-item"><a href="${APP_PATH}/adminExit">退出</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="">操作中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${APP_PATH}/adminPost.jsp">查看主贴</a></dd>
                        <dd class="active"><a href="${APP_PATH}/jumpadmin">用户管理</a></dd>
                        <dd><a href="${APP_PATH}/viewsectionlist.jsp">板块管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe class="layadmin-iframe ifrem_voice" src="${APP_PATH}/viewsuserlist.jsp" width="100%" height="700px" frameborder="0" name="userList" scrolling="no"></iframe>
        </div>
    </div>
    <div class="layui-footer">
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
