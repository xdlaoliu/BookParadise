<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico">

  <title>Sign In Page</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/stylesheets/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/stylesheets/signin.css" rel="stylesheet">

  <script src="${pageContext.request.contextPath}/scripts/ie-emulation-modes-warning.js"></script>

</head>

<shiro:authenticated>
  <%
    response.sendRedirect("/BookParadise/Home");
  %>
</shiro:authenticated>

<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <form class="form-signin" action="<%= request.getContextPath()%>/Login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <c:if test="${requestScope.login_error != NULL}">
          <div class="alert alert-danger">
            <strong>${requestScope.login_error}</strong>
          </div>
        </c:if>
        <br/>
        <% String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);%>
        <c:set var="exp_type" value="<%=error %>"/>
        <c:set var="tips" value=""></c:set>
        <c:if test="${fn:contains(exp_type,'CaptchaException')}">
          <c:set var="tips" value="验证码错误"></c:set>
        </c:if>
        <c:if test="${fn:contains(exp_type,'FailVertifyException')}">
          <c:set var="tips" value="该账号审核未通过，不允许登陆!"></c:set>
        </c:if>
        <c:if test="${fn:contains(exp_type,'NotVertifyException')}">
          <c:set var="tips" value="该账号正在审核中... 不允许登陆!"></c:set>
        </c:if>
        <c:if test="${fn:contains(exp_type,'UnknownAccountException')}">
          <c:set var="tips" value="账号不存在!"></c:set>
        </c:if>
        <c:if test="${fn:contains(exp_type,'DisabledAccountException')}">
          <c:set var="tips" value="账号不允许登陆!"></c:set>
        </c:if>
        <c:if test="${fn:contains(exp_type,'IncorrectCredentialsException')}">
          <c:set var="tips" value="密码错误!"></c:set>
        </c:if>
        <c:if test="${tips!='' && tips!=null}">
          <div class="alert alert-danger">
            <strong><c:out value="ERROR: ${tips}"/></strong>
          </div>
        </c:if>
      </form>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <form class="form-signin" action="<%= request.getContextPath()%>/Register" method="post">
        <h4 >If you don't have ID,Please register.</h4>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
