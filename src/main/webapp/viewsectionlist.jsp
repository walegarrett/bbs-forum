
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/18
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>板块管理</title>
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
<body class="layui-layout-body">
<!-- 编辑板块模态框 -->
<div class="modal fade" id="sectionUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改板块</h4>
            </div>
            <div class="modal-body">
                <!--编辑表单-->
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="sBanzhuid_update_input" class="col-sm-2 control-label">版主id</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sBanzhuid" id="sBanzhuid_update_input" placeholder="请输入你要修改后的版主id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sSectionname_update_input" class="col-sm-2 control-label">版块名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sBanzhuid" id="sSectionname_update_input" placeholder="请输入你要修改后的板块名称">
<%--                            <p class="form-control-static" id="sSectionname_update_static"></p>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sDescription_update_input" class="col-sm-2 control-label">板块描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sBanzhuid" id="sDescription_update_input" placeholder="请输入你要修改后的板块描述">
<%--                            <p class="form-control-static" id="sDescription_update_static"></p>--%>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary btn-sm" id="section_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<!-- 新增板块模态框 -->
<div class="modal fade" id="sectionAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myAddModalLabel">新增板块</h4>
            </div>
            <div class="modal-body">
                <!--新增表单-->
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="sId_add_input" class="col-sm-2 control-label">设置版主(填用户管理中用户的序号)</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sId_add_input" placeholder="请输入你要设置的版主序号">
                            <%--                <p class="form-control-static" id="sSectionname_update_static"></p>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sSectionname_add_input" class="col-sm-2 control-label">版块名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sSectionname_add_input" placeholder="请输入你要增加的板块名称">
                            <%--               <p class="form-control-static" id="sSectionname_update_static"></p>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sDescription_add_input" class="col-sm-2 control-label">板块描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sDescription_add_input" placeholder="请输入你要增加的板块描述">
                            <%--                            <p class="form-control-static" id="sDescription_update_static"></p>--%>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary btn-sm" id="section_add_btn">新增</button>
            </div>
        </div>
    </div>
</div>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/bbs/statics/images/upload/f1c3d132ffad4c17a32b985cbf8ef24c_PictureUnlock_54077.pictureunlock.jpg" class="layui-nav-img">
                    ${adminname}
                </a>
            </li>
            <li class="layui-nav-item"><a href="${APP_PATH}/index1.jsp">网站首页</a></li>
            <li class="layui-nav-item"><a href="${APP_PATH}/adminExit">退出</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="">操作中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="adminPost.jsp">查看主贴</a></dd>
                        <dd><a href="${APP_PATH}/jumpadmin">用户管理</a></dd>
                        <dd class="active"><a href="viewsectionlist.jsp">板块管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="body">
        <!-- 内容主体区域 -->

        <!--搭建显示页面-->
        <div class="container">
            <!--标题-->
            <div class="row" class="col-md-12">
                <h1>板块管理</h1>
            </div>
            <!--按钮-->
            <div class="row">
                <div class="col-md-12 col-md-offset-10">
                <button type="button" id="add_Section_btn" class="btn btn-success btn-sm glyphicon glyphicon-pencil ">新增</button>
                </div>
            </div>
            <!--显示表格数据-->
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover" id="sections_table">
                        <thead>
                        <tr>
                            <th>板块名称</th>
                            <th>板块描述</th>
                            <th>版主id</th>
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
    </div>
    <div class="layui-footer">
    </div>
</div>

