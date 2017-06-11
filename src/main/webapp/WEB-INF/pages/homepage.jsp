<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/7
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/bootstrap/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/bootstrap-datepicker/css/bootstrap-datetimepicker.min.css"/>
  <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/jquery.dataTables.css"/>--%>
  <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
  <%--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.11.1.js"></script>--%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.validate.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap-datepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap-datepicker/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
  <%--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.dataTables.js" ></script>--%>
  <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
  <script type="text/javascript">
    $(document).ready( function () {
      $('#t3').DataTable();
    } );
  </script>
</head>
<body>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span12">
      <table id="t3" class="display">
        <thead>
        <tr>
          <th hidden>Book Id</th>
          <th>书名</th>
          <th>作者</th>
          <th>上传时间</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.books}" var="book">
          <tr>
            <td hidden>${book.bookid}</td>
            <td>${book.bookname}</td>
            <td>${book.author}</td>
            <td>${book.uploaddate}</td>
            <td><a href="/BookParadise/handlebook/download?bookid=${book.bookid}">Download</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>

