<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/18
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>搜索结果页面</title>
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

<div class="containers">
    <%@include file="nav-top.jsp"%>
    <!--右部的主页内容栏-->
    <div class="right-main">
        <div class="container">
            <!--搜索-->
            <div class="row">
                <div>
                    <div class="navbar-form">
                        <div class="form-group">
                            <input type="text" class="form-control" id="localsearch" placeholder="搜索帖子、用户" value="${searchcontent}" style="width:1000px">
                        </div>
                        <button class="btn btn-default" id="totalsearch1">搜索</button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="introduce">

                    </div>
                    <div class="nav">
                        <!--显示选择看帖子还是精华帖-->
                        <div class="selects">
                            <div class="row">
                                <ul class="nav nav-tabs kinds">
                                    <li role="presentation" id="searchmains"><a href="#">帖子</a></li>
                                    <li role="presentation" id="searchusers"><a href="#">用户</a></li>
<%--                                    <li role="presentation"><a href="#">其他</a></li>--%>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--搜索结果区-->
            <div class="searchresult">

            </div>
            <div class="pagehelp">
                <!--显示分页信息-->
                <div class="row">
                    <!--分页文字信息-->
                    <div class="col-md-6" id="page_info_area">

                    </div>
                    <!--分页条-->
                    <div class="col-md-6" id="page_nav_area">

                    </div>
                </div>
            </div>

        </div>
    </div>
