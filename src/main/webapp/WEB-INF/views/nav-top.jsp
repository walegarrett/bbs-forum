<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/17
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    //这个的路径是以斜线开始的，不以斜线结束
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<div class="top-navigate">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left" action="${APP_PATH}/section/totalsearch" method="post">
                    <div class="form-group">
                        <input type="text" name="searchcontent" class="form-control" placeholder="搜索帖子、用户">
                    </div>
                    <button type="submit" class="btn btn-default" id="totalsearch">搜索</button>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${APP_PATH}/index1.jsp">网站首页</a></li>
                    <c:if test="${userid!=null}">
                        <c:if test="${userid==section.sBanzhuid}">
                            <li><a href="${APP_PATH}/main/notTop?sectionId=${section.sId}">置顶</a></li>
                            <li><a href="${APP_PATH}/main/notPerfect?sectionId=${section.sId}">加精</a></li>
                            <li><a href="${APP_PATH}/section/tochangesection?sectionId=${section.sId}">修改版块信息</a></li>
                        </c:if>
                    </c:if>
                    <c:if test="${adminid==null}">
                        <li><a href="${APP_PATH}/adminlogin.jsp">管理员登录</a></li>
                    </c:if>
                    <c:if test="${adminid!=null}">
                        <li><a href="${APP_PATH}/jumpToLogin/toWhere?where=admin">管理员入口</a></li>
                    </c:if>
                    <c:if test="${userid==null}">
                        <li><a href="${APP_PATH}/jumpToLogin/login">登录</a></li>
                        <li><a href="${APP_PATH}/jumpToLogin/register">注册</a></li>
                    </c:if>
                    <c:if test="${userid!=null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <img src="${userheadpic}" alt='头像' class="img-circle" width=30px height=30px>${username}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${APP_PATH}/jumpwang/toSelfInfo">个人主页</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${APP_PATH}/user/userExit">退出登录</a></li>
                        </ul>
                    </li>
                    </c:if>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
<%--    <script>--%>
<%--        function jumptoselfinfo() {--%>
<%--            alert(1);--%>
<%--            $.ajax({--%>
<%--                url:"${APP_PATH}/jumpwang/toSelfInfo",--%>
<%--                type:"get",--%>
<%--                success:function (result) {--%>
<%--                    window.location.href='${APP_PATH}/views/selfInfo.jsp';--%>
<%--                }--%>
<%--            })--%>
<%--        }--%>
<%--    </script>--%>
</div>

