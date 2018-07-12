<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 05.12.2017
  Time: 2:41
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
    <title>User registration</title>
    <!-- Bootstrap core CSS-->
    <link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css" /> " rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/static/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/static/css/sb-admin.css" />" rel="stylesheet">
</head>

<body class="bg-light">
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register a Cashier</div>
        <div class="card-body">
            <form:form method="POST" action="/cashier/registrate" modelAttribute="cashier" class="form-horizontal">

                <div class="form-group">
                    <label for="username">Username</label>
                    <form:input path="username" type="text" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:input path="password" type="password" cssClass="form-control"/>

                </div>
                <div class="form-group">
                    <label for="role">Select Role:</label>
                    <form:select path="role" items="${roles}" multiple="false" itemValue="id" itemLabel="name" class="form-control input-sm" />

                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Register"/>
            </form:form>
            <div class="text-center">
                <a class="d-block small mt-3" href="<c:url value="/"/> ">Go back</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/static/vendor/jquery/jquery.min.js"/> "></script>
<script src="<c:url value="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- Core plugin JavaScript-->
<script src="<c:url value="/static/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
</body>

</html>