<script>
    $(function () {
        $("#searchmains").addClass("active");
        $("#searchusers").removeClass("active");
        to_page(1);
    });
    //跳转到页面
    function to_page(pn){
        if($("#localsearch").val().length===0){
            $(".searchresult").html("请输入要搜索的内容！");
            $("#page_info_area").empty();
            $("#page_nav_area").empty();
            return;
        }
        var data={
            "pn":pn,
            "keyword":$("#localsearch").val()//拿到搜索框里的关键词
        };
        //alert($("#localsearch").val());
        $.ajax({
            url:"${APP_PATH}/main/searchMains",
            data:data,
            type:"get",
            success:function (result) {
                //console.log(result);
                var emps=result.extend.pageInfo.list;
                var num=0;
                $.each(emps,function (index,item) {
                    num++;
                });
                if(num==0){
                    $(".searchresult").html("搜索内容为空！");
                    $("#page_info_area").empty();
                    $("#page_nav_area").empty();
                    return;
                }
                //1.解析并且显示员工数据
                build_mains_table(result);
                //2.解析并且显示分页信息
                build_page_info(result);
                //3.分页条的显示
                build_page_nav(result);
            }
        });
    }
    //table结构
    function build_mains_table(result) {
        //清空table表
        $(".searchresult").empty();
        var emps=result.extend.pageInfo.list;
        $.each(emps,function (index,item) {

            var mainTitleTd=$("<div class='col-md-3'></div>").append("标题："+item.mTitle);
            var link=$("<a href='${APP_PATH}/jumpToLogin/follow?mainId="+item.mMainid+"' target='_blank' class='link'></a>");
            mainTitleTd.append(link);
            //指向特定帖子的链接
            var link=$("<a href='${APP_PATH}/jumpToLogin/follow?mainId="+item.mMainid+"' target='_blank' class='link'></a>");
            mainTitleTd.append(link);

            var mainnerHeadPic=$("<div></div>").append("<img src='"+item.user.uHeadpic+"'alt='头像' class=\"img-circle\" width=45px height=45px>");
            var mainnerid=$("<div></div>").append(item.user.uUserid);
            var userNickname=$("<div class='col-md-3'></div>").append(mainnerHeadPic).append(mainnerid);//主帖的发布者
            link=$("<a href='${APP_PATH}/userInfo.jsp?uid="+item.user.uId+"' target='_blank' class='link'></a>");
            userNickname.append(link);

            var date=formatDate(item.mMaindate);
            var hourandminute=formatDateHourAndMinute(item.mMaindate);

            var mainDate=$("<div class='col-md-3'></div>").append("发帖时间："+date+" "+hourandminute);

            var follows=$("<div class='col-md-3'></div>").append("回复数:"+getJsonLength(item.follows));

            //append方法执行完返回的还是原来的元素
            $("<div class=\"col-md-12\"></div>")
                .append(mainTitleTd)
                .append(userNickname)
                .append(mainDate)
                .append(follows)
                .appendTo($("<div class=\"row\"></div>"))
                .appendTo(".searchresult");
        });
    }
    //解析显示分页信息
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，" +
            "总共"+result.extend.pageInfo.pages+"页，" +
            "总共"+result.extend.pageInfo.total+"条记录");
        totalRecord=result.extend.pageInfo.total;
        currentPage=result.extend.pageInfo.pageNum;
    }
    //解析显示分页条，点击分页要去下一页
    function build_page_nav(result){
        $("#page_nav_area").empty();
        var ul=$("<ul><ul>").addClass("pagination");
        var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            });
        }
        var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage==false){
            lastPageLi.addClass("disabled");
            nextPageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            });
        }

        //添加首页和前一页的提示
        ul.append(firstPageLi).append(prePageLi);

        //遍历给ul中添加页码
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numLi=$("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum==item){
                numLi.addClass("active");//高亮显示
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加末页和下一页的提示
        ul.append(nextPageLi).append(lastPageLi);
        //把ul添加到nav中
        var navEle=$("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }
    //点击搜索按钮
    $("#totalsearch1").click(function () {
        if($("#searchmains").hasClass("active")){
            to_page(1);
        }else{
            to_page_user(1);
        }
    });
    //查找帖子
    $("#searchmains a").click(function () {
        $("#searchusers").removeClass("active");
        $("#searchmains").addClass("active");
        to_page(1);
    });
    //查找用户
    $("#searchusers a").click(function () {
        $("#searchmains").removeClass("active");
        $("#searchusers").addClass("active");
        to_page_user(1);
    });
    //以下是用户的搜索结果
    //跳转到页面
    function to_page_user(pn){
        //alert($("#localsearch").val());
        if($("#localsearch").val().length===0){
            $(".searchresult").html("请输入要搜索的内容！");
            $("#page_info_area").empty();
            $("#page_nav_area").empty();
            return;
        }
        var data={
            "pn":pn,
            "keyword":$("#localsearch").val()//拿到搜索框里的关键词
        };

        $.ajax({
            url:"${APP_PATH}/user/searchUsers",
            data:data,
            type:"get",
            success:function (result) {
                //console.log(result);
                var emps=result.extend.pageInfo.list;
                var num=0;
                $.each(emps,function (index,item) {
                    num++;
                });
                if(num==0){
                    $(".searchresult").html("搜索内容为空！");
                    $("#page_info_area").empty();
                    $("#page_nav_area").empty();
                    return;
                }
                //1.解析并且显示员工数据
                build_mains_table_user(result);
                //2.解析并且显示分页信息
                build_page_info_user(result);
                //3.分页条的显示
                build_page_nav_user(result);
            }
        });
    }

    //table结构
    function build_mains_table_user(result) {
        //清空table表
        $(".searchresult").empty();
        var emps=result.extend.pageInfo.list;
        $.each(emps,function (index,item) {

            var mainnerHeadPic=$("<div></div>").append("<img src='"+item.uHeadpic+"'alt='头像' class=\"img-circle\" width=45px height=45px>");
            var mainnerid=$("<div></div>").append(item.uUserid);
            var userid=$("<div class='col-md-4'></div>").append(mainnerHeadPic).append(mainnerid);//主帖的发布者

            var link=$("<a href='${APP_PATH}/userInfo.jsp?uid="+item.uId+"' target='_blank' class='link'></a>");
            userid.append(link);

            var mains=$("<div class='col-md-4'></div>").append("总发帖数："+item.mainPostNums);

            //积分数
            var points=$("<div class='col-md-4'></div>").append("积分数："+item.uPoints);

            //append方法执行完返回的还是原来的元素
            $("<div class=\"col-md-12\"></div>")
                .append(userid)
                .append(mains)
                .append(points)
                .appendTo($("<div class=\"row\"></div>"))
                .appendTo(".searchresult");
        });
    }
    //解析显示分页信息
    function build_page_info_user(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，" +
            "总共"+result.extend.pageInfo.pages+"页，" +
            "总共"+result.extend.pageInfo.total+"条记录");
        totalRecord=result.extend.pageInfo.total;
        currentPage=result.extend.pageInfo.pageNum;
    }
    //解析显示分页条，点击分页要去下一页
    function build_page_nav_user(result){
        $("#page_nav_area").empty();
        var ul=$("<ul><ul>").addClass("pagination");
        var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            firstPageLi.click(function () {
                to_page_user(1);
            });
            prePageLi.click(function () {
                to_page_user(result.extend.pageInfo.pageNum-1);
            });
        }
        var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage==false){
            lastPageLi.addClass("disabled");
            nextPageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            lastPageLi.click(function () {
                to_page_user(result.extend.pageInfo.pages);
            });
            nextPageLi.click(function () {
                to_page_user(result.extend.pageInfo.pageNum+1);
            });
        }

        //添加首页和前一页的提示
        ul.append(firstPageLi).append(prePageLi);

        //遍历给ul中添加页码
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numLi=$("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum==item){
                numLi.addClass("active");//高亮显示
            }
            numLi.click(function () {
                to_page_user(item);
            });
            ul.append(numLi);
        });
        //添加末页和下一页的提示
        ul.append(nextPageLi).append(lastPageLi);
        //把ul添加到nav中
        var navEle=$("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }
</script>
</body>
</html>
