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
  <%--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.11.1.js"></script>--%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.validate.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap-datepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap-datepicker/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/bookinfor.js" ></script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-8 col-sm-offset-2">
      <div class="page-header">
        <div class="alert alert-info" role="alert">
          <h3>Please Input Information</h3>
        </div>
      </div>

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Book Details ( * means Required )</h3>
        </div>
        <div class="panel-body">
          <form id="bookForm" method="post" class="form-horizontal" enctype="multipart/form-data" action="<%= request.getContextPath()%>/handlebook/add">

            <div class="form-group">
              <label class="col-sm-4 control-label" for="bookname">Book Name</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="bookname" name="bookname" placeholder="Bookname" />
              </div>
              <div><p style="color:red">*</p></div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="author">Author</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="author" name="author" placeholder="Author" />
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="uploadpdf">File</label>
              <div class="col-sm-5">
                <input type="file" class="form-control"  id="uploadpdf" name="uploadpdf"  placeholder="Uploadpdf" />
              </div>
              <div><p style="color:red">*</p></div>
            </div>


            <div class="form-group">
              <div class="col-sm-9 col-sm-offset-4">
                <button type="submit" class="btn btn-primary" name="commit" value="Commit">Submit</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
  </div>
</div>
</body>
</html>
