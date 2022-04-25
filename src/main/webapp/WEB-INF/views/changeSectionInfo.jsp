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
    <title>版块信息修改</title>
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
        <div>
            <div class="container">
                <div class="row">
                    <div class="col-md-2"><nav><div id="return_section"></div></nav></div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav">
                        <div class="titleShow"><h1>修改版块基本信息</h1></div>
                        <!--显示选择看帖子还是精华帖-->
                        <div class="selects">
                            <div class="row">
                                <ul class="nav nav-tabs">
                                    <li role="presentation"><a href="${APP_PATH}/main/notTop?sectionId=${section.sId}">置顶</a></li>
                                    <li role="presentation"><a href="${APP_PATH}/main/notPerfect?sectionId=${section.sId}">加精</a></li>
                                    <li role="presentation" class="active"><a href="${APP_PATH}/section/tochangesection?sectionId=${section.sId}">修改版块信息</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--展示版块信息-->
            <div class="row">
                <div class="col-md-12">
                    <div class="allMains">
                        <div class="row">
                            <div class="col-md-12"><!--存放所有的版块-->
                                <table class="table table-hover" id="sections_table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>版块名称</th>
                                        <th>版块介绍</th>
                                        <th>所有主帖数</th>
                                        <th>所有回复数</th>
                                        <th>编辑</th>
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
            <!--修改版块信息-->
            <a id="edit"></a>
            <div class="showedit">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <p>修改版块信息！</p>
                        </div>
                    </div>
                    <form>
                        <input type="text" name="sId" hidden>
                        <div class="row">
                            <div class="input-group title">
                                <input type="text" name="sSectionname" id="section-title" class="form-control" style="width:1150px;height:50px" placeholder="请填写标题（字数不多于50）"/>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-group title">
                                <input type="text" name="sDescription" id="section-description" class="form-control" style="width:1150px;height:50px" placeholder="请填写版块介绍（字数不多于150）"/>
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <input type="text" name="sBanzhuid" hidden>

                    </form>
                    <!--注意这里的提交修改-->
                    <div class="row">
                        <div class="sub">
                            <button class="btn btn-primary" id="change_btn"><span class="glyphicon glyphicon-share-alt"></span>提交修改</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        var return_section_span=
            $("<a href='${APP_PATH}/section/thesection?sectionId=${section.sId}'>" + "<span class=\"glyphicon glyphicon-arrow-left \" aria-hidden=\"true\"></span> 返回版面</a>");
        $("#return_section").append(return_section_span);
        $(function () {
            $(".showedit").hide();//将修改版块的区域默认不可见
            //展示该版主管理的所有版块
            showAllSection();
        });
        //展示所有的版块及其标题和介绍
        function showAllSection(){
            //通过userid来进行操作显示所有的版块
            if("${userid}".length===0){
                alert("您当前未登录，不能查看版块信息！");
                return;
            }
            if("${user.uIssectioner}"=="0"){
                alert("您不是版主，不能查看版块信息！");
                return;
            }
            var userid="${userid}";
            $.ajax({
                url:"${APP_PATH}/section/findAllSections",
                data:"banzhuid="+userid,
                success:function (result) {
                    if(result.code==100){
                        build_section_list(result);
                    }else{
                        alert("查看版块信息失败！");
                    }
                }
            });
        }
        function build_section_list(result){

            //清空table表
            $("table tbody").empty();
            var emps=result.extend.list;

            $.each(emps,function (index,item) {
                // var checkBoxTd=$("<td><input type='checkbox' class='check_item'/></td>" );
                var mainIdTd=$("<td></td>").append(item.sId);

                var mainTitleTd=$("<td></td>").append(item.sSectionname);
                var link=$("<a href='${APP_PATH}/section/thesection?sectionId="+item.sId+"' target='_blank' class='link'></a>");
                mainTitleTd.append(link);
                // var divdescription=$("<div style='width=100px'></div>").append(item.sDescription);
                var description=$("<td></td>").append(item.sDescription);

                var mainnums=$("<td></td>").append(item.mainNums);
                var follownums=$("<td></td>").append(item.followNums);
                //增加编辑按钮
                var editBtn=$("<button></button>").addClass("btn btn-success btn-sm edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("<a href='#edit'>编辑</a>");
                //为编辑按钮添加一个自定义的属性
                editBtn.attr("edit-id",item.sId);
                var editTd=$("<td></td>").append(editBtn);
                //append方法执行完返回的还是原来的元素
                $("<tr></tr>")
                    .append(mainIdTd)
                    .append(mainTitleTd)
                    .append(description)
                    .append(mainnums)
                    .append(follownums)
                    .append(editTd)
                    .appendTo("#sections_table tbody");
            });
        }
        //check_item
        $(document).on("click",".edit_btn",function () {
            //首先判断是否登录
            if("${userid}".length===0){
                alert("您当前未登录，不能修改版块信息！");
                return false;
            }
            //先把编辑区显示出来
            $(".showedit").show();
            var sectionId=$(this).attr("edit-id");//获取主帖的id
            $("#change_btn").attr("sectionId",sectionId);//传递attr属性表示修改的是哪个版块

            var sectionTitle=$(this).parents("tr").find("td:eq(1)").text();
            var sectionDescription=$(this).parents("tr").find("td:eq(2)").text();
            $("#section-title").val(sectionTitle);
            $("#section-description").val(sectionDescription);
        });
        //显示校验结果的提示信息
        function show_validate_msg(ele,status,msg){
            //清除当前元素的校验状态
            $(ele).parent().removeClass("has-success has-error");
            $(ele).next("span").text("");
            if("success"==status){
                $(ele).parent().addClass("has-success");
                $(ele).next("span").text(msg);
            }else if("error"==status){
                $(ele).parent().addClass("has-error");
                $(ele).next("span").text(msg);
            }
        }
        //版块名称输入框的变化
        $("#section-title").change(function () {
            var title=$("#section-title").val();
            if(title.length>15){
                show_validate_msg("#section-title","error","版块名称字数不超过15字");
            }else if(!title){
                show_validate_msg("#section-title","error","版块名称不能为空");
            }else{
                show_validate_msg("#section-title","success","");
            }
        });
        //版块名称输入框的变化
        $("#section-description").change(function () {
            var description=$("#section-description").val();
            if(description.length>150){
                show_validate_msg("#section-description","error","版块介绍字数不超过150字");
            }else if(!description){
                show_validate_msg("#section-description","error","版块介绍不能为空");
            }else{
                show_validate_msg("#section-description","success","");
            }
        });
        function validateInput(){
            var title=$("#section-title").val();
            if(title.length>15){
                show_validate_msg("#section-title","error","版块名称字数不超过15字");
                return false;
            }else if(!title){
                show_validate_msg("#section-title","error","版块名称不能为空");
                return false
            }else{
                show_validate_msg("#section-title","success","");
            }
            var description=$("#section-description").val();
            if(description.length>150){
                show_validate_msg("#section-description","error","版块介绍字数不超过150字");
                return false
            }else if(!description){
                show_validate_msg("#section-description","error","版块介绍不能为空");
                return false
            }else{
                show_validate_msg("#section-description","success","");
            }
            return true;
        }
        //提交修改文章的操作
        $("#change_btn").click(function () {
            //首先判断是否登录
            if("${userid}".length===0){
                alert("您当前未登录，不能修改版块信息！");
                return false;
            }
            //数据校验
            if(!validateInput()){
                return false;
            }
            var banzhuid="${userid}";
            banzhuid=parseInt(banzhuid);
            var sectionId=$("#change_btn").attr("sectionId");
            // sectionId=parseInt(sectionId);
            $("form input[name=sId]").val(sectionId);
            $("form input[name=sBanzhuid]").val(banzhuid);
            //alert($("form input[name=sBanzhuid]").val());
            var data={
                "sId":sectionId,
                "sBanzhuid":banzhuid,
                "sSectionname":$("#section-title").val(),
                "sDescription":$("#section-description").val()
            };
            //alert(data);
            $.ajax({
                url:"${APP_PATH}/section/updateSection",
                type:"POST",
                data:$("form").serialize(),
                // data:data,
                success:function (result) {
                    if(result.code==100){
                        $(".showedit").hide();//将修改文章的区域默认不可见
                        showAllSection();
                    }else{
                        alert("失败！");
                    }
                }
            });

        });
    </script>
</body>
</html>
