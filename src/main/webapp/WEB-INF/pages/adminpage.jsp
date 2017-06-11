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
    <title>Administrator Page</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/bookinfor.js" ></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.dataTables.js" ></script>--%>
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
        $(document).ready( function () {
            $('#t1').DataTable();
            $('#t2').DataTable();
        } );
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3>
                管理员主页
            </h3>
            <div class="tabbable" id="tabs-505233">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#panel-434112" data-toggle="tab">图书信息</a>
                    </li>
                    <li>
                        <a href="#panel-386025" data-toggle="tab">用户信息</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-434112">
                        <div class="row">
                            <div class="col-md-9">
                                <table id="t1" class="display" width="95%">
                                    <thead>
                                    <tr>
                                        <th hidden>Book Id</th>
                                        <th>Book Name</th>
                                        <th>Auhtor</th>
                                        <th>User ID</th>
                                        <th>Update Time</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.books}" var="book">
                                        <tr>
                                            <td hidden>${book.bookid}</td>
                                            <td>${book.bookname}</td>
                                            <td>${book.author}</td>
                                            <td>${book.personid}</td>
                                            <td>${book.uploaddate}</td>
                                            <td><a href="/BookParadise/handlebook/edit?bookid=${book.bookid}">Edit</a></td>
                                            <td><a href="/BookParadise/handlebook/delete?bookid=${book.bookid}">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="panel-386025">
                        <div class="row">
                            <div class="col-md-9">
                                <table id="t2" class="display" width="95%">
                                    <thead>
                                    <tr>
                                        <th hidden>User Id</th>
                                        <th>User Name</th>
                                        <th>Gender</th>
                                        <th>Birthday</th>
                                        <th>Education</th>
                                        <th>Hobby</th>
                                        <th>Motto</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.users}" var="user">
                                        <tr>
                                            <td hidden>${user.userid}</td>
                                            <td>${user.username}</td>
                                            <td>${user.gender}</td>
                                            <td>${user.birthday}</td>
                                            <td>${user.education}</td>
                                            <td>${user.hobby}</td>
                                            <td>${user.motto}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
