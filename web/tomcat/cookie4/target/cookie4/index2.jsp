<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" buffer="16kb" errorPage="500.jsp" %>

<html>
<head>
    <title>index2</title>
</head>
<body>
<%
    List list = new ArrayList();
//    int i = 3 / 0;


%>

<%
    pageContext.setAttribute("name", "hello");
%>
<h1>
<%=pageContext.getAttribute("name")%>
</h1>


</body>
</html>
