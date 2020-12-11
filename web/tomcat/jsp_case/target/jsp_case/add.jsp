<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/7/1
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加联系人</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<h3>添加联系人页面</h3>
<form action="${pageContext.request.contextPath}/addUserServlet" method="post">
    
    <div class="form-group">
        <label for="name">姓名: </label>
        <input class="form-control" type="text" name="name" id="name" placeholder="请输入年龄">
    </div>
    
    <div class="form-group">
        <label >性别: </label>
        <input type="radio" name="gender" value="男" checked>男
        <input type="radio" name="gender" value="女">女
    </div>
    
    <div class="form-group">
        <label for="age">年龄: </label>
        <input class="form-control" type="text" name="age" id="age" placeholder="请输入年龄">
    </div>
    
    <div class="form-group">
        <label for="address">年龄: </label>
        <input class="form-control" type="text" name="address" id="address" placeholder="请输入地址">
    </div>
    
    <div class="form-group">
        <label for="QQ">QQ: </label>
        <input class="form-control" type="text" name="QQ" id="QQ" placeholder="请输入QQ">
    </div>
    
    <div class="form-group">
        <label for="email">邮箱: </label>
        <input class="form-control" type="email" name="email" id="email" placeholder="请输入邮箱地址">
    </div>
    
    <input type="submit" value="提交" class="btn btn-primary">
    <input type="reset" value="重置" class="btn btn-default">
    <a href="" class="btn btn-default">返回</a>

</form>

</body>
</html>
