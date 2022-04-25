<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/14
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跟帖</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("MAIN_ID",session.getAttribute("mainid"));
        if (session.getAttribute("userid")==null) {
            pageContext.setAttribute("USERID", "-1");
            pageContext.setAttribute("USERNAME","-1");
        }
        else {
            pageContext.setAttribute("USERID",session.getAttribute("userid"));
            pageContext.setAttribute("USERNAME",session.getAttribute("username"));
        }
        //pageContext.setAttribute("USERID","1");
       // pageContext.setAttribute("USERNAME","admin");
    %>
    <!--
        web路径：
        1.不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
        2.以/开始的相对路径，找资源，以服务器的路径为标准，需要加上项目名称
    -->
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/dist/css/bootstrapValidator.css"/>
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/dist/js/bootstrapValidator.js"></script>
    <style>
        #page_right{
            width: 70%;
            position: relative;
            right: -20%;
        }
        #ckeditor{
            width: 70%;
            position: relative;
            right: -20%;
        }
        #page_nav{
            width: 70%;
            position: relative;
            right: -20%;
        }
        .left{
            width: 20%;
        }
        .right{
            position: relative;
        }
        .right-follow{
            width:80%;
            height: 80%;
        }
        .right-follow-content{
            word-break: break-all;
            display: table;
        }
        .right-middle-nav-aux{
            height: 50px;
            position: relative;
        }
        .right-middle-nav{
            position: absolute;
            right: 0;
            bottom: 0;
        }
        .right-reply{
            padding: 10% 10%;
        }
        .follow-button{
            position: relative;
            right: -50%;
        }
    </style>
    <%--    ckedit--%>
    <script src="${APP_PATH}/statics/ckeditor/ckeditor.js"></script>
    <script>
        function editArticle() {
            var main_content;
            $.ajax({
                url:"${APP_PATH}/main/getmainbyid",
                type:"post",
                data:{mainid:${MAIN_ID}},
                async:false,
                success:function (result) {
                    // alert(result);
                    var obj=JSON.parse(result);
                    // alert(obj);
                    var main=obj["main"];
                    main_content=main.mContent;
                }
            });
            CKEDITOR.instances.description.setData(main_content);
            //alert(CKEDITOR.instances.description.getData());
            change_postmess_button_onclick("modify_main()","提交修改");
        }
        function change_postmess_button_onclick(func,but_text) {
            var postmess_button=$("#postmess");
            postmess_button.attr("onclick",func);
            postmess_button.text(but_text);
        }
        function modify_main() {
            var modify_main_content=CKEDITOR.instances.description.getData();
            $.ajax({
                url:"${APP_PATH}/main/modifymaincontent",
                type:"post",
                data:{mainid:${MAIN_ID},content:modify_main_content},
                async:false,
                success:function (result) {
                    initialAjax(1);
                   showerrormess("修改成功！");
                    CKEDITOR.instances.description.setData("");
                   change_postmess_button_onclick("follow(this)","跟帖");
                }
            });
        }
        function addpoint(followerid,point) {
            var mainid=${MAIN_ID};

        }
        function showaddpoint(obj) {
            var data=$(obj).attr("data-field");
            //alert(data);
            var t=JSON.parse(data);
            followerid=t["followerid"];
            $(function () { $('#pointModal').on('show.bs.modal', function () {
                var modal = $(this);
                //此处即为修改modal的内容
                modal.find('#pointModal_points').attr('placeholder','(你发布的奖励还剩'+mainpoint+'积分)');
                modal.find('#pointModal_points').attr('followerid',followerid);
            }) });
            $("#pointModal").modal();
            //alert(followid);
            //addpoint()
        }
        $(document).on("click","#bonus",function () {
            var modal=$("#pointModal");
            var bonuspoint=modal.find('#pointModal_points').val();
            var followerid=modal.find('#pointModal_points').attr('followerid');
            if (bonuspoint>mainpoint){
                modal.modal('hide');
                showerrormess("此帖剩余积分不足！");
            }
            else if (bonuspoint<=0)
            {
                modal.modal('hide');
                showerrormess("积分必须是正数！");
            }
            else {
                var mainpointafter =mainpoint-bonuspoint;
                //alert(followerid+"  "+bonuspoint+"   "+mainpointafter);
                $.ajax({
                    url:"${APP_PATH}/user/addPoint",
                    type:"post",
                    data:{mainid:${MAIN_ID},followerid:followerid,bonuspoint:bonuspoint,mainpoint:mainpointafter},
                    async:false,
                    success:function (result) {
                        modal.modal('hide');
                        initialAjax(1);
                        showerrormess("奖励成功！");
                    }
                });
            }
        });
    </script>
