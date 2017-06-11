<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/8
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
  <title>
    <sitemesh:write property='title'/>
  </title>
  <sitemesh:write property='head'/>
</head>
<body>
  <header>
    <div class="container-fluid" style="margin-bottom:10px">
      <div class="row-fluid">
        <div class="span12">
          <div class="page-header" style="margin-bottom: 2px;margin-top: 2px;padding-bottom: 2px;">
            <h3 style="margin-top:10px">
              Welcome to Book Paradise |
              <a href="/BookParadise/Home"> Home</a>
              <a href="/BookParadise/handleuser/logout" style="float:right">Logout</a>
              <a href="/BookParadise/Myspace" style="float:right"><shiro:principal/>&nbsp&nbsp&nbsp</a>
            </h3>
          </div>
        </div>
      </div>
    </div>
  </header>
  <sitemesh:write property='body' />
  <hr/>
</body>
</html>
