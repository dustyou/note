<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@include file="top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/6/26
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>itcast</title>
</head>
<body>

<%
    response.setContentType("text/html;charset=utf-8");
    boolean flag = false;
    String info = null;
    //获取所有的cookie
    Cookie[] cookies = request.getCookies();
    if (cookies!=null && cookies.length>0) {
        for (Cookie cookie: cookies
        ) {
            //获取cookie名称
            String name = cookie.getName();
            
            if ("lastTime".equals(name)) {
                //响应数据
                String value = cookie.getValue();
                info = "<h1>欢迎回来,您上次访问时间为:" + value + "</h1>";
                flag = true;
                break;
            }
            
        }
    }
    
    %>

<%
    //第一次访问
    if (!flag) {

        info="欢迎您首次访问</h1>";
    }
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
    String str_date = sdf.format(date);
    Cookie lastTime = new Cookie("lastTime", str_date);
    lastTime.setMaxAge(60*60*24*30);
   response.addCookie(lastTime);

%>
<p><%=info%></p>

<h3>主体信息</h3>
<c:

</body>
</html>
