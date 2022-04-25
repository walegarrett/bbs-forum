<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/16
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/statics/css/layui.css">
    <script src="${APP_PATH}/statics/js/layui.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/dist/js/bootstrapValidator.js"></script>
    <title>注册</title>
</head>
<body style="background-image:url('${APP_PATH}/statics/images/register.jpg')">
<div class="container">
    <div class="row">
        <!-- form: -->
        <section>
            <div class="col-lg-8 col-lg-offset-2">
                <div class="page-header">
                    <h2>注&nbsp;册</h2>
                </div>
                <form action="${APP_PATH}/regUser" method="post" id="user_regis_form" class="form-horizontal"
<%--                      method="post" action="reguser"--%>
                      data-bv-message="This value is not valid"
                      data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                      data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                      data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">真实姓名</label>
                        <div class="col-lg-4">
                            <input action="reguser" type="text" class="form-control" name="uName" id="uName" placeholder="Full name" required data-bv-notempty-message="姓名栏不能为空" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">年龄</label>
                        <div class="col-lg-3">
                            <input type="text" class="form-control" name="uAge" id="uAge" placeholder="Age"
                                   required data-bv-notempty-message="请填入您的年龄"
                            />
                        </div>
                    </div>
<%--                    |^[\u2E80-\u9FFF]{2,5}$--%>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">账号</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="uUserid" id="uUserid" placeholder="Userid"
                                   required data-bv-notempty-message="账号不能为空哦"
                                   pattern="^[a-zA-Z0-9_]{6,16}$|^[\u2E80-\u9FFF]{2,5}$"
                                   data-bv-regexp-message="用户名必须是6-16位数字和字母的组合或者2-5位中文"
<%--                                   data-bv-stringlength="true" data-bv-stringlength-min="9" --%>
<%--                                   data-bv-stringlength-max="11" data-bv-stringlength-message="账号长度要在9~11哦"--%>
                            />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">昵称</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="uNickname" id="uNickname" placeholder="Nickname" required data-bv-notempty-message="昵称不能为空" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">Email address</label>
                        <div class="col-lg-5">
                            <input class="form-control" name="uEmail" id="uEmail" type="email" placeholder="*****@qq.com" data-bv-emailaddress-message="您输入的email不可用" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">密码</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="uPassword" id="uPassword" placeholder="密码(不能和昵称相同哦)"
                                   required data-bv-notempty-message="请输入您的密码"
                                   data-bv-different="true" data-bv-different-field="uUserid" data-bv-different-message="密码不能和账号相同哦"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">确认密码</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="confirmPassword" placeholder="请重新输入您的密码"
                                   required data-bv-notempty-message="确认密码不能为空哦"
                                   data-bv-identical="true" data-bv-identical-field="uPassword" data-bv-identical-message="确认密码不正确"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">性别</label>
                        <div class="col-lg-5">
                            <select name = "uSex" id="uSex" class="form-control" class="form-control" required data-bv-notempty-message="请选择您的性别">
                                <option value = "男">男</option>
                                <option value = "女">女</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">地区</label>
                        <div class="col-lg-5">
                            <select class="form-control" name="uWorkplace" id="uWorkplace" data-bv-notempty data-bv-notempty-message="The country is required">
                                <option value="">-- Select a country --</option>
                                <option value="中国">China</option>
                                <option value="法国">France</option>
                                <option value="德国">Germany</option>
                                <option value="意大利">Italy</option>
                                <option value="日本">Japan</option>
                                <option value="俄罗斯">Russia</option>
                                <option value="英国">United Kingdom</option>
                                <option value="美国">United State</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-9 col-lg-offset-3">
                            <button id="user_save_btn" type="submit" class="btn btn-primary">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- :form -->
    </div>
</div>
</body>
<script>
    $(function(){
        $("#uName").empty();
        $("#uAge").empty();
        $("#uUserid").empty();
        $("#uNickname").empty();
        $("#uEmail").empty();
        $("#uPassword").empty();
    });
     $("#user_regis_form").submit(function (){
        //1.采用模态框进行表单数据的提交给服务器
        //2.发送ajax请求保存新用户
         //发送ajax请求校验账号是否重复
         var uUserid=$("#uUserid").val();
         var checkid = true;
         $.ajax({
             url:"${APP_PATH}/checkuUserid",
             data:"uUserid="+uUserid,
             async:false,
             type:"POST",
             success:function (result){
                 if(result.code==100){
                     $("#uUserid").parent().removeClass("has-error");
                     $("#uUserid").parent().addClass("has-success");
                 }else{
                     $("#uUserid").parent().removeClass("has-success");
                     $("#uUserid").parent().addClass("has-error");
                     checkid = false;
                 }
             }
         });
         if(checkid){
         }else{
             alert("账号重复");
             return false;
         }
             var uName=$("#uName").val();
             var uAge=$("#uAge").val();
             var uNickname=$("#uNickname").val();
             var uEmail=$("#uEmail").val();
             var uPassword=$("#uPassword").val();
             var uSex=$("#uSex").val();
             var uWorkplace=$("#uWorkplace").val();
         if(uName.length==0){
                 return false;
         }
         if(uAge.length==0){
             return false;
         }
         if(uUserid.length==0){
             return false;
         }
        if(uNickname.length==0){
                 return false;
         }
         if(uEmail.length==0){
             return false;
         }
         if(uPassword.length==0){
             return false;
         }
         if(uSex.length==0){
             return false;
         }
         if(uWorkplace.length==0){
             return false;
         }
         if (uName.length > 5) {
             alert("请输入真实姓名！！");
             return false;
         }
         if (uNickname.length > 20) {
             alert("昵称输入过长，请您重新填写！！");
             return false;
         }
         if(uPassword.length>25){
             alert("密码输入过长，请您重新填写！！");
             return false;
         }
         if (uAge.length > 2) {
             alert("年龄输入过大，请您重新填写！！");
             return false;
         }
         if (uEmail.length > 30) {
             alert("邮箱输入过长，请您重新填写！！");
             return false;
         }
         var j=0;
         var i;
         for(i=0;i<uEmail.length;i++)
         {
             if(uEmail[i]!=='@')
             {
                 j++;
             }else if(uEmail[i+1]==null){
                 alert("邮箱格式不正确");
                 return false;
             }
         }
         if(j===uEmail.length){
             alert("邮箱格式不正确");
             return false;
         }
     // });
     });
     $(document).ready(function(){
         $('#user_regis_form').bootstrapValidator();
     });
</script>
</html>
<%--// let newTab  = window.open("about:blank");--%>
<%--$.ajax({--%>
<%--    url:"${APP_PATH}/regUser?uName="+uName+"&uAge="+uAge+"&uUserid="+uUserid+"&uNickname="+uNickname+"&uEmail="+uEmail+"&uPassword="+uPassword+"&uSex="+uSex+"&uWorkplace="+uWorkplace,--%>
<%--    type:"POST",--%>
<%--    async:false,//删除--%>
<%--    success:function(result){--%>
<%--        if(result.code==100){--%>
<%--            alert("注册成功");--%>
<%--            &lt;%&ndash;window.location.href='${APP_PATH}/jumpToLogin/login';&ndash;%&gt;--%>
<%--            newTab.location.href='${APP_PATH}/jumpToLogin/login';--%>
<%--            &lt;%&ndash;window.open('${APP_PATH}/jumpToLogin/login');&ndash;%&gt;--%>
<%--        }else{--%>
<%--            alert("注册失败");--%>
<%--        }--%>
<%--    }--%>
<%--});--%>
<%--// $("#uUserid").change(function (){--%>