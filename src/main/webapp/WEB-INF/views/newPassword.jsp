<%--
  Created by IntelliJ IDEA.
  User: 涛声依旧
  Date: 2019/12/18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
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
        function getPass() {
            var userid='${userid}';
            $.ajax({
                url: "${APP_PATH}/getPassword",
                data:{userid:userid},
                type: "GET",
                success: function (result) {
                    var s = result.extend.paw;
                    $.each(s, function (index, item) {
                     $("#oldPassword").val(item.uPassword);
                    });
                }
            });
        }
    </script>
</head>
<body onload="getPass()">
<div style="text-align: center;">
                        <div class="form-group">
                            <label for="oldPassword" class="col-sm-2 control-label">原密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="oldPassword" placeholder="Password" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="oldPassword_Input" class="col-sm-2 control-label">请输入原密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="oldPassword_Input" placeholder="Password" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="newPassword" class="col-sm-2 control-label">新密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="newPassword" placeholder="Password" >
                            </div>
                        </div>
                            <div class="form-group">
                                <label for="makeSure_input" class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="makeSure_input" placeholder="Password">
                                </div>
                            </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" id="self_save_btn">保存</button>
                                    </div>
</div>
<script>
    $("#self_save_btn").click(function () {
        //先进行数据校验
        //判断原密码是否正确
        if(!validate_oldPassword()) return false;
        if(!validate_save_form()) return false;
        if(!istooLong()) return false;
        /**  获取密码修改后信息  **/
        var password=$("#makeSure_input").val();
        var userid='${userid}';
        $.ajax({
            url:"${APP_PATH}/selfPass?userid="+userid+"&password="+password,
            type:"POST",
            success: function (result) {
                if (result =="") {
                    alert("修改密码成功！可以重新登录");
                }
                 else {
                    alert("修改密码失败！");
                 }
            }




        });


    });
    //校验数据
    function validate_save_form() {
        var password=$("#oldPassword").val();
        var password1 = $("#newPassword").val();
        var password2 = $("#makeSure_input").val();
       if(password1=="" ||password2==""){
           alert("密码不可为空！！")
           return false;
       }
      else  if (password1 != password2) {
            alert("密码不一致！！")
            return false;
        }
        else if(password==password1){
            alert("原密码与新密码相同！！")
            return false;
        }
        else return true;
    }

    //判断原密码是否正确
    function validate_oldPassword(){
        var oldPass=$("#oldPassword").val();
        var oldPassInput=$("#oldPassword_Input").val();
        if(oldPass!=oldPassInput){
          alert("原密码输入错误！！！");
            return false;
        }
        else return true;
    }
    //判断输入字符是否过长
  function  istooLong(){
        var oldInput=$("#oldPassword_Input").val();
      var newInput=$("#newPassword").val();
      var newInput2=$("#makeSure_input").val();
      if(oldInput.length>20||newInput.length>20||newInput2.length>20){
          alert("输入密码过长！！！")
      return false;
      }
      else return true;
  }
</script>
</body>
</html>
