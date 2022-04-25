<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/10
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<!--
    置顶主贴页面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>将主贴置顶</title>
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
    <!--上方的导航栏-->
    <%@include file="nav-top.jsp"%>


    <!--右部的主页内容栏-->
    <div class="right-main">
        <div>
            <div class="container">
                <div class="row">
                    <div class="col-md-2"><nav><div id="return_section"></div></nav></div>
                </div>
            </div>
        </div>
        <div class="container">
            <!--导航区-->
            <div class="row">
                <div class="col-md-12">
                    <div class="nav">
                        <div class="titleShow"><h1>请选择${section.sSectionname}版面需要置顶的主贴</h1></div>
                        <!--显示选择看帖子还是精华帖-->
                        <div class="selects">
                            <div class="row">
                                <ul class="nav nav-tabs">
                                    <li role="presentation" class="active"><a href="${APP_PATH}/main/notTop?sectionId=${section.sId}">置顶</a></li>
                                    <li role="presentation"><a href="${APP_PATH}/main/notPerfect?sectionId=${section.sId}">加精</a></li>
                                    <li role="presentation"><a href="${APP_PATH}/section/tochangesection?sectionId=${section.sId}">修改版块信息</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--内容区-->
            <div class="row">
                <div class="col-md-12">
                    <!--展示帖子或者精华帖-->
                    <div class="allMains">
                        <div class="row">
                            <div class="col-md-12"><!--存放所有的帖子-->
                                <table class="table table-hover" id="mains_table">
                                    <thead>
                                    <tr>
                                        <th>
                                            <input type="checkbox" id="check_all">
                                        </th>
                                        <th>#</th>
                                        <th>标题</th>
                                        <th>发帖人</th>
                                        <th>发帖时间</th>
                                        <th>回复数</th>
                                        <th>最后发表</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--按钮-->
            <div class="row">
                <div class="col-md-4">
                    <button class="btn btn-danger" id="selectTop"><span class="glyphicon glyphicon-plus" aria-hidden="true">置顶</span></button>
                </div>
            </div>
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
    var totalRecord;//总记录数
    var currentPage;//当前页
    //返回所在版面的标志
    var return_section_span=
        $("<a href='${APP_PATH}/section/thesection?sectionId=${section.sId}'>" + "<span class=\"glyphicon glyphicon-arrow-left \" aria-hidden=\"true\"></span> 返回版面</a>");
    $("#return_section").append(return_section_span);

    //1.页面加载完成后，直接发送一个ajax请求，拿到分页信息
    $(function(){
        to_page(1);//首次加载页面时显示第一页
    });
    //跳转到页面
    function to_page(pn){
        $("#check_all").prop("checked",false);
        var data={
            "pn":pn,
            "sectionId":${section.sId}
        };
        $.ajax({
            url:"${APP_PATH}/main/findNotTop",
            data:data,
            type:"get",
            success:function (result) {
                //console.log(result);
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
        $("table tbody").empty();
        var emps=result.extend.pageInfo.list;

        $.each(emps,function (index,item) {
            var checkBoxTd=$("<td><input type='checkbox' class='check_item'/></td>" );
            var mainIdTd=$("<td></td>").append(item.mMainid);
            var mainTitleTd=$("<td></td>").append(item.mTitle);
            var link=$("<a href='${APP_PATH}/jumpToLogin/follow?mainId="+item.mMainid+"' target='_blank' class='link'></a>");
            mainTitleTd.append(link);

            var mainnerHeadPic=$("<div></div>").append("<img src='"+item.user.uHeadpic+"'alt='头像' class=\"img-circle\" width=45px height=45px>");
            var mainnerNickname=$("<div></div>").append(item.user.uUserid);
            var userNickname=$("<td></td>").append(mainnerHeadPic).append(mainnerNickname);//主帖的发布者
            link=$("<a href='${APP_PATH}/userInfo.jsp?uid="+item.user.uId+"' target='_blank' class='link'></a>");
            userNickname.append(link);

            var date=formatDate(item.mMaindate);
            var hourandminute=formatDateHourAndMinute(item.mMaindate);

            var mainDate=$("<td></td>").append(date+" "+hourandminute);

            var follows=$("<td></td>").append(getJsonLength(item.follows));

            var latestdate=formatDate(item.latestTime);
            var latesthourandminute=formatDateHourAndMinute(item.latestTime);

            var latestuser=$("<div></div>").append(item.latestPublish.uUserid);
            var latesttime=$("<div></div>").append(latestdate+" "+latesthourandminute);
            //最新发表
            var latest=$("<td></td>").append(latestuser).append(latesttime);


            //append方法执行完返回的还是原来的元素
            $("<tr></tr>")
                .append(checkBoxTd)
                .append(mainIdTd)
                .append(mainTitleTd)
                .append(userNickname)
                .append(mainDate)
                .append(follows)
                .append(latest)
                .appendTo("#mains_table tbody");
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

    //完成全选，全不选功能
    $("#check_all").click(function () {
        //attr获取checked是undefined,dom原生的属性
        //以后使用prop修改和读取dom原生属性的值
        //alert($(this).prop("checked"));
        $(".check_item").prop("checked",$(this).prop("checked"));
    });
    //check_item
    $(document).on("click",".check_item",function () {
        //判断当前选择的元素是否是5个
        var flag=$(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });
    //点击置顶就批量置顶
    $("#selectTop").click(function () {
        //首先判断是否登录
        if("${userid}".length===0){
            alert("您当前未登录，不能置顶帖子！");
            return;
        }
        if("${userid}"!="${section.sBanzhuid}"){
            alert("你不是该版的版主，不能进行移除操作！！！");
            return;
        }
        var postID="";
        var tops="";
        var num=0;
        $.each($(".check_item:checked"),function () {
            //当前遍历的元素
            //$(this).parents("tr").find("td:eq(2)").text();
            postID+=$(this).parents("tr").find("td:eq(1)").text()+" ,";
            //组装主贴id的字符串
            tops+=$(this).parents("tr").find("td:eq(1)").text()+"-";
            num++;
        });

        if(!num){
            alert("请选择需要置顶的帖子");
            return;
        }
        //去除empNames多余的逗号
        postID=postID.substring(0,postID.length-1);
        //去除多余的分隔符
        tops=tops.substring(0,tops.length-1);
        if(confirm("确认将【"+postID+"】置顶吗？")){

            //发送ajax请求
            var params = {
                "tops":tops,
                "sectionId":${section.sId}
            };
            $.ajax({
                url:"${APP_PATH}/main/addTop",
                data:params,
                success:function (result) {
                    if(result.code==100){
                        alert("置顶成功！");
                        to_page(currentPage);//----------------可以优化
                    }else{

                        //执行有错误时候的判断
                        if(undefined!=result.extend.errorFields.usernotlogin){
                            alert(result.extend.errorFields.usernotlogin);
                        }
                        if(undefined!=result.extend.errorFields.notbanzhu){
                            alert(result.extend.errorFields.notbanzhu);
                        }else
                            alert(result.extend.error);
                    }
                }
            });
        }
    })
</script>
</body>
</html>

