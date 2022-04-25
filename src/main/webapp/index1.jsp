<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>主页设计</title>
    <meta charset="UTF-8">
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
    <script src="${APP_PATH}/statics/js/common.js"></script>
</head>
<body>

    <!--上方的导航栏-->
    <div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <form class="navbar-form navbar-left" action="${APP_PATH}/section/totalsearch" method="post">
                        <div class="form-group">
                            <input type="text" name="searchcontent" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${APP_PATH}/index1.jsp">网站首页</a></li>
                        <c:if test="${adminid==null}">
                            <li><a href="${APP_PATH}/adminlogin.jsp">管理员登录</a></li>
                        </c:if>
                        <c:if test="${adminid!=null}">
                            <li><a href="${APP_PATH}/jumpToLogin/toWhere?where=admin">管理员入口</a></li>
                        </c:if>
                        <c:if test="${userid==null}">
                            <li><a href="${APP_PATH}/jumpToLogin/login">登录</a></li>
                            <li><a href="${APP_PATH}/register.jsp">注册</a></li>
                        </c:if>
                        <c:if test="${userid!=null}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <img src="${userheadpic}" alt='头像' class="img-circle" width=30px height=30px><span>${username}</span><span class="caret"></span></a>
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
    </div>
<div class="main">
    <!--右部的主页内容栏-->
    <div class="main-section">
        <div class="container allsections">
            <%--            <div class="row sections">--%>

            <%--            </div>--%>
        </div>
    </div>
</div>

<script>
    //页面首次加载
    $(function () {

        $.ajax({
            url:"${APP_PATH}/section/findAll",
            type:"GET",
            success:function(result){
                var sectionlist=result.extend.sectionslist;
                var row=$("<div class='row'></div>");
                $.each(sectionlist,function (index,item) {//所有的版块
                    //alert(item.sSectionname);//测试是否成功
                    var img=$("<img src=\"${APP_PATH}/statics/images/section/section"+item.sId+".jpg\" class=\"img-circle\" alt=\"版块\" width=\"250\" height=\"250\"/>");
                    var sectionA=$("<a></a>").append(item.sSectionname);
                    sectionA.attr("href","${APP_PATH}/section/thesection?sectionId="+item.sId);
                    var h3=$("<h3></h3>").append(sectionA);
                    var detailsection=$("<a></a>").append("详细");
                    detailsection.attr("href","${APP_PATH}/section/thesection?sectionId="+item.sId);
                    var p=$("<p></p>").append(item.sDescription);
                    var detail=$("<p></P>").append(detailsection);
                    var div=$("<div></div>").append(h3).append(p).append(detail).addClass("divsection");
                    $("<div class='col-md-3 clearfix'></div>")//section
                        .append(img)
                        .append(div)
                        .appendTo(row);
                    if(index%4===3){
                        row.appendTo(".allsections");
                        row=$("<div class='row'></div>");
                    }
                });
                row.appendTo(".allsections");
            }
        });
      });
</script>
</body>
</html>
