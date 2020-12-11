<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/9/3
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input name="username" type="text"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input name="password" type="password"></td>
        </tr>
    </table>
    <input type="submit">
</form>

</body>
</html>
