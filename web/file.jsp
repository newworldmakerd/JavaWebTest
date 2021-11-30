<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/11/30
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件提交</title>
</head>
<body>
<form action=<%=request.getContextPath()%>/fileUpload method="post" enctype="multipart/form-data">
    用户名<input type="text" name="username">
    <br>
    头像<input type="file" name="img">
    <br>
    <input type="submit" value="提交">

</form>
</body>
</html>
