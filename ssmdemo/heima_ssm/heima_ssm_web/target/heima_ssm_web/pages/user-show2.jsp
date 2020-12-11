<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/8/16
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="tab-pane" id="tab-treetable">
    <table id="collapse-table" class="table table-bordered table-hover dataTable">
        <thead>
        <tr>
            <th>用户</th>
            <th>描述</th>
        </tr>
        </thead>
        
        <tr data-tt-id="0">
            <td colspan="2">${user.username}</td>
        </tr>
        
        <tbody>
        <c:forEach items="${user.roles}" var="role">
            <tr data-tt-id="1" data-tt-parent-id="0">
                <td>${role.roleName}</td>
                <td>${role.roleDesc}</td>
            </tr>
            <c:forEach items="${role.permissions}" var="permission">
                <tr data-tt-id="1-1" data-tt-parent-id="1">
                    <td>${permission.permissionName}</td>
                    <td>${permission.url}</td>
                </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    
    </table>
</div>
</body>
</html>
