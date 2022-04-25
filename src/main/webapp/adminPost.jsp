<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/17
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理员页面</title>
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
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="#"></a></li>
        </ul>
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
                        <dd class="active"><a href="adminPost.jsp">查看主贴</a></dd>
                        <dd><a href="${APP_PATH}/jumpToLogin/toWhere?where=admin">用户管理</a></dd>
                        <dd><a href="viewsectionlist.jsp">板块管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="container-fluid">

                <!--显示所有帖子-->
                <div class="allMains">
                    <div class="row">
                        <div class="col-md-12"><!--存放所有的帖子-->
                            <table class="table table-hover" id="mains_table">
                                <thead>
                                <tr>
                                    <th>
                                        <input type="checkbox" id="check_all">
                                    </th>
                                    <th>序号</th>
                                    <th>标题</th>
                                    <th>发帖人</th>
                                    <th>发帖时间</th>
                                    <th>回复数</th>
                                    <th>最后发表</th>
                                    <th>所在版块</th>
                                    <th>修改帖子</th>
                                </tr>
                                </thead>

                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!--按钮-->
            <div class="row">
                <div class="col-md-4">
                    <button class="btn btn-primary" id="deleteMain">删除</button>
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
            <a id="edits"></a>
            <!--编辑区-->
            <div class="row">
                <!--此区域进行发帖操作-->
                <div class="edit-publish" >
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <p>修改文章！</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-group title">
                                <input type="text" name="title" id="P-title" class="form-control" style="width:1150px;height:50px" placeholder="请填写标题（字数不多于50）"/>
                                <%--                                        <span>注：标题长度不超过50个字</span>--%>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="row">
                            <textarea name="content" id="content" placeholder="请输入想要修改的内容。。。"/>

                            </textarea>
                            <span class="help-block"></span>
                        </div>
                        <!--管理员无法修改是否是需求帖，因为还要判断该用户是否有足够的积分进行发帖操作-->
