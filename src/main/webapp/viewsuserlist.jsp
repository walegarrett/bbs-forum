<%--<jsp:useBean id="user" scope="request" type=""/>--%>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/18
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="pageInfo" scope="page" type="com.github.pagehelper.Page"/>--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<jsp:forward page="/user"/>--%>
<html>
<head>
    <title>用户管理</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/statics/css/layui.css">
    <script src="${APP_PATH}/statics/js/layui.js"></script>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/statics/ckeditor/ckeditor.js"></script>
    <script src="${APP_PATH}/statics/js/common.js"></script>
</head>
<body>
<div class="modal fade" id="userUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改用户</h4>
            </div>
            <div class="modal-body">
                <!--编辑表单-->
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="uUserid_update_static" class="col-sm-2 control-label">用户账号</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="uUserid_update_static"></p>
<%--                            <input type="text" class="form-control" name="uUserid" id="uUserid_update_input" placeholder="请输入你要修改后的用户账号">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uPassword_update_input" class="col-sm-2 control-label">用户密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="uPassword" id="uPassword_update_input" placeholder="请输入你要修改后的用户密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uNickname_update_input" class="col-sm-2 control-label">用户昵称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="uNickname" id="uNickname_update_input" placeholder="请输入你要修改后的用户昵称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uSex_update_static" class="col-sm-2 control-label">用户性别</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="uSex_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uName_update_input" class="col-sm-2 control-label">真实姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="uName" id="uName_update_input" placeholder="请输入你要修改后的真实姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uEmail_update_input" class="col-sm-2 control-label">E-mail</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="uEmail" id="uEmail_update_input" placeholder="请输入你要修改后的E-mail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uWorkplace_update_input" class="col-sm-2 control-label">地区</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="uWorkplace" id="uWorkplace_update_input">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary btn-sm" id="user_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
     <!--搭建显示页面-->
     <div class="container">
         <!--标题-->
         <div class="row" class="col-md-12">
             <h1>用户管理</h1>
         </div>
         <!--按钮-->
         <div class="row">
         </div>
         <!--显示表格数据-->
         <div class="row">
             <div class="col-md-12">
                 <table class="table table-hover" id="users_table">
                     <thead>
                     <tr>
                         <th>序号</th>
                         <th>账号</th>
                         <th>密码</th>
                         <th>昵称</th>
                         <th>性别</th>
                         <th>姓名</th>
                         <th>E-mail</th>
                         <th>地区</th>
                         <th>操作</th>
                     </tr>
                     </thead>
                     <tbody>

                     </tbody>
                 </table>
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
     <script type="text/javascript">
         var totalRecord;//总记录数
         var currentPage;//当前页
         //1.页面加载请完成后，直接发送一个ajax求，拿到分页信息
         $(function(){
             to_page(1);//首次加载页面时显示第一页
         });
         //跳转到页面
         function to_page(pn){
             $.ajax({
                 url:"${APP_PATH}/User",
                 data:"pn="+pn,
                 type:"get",
                 success:function (result) {
                     //console.log(result);
                     //1.解析并且显示员工数据
                     build_users_table(result);
                     //2.解析并且显示分页信息
                     build_page_info(result);
                     //3.分页条的显示
                     build_page_nav(result);
                 }
             });
         }
         //table结构
         function build_users_table(result) {
             //清空table表
             $("table tbody").empty();
             var users=result.extend.pageInfo.list;
             $.each(users,function (index,item) {
                 var uIdTd = $("<td></td>").append(item.uId);
                 var uUseridTd = $("<td></td>").append(item.uUserid);
                 var uPasswordTd = $("<td></td>").append(item.uPassword);
                 var uNicknameTd = $("<td></td>").append(item.uNickname);
                 var uSexTd = $("<td></td>").append(item.uSex);
                 var uNameTd = $("<td></td>").append(item.uName);
                 var uEmailTd = $("<td></td>").append(item.uEmail);
                 var uWorkplaceTd = $("<td></td>").append(item.uWorkplace);
                 var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                     .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                 var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                     .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                 //为编辑按钮添加一个自定义的属性
                 editBtn.attr("edit-id",item.uId);
                 //为删除按钮添加一个自定义的属性来表示当前删除的员工id
                 delBtn.attr("delete-id",item.uId);
                 var btnTd = $("<td></td>").append(delBtn).append(" ").append(editBtn);
                 $("<tr></tr>")
                     .append(uIdTd)
                     .append(uUseridTd)
                     .append(uPasswordTd)
                     .append(uNicknameTd)
                     .append(uSexTd)
                     .append(uNameTd)
                     .append(uEmailTd)
                     .append(uWorkplaceTd)
                     .append(btnTd)
                     .appendTo("#users_table tbody");
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

         //点击删除按钮事件
         $(document).on("click",".delete_btn",function () {
             //弹出是否确认删除的对话框
             // alert($(this).parents("tr").find("td:eq(0)").text());
             var uUserid=$(this).parents("tr").find("td:eq(0)").text();
             var uId=$(this).attr("delete-id");
             var data=
                 {
                 "uId":uId,
                 };
             if(confirm("确认删除"+uUserid+"吗？")){
                 //确认，发送ajax请求删除
                 $.ajax({
                     url:"${APP_PATH}/Users",
                     type:"POST",
                     data:data,
                     success:function (result) {
                         if(result.code==100) {
                             alert("删除成功");
                             to_page(currentPage);
                         }else{
                             alert("删除失败");
                             to_page(currentPage);
                         }
                     }
                 });
             }
         });

         //点击编辑用户
         $(document).on("click",".edit_btn",function () {
             //alert("");
             //-------------注意以下的逻辑关系，先后次序不能改变
             getUser($(this).attr("edit-id"));
             $("#userUpdateModal").modal({
                 backdrop:"static"
             });
             //2.把用户的id传递给模态框的更新按钮
             $("#user_update_btn").attr("edit-id",$(this).attr("edit-id"));

             // $("#sBanzhuid_update_input").val("");
             // $("#sBanzhuid_update_input").val($(this).attr("banzhuuserid"));
             // $("#sBanzhuid_update_input").attr("banzhuid",$(this).attr("banzhuid"));
         });
         // uUserid_update_input
         // uPassword_update_input
         // uNickname_update_input
         // uSex_update_static
         // uName_update_input
         // uEmail_update_input
         // uWorkplace_update_input
         /**
          * 获取板块信息
          */
         function getUser(uId) {
             $.ajax({
                 url:"${APP_PATH}/User/"+uId,
                 type:"GET",
                 success:function (result) {
                     var userData=result.extend.User;
                     $("#uUserid_update_static").text(userData.uUserid);
                     $("#uPassword_update_input").val(userData.uPassword);
                     $("#uNickname_update_input").val(userData.uNickname);
                     $("#uSex_update_static").text(userData.uSex);
                     $("#uName_update_input").val(userData.uName);
                     $("#uEmail_update_input").val(userData.uEmail);
                     $("#uWorkplace_update_input").val(userData.uWorkplace);
                 }
             });
         }

         /**
          * 点击更新，更新用户信息
          */
         $("#user_update_btn").click(function () {
             // var uUserid=$("#uUserid_update_input").val();
             var uPassword=$("#uPassword_update_input").val();
             var uNickname=$("#uNickname_update_input").val();
             var uName=$("#uName_update_input").val();
             var uEmail=$("#uEmail_update_input").val();
             var uWorkplace=$("#uWorkplace_update_input").val();
             alert($(this).attr("edit-id"));
             // alert(uUserid);
             var data={
                 "uId":$(this).attr("edit-id"),
                 "uPassword":uPassword,
                 "uNickname":uNickname,
                 "uName":uName,
                 "uEmail":uEmail,
                 "uWorkplace":uWorkplace,
             };
             //发送ajax请求，保存更新的用户信息
             $.ajax({
                 url:"${APP_PATH}/updateUser",
                 type:"POST",
                 data:data,
                 success:function (result) {
                     if(result.code==100){
                         alert("编辑成功");
                         //1.关闭对话框
                         $("#userUpdateModal").modal("hide");
                         //2.回到本页面
                         to_page(currentPage);
                     }else{
                         alert("编辑失败");
                         to_page(currentPage);
                     }
                 }
             });
         });
         layui.use('element', function(){
             var element = layui.element;
         });
     </script>
</body>
</html>
