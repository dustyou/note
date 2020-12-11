<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/6/29
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户信息管理系统</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        td {
            text-align: center;
        }
        
        th {
            text-align: center;
        }
        
    </style>

</head>
<%
    User user = new User();
    List<User> users = new ArrayList<>();
    users.add(new User("张三", "男", 23, "北京", "12345567", "124545fg3@qq.com"));
    users.add(new User("李四", "男", 24, "天津", "14654567", "12xfgw34543@qq.com"));
    users.add(new User("张三", "男", 25, "湖南", "12345654", "123454gsd3@qq.com"));
    users.add(new User("老王", "男", 26, "江西", "154354567", "3245fg3@qq.com"));
    users.add(new User("老戴", "男", 27, "江西", "3454347", "1rtwert23@qq.com"));
    users.add(new User("马老师", "男", 21, "上海", "345435567", "4354ger3@qq.com"));
    session.setAttribute("users", users);

%>


<body>
<div class="container">
    <h3>用户信息列表</h3>
    
    <div style="float:left;">
        <form class="form-inline">
            <div class="form-group">
                <label for="inputName">姓名</label>
                <input type="text" class="form-control" id="inputName" placeholder="张三">
            </div>
            <div class="form-group">
                <label for="inputPlace">籍贯</label>
                <input type="email" class="form-control" id="inputPlace" placeholder="北京">
            </div>
            <div class="form-group">
                <label for="inputEmail">邮箱</label>
                <input type="email" class="form-control" id="inputEmail" placeholder="zhangsan@example.com">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    
    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="add.html">添加联系人</a>
        <a class="btn btn-primary" href="add.html">删除选中</a>
    </div>
    <div class="table1">
        <table border="1" class="table table-borderd table-hover ">
            <tr class="success">
                <th><input type="checkbox"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            
            <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.place}</td>
                    <td>${user.QQ}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="update.html" class="btn btn-default btn-sm">修改</a>
                        <a href="delete.html" class="btn btn-default btn-sm">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 22px; margin-left: 5px">
                    共16条记录, 共4页
                </span>
            </ul>
        </nav>
    </div>
</div>


</body>
</html>
