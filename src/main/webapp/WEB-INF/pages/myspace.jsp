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
  <title>Book Page</title>
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
      $('#btn1').click(function(){
          var href = "/BookParadise/bookpage";
          window.location.href = href;
      });
      $('#btn2').click(function(){
        var href = "/BookParadise/handleuser/useredit";
        window.location.href = href;
      });
    } );
  </script>
</head>
<body>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span12">
      <h3>
        个人空间 <button id="btn1" class="btn btn-lg btn-primary">上传</button>
      </h3>
      <div class="tabbable" id="tabs-505233">
        <ul class="nav nav-tabs">
          <li class="active">
            <a href="#panel-434112" data-toggle="tab">上传的书</a>
          </li>
          <li>
            <a href="#panel-386025" data-toggle="tab">收藏的书</a>
          </li>
          <li>
            <a href="#panel-386030" data-toggle="tab">个人信息</a>
          </li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="panel-434112">
            <table id="t1" class="display">
              <thead>
              <tr>
                <th hidden>Book Id</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Update Time</th>
                <th></th>
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
                  <td>${book.uploaddate}</td>
                  <td><a href="/BookParadise/handlebook/download?bookid=${book.bookid}">Download</a></td>
                  <td><a href="/BookParadise/handlebook/edit?bookid=${book.bookid}">Edit</a></td>
                  <td><a href="/BookParadise/handlebook/delete?bookid=${book.bookid}">Delete</a></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
          <div class="tab-pane" id="panel-386025">
            <table id="t2" class="display">
              <thead>
              <tr>
                <th>Column 1</th>
                <th>Column 2</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>Row 1 Data 1</td>
                <td>Row 1 Data 2</td>
              </tr>
              <tr>
                <td>Row 2 Data 1</td>
                <td>Row 2 Data 2</td>
              </tr>
              </tbody>
            </table>
          </div>
          <div class="tab-pane" id="panel-386030">
            <div class="row">
              <div class="col-md-3">
                <br>
                <button id="btn2" class="btn btn-lg btn-primary">编辑</button>
                <br>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-md-6">
                <table id="t3" class="table table-bordered table-striped" >
                  <thead>
                  <tr>
                    <th hidden></th>
                    <th></th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td hidden>1</td>
                    <td>User Name</td>
                    <td>${user.username}</td>
                  </tr>
                  <tr>
                    <td hidden>2</td>
                    <td>Gender</td>
                    <td>${user.gender}</td>
                  </tr>
                  <tr>
                    <td hidden>3</td>
                    <td>Birthday</td>
                    <td>${user.birthday}</td>
                  </tr>
                  <tr>
                    <td hidden>4</td>
                    <td>Education</td>
                    <td>${user.education}</td>
                  </tr>
                  <tr>
                    <td hidden>5</td>
                    <td>Hobby</td>
                    <td>${user.hobby}</td>
                  </tr>
                  <tr>
                    <td hidden>6</td>
                    <td>Motto</td>
                    <td>${user.motto}</td>
                  </tr>
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
