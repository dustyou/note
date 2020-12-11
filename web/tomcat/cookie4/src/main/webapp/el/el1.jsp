<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/6/27
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>EL</title>
</head>
<body>
${3 > 4}
\${3 > 4}
<h3>算数运算符</h3>
${3 + 4}<br>
${3 / 4}<br>
${3 div 4}<br>
${3 % 4}<br>
${3 mod 4}<br>
${3 == 4}<br>
${3 == 4 or 3 > 4 or 3 != 4}<br>
<%
request.setAttribute("name", "zhangsan");
%>
${requestScope.name}

<h3>EL获取对象中的值</h3>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());
    request.setAttribute("u", user);
%>
${requestScope.u.name}<br>
${requestScope.u.age}<br>
${requestScope.u.birthday}<br>
${u.birthday.year}<br>

<h3>EL获取List中的值</h3>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list", list);
%>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[2]}<br>

<h3>EL获取Map中的值</h3>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("name", "张三");
    request.setAttribute("map", map);
%>
${map}<br>
${map["name"]}<br>
${requestScope.map.name}<br>

<h3>empty运算符</h3>
${empty list}
${empty list22}

<h3>在jsp页面动态获取虚拟目录</h3>
${pageContext.request.contextPath}



</body>
</html>
