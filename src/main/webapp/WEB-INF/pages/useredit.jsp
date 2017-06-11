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
  <title>User Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/bootstrap/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/bootstrap-datepicker/css/bootstrap-datetimepicker.min.css"/>
  <%--<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.11.1.js"></script>--%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.validate.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap-datepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assert/bootstrap-datepicker/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/userinfor.js" ></script>  \
  <script type="text/javascript">
    $(document).ready(function(){

    });
  </script>
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
          <h3 class="panel-title">User Information ( * means Required )</h3>
        </div>
        <div class="panel-body">
          <form id="signupForm" method="post" class="form-horizontal" action="<%= request.getContextPath()%>/handleuser/update">
            <div class="form-group" hidden>
              <label class="col-sm-4 control-label" for="userid">User ID</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="userid" name="userid" placeholder="userid" value="${useredit.userid}" contenteditable="false"/>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="username">Username</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username"  value="${useredit.username}"/>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="gender">Gender</label>
              <div class="col-sm-5">
                <select id="gender" name="gender" class="form-control">
                  <c:if test="${useredit.gender=='Male'}">
                    <option id="option0" selected>Male</option>
                    <option id="option1">Female</option>
                  </c:if>
                  <c:if test="${useredit.gender}=='Female'">
                    <option id="option0">Male</option>
                    <option id="option1" selected>Female</option>
                  </c:if>
                  <c:if test="${useredit.gender}=='Male'">
                    Male
                  </c:if>
                  <c:if test="${useredit.gender}=='Female'">
                    Female
                  </c:if>
                </select>
              </div>
              <div><p style="color:red">*</p></div>
            </div>

            <div class="form-group">
              <label for="birthday" class="col-sm-4 control-label">Birthday</label>
              <div class="input-group date form_date col-sm-5" data-date="" data-date-format="dd MM yyyy" data-link-format="yyyy-mm-dd">
                <input id="birthday" name="birthday" class="form-control" placeholder="Birthday" size="16" type="text" value="${useredit.birthday}" readonly>
                <%--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>--%>
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
              </div>
              <div><p style="color:red">*</p></div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="education">Eduction</label>
              <div class="col-sm-5">
                <%--<input type="text" class="form-control" id="education" name="education" placeholder="Education" />--%>
                  <c:if test="${useredit.education=='Bachelor'}">
                    <select id="education" name="education" class="form-control">
                      <option id="edu_option1" selected>Bachelor</option>
                      <option id="edu_option2">Master</option>
                      <option id="edu_option3">Doctor</option>
                    </select>
                  </c:if>
                  <c:if test="${useredit.education=='Master'}">
                    <select id="education" name="education" class="form-control">
                      <option id="edu_option1">Bachelor</option>
                      <option id="edu_option2" selected>Master</option>
                      <option id="edu_option3">Doctor</option>
                    </select>
                  </c:if>
                  <c:if test="${useredit.education=='Doctor'}">
                    <select id="education" name="education" class="form-control">
                      <option id="edu_option1">Bachelor</option>
                      <option id="edu_option2">Master</option>
                      <option id="edu_option3" selected>Doctor</option>
                    </select>
                  </c:if>
              </div>
              <div><p style="color:red">*</p></div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="hobby">Hobby</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="hobby" name="hobby" placeholder="Hobby" value="${useredit.hobby}"/>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-4 control-label" for="motto">Motto</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="motto" name="motto" placeholder="Motto" value="${useredit.motto}"/>
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-9 col-sm-offset-4">
                <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Submit</button>
              </div>
            </div>

            <div class="form-group" hidden>
              <div class="col-sm-5 col-sm-offset-4">
                <div class="checkbox">
                  <label>
                    <input type="checkbox" id="agree" name="agree" value="agree" checked/>Please agree to our policy
                  </label>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
