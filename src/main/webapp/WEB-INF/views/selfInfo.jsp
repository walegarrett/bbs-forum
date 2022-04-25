<%--
  Created by IntelliJ IDEA.
  User: 涛声依旧
  Date: 2019/12/12
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>个人信息修改</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("userid",session.getAttribute("username"));
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        .div1{
            position: absolute;
            left: 0%;
            top: 0%;
            width: 1200px;
            height: 150px;
        }
        .div2{
            position: absolute;
            left: 1%;
            top: 25%;
        }
        .div3{
            position: absolute;
            left: 15%;
            top: 25%;
        }
        .left-info{
            height:100%;/*100%*/
            width:160px;/*10%*/
            float:left;
            position:fixed;
            margin:70px auto;/*上方页面位置*/
            top:0;
            z-index:151;
            background-color: #e9f1f4;
        }
        .right-main{
            margin:70px auto;
            float:left;
        }
        button{
            border:0px;background-color:transparent;
        }
    </style>
</head>
<body>
<div class="containers">
    <!--上方的导航栏-->
    <%@include file="nav-top.jsp"%>
    <!--左部显示-->
    <div class="left-info">
<%--        <div class="div2">--%>
<%--            <div class="col-md-3">--%>
                <%-- 个人资料查看--%>
                <button type="button" id="self_view_btn" class="btn btn-info btn-lg btn-block">查看个人</button>
                <!-- 个人资料修改-->
                <button type="button" id="self_info_btn" class="btn btn-info btn-lg btn-block">个人资料</button>
                <%--文章修改--%>
                <button type="button" id="article_modify_btn" class="btn btn-info btn-lg btn-block">文章修改</button>
                <%--修改密码--%>
                <button type="button" id="password_modify_btn" class="btn btn-info btn-lg btn-block">修改密码</button>
                <%--修改头像--%>
                <button type="button" id="self_pic_btn" class="btn btn-info btn-lg btn-block">更换头像</button>
<%--            </div>--%>
<%--        </div>--%>
    </div>
    <!--右部的主页内容栏-->
    <div class="right-main">
        <%--显示个人信息和帖子--%>
        <div class="div3">
            <%--    iframe--%>
            <iframe id="frame_id" src="${APP_PATH}/view" frameborder="0" width="800" height="800" class="div3">

            </iframe>
        </div>
    </div>
</div>
<%--&lt;%&ndash;网站首部&ndash;%&gt;--%>
<%--<div class="div1">--%>

<%--    <h1> <strong>个人主页</strong></h1>--%>
<%--</div>--%>
<%--<hr>--%>


    <!-- 个人信息模态框 -->
    <div class="modal fade" id="selfInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">个人资料修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="selfInfo_form">
                        <div class="form-group">
                            <label for="userid_input" class="col-sm-2 control-label">账户</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="userid_input" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="issectioner_iput">是否版主</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text"  id="issectioner_iput" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name_input" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name_input" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="points_input">积分</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="points_input" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nickname_input" class="col-sm-2 control-label">昵称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="nickname_input" placeholder="昵称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gender_input" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="gender_input" placeholder="性别">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="age_input" class="col-sm-2 control-label">年龄</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="age_input" placeholder="年龄">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="workproperty_input" class="col-sm-2 control-label">工作性质</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="workproperty_input" placeholder="工作性质">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="workplace_input" class="col-sm-2 control-label">工作地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="workplace_input" placeholder="工作地址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email_input" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email_input" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="self_intro" class="col-sm-2 control-label">个人介绍</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="3" id="self_intro"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="self_save_btn">保存</button>
                </div>
            </div>
        </div>
    </div>
<script>
    $(function(){
        // 点击切换页面

        //查看个人
        $("#self_view_btn").click(function() {
            $("#frame_id").attr("src", "${APP_PATH}/view");
        });
        //文章修改
        $("#article_modify_btn").click(function() {
            $("#frame_id").attr("src", "${APP_PATH}/article");
        });
        //修改密码
        $("#password_modify_btn").click(function() {
            $("#frame_id").attr("src", "${APP_PATH}/pass");
        });
        //更换头像
        $("#self_pic_btn").click(function() {
            $("#frame_id").attr("src", "${APP_PATH}/pic");
        });
    });
