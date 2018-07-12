<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 04.12.2017
  Time: 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login</title>
    <!-- Bootstrap core CSS-->
    <link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/static/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/static/css/sb-admin.css" />" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:url var="loginUrl" value="/login" />
            <form action="${loginUrl}" method="post" >
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p>Invalid username and password.</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-info">
                        <p>You have been loged out</p>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="exampleInputEmail1">Username</label>
                    <input class="form-control" name="username" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input class="form-control" name="password" id="exampleInputPassword1" type="password" placeholder="Password">
                </div>
               <input type="submit" class="btn btn-primary btn-block"  value="Login">
                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
            </form>

        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/static/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/static/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<!-- Core plugin JavaScript-->
<script src="<c:url value="/static/vendor/jquery-easing/jquery.easing.min.js" />"></script>
</body>

</html>