<script>
    var totalRecord;//总记录数
    var currentPage;//当前页
    //1.页面加载请完成后，直接发送一个ajax求，拿到分页信息
    $(function(){
        to_page(1);//首次加载页面时显示第一页
    });
    //跳转到页面
    function to_page(pn){
        $.ajax({
            url:"${APP_PATH}/Section",
            data:"pn="+pn,
            type:"get",
            success:function (result) {
                //console.log(result);
                //1.解析并且显示员工数据
                build_sections_table(result);
                //2.解析并且显示分页信息
                build_page_info(result);
                //3.分页条的显示
                build_page_nav(result);
            }
        });
    }
    //table结构
    function build_sections_table(result) {
        //清空table表
        $("table tbody").empty();
        var sections=result.extend.pageInfo.list;
        var userlist=result.extend.Userlist;
        num=0;
        $.each(sections,function (index,item) {
            var one=userlist[index];
            // var sIdTd = $("<td></td>").append(item.sId);
            var sSectionnameTd = $("<td></td>").append(item.sSectionname);
            var sDescriptionTd = $("<td></td>").append(item.sDescription);
            var sBanzhuidTd = $("<td></td>").append(one["uUserid"]);
            var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            editBtn.attr("banzhuuserid",one["uUserid"]);
            editBtn.attr("banzhuid",item.sBanzhuid);
            //为编辑按钮添加一个自定义的属性
            editBtn.attr("edit-id",item.sId);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");

            //为删除按钮添加一个自定义的属性来表示当前删除的员工id
            delBtn.attr("delete-id",item.sId);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>")
                .append(sSectionnameTd)
                .append(sDescriptionTd )
                .append(sBanzhuidTd )
                .append(btnTd)
                .appendTo("#sections_table tbody");
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

    //删除操作
    $(document).on("click",".delete_btn",function () {
        //弹出是否确认删除的对话框
        var sSectionname =$(this).parents("tr").find("td:eq(0)").text();
        var sId=$(this).attr("delete-id");
        var data={
            "sId":sId,
        };
        if(confirm("确认删除"+sSectionname+"板块吗？")){
            //确认，发送ajax请求删除
            $.ajax({
                url:"${APP_PATH}/Sections",
                type:"POST",
                data:data,
                success:function (result) {
                    if(result.code==100){
                        alert("删除成功");
                        to_page(currentPage);
                    }else{
                        alert("删除失败");
                        to_page(currentPage);
                    }
                }
            })
        }
    });
    //点击编辑板块
    $(document).on("click",".edit_btn",function () {
        //alert("");
        //-------------注意以下的逻辑关系，先后次序不能改变
        getSection($(this).attr("edit-id"));
        $("#sectionUpdateModal").modal({
            backdrop:"static"
        });
        //2.把版主的id传递给模态框的更新按钮
        $("#section_update_btn").attr("edit-id",$(this).attr("edit-id"));

        //banzhuuserid
        //alert($(this).attr("banzhuuserid"));
        $("#sBanzhuid_update_input").val("");
        $("#sBanzhuid_update_input").val($(this).attr("banzhuuserid"));
        $("#sBanzhuid_update_input").attr("banzhuid",$(this).attr("banzhuid"));
    });


    //获取板块信息
    function getSection(sId) {
        $.ajax({
            url:"${APP_PATH}/Section/"+sId,
            type:"GET",
            success:function (result) {
                var sectionData=result.extend.Section;
                $("#sSectionname_update_input").val(sectionData.sSectionname);
                $("#sDescription_update_input").val(sectionData.sDescription);
                //$("#sBanzhuid_update_input").val(sectionData.sBanzhuid);
            }
        });
    }
    function checkUserid(username){
        //userid=parseInt(userid);
        var data;
        $.ajax({
            url:"${APP_PATH}/user/checkUserId",
            data:{username:username},
            type:"POST",
            async:false,
            success:function (result) {
                if (result.code == 100) {
                    data = true;
                } else if (result.code == 200) {
                    data = false;
                }
                // alert(result.code);
            }
        });
        // alert(data);
        return data;
    }
    //点击更新，更新板块信息
    $("#section_update_btn").click(function () {
        var sBanzhuid=$("#sBanzhuid_update_input").val();
        var sSectionname=$("#sSectionname_update_input").val();
        var sDescription=$("#sDescription_update_input").val();
        if(!checkUserid(sBanzhuid)){
            alert("所要设定的版主不存在，请重新输入正确的版主id");
            return false;
        }
        var data={
            "originid":$("#sBanzhuid_update_input").attr("banzhuid"),
            "banzhuUserid":sBanzhuid,
            "Sectionid":$(this).attr("edit-id"),
            "sSectionname":sSectionname,
            "sDescription":sDescription
        };
        //发送ajax请求，保存更新的用户信息
        $.ajax({
            url:"${APP_PATH}/findBanzhuId",
            type:"POST",
            data:data,
            success:function (result) {
                if(result.code==100){
                    alert("编辑成功");
                    //1.关闭对话框
                    $("#sectionUpdateModal").modal("hide");
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

    /**
     * 新增板块
     */
    // sSectionname_add_input
    // sDescription_add_input
    $("#add_Section_btn").click(function () {
        $("#sectionAddModal").modal({
            backdrop: "static"
        });
    });

    $("#section_add_btn").click(function (){
        var addSId = $("#sId_add_input").val();
        var addSectionName = $("#sSectionname_add_input").val();
        var addSectionDes = $("#sDescription_add_input").val();
        if(addSectionName.length==0){
            alert("请输入板块名称");
            return false;
        }
        if(addSectionName.length>20){
            alert("板块名称不能长于20");
            return false;
        }
        if(addSectionDes.length==0){
            alert("请输入板块描述");
            return false;
        }
        if(addSectionDes.length>200){
            alert("板块描述不能长于200");
            return false;
        }
        if(Check(addSId)){
            var data={
                "sBanzhuid":addSId,
                "sSectionname":addSectionName,
                "sDescription":addSectionDes
            };
            $.ajax({
                url:"${APP_PATH}/addSection",
                type:"POST",
                data:data,
                success:function (result) {
                    if(result.code==100){
                        alert("新增成功");
                        //1.关闭对话框
                        $("#sectionAddModal").modal("hide");
                        //2.回到本页面
                        to_page(currentPage);
                    }else{
                        alert("新增失败");
                    }
                }
            });
        }else{
            alert("无此序号!!!");
        }
    });

    function Check(SId) {
        var check = true ;
        var data={
          "uId":SId,
        };
        $.ajax({
               url:"${APP_PATH}/checkuId",
               type:"POST",
               async:false,
               data:data,
               success:function(result){
                   if(result.code==100)
                   {
                   }else{
                       check=false;
                   }
               }
        });
        if(check)
        {
            return true;
        }
        else
            {
            return false;
        }
    }
</script>
</body>
</html>
