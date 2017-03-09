<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-10-21
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>B计划后台登录</title>
</head>
<body>

<div>
  <form action="<c:url value="/login" />" method="post" role="form">
    <c:if test="${loginError}">登录失败</c:if>
    <div class="form-group">
      <input class="form-control" placeholder="用户名" name="username" type="text" autofocus>
    </div>
    <div class="form-group">
      <input class="form-control" placeholder="输入密码" name="password" type="password" value="">
    </div>
    <div class="checkbox">
      <label>
        <input name="remember" type="checkbox" value="Remember Me">记住密码
      </label>

    </div>
    <!-- Change this to a button or input when using this as a form -->
    <input type="submit" value="登录" class="btn btn-lg btn-primary btn-block"/>
    <hr/>
    <a href="#" target="_blank" class="pull-right"><span>忘记登录密码</span></a>
  </form>
</div>

</body>
</html>
