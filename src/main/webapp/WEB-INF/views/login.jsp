<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/10
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>login</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

    <!--
        web路径：
        1.不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
        2.以/开始的相对路径，找资源，以服务器的路径为标准，需要加上项目名称
    -->
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/dist/js/bootstrapValidator.js"></script>


    <style>
        body{
            background: url("${APP_PATH}/statics/images/login/login1.jpg");
            animation-name:myfirst;
            animation-duration:12s;
            /*变换时间*/
            animation-delay:8s;
            /*动画开始时间*/
            animation-iteration-count:infinite;
            /*下一周期循环播放*/
            animation-play-state:running;
            /*动画开始运行*/
        }
        @keyframes myfirst
        {
            0%   {background:url("${APP_PATH}/statics/images/login/login1.jpg");}
            34%  {background:url("${APP_PATH}/statics/images/login/login2.jpg");}
            67%  {background:url("${APP_PATH}/statics/images/login/login3.jpg");}
            100% {background:url("${APP_PATH}/statics/images/login/login4.jpg");}
        }
        .form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}
        /*阴影*/
    </style>
    <script>
        function isLogin_Error() {
            var mess="${message}";
            <%--$(function(){--%>
            <%--    var args={"time":new Date()};--%>
            <%--    $.getJSON("${APP_PATH}/user/userLogin",args,function (data){--%>
            <%--        mess=data.message--%>
            <%--    })--%>
            <%--});--%>
            if (mess!=""){
                $(function () { $('#myModal').on('show.bs.modal', function () {
                    var modal = $(this);
                    //此处即为修改modal的内容
                    modal.find('.modal-body').text(mess)
                }) });
                $("#myModal").modal();
            }
          }

        $("#myModal").on("hidden.bs.modal", function() {
            $(this).removeData("bs.modal");
        });
    </script>
</head>
<body onload="isLogin_Error()">
<form id="login-form" class="form" action="${APP_PATH}/user/userLogin" method="post">
    <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control" name="username" id="username"/>
    </div>
    <div class="form-group">
        <label>密码</label>
        <input type="password" class="form-control" name="password" id="password"/>
    </div>
    <div class="form-group">
        <label>验证码</label>
        <input type="text" class="form-control" name="code"  id="code"/>
    </div>
    <div class="form-group">
        <div class="col-lg-5">
            <img id="imgObj" alt="验证码" src="${APP_PATH}/code/getCode">
            <a onclick="changeImg()">换一张</a>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-4 col-md-offset-8">
            <a href="${APP_PATH}/adminlogin.jsp" ><label style="font-size: 12px;text-decoration: none">管理员入口/</label></a>
            <a href="${APP_PATH}/register.jsp"><label style="font-size: 12px;text-decoration: none">注册</label></a>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-6 col-md-offset-3 " >
            <button type="submit" name="login" class="btn btn-success  btn-block"
            onclick="login()">登录</button>
        </div>
    </div>
</form>

<%--登录错误提示的模态框--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    登录失败
                </h4>
            </div>
            <div class="modal-body" >
                <h3 id="login_fault_message"></h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<%--<div class="container">--%>
<%--    <div class="form row">--%>
<%--        <form class="form-horizontal col-md-offset-3" id="login_form" role="form">--%>
<%--            <h3 class="form-title">LOGIN</h3>--%>
<%--            <div class="col-md-9">--%>
<%--                <div class="form-group">--%>
<%--&lt;%&ndash;                    <i class="fa fa-user fa-lg"></i>&ndash;%&gt;--%>
<%--                    <input class="form-control required" type="text" placeholder="用户名" id="username" name="username" autofocus="autofocus" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--&lt;%&ndash;                    <span class="fa fa-unlock-alt fa-2x form-control-feedback"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <i class="fa fa-lock fa-lg"></i>&ndash;%&gt;--%>
<%--                    <input class="form-control required" type="password" placeholder="密码" id="password" name="password" />--%>
<%--                </div>--%>
<%--                <div class="form-group col-md-offset-9 ">--%>
<%--                    <button type="button" class="btn btn-success pull-left" name="submit">注册</button>--%>
<%--                    <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>


</body>
</html>


<script>
    $(document).ready(function() {
        $('#login-form').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: '登录帐号不可用',
                    validators: {
                        notEmpty: {
                            message: '登录账号不能为空'
                        },
                        remote: {
                            type:"POST",
                            message: '用户名不存在',
                            url: '${APP_PATH}/user/checkUserName',
                            data :
                                {
                                    username:'username'
                                },//这里默认会传递该验证字段的值到后端,
                            delay: 2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                code: {
                    validators: {
                        notEmpty: {
                            message: '验证码不能为空'
                        },
                        remote: {
                            type:"POST",
                            message: '验证码错误',
                            url: '${APP_PATH}/code/checkCode',
                            data :
                                {
                                    code:'code'
                                },//这里默认会传递该验证字段的值到后端,
                            delay: 2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        }
                    }

                }
            }
        });
    });
    function changeImg() {
        $("#code").val("");
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }

    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 24);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
    <%--function login() {--%>
    <%--    var name=$("#username").attr("value");--%>
    <%--    var pwd=$("#password").attr("value");--%>
    <%--    var code=$("#code").attr("value");--%>
    <%--    var datas = new Object();--%>
    <%--    $.ajax({--%>
    <%--            url:"${APP_PATH}/user/userLogin?username"+name+"&password"+pwd--%>
    <%--        +"&code"+code,--%>
    <%--            type:"post",--%>
    <%--            contentType:"application/string",--%>
    <%--            dataType:"json",--%>
    <%--            async:false,--%>
    <%--            success:function (result) {--%>
    <%--                datas = eval("("+result+")");--%>
    <%--            }--%>
    <%--        });--%>
    <%--}--%>
</script>



