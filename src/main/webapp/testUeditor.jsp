<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加文章</title>
</head>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/statics/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/statics/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/statics/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('content');
</script>
<body>
<form action="#" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>文章标题</td>
            <td><input type="text" name="headline"></td>
        </tr>
        <tr>
            <td>文章属性id</td>
            <td><input type="text" name="propertyId"></td>
        </tr>
        <tr>
            <td>文章内容</td>
            <td>
                <textarea name="content" id="content" style="width: 800px; height: 400px; margin: 0 auto;"></textarea>
            </td>
        </tr>
        <tr>
            <td>添加附件</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>