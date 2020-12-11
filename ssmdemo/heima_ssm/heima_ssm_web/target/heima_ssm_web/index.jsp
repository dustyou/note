<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/8/5
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<jsp:forward page="/login.jsp"></jsp:forward>
<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有的产品信息</a>
</body>
</html>
