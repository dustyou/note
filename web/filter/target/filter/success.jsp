<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/6/27
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>, 欢迎你</h1>
<a href="${pageContext.request.contextPath}/list.jsp">进入用户信息查询页面</a>

</body>
</html>
