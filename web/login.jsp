<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/11/26
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    用户名<input type="text" name="name"/>
    <br>
    密码<input type="password" name="pwd"/>
    <br>
    <input type="submit" value="登录">
    <br>
    消息记录:${msg}
</form>
</body>
</html>
