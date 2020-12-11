<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/9/3
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/save">
    <table>
        <tr>
            <td>用户名: </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>真实姓名: </td>
            <td><input type="text" name="realname"></td>
        </tr>
        <tr>
            <td>密码: </td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>
                <label><input type="radio" value="male" name="sex" checked>男</label>
                <label><input type="radio" value="female" name="sex">女</label>
            </td>
        </tr>
    </table>

    <input type="submit" value="提交">
</form>

</body>
</html>
