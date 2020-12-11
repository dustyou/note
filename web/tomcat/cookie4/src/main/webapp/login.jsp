<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/6/27
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<script type="text/javascript">
    onload = function () {
        document.getElementById("image").onclick = function () {
            
            this.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }
    }


</script>
    <style>
        div {
            color: red;
        }
        
        
    </style>
<head>
    <title>login</title>
</head>
<body >
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img src="${pageContext.request.contextPath}/checkCodeServlet" name="image" id="image"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
        
        
    </form>
    
    <div><%=request.getAttribute("cc_erro")==null?"":request.getAttribute("cc_erro")%></div>
    <div><%=request.getAttribute("login_erro")==null?"":request.getAttribute("login_erro")%></div>

${pageContext.request.contextPath}



</body>
</html>
