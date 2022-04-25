<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/17
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    //这个的路径是以斜线开始的，不以斜线结束
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!--导航区-->
<div class="row">
    <div class="col-md-12">
        <div class="introduce">
            <div class="titleShow"><h1>${section.sSectionname}</h1></div>
            <div class="introduceShow">
                <p>${section.sDescription}</p>
            </div>
            <div class="countInfo">
                <p>总帖数：<span>${section.mainNums}</span> 总回复数：<span>${section.followNums}</span></p>
            </div>
        </div>
        <div class="nav">
            <!--显示选择看帖子还是精华帖-->
            <div class="selects">
                <div class="row">
                    <ul class="nav nav-tabs kinds">
                        <li role="presentation" id="mains"><a href="${APP_PATH}/section/thesection?sectionId=${section.sId}">帖子</a></li>
                        <li role="presentation" id="perfects"><a href="${APP_PATH}/section/perfects?sectionId=${section.sId}">精华帖</a></li>
                        <li role="presentation" id="needs"><a href="${APP_PATH}/section/needs?sectionId=${section.sId}">需求帖</a></li>
                        <li role="presentation" id="hots"><a href="${APP_PATH}/section/hots?sectionId=${section.sId}">热门帖</a></li>
                        <li role="presentation" id="latests"><a href="${APP_PATH}/section/news?sectionId=${section.sId}">最新帖</a></li>
<%--                        <li role="presentation"><a href="#">其他</a></li>--%>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    // $(".kinds a").click(function () {
    //     $(".kinds li").each(function () {
    //         $(this).removeClass("active");
    //     });
    //     $(this).parent("li").addClass("active");
    // })
</script>
