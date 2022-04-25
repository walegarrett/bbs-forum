<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/19
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/dist/js/bootstrapValidator.js"></script>

</head>
<body style="background-image:url('${APP_PATH}/statics/images/adminLogin.jpg')">
<form action="${APP_PATH}/checkLogin" method="post" id="adminloginform">
    <h1>欢迎管理员</h1>
    <hr/>
    <table align="center">
        <tr>
            <td>账号：</td>
            <td><input type="text" name="aAdminname" id="aAdminname" class="form-control">
                <div id="idError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="aPassword" id="aPassword" class="form-control">
                <div id="passwordError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="checkbox">
                    <label>
                        <input type="checkbox">记住密码
                    </label>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <button id="admin_login_btn" type="submit" class="btn btn-primary">登录</button>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
<script>
        $("#adminloginform").submit(function() {
        //发送ajax请求校验账号是否重复
        var aAdminname=$("#aAdminname").val();
        var aPassword=$("#aPassword").val();
        if(aAdminname.length==0){
            alert("请输入管理员账号");
            return false;
        }
        if(aPassword.length==0){
            alert("请输入密码");
            return false;
        }
         var data = {
             "aAdminname":aAdminname,
             "aPassword":aPassword,
         };
        <%--$.ajax({--%>
        <%--    url:"${APP_PATH}/checkLogin",--%>
        <%--    data:data,--%>
        <%--    type:"POST",--%>
        <%--    async:false,--%>
        <%--    success:function (result) {--%>
        <%--        if (result==null) {--%>
        <%--            alert("对不起，您还不是管理员");--%>
        <%--            return false;--%>
        <%--        }--%>
        <%--    }--%>
        <%--});--%>
    });
</script>
</html>
