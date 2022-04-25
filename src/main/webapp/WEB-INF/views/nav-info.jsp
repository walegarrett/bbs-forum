<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/17
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="info">
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="#">个人主页</a></li>
        <li role="presentation"><a href="#edit-publish">发帖</a></li>
        <c:if test="${userid==section.sBanzhuid}">
            <li role="presentation"><a href="${APP_PATH}/main/notPerfect?sectionId=${section.sId}">加精</a></li>
            <li role="presentation"><a href="${APP_PATH}/main/notTop?sectionId=${section.sId}">置顶</a></li>
        </c:if>
        <c:if test="${userid!=section.sBanzhuid}">
            <li role="presentation"><a href="#">其他</a></li>
        </c:if>
        <li role="presentation"><a href="${APP_PATH}/index1.jsp">返回主页</a></li>
    </ul>
</div>