</head>
<body onload="initialAjax(1)">
<div id="page_up">

</div>
<div class="containers">
    <%@include file="nav-top.jsp"%>
    <div class="right-main">

        <div id="page_right">
            <table id="main" class="table table-hover table-bordered">
                <tbody>
                <tr>
                    <td colspan="2">
                        <nav><div id="return_section"></div></nav>
                        <header id="title"></header>
                    </td>
                </tr>
                <tr class="warning">
                    <td class="left">
                        <div id="mainner_headpic"></div>
                        <div id="mainner_name"></div>
                        <div id="email"></div>
                    </td>
                    <td class="right">
                        <div class="right-follow" id="main_content"></div>
                        <div class="right-middle-nav-aux">
                            <div class="right-middle-nav">
                                <a id="delete_main"></a>
                                <span>1楼</span>
                                <span id="main_date"></span>
                                <a href="#edit">回复</a>
                                <a href="#edit" id="editarticle"></a>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <table  id="follow" class="table table-hover table-bordered">
                <tbody>
                <tr id="follower1">
                    <td class="left">
                        <div >
                        </div>
                        <div>
                        </div>
                    </td>
                    <td class="right">
                        <div class="right-follow">
                        </div>
                        <div class="right-middle-nav-aux">
                            <div class="right-middle-nav">
                            </div>
                        </div>
                        <div id="right-reply" class="right-reply">
                            <table class="table table-hover table-bordered">
                                <tr>
                                    <td class="left">
                                        <div >

                                        </div>
                                        <div>
                                        </div>
                                    </td>
                                    <td class="right">
                                        <div class="right-follow">
                                        </div>
                                        <div class="right-middle-nav-aux">
                                            <div class="right-middle-nav">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="right-postReply">

                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div id="page_nav">
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
        <%--ckedit--%>
        <div id="ckeditor">
            <a id="edit"></a>
            <textarea class="form-control" id="description"
                      name="description" style="color: #8a8a8a;">

            </textarea>
            <div class="follow-button">
                <button type="button" id="postmess"
                        style="width: 100px" class="btn btn-success" onclick="follow(this)">跟帖</button>
            </div>
        </div>

        <%--积分添加框--%>
        <div class="modal fade" id="pointModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="pointModalLabel">
                        </h4>
                    </div>
                    <div class="modal-body" >
                        <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">积分奖励</label>
                            <div class="col-sm-10">
                                <input type="text" name="empName" class="form-control" id="pointModal_points" >
                                <span class="help-block"></span>
                            </div>
                        </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-success" id="bonus" >奖励
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
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
</body>
</html>
<script>

    let localEditor;
    function ckEditors(id) {
        localEditor = CKEDITOR.replace(id, {toolbar: 'Basic'});
    }
    function showhtm() {
        alert(localEditor.document.getBody().getHtml());
    }


    var totalRecord;//总记录数
    var currentPage;//当前页
    var lastPage;
    var mSectionid;//板块id
    var mainerid;//主帖人的id
    var mainpoint;
    /*
                获得一个主帖的所有信息，同时把username发送过去拿到userid
                获得一个数组，存所有的跟帖，和他们的信息
                根据这些构建出主帖---跟帖表，主帖的回复按钮直接页内跳转到最下面的回复框，
                根据username和主帖发帖人id判断是否添加一个删除按钮
                每个跟帖的回复a标签要存一个data-followid属性
                点击a标签，直接发送ajax请求，拿到所有的回复信息构建回复table，
                回复框的按钮要加一个data-followid属性，加一个onclick属性，
                触发时，拿到userid，followid，content，时间。
                根据userid和回复人判断在每一条回复后是否要加一个删除按钮
                 */
    function initialAjax(pn){//初始化，拿到主帖和所有跟帖
        ckEditors('description');//初始化ckedit
        $.ajax({
            url:"${APP_PATH}/main/getmainbyid",
            type:"post",
            data:{mainid:${MAIN_ID}},
            async:false,
            success:function (result) {
                // alert(result);
                var obj=JSON.parse(result);
                // alert(obj);
                for (var key in obj)//只有一个主帖，所以只循环一次
                    build_main(obj[key]);
            }
        });
        to_page(pn);//初始化，构建第一页的跟帖。
    }
    function build_main(result) {
        mSectionid=result.mSectionid;
        $("#mainner_headpic").empty();
        $("#mainner_name").empty();
        $("#email").empty();
        $("#main_content").empty();
        $("#main_date").empty();
        $("#return_section").empty();
        $("#title").empty();
        var userid=${USERID};
        mainerid=result.mMainerid;
        mainpoint=result.mPoint;
        if (userid===result.mMainerid) {
            var delete_a = $("#delete_main");
            delete_a.attr("onclick",'delete_main()');//点击删除,拿到跟帖的id，删除此跟帖
            var edit_a=$("#editarticle");
            edit_a.text("编辑文章")
            edit_a.attr("onclick","editArticle()");
        }

        var sectionid=result.mSectionid;
        var title=result.mTitle;
        if (result.mPoint!=0)
            title+="(积分:"+result.mPoint+")";
        var title_span=$("<h3></h3>").html(title);
        //返回板块
        var return_section_span=
            $("<a href='${APP_PATH}/section/thesection?sectionId="+mSectionid+"'><span class=\"glyphicon glyphicon-arrow-left \" aria-hidden=\"true\"></span> 返回版面</a>");
        return_section_span.attr("sectionid",result.mSectionid);
        var mannerid=result.mMainerid;
        var User=getUserByid(mannerid);
        // alert(User);
        var headpic=User.uHeadpic;
        var name=User.uUserid;
        var email=User.uEmail;
        var content=result.mContent;
        var smain_date=result.mMaindate;
        var main_date=x(smain_date);//秒数转换成时间格式
        var content=$("<div class='right-follow-content'></div>").html(content);
        var headpic_img=$("<img class=\"img-circle\" width=50px height=50px>")
            .attr("src",headpic);
        var link=$("<a></a>");
        link.attr("href","${APP_PATH}/userInfo.jsp?uid="+result.mMainerid);
        headpic_img.appendTo(link);
        var name_span=$("<span class='glyphicon glyphicon-user' style='font-size: 10px'></span>").text(name);
        var email_span=$("<span class='glyphicon glyphicon-envelope' style='font-size: 10px'></span>").text(email);
        $("#mainner_headpic").append(link);
        $("#mainner_name").append(name_span);
        $("#main_content").append(content);
        $("#main_date").text(main_date);
        $("#title").append(title_span);
        $("#return_section").append(return_section_span);
        $("#email").append(email_span);
    }
    function delete_main() {
        if (confirm("您确定要删除主帖吗？（警告：所有跟帖和回复都会被删除）")){
            $.ajax({
                url:"${APP_PATH}/main/deletemainbyid",
                type:"post",
                data:{mainid:${MAIN_ID}},
                async:false,
                success:function (result) {
                    showerrormess("删除成功！");//删除后返回主页面
                    back_section();
                }
            });
        }
    }
    function getUserByid(id) {
        var user;
        $.ajax({
            url:"${APP_PATH}/user/getUserById",
            type:"post",
            data:{userid:id},
            datatype:'JSON',
            async:false,
            success:function (result) {
                user=result;
            }
        })
        return JSON.parse(user)["user"];
    }
    function to_page(pn) {
        $.ajax({
            url:"${APP_PATH}/follow/getfollowbyid",
            type:"post",
            data:{mainid:${MAIN_ID},pn:pn},
            async:false,
            success:function (result) {
                // alert(result);
                var obj=JSON.parse(result);
                //alert(obj);
                build_page_info(obj);
                build_page_nav(obj);
                for (var key in obj)//只有一个跟帖数组，所以只循环一次，得到的是pageInfo对象
                    build_follow(obj[key]);
            }
        })
    }
    // <td class="left">
    //     <div >
    //     <img src="http://tb.himg.baidu.com/sys/portrait/item/tb.1.488cbd10.deM4YdwNZ4_-P2xHfnY4kA" class="img-rounded">
    //     </div>
    //     <div>
    //     <span>名字</span>
    //     </div>
    //     </td>
    //     <td class="right">
    //     <div class="right-follow">
    //     <img src="http://tb.himg.baidu.com/sys/portrait/item/tb.1.488cbd10.deM4YdwNZ4_-P2xHfnY4kA" class="img-rounded">
    //     111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
    //     </div>
    //     <div class="right-middle-nav-aux">
    //     <div class="right-middle-nav">
    //     <a>删除</a>
    //     <span>1楼</span>
    // <span>2019-11-24 16:40</span>
    // <a onclick="add_reply(this)" data-username="xxx">回复</a>
    //     </div>
    //     </div>
    function build_follow(result) {//构建主帖跟帖表--分页显示
        $("#follow").empty();
        var follow=result.list;
        $.each(follow,function (index,item) {
            var oneFollow=$("<tr></tr>");
            /*
            * 左边的头像何用户名*/
            var User=getUserByid(item.fFollowerid);
            // alert(item.fContent);
            var head_pic=$("<img  class=\"img-circle\" alt=\"0\" style=\"width:50px;height:50px\">")
                .attr("src",User.uHeadpic);
            var link=$("<a></a>");
            link.attr("href","${APP_PATH}/userInfo.jsp?uid="+item.fFollowerid);
            head_pic.appendTo(link);
            var name=$("<span class='glyphicon glyphicon-user' style='font-size: 10px'></span>")
                .text(User.uUserid);
            var point=$("<span class='glyphicon glyphicon-star' style='font-size: 10px'></span>").text(User.uPoints);
            var email_span=$("<span class='glyphicon glyphicon-envelope' style='font-size: 10px'></span>").text(User.uEmail);
            var head_pic_div=$("<div></div>").append(link);
            var name_div=$("<div></div>").append(name);
            var email_div=$("<div></div>").append(email_span);
            var point_div=$("<div></div>").append(point);
            var left_div=$("<div></div>").append(head_pic_div).append(name_div).append(email_div).append(point_div);
            var left=$("<td class=\"left\"></td>");
            left.append(left_div);

            var right=$("<td class=\"right\"></td>");
            right.attr("id","follow"+item.fFollowid);
            //********设置这条跟帖(这一行)的id为跟帖id，这样的话点击回复就可以在这个td下面加回复消息何回复框
            /*右边上面的内容*/
            var content=$("<div class=\"right-follow-content\"></div>").html(item.fContent);
            /*右边中间的删除-楼数-时间-回复栏*/
            var userid=${USERID};
            var right_middle_nav=$("<div class=\"right-middle-nav\">");
            var right_middle_nav_aux=$("<div class=\"right-middle-nav-aux\">");
            //如果当前用户是跟贴的人，那么赋予他删除的权力。
            if (userid===item.fFollowerid) {
                var delete_a = $("<a onclick='deleteFollow(this)'>删除&nbsp</a>");
                delete_a.attr("data-field",'{"followid":'+item.fFollowid+'}');//点击删除,拿到跟帖的id，删除此跟帖
                delete_a.appendTo(right_middle_nav);
            }
            var farfloor=(currentPage-1)*5+index+2;
            var floor=$("<span></span>").text(farfloor+"楼");
            floor.appendTo(right_middle_nav)

            var follow_date=$("<span>&nbsp</span>").text(x(item.fFollowdate));
            follow_date.appendTo(right_middle_nav);

            var reply_a=$("<a onclick=\"getReply(this)\">&nbsp回复</a>");
            reply_a.attr("data-field",'{"followid":'+item.fFollowid+'}');
            reply_a.attr("id","a_reply_"+item.fFollowid);
            reply_a.appendTo(right_middle_nav);

            var reply_num=get_replynum(item.fFollowid);
            //alert(reply_num);
            var reply_num_span=$("<span><span>").text("("+reply_num+")");
            reply_num_span.attr("id","reply_num_span_"+item.fFollowid);
            reply_num_span.appendTo(right_middle_nav);
            //如果此人是主帖发帖人，那么可以给积分奖励
            if (mainerid==${USERID}){
                var add_point_span=$("<span class='glyphicon glyphicon-thumbs-up' onclick='showaddpoint(this)'></span>");
                add_point_span.attr("data-field",'{"followerid":'+item.fFollowerid+'}');
                add_point_span.appendTo(right_middle_nav)
            }

            right_middle_nav_aux.append(right_middle_nav);

            right.append(content).append(right_middle_nav_aux);

            oneFollow.append(left).append(right);
            oneFollow.appendTo($("#follow"));
            //点击回复，拿到跟帖的id，显示回复信息.回复框
            // private Integer fFollowid;
            //
            // private String fContent;
            //
            // private Integer fFollowerid;
            //
            // private Integer fMainid;
            //
            // private Date fFollowdate;
        });
    }
    function deleteFollow(a) {
        //alert($(a));//传this过来要这样才可以,a.attr会报错
        var data=$(a).attr("data-field");
        var obj=JSON.parse(data);
        // alert(obj);
        // for (var key in obj)
        //     alert(obj[key]);
        var followid=obj["followid"];
        if (confirm("你确定要删除吗?")){
            $.ajax({
                    url:"${APP_PATH}/follow/deletefollowbyid",
                    type:"post",
                    data:{followid:followid},
                    async:false,
                    success:function (result) {
                        refreshfollow();
                    }
                }
            );
        }
    }
    //解析显示分页信息
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.pageInfo.pageNum+"页，" +
            "总共"+result.pageInfo.pages+"页，" +
            "总共"+result.pageInfo.total+"条记录");
        totalRecord=result.pageInfo.total;
        currentPage=result.pageInfo.pageNum;
        lastPage=result.pageInfo.pages;
    }
    //解析显示分页条，点击分页要去下一页
    function build_page_nav(result){
        $("#page_nav_area").empty();

        var ul=$("<ul><ul>").addClass("pagination");
        var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.pageInfo.pageNum-1);
            });
        }
        var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.pageInfo.hasNextPage==false){
            lastPageLi.addClass("disabled");
            nextPageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            lastPageLi.click(function () {
                to_page(result.pageInfo.pages);
            });
            nextPageLi.click(function () {
                to_page(result.pageInfo.pageNum+1);
            });
        }
        //添加首页和前一页的提示
        ul.append(firstPageLi).append(prePageLi);
        //遍历给ul中添加页码
        $.each(result.pageInfo.navigatepageNums,function (index,item) {
            var numLi=$("<li></li>").append($("<a></a>").append(item));
            if(result.pageInfo.pageNum==item){
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
    function getReply(a) {//点击回复，发送ajax请求，拿到这个跟贴的所有回复信息
        //alert($(a));//传this过来要这样才可以,a.attr会报错
        var data=$(a).attr("data-field");
        var obj=JSON.parse(data);
        // alert(obj);
        var followid=obj["followid"];
        // for (var key in obj)
        //     alert(obj[key]);
        //alert(followid);
        $.ajax({
            url:"${APP_PATH}/reply/getreplybyfollowid",
            type:"post",
            data:{followid:followid},
            async:false,
            success:function (result) {
                // alert(result);
                var obj=JSON.parse(result);
                //alert(obj);
                //alert(obj);
                var list=obj["list"];
                build_reply(list,followid);
                //alert(result[0]);
            }
        })
    }
    // <div id="right-reply" class="right-reply">
    //     <table class="table table-hover table-bordered">
    //     <tr>
    //     <td class="left">
    //     <div >
    //     <img src="http://tb.himg.baidu.com/sys/portrait/item/tb.1.488cbd10.deM4YdwNZ4_-P2xHfnY4kA" class="img-rounded">
    //     </div>
    //     <div>
    //     <span>名字</span>
    //     </div>
    //     </td>
    //     <td class="right">
    //     <div class="right-follow">
    //     <img src="http://tb.himg.baidu.com/sys/portrait/item/tb.1.488cbd10.deM4YdwNZ4_-P2xHfnY4kA" class="img-rounded">
    //     111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
    //     </div>
    //     <div class="right-middle-nav-aux">
    //     <div class="right-middle-nav">
    //     <a>删除</a>
    //     <span>1楼</span>
    // <span>2019-11-24 16:40</span>
    // <a onclick="add_reply(this)" data-username="xxx">回复</a>
    //     </div>
    //     </div>
    //     </td>
    //     </tr>
    //     </table>
    //     </div>
    function build_reply(result,followid) {//构建所有的回复信息和回复框
        // reply_a.attr("id","a_reply_"+item.fFollowid);
        $("#"+"a_reply_"+followid).text("收起回复");
        $("#"+"a_reply_"+followid).attr("onclick","clearreply(this)");
        //alert(followid);
        $(".right-reply").empty();
        var fid="follow"+followid;
        var followtd=$("#"+fid);//拿到跟帖的id，把回复信息和回复框加入
        //alert(followtd.innerHTML);
        var reply_div=$("<div  class=\"right-reply\"></div>");
        reply_div.attr("id","reply-follow"+followid);
        var reply_table=$("<table class=\"table table-hover table-bordered\"></table>");
        $.each(result,function (index,item) {
            var User=getUserByid(item.rReplyerid);
            var userid=${USERID};
            var reply_tr=$("<tr class=\"success\"></tr>");
            reply_tr.attr("id","reply"+item.rReplyid);
            var reply_left_td=$("<td class=\"left\">");
            var reply_left_td_div_headpic=$("<div></div>");
            var reply_left_td_div_img_headpic=$("<img class='img-circle' style=\"width:50px;height:50px\">");//头像
            reply_left_td_div_img_headpic.attr("src",User.uHeadpic);
            var reply_left_td_div_name=$("<div></div>");
            var reply_left_td_div_span_name=$("<span class='glyphicon glyphicon-user' style='font-size: 8px'></span>");//名字
            reply_left_td_div_span_name.text(User.uUserid);
            var reply_left_td_div_eamil=$("<div></div>");//邮箱
            var reply_left_td_div_span_eamil=$("<span class='glyphicon glyphicon-envelope' style='font-size: 8px'></span>");//名字
            reply_left_td_div_span_eamil.text(User.uEmail);
            reply_left_td_div_headpic.append(reply_left_td_div_img_headpic);
            reply_left_td_div_name.append(reply_left_td_div_span_name);
            reply_left_td_div_name.append(reply_left_td_div_span_eamil);
            reply_left_td.append(reply_left_td_div_headpic).append(reply_left_td_div_name);


            var reply_right_td=$("<td class=\"right\">");
            var reply_right_div_content= $("<div class=\"right-follow-content\">");
            reply_right_div_content.text(item.rContent);
            var reply_right_middle_nav_aux=$("<div class=\"right-middle-nav-aux\">");
            var reply_right_middle_nav=$("<div class=\"right-middle-nav\">");
            var reply_right_a_deletereply=$("<a onclick='deletereply(this)'>删除</a>");
            reply_right_a_deletereply.attr("data-field",'{"replyid":'+item.rReplyid+',"followid":'+followid+'}');
            var reply_right_span_replydate=$("<span></span>");
            reply_right_span_replydate.text(x(item.rReplydate));
            if(userid==item.rReplyerid){//只有当前用户是回复人，才可以删除
                reply_right_middle_nav.append(reply_right_a_deletereply);
            }
            reply_right_middle_nav.append(reply_right_span_replydate);
            reply_right_middle_nav_aux.append(reply_right_middle_nav);
            reply_right_td.append(reply_right_div_content);
            reply_right_td.append(reply_right_middle_nav_aux);

            reply_tr.append(reply_left_td).append(reply_right_td);
            reply_table.append(reply_tr);
            //alert(item.rContent);
            reply_tr.attr("id",item.rReplyid);
        });

        var replybox_div=$("<div class=\"input-group-btn\"></div>");
        var replybox_input=$("<input type=\"text\" class=\"form-control\" aria-label=\"...\">");
        replybox_input.attr("id","input-button-reply"+followid);
        var replybox_button=$("<button type=\"button\" class=\"btn btn-success\">发表</button>");
        replybox_button.attr("data-field",'{"followid":'+followid+'}');
        replybox_button.attr("onclick","reply(this)");
        replybox_div.append(replybox_button);
        var replybox=$("<div class=\"input-group input-group-lg\">");
        replybox.append(replybox_input).append(replybox_div);
        var right_postReply=$("<div></div>");
        right_postReply.attr("id","right-postReply"+followid);
        right_postReply.append(replybox);

        reply_div.append(reply_table);

        followtd.append(reply_div);
        followtd.append(right_postReply);

        //alert(reply_div.innerHTML);
        // private Integer rReplyid;
        //
        // private String rContent;
        //
        // private Integer rReplyerid;
        //
        // private Integer rFollowid;
        //
        // private Date rReplydate;
    }
    function clearreply(obj) {
        //alert($(obj));
        var data=$(obj).attr("data-field");
        //alert(data);
        var t=JSON.parse(data);
        var followid=t["followid"];
        // alert(followid);
        var follow_reply="reply-follow"+followid;
        $("#"+follow_reply).remove();//收起回复
        $("#right-postReply"+followid).remove();
        $(obj).text("回复");
        $(obj).attr("onclick","getReply(this)");
    }
    function deletereply(obj) {
        data=$(obj).attr("data-field");
        var obj=JSON.parse(data);
        var replyid=obj["replyid"];
        var followid=obj["followid"];
        $.ajax({
            url:"${APP_PATH}/reply/deletereply",
            type:"post",
            data:{replyid:replyid},
            async:false,
            success:function (result) {
                //alert(followid);
                refreshreply(followid);
                reset_reply_num(followid);
            }
        })
    }
    function reply(obj) {//点击回复按钮，发送ajax回复
        var userid=${USERID};
        if (userid===-1)
            showerrormess("请先登录！")
        else {
            data=$(obj).attr("data-field");
            var obj=JSON.parse(data);
            var followid=obj["followid"];
            //alert(followid);
            var reply_content=$("#input-button-reply"+followid).val();
            if (reply_content.length>230){
                showerrormess("你输入的字符超过长度！");
            }
            else{
                var replyerid=${USERID};
                var replydate=Date.parse(new Date());
                //alert(followid+reply_content+replyerid+replydate);
                //alert(reply_content);
                $.ajax({
                    url:"${APP_PATH}/reply/insertreply",
                    type:"post",
                    data:{followid:followid,
                        replycontent:reply_content,
                        replyerid:replyerid,
                        replydate:replydate},
                    async:false,
                    success:function (result) {
                        refreshreply(followid);
                        reset_reply_num(followid);
                    }
                })
            }
        }
    }
    function refreshreply(followid) {
        clearreply($("#a_reply_"+followid));
        getReply($("#a_reply_"+followid))
    }
    function refreshfollow() {
        initialAjax(currentPage);
    }
    function follow(obj) {//点击跟帖，发送ajax跟帖
        var userid=${USERID};
        if (userid===-1) {
            showerrormess("请先登录！")
        }
        else {
            var followerid=${USERID};
            var followcontent=CKEDITOR.instances.description.getData();
            var mainid=${MAIN_ID};
            var followdate=Date.parse(new Date());
           // alert(mainid);
            if (followcontent.length>3000){
                showerrormess("你输入的内容超过长度！");
            }

            else {
                $.ajax(
                    {
                        url:"${APP_PATH}/follow/insertfollow",
                        type:"post",
                        data:{followerid:followerid,
                            followcontent:followcontent,
                            mainid:mainid,
                            followdate:followdate},
                        async:false,
                        success:function (result) {
                            initialAjax(lastPage);
                            showerrormess("跟帖成功！");
                            CKEDITOR.instances.description.setData("");
                        }
                    }
                )
            }
        }
    }
    function jto_follow() {

    }
    function x(second) {
        var unixTimestamp = new Date( second) ;
        commonTime = unixTimestamp.toLocaleString();
        return commonTime;
    }
    //重写按照自己要的格式
    Date.prototype.toLocaleString = function() {
        return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日 " + this.getHours() + "点" + this.getMinutes() + "分" + this.getSeconds() + "秒";
    };
    function showerrormess(mess) {
        $(function () { $('#myModal').on('show.bs.modal', function () {
            var modal = $(this);
            //此处即为修改modal的内容
            modal.find('.modal-body').text(mess)
        }) });
        $("#myModal").modal();
    }
    // function jumpto() {
    //
    // }
    // $(document).on("click",".return_section",function () {
    //     alert($(this).attr("sectionid"));
    // });
    function back_section() {

        alert(mSectionid);
    }
    function reset_reply_num(followid) {
        var reply_num=get_replynum(followid);
        $("#reply_num_span_"+followid).text("("+reply_num+")");
    }
    function get_replynum(followid) {
        var replynum
        $.ajax({
            url:"${APP_PATH}/reply/getreplybyfollowid",
            type:"post",
            data:{followid:followid},
            async:false,
            success:function (result) {
                // alert(result);
                var obj=JSON.parse(result);
                //alert(obj);
                //alert(obj);
                var list=obj["list"];
                //alert(list.length);
                replynum=list.length;
                //alert(result[0]);
            }
        });
        return replynum;
    }
</script>