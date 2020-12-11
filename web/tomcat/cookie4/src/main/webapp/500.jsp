<%@ page import="javax.sound.midi.SoundbankResource" %><%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/6/27
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>500</title>
</head>
<body>
    <h1>服务器正忙......</h1>
    <%
    String message = exception.getMessage();
    System.out.print(message);
    %>
</body>
</html>
