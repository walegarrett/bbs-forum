<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<!--
    这里是具体的哪一个版面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有版块显示</title>
    <meta charset="UTF-8">
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
    <script src="${APP_PATH}/statics/ckeditor/ckeditor.js"></script>
    <script src="${APP_PATH}/statics/js/common.js"></script>
</head>
<body>
    <div class="containers">
            <!--上方的导航栏-->
            <%@include file="nav-top.jsp"%>
            <!--右部的主页内容栏-->
            <div class="right-main">
                <div class="container">
                    <!--导航区-->
                    <jsp:include page="nav-kind.jsp"></jsp:include>
                    <div class="row" style="background-color:white">
                        <div class="col-md-1 col-md-offset-11">
                            <button class="btn btn-danger>"><a href="#edit">发帖</a></button>
                        </div>
                    </div>
                    <!--内容区-->
                    <div class="row">
                        <div class="col-md-12">
                            <!--展示帖子或者精华帖-->
                            <div class="allMains">
                                <div class="row">
                                    <div class="col-md-12"><!--存放所有的帖子-->
                                        <table class="table table-hover" id="mains_table">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>标题</th>
                                                <th>发帖人</th>
                                                <th>发帖时间</th>
                                                <th>回复数</th>
                                                <th>最后发表</th>
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

                    <!--显示分页信息-->
                    <div class="row">
                        <!--分页文字信息-->
                        <div class="col-md-6" id="page_info_area">

                        </div>
                        <!--分页条-->
                        <div class="col-md-6" id="page_nav_area">

                        </div>
                    </div>
                    <a id="edit"></a>
                    <!--编辑区-->
                    <div class="row">
                        <!--此区域进行发帖操作-->
                        <a name="edit-publish"></a>
                        <div class="edit-publish" >
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <p>请写下想要分享的内容吧！</p>
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
                                    <textarea name="content" id="content" placeholder="请输入想要分享的内容。。。"/>

                                    </textarea>
                                    <span class="help-block"></span>
                                </div>
                                <div class="row">
                                    <div class="pointSelect">
                                        请选择是否发布积分奖励：否<input type="radio" name="points" value="0" id="nopoint" checked> 是<input type="radio" name="points" id="haspoint">
                                        <p style="display:inline" class="notshowpoint"><span>请输入需要奖励的积分数</span>
                                            <input type="text" id="point" oninput="value=value.replace(/[^\d]/g,'')">
                                            <span class="help-block"></span>
                                        </p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="sub">
                                        <button class="btn btn-primary" id="publish_btn"><span class="glyphicon glyphicon-share-alt"></span>发帖</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>

    <%--错误提示的模态框--%>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
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


