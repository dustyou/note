<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/9/3
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>所有员工</title>
</head>
<body>
<table>
<%--    @elvariable id="empList" type="java.util.List"--%>
    <c:forEach items="${empList}" var="emp">
        <tr>${emp.name}</tr>
    </c:forEach>
</table>

</body>
</html>