</script>

<script>
$("#self_info_btn").click(function () {
    //发送请求，查询用户信息，显示在模态框
    getUserByid();
    //弹出模态框
    $("#selfInfoModal").modal({
        backdrop:"static"
    });
    function getUserByid() {
        var userid='${userid}';
        $.ajax({
            url: "${APP_PATH}/getUser",
            data:{userid:userid},
            type: "POST",
            success: function (result) {
                var s=result.extend.all;
                $.each(s,function (index,item) {
                    $("#userid_input").val(item.uUserid);
                    $("#issectioner_iput").val(item.uIssectioner===1?"是":"否");
                    $("#name_input").val(item.uName);
                    $("#points_input").val(item.uPoints);
                    $("#nickname_input").val(item.uNickname);
                    $("#gender_input").val(item.uSex);
                    $("#age_input").val(item.uAge);
                    $("#workproperty_input").val(item.uWorkproperty);
                    $("#workplace_input").val(item.uWorkplace);
                    $("#email_input").val(item.uEmail);
                    $("#self_intro").val(item.uIntro);
                });
            }

        });
    }
});


//个人资料修改提交
$("#self_save_btn").click(function () {
    //先进行数据校验
    if(!is_tooLong()) return false;
    /**  获取表单修改后信息  **/
    var userid=$("#userid_input").val();
    // var password=$("#makeSure_input").val();
    var name=$("#name_input").val();
    var nickname=$("#nickname_input").val();
    var sex=$("#gender_input").val();
    var age=$("#age_input").val();
    var email=$("#email_input").val();
    var workproperty=$("#workproperty_input").val();
    var workplace=$("#workplace_input").val();
    var intro=$("#self_intro").val();
// alert("userid="+userid+"&name="+name+"&nickname="+nickname+"&sex="+sex+"&age="+age
//     +"&email="+email+"&workproperty="+workproperty+"&workplace="+workplace+"&intro="
//     +intro,)
 $.ajax({
        url:"${APP_PATH}/selfAjax?userid="+userid+"&name="+name+"&nickname="+nickname
            +"&sex="+sex+"&age="+age+"&email="+email+"&workproperty="+workproperty+"&workplace="+workplace+"&intro="+intro,
        type:"POST",
        success: function (result) {
            if (result =="") {
              alert("个人资料添加成功！");
                $("#selfInfoModal").modal('hide');
            }
            else {
                alert("个人资料添加失败！");
            }
        }

    });
});

//校验输入是否过长
 function   is_tooLong() {
     var name = $("#name_input").val();
     var nickname = $("#nickname_input").val();
     var sex = $("#gender_input").val();
     var age = $("#age_input").val();
     var email = $("#email_input").val();
     var workproperty = $("#workproperty_input").val();
     var workplace = $("#workplace_input").val();
     var intro = $("#self_intro").val();
     if (name.length > 20) {
         alert("用户名输入过长，请您重新填写！！")
         return false;
     }
   else  if (nickname.length > 20) {
         alert("昵称输入过长，请您重新填写！！")
         return false;
     }
   else  if (sex.length > 10) {
         alert("性别输入过长，请您重新填写！！")
         return false;
     }
   else  if (age.length > 5) {
         alert("年龄输入过长，请您重新填写！！")
         return false;
     }
    else if (email.length > 30) {
         alert("邮箱输入过长，请您重新填写！！")
         return false;
     }
  else   if (workplace.length> 100) {
         alert("工作地址输入过长，请您重新填写！！")
         return false;
     }
   else  if (workproperty.length > 100) {
         alert("工作性质输入过长，请您重新填写！！")
         return false;
     }
   else  if (intro.length > 200) {
         alert("个人介绍输入过长，请您重新填写！！")
         return false;
     }
   else return true;
 }
</script>
</body>
</html>