<%--                        <div class="row">--%>
<%--                            <div class="pointSelect">--%>
<%--                                请选择是否发布积分奖励：否<input type="radio" name="points" value="0" id="nopoint" checked> 是--%>
<%--                                <input type="radio" name="points" id="haspoint">--%>
<%--                                <p style="display:inline" class="notshowpoint"><span>请修改需要奖励的积分数</span>--%>
<%--                                    <input type="text" id="point" oninput="value=value.replace(/[^\d]/g,'')">--%>
<%--                                    <span class="help-block"></span>--%>
<%--                                </p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="row">
                            <div class="sub">
                                <button class="btn btn-primary" id="publish_btn"><span class="glyphicon glyphicon-share-alt"></span>提交修改</button>
                            </div>
                        </div>
                    </div>
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
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
    $(function () {
        CKEDITOR.replace( 'content',{
            height:100,
            width:1150
        });
        $(".edit-publish").hide();//将修改文章的区域默认不可见
       to_page(1);
    });
    //跳转到页面
    function to_page(pn){
        var data={
            "pn":pn
        };
        $.ajax({
            url:"${APP_PATH}/main/findAllPost",
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
            var mainnerNickname=$("<div></div>").append(item.user.uNickname);
            var userNickname=$("<td></td>").append(mainnerHeadPic).append(mainnerNickname);//主帖的发布者

            var date=formatDate(item.mMaindate);
            var hourandminute=formatDateHourAndMinute(item.mMaindate);

            var mainDate=$("<td></td>").append(date+" "+hourandminute);

            var follows=$("<td></td>").append(getJsonLength(item.follows));

            var latestdate=formatDate(item.latestTime);
            var latesthourandminute=formatDateHourAndMinute(item.latestTime);

            var latestuser=$("<div></div>").append(item.latestPublish.uNickname);
            var latesttime=$("<div></div>").append(latestdate+" "+latesthourandminute);
            //最新发表
            var latest=$("<td></td>").append(latestuser).append(latesttime);
            //这里是帖子所在的版块信息
            var sectionname=$("<td></td>").append(item.section.sSectionname);
            //增加编辑按钮

            var editBtn=$("<button></button>").addClass("btn btn-fail btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            var aeditBtn=$("<a href='#edits'></a>").append(editBtn);
            //为编辑按钮添加一个自定义的属性
            editBtn.attr("edit-id",item.mMainid);
            var editTd=$("<td></td>").append(aeditBtn);
            //append方法执行完返回的还是原来的元素
            $("<tr></tr>")
                .append(checkBoxTd)
                .append(mainIdTd)
                .append(mainTitleTd)
                .append(userNickname)
                .append(mainDate)
                .append(follows)
                .append(latest)
                .append(sectionname)
                .append(editTd)
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
    //获取输入框内容
    function getContentData(){
        var content=CKEDITOR.instances.content.getData();//获取texarea的内容
        return content;
    }
    //check_item
    $(document).on("click",".edit_btn",function () {
        //首先判断是否登录
        if("${adminid}".length===0){
            alert("您当前未登录，不能修改帖子！");
            return false;
        }
        //先把编辑区显示出来
        $(".edit-publish").show();
        var mainId=$(this).attr("edit-id");//获取主帖的id
        $("#publish_btn").attr("mainId",mainId);//传递attr属性表示修改的是哪个主帖

        $.ajax({
            url:"${APP_PATH}/main/changeMainByMainId",
            data:"mainId="+mainId,
            success:function (result) {
                if(result.code==100){
                    var title=result.extend.main.mTitle;
                    var content=result.extend.main.mContent;
                    var point=result.extend.main.mPoint;
                    $("#P-title").val(title);
                    //alert(point);
                    if(point>0){
                        $(".notshowpoint").show();
                        $("#point").val(point);//输入框置空
                        $("#haspoint").prop("checked",true);
                    }else{
                        $(".notshowpoint").hide();
                        $("#point").val("");//输入框置空
                        $("#nopoint").prop("checked",true);
                    }
                    CKEDITOR.instances.content.setData(content);
                }else if(result.code==200){
                    alert("显示主帖信息出错！");
                }
            }
        })
    });
    //对于奖励的积分设置
    $("#haspoint").click(function () {
        $(".notshowpoint").show();
    });
    $("#nopoint").click(function () {
        // $("#point").val("");//输入框置空
        // $("#point").next("span").text("");//提示信息
        $(".notshowpoint").hide();
    });
    //奖励积分输入框的变化
    // $("#point").change(function () {
    //     var point=$(this).val();
    //     if(point>100){
    //         show_validate_msg("#point","error","奖励的积分数不得超过100");
    //     }else{
    //         show_validate_msg("#point","success","");
    //     }
    // });
    //奖励积分输入框的变化
    $("#P-title").change(function () {
        var title=$("#P-title").val();
        if(title.length>=50){
            show_validate_msg("#P-title","error","标题字数不超过50字");
        }else if(!title){
            show_validate_msg("#P-title","error","标题不能为空");
        }else{
            show_validate_msg("#P-title","success","");
        }
    });
    function validateInput(){
        var title=$("#P-title").val();
        if(title.length>=50){
            show_validate_msg("#P-title","error","标题字数不超过50字");
            return false;
        }else if(!title){
            show_validate_msg("#P-title","error","标题不能为空");
            return false;
        }
        var content=getContentData();
        if(content.length>3000){
            alert("你的帖子中文内容太长，无法发表，请减少想要发表的内容！");
            return false;
        }else if(!content.length){
            alert("请输入帖子中文内容！");
            return false;
        }
        // var point=$("#point").val();
        // if(!$("#point").val())
        //     point=0;
        // else point=parseInt(point);
        // if(point>100){
        //     show_validate_msg("#point","error","奖励的积分数不得超过100");
        //     return false;
        // }
        return true;
    }
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
    //提交修改文章的操作
    $("#publish_btn").click(function () {
        //首先判断是否登录
        if("${adminid}".length===0){
            alert("您当前未登录，不能修改帖子！");
            return false;
        }
        var mainId=$("#publish_btn").attr("mainId");

        var content=getContentData();
        // var point=$("#point").val();
        // if(!$("#point").val())
        //     point=0;
        // else point=parseInt(point);
        //数据校验
        if(!validateInput()){
            return false;
        }
        var data={
            "mMainid":mainId,
            "mTitle":$("#P-title").val(),
            "mContent":content,
            // "mPoint":point
        };
        //alert(data);
        $.ajax({
            url:"${APP_PATH}/main/submitChangeMain",
            type:"post",
            data:data,//一个json封装的数据
            //dataType: "json",//返回的数据格式为json
            success:function (result) {
                if(result.code==100){
                    alert("编辑保存成功！");
                    $(".edit-publish").hide();//将修改文章的区域默认不可见
                    to_page(currentPage);//跳转到当前页
                }else{
                    //alert("有错");
                    //执行有错误时候的判断
                    if(undefined!=result.extend.errorFields.title){
                        show_validate_msg("#P-title","error",result.extend.errorFields.title);
                    }
                    if(undefined!=result.extend.errorFields.content){
                        alert(result.extend.errorFields.content);
                    }
                    if(undefined!=result.extend.errorFields.adminnotlogin){
                        alert(result.extend.errorFields.adminnotlogin);
                    }
                }
            }
        });
    });
    //点击删除可以实现删除操作
    $("#deleteMain").click(function () {
        //首先判断是否登录
        if("${adminid}".length===0){
            alert("您当前未登录，不能删除帖子！");
            return;
        }
        var mainID="";
        var perfects="";
        var num=0;
        $.each($(".check_item:checked"),function () {
            //当前遍历的元素
            mainID+=$(this).parents("tr").find("td:eq(1)").text()+" ,";
            //组装主贴id的字符串
            perfects+=$(this).parents("tr").find("td:eq(1)").text()+"-";
            num++;
        });
        if(!num){
            alert("请选择需要删除的帖子");
            return;
        }
        //去除empNames多余的逗号
        mainID=mainID.substring(0,mainID.length-1);
        //去除多余的分隔符
        perfects=perfects.substring(0,perfects.length-1);
        if(confirm("确认将【"+mainID+"】删除吗？")){
            $.ajax({
                url:"${APP_PATH}/main/deleteMains",
                data:"perfects="+perfects,
                success:function (result) {
                    if(result.code==100){
                        to_page(currentPage);
                    }else{
                        if(undefined!=result.extend.errorFields.adminnotlogin){
                            alert(result.extend.errorFields.adminnotlogin);
                        }
                        alert("删除失败！");
                    }
                }
            });
        }
    });
</script>
</body>
</html>