<script>
    function showerrormess(mess) {
        $(function () { $('#myModal').on('show.bs.modal', function () {
            var modal = $(this);
            //此处即为修改modal的内容
            modal.find('.modal-body').text(mess)
        }) });
        $("#myModal").modal();
    }

    var totalRecord;//总记录数
    var currentPage;//当前页
    //1.页面加载完成后，直接发送一个ajax请求，拿到分页信息
    $(function(){
        CKEDITOR.replace( 'content',{
            height:100,
            width:1150
        });
        $("#mains").addClass("active");
        $(".notshowpoint").hide();
        to_page(1);//首次加载页面时显示第一页
    });
    //跳转到页面
    function to_page(pn){
        var data={
            "pn":pn,
            "sectionId":${section.sId}
        };
        $.ajax({
            url:"${APP_PATH}/main/findMainsInSection",
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

    //获取输入框内容
    function getContentData(){
        var content=CKEDITOR.instances.content.getData();//获取texarea的内容
        return content;
    }
    //table结构
    function build_mains_table(result) {
        //清空table表
        $("table tbody").empty();
        var emps=result.extend.pageInfo.list;
        var topmains=result.extend.toplist;//置顶的几个帖子

        //这里是置顶帖
        $.each(topmains,function (index,item) {

            var mainIdTd=$("<td></td>").append("<span class=\"label label-danger\">置顶</span>").addClass("topmain")//增加一个class，标识为置顶帖;
            var cancelTopUl=$("<li></li>").append("<a href='#'>取消置顶</a>").addClass("notshow");

            var mainTitleTd=$("<td></td>").append(item.mTitle);
            //指向特定帖子的链接
            var link=$("<a href='${APP_PATH}/jumpToLogin/follow?mainId="+item.mMainid+"' target='_blank' class='link'></a>");
            mainTitleTd.append(link);

            var mainnerHeadPic=$("<div></div>").append("<img src='"+item.user.uHeadpic+"'alt='头像' class=\"img-circle\" width=45px height=45px>");
            var mainnerNickname=$("<div></div>").append(item.user.uUserid);
            var userNickname=$("<td></td>").append(mainnerHeadPic).append(mainnerNickname);//主帖的发布者
            link=$("<a href='${APP_PATH}/userInfo.jsp?uid="+item.user.uId+"' target='_blank' class='link'></a>");
            userNickname.append(link);

            var date=formatDate(item.mMaindate);
            var hourandminute=formatDateHourAndMinute(item.mMaindate);
            var mainDate=$("<td></td>").append(date+" "+hourandminute);
            var follows=$("<td></td>").append(getJsonLength(item.follows));

            var latestdate=formatDate(item.latestTime);
            var latesthourandminute=formatDateHourAndMinute(item.latestTime);

            var latestuser=$("<div></div>").append(item.latestPublish.uUserid);
            var latesttime=$("<div></div>").append(latestdate+" "+latesthourandminute);
            //最新发表
            var latest=$("<td></td>").append(latestuser).append(latesttime);


            $("<tr></tr>")
                .append(mainIdTd)
                .append(mainTitleTd)
                .append(userNickname)
                .append(mainDate)
                .append(follows)
                .append(latest)
                .attr("mainId",item.mMainid)//增加一个帖子编号属性
                .appendTo("#mains_table tbody");
            //新增一个下拉菜单
            $("<ul></ul>")
                .append(cancelTopUl).attr("mainId",item.mMainid).appendTo(mainIdTd);
        });
        //这里是除了置顶帖之外的帖子
        $.each(emps,function (index,item) {
            var mainIdTd=$("<td></td>").append(item.mMainid).addClass("normalmain");//增加一个class，标识为非置顶帖;
            var mainTitleTd=$("<td></td>").append(item.mTitle);
            var link=$("<a href='${APP_PATH}/jumpToLogin/follow?mainId="+item.mMainid+"' target='_blank' class='link'></a>");
            mainTitleTd.append(link);

            var mainnerHeadPic=$("<div></div>").append("<img src='"+item.user.uHeadpic+"'alt='头像' class=\"img-circle\" width=50px height=50px>");
            var mainnerNickname=$("<div></div>").append(item.user.uUserid);
            var userNickname=$("<td></td>").append(mainnerHeadPic).append(mainnerNickname);//主帖的发布者
            link=$("<a href='${APP_PATH}/userInfo.jsp?uid="+item.user.uId+"' target='_blank' class='link'></a>");
            userNickname.append(link);

            var date=formatDate(item.mMaindate);
            var hourandminute=formatDateHourAndMinute(item.mMaindate);
            var mainDate=$("<td></td>").append(date+" "+hourandminute);

            var follows=$("<td></td>").append(getJsonLength(item.follows));

            var latestdate=formatDate(item.latestTime);
            var latesthourandminute=formatDateHourAndMinute(item.latestTime);
            //最新发表的相关信息
            var latestuser=$("<div></div>").append(item.latestPublish.uUserid);
            var latesttime=$("<div></div>").append(latestdate+" "+latesthourandminute);
            //最新发表
            var latest=$("<td></td>").append(latestuser).append(latesttime);


            //append方法执行完返回的还是原来的元素
            $("<tr></tr>")
                .append(mainIdTd)
                .append(mainTitleTd)
                .append(userNickname)
                .append(mainDate)
                .append(follows)
                .append(latest)
                .attr("mainId",item.mMainid)//增加一个帖子编号属性
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
        var point=$("#point").val();
        if(!$("#point").val())
            point=0;
        else point=parseInt(point);

        if(point>100){
            show_validate_msg("#point","error","奖励的积分数不得超过100");
            return false;
        }else if(point<0){
            show_validate_msg("#point","error","奖励的积分数必须大于0");
            return false;
        }
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
    /*
        提交主贴的内容
     */
    $("#publish_btn").click(function () {

        //首先判断是否登录
        if("${userid}".length==0){
            showerrormess("您当前未登录，不能发布帖子！");
            return false;
        }
        var content=getContentData();
        var point=$("#point").val();
        if(!$("#point").val())
            point=0;
        else point=parseInt(point);
        // alert(point);
        //数据校验
        if(!validateInput()){
            return false;
        }
        var data={
            "mMainerid":"${userid}",//${sessionScope.userId}设置一个默认的发帖人
            "mSectionid":${section.sId},
            "mTitle":$("#P-title").val(),
            // "mContent":$("#content").html(),
            "mContent":content,
            "mPoint":point
        };
        //alert(data);
        $.ajax({
            url:"${APP_PATH}/main/publish",
            type:"post",
            data:data,//一个json封装的数据
            //dataType: "json",//返回的数据格式为json
            success:function (result) {
                if(result.code==100){
                    //$(".showContent").html(result.extend.content);
                    // $("#content").empty();
                    showerrormess("发帖成功！");
                    CKEDITOR.instances.content.setData("");
                    $("#P-title").val("");
                    $("#point").val("");//输入框置空
                    $(".notshowpoint").hide();
                    to_page(1);//跳转到第一页数据处
                }else{
                    //执行有错误时候的判断
                    if(undefined!=result.extend.errorFields.point){
                        show_validate_msg("#point","error",result.extend.errorFields.point);
                    }
                    if(undefined!=result.extend.errorFields.title){
                        show_validate_msg("#P-title","error",result.extend.errorFields.title);
                    }
                    if(undefined!=result.extend.errorFields.content){
                        alert(result.extend.errorFields.content);
                    }
                    if(undefined!=result.extend.errorFields.usernotlogin){
                        alert(result.extend.errorFields.usernotlogin);
                    }
                }
            }
        });
    });

    //1.点击编辑钮创建之前就绑定了事件，编辑信息资料
    //2.可以在创建按钮的时候绑定事件
    //3.绑定点击.live()
    //jquery新版本没有live(),使用on替代
    $(document).on("mouseover ",".topmain",function () {//mouseover
        if(${userid==section.sBanzhuid}){
            $(this).find('li').show();
        }
    });
    $(document).on("mouseout ",".topmain",function () {//mouseover
        if(${userid==section.sBanzhuid}){
            $(this).find('li').hide();
        }

    });

    //点击取消置顶
    $(document).on("click ",".notshow",function () {//mouseover
        if("${userid}".length===0){
            alert("您当前未登录，不能进行从精华帖移除帖子的操作！");
            return;
        }
        if("${userid}"!="${section.sBanzhuid}"){
            alert("你不是该版的版主，不能进行移除操作！！！");
            return;
        }
        var mainId=$(this).parent('ul').attr("mainId");
        if(confirm("确认取消"+mainId+"的置顶吗？")){
            $.ajax({
                url:"${APP_PATH}/main/cancelTop",
                data:"mainId="+mainId,
                success:function (result) {
                    $(this).find('li').hide();
                    if(result.code==100){
                        alert("取消置顶成功！");
                        to_page(currentPage);
                    }else if(result.code==200){
                        //执行有错误时候的判断
                        if(undefined!=result.extend.errorFields.usernotlogin){
                            alert(result.extend.errorFields.usernotlogin);
                        }
                        if(undefined!=result.extend.errorFields.notbanzhu){
                            alert(result.extend.errorFields.notbanzhu);
                        }
                    }
                }
            });
        }
    });
    //对于奖励的积分设置
    $("#haspoint").click(function () {
        $(".notshowpoint").show();
    });
    $("#nopoint").click(function () {
        $("#point").val("");//输入框置空
        $("#point").next("span").text("");//提示信息
        $(".notshowpoint").hide();
    });
    //奖励积分输入框的变化
    $("#point").change(function () {
       var point=$(this).val();
       if(point>100){
           show_validate_msg("#point","error","奖励的积分数不得超过100");
       }else if(point<=0){
           show_validate_msg("#point","error","奖励的积分数必须大于0");
       }else{
           var data={
               "point":point
           };
           //判断发帖人是否有足够的积分进行发帖
           $.ajax({
               url:"${APP_PATH}/main/hasEnoughPoint",
               data:data,
               success:function (result) {
                    if(result.code==100){
                        show_validate_msg("#point","success","");
                    }else if(result.code==200){
                        show_validate_msg("#point","error","您账户中的个人积分不足，无法发布积分奖励，请减少积分奖励数量或者发布普通帖子！");
                    }
               }
           });
       }
    });
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

</script>
</body>
</html>
