<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/9/3
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>所有员工</title>
</head>
<body>
<table>


    <c:forEach items="${empList}" var="emp">
        <tr>${emp.name}</tr>
        <tr>${emp.id}</tr>
    </c:forEach>
</table>

<h1>empslist.jsp</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>salary</th>
        <th>operation</th>
    </tr>
    <c:forEach items="${empList}" var="emp">
    <tr>
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td><fmt:formatNumber type="number" value="${emp.salary}" pattern="#.00"/></td>
        <td>${emp.age}</td>
        <td><a href="${pageContext.request.contextPath}/emp/delete?id=${emp.id}">delete</a> &nbsp; <a href="${pageContext.request.contextPath}/emp/findOne?id=${emp.id}">modify</a></td>

    </tr>
    </c:forEach>

</body>
</html>
