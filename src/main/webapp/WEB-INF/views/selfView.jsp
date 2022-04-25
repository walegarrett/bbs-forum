<%--
  Created by IntelliJ IDEA.
  User: 涛声依旧
  Date: 2019/12/18
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("userid",session.getAttribute("username"));
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <%--    <script src="${APP_PATH}/statics/js/jquery.ajaxfileupload.js"></script>--%>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        function gerUser() {
            var userid='${userid}';
            $.ajax({
                url: "${APP_PATH}/getUser",
                data:{userid:userid},
                type: "POST",
                success: function (result) {
                    var s = result.extend.all;
                    $.each(s, function (index, item) {
                        $("#userid_input1").val(item.uUserid);
                        $("#issectioner_iput1").val(item.uIssectioner === 1 ? "是" : "否");
                        $("#name_input1").val(item.uName);
                        $("#points_input1").val(item.uPoints);
                        $("#nickname_input1").val(item.uNickname);
                        $("#gender_input1").val(item.uSex);
                        $("#age_input1").val(item.uAge);
                        $("#workproperty_input1").val(item.uWorkproperty);
                        $("#workplace_input1").val(item.uWorkplace);
                        $("#email_input1").val(item.uEmail);
                        $("#self_intro1").val(item.uIntro);
                    });
                }
            });
        }
    </script>
</head>
<body onload="gerUser()">
<div class="col-md-9" id="selfInfo_Main">
    <%--个人信息展示--%>
    <form class="form-horizontal" id="selfInfo_form1">
<%--        <img src="${APP_PATH}\webapp\statics\images\spring.jpg" alt="123" class="img-rounded">--%>
        <div class="form-group">
            <label for="userid_input1" class="col-sm-2 control-label">账户</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="userid_input1" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="issectioner_iput1">是否版主</label>
            <div class="col-sm-10">
                <input class="form-control" type="text"  id="issectioner_iput1" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="name_input1" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name_input1" placeholder="用户名" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="points_input1">积分</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="points_input1" readonly>
        </div>
        </div>
        <div class="form-group">
            <label for="nickname_input1" class="col-sm-2 control-label">昵称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nickname_input1" placeholder="昵称" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="gender_input1" class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gender_input1" placeholder="性别" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="age_input1" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="age_input1" placeholder="年龄" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="workproperty_input1" class="col-sm-2 control-label">工作性质</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="workproperty_input1" placeholder="工作性质" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="workplace_input1" class="col-sm-2 control-label">工作地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="workplace_input1" placeholder="工作地址" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="email_input1" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email_input1" placeholder="Email" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="self_intro1" class="col-sm-2 control-label">个人介绍</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="3" id="self_intro1" readonly></textarea>
            </div>
        </div>
    </form>
</div>
</body>
</html>
