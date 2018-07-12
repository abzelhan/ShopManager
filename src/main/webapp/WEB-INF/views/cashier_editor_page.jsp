<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11.12.2017
  Time: 0:19
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
    <title>SB Admin - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS-->
    <link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css" /> " rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/static/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/static/css/sb-admin.css" />" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Cashier profile Info</div>
        <div class="card-body">
            <form method="post" action="<c:url value="/cashier/update-${cashier.id}"></c:url> " class="form-horizontal" >
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <label for="exampleInputName">First name</label>
                            <input class="form-control" name="name" id="exampleInputName" type="text" value="${cashier.name}"  placeholder="Enter first name"/>
                        </div>
                        <div class="col-md-6">
                            <label for="exampleInputLastName">Last name</label>
                            <input  class="form-control" name="surname" id="exampleInputLastName" type="text" value="${cashier.surname}"  placeholder="Enter last name"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label  for="birthDate">Birth date </label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar">
                                </i>
                            </div>
                            <input  class="form-control" name="birth_date"
                                   type="date" id="birthDate" value="${cashier.birthDate}"/></div>
                </div>
                <div class="form-group">
                    <label  for="gender">Gender</label>

                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-child">
                            </i>
                        </div>


                        <select name="gender" class="form-control" id="gender">
                                <c:choose>
                                    <c:when test="${cashier.gender == null}">
                                        <option value="male" selected>Male</option>
                                        <option value="female">Female</option>
                                        <option value="trans">Trans</option>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                        <c:when test="${cashier.gender == 'male'}">
                                            <option value="male" selected>Male</option>
                                            <option value="female">Female</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="male" >Male</option>
                                            <option value="female" selected>Female</option>
                                        </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>






                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label  for="phone_number">Phone number</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-phone">
                                </i>
                            </div>
                            <input  id="phone_number" name="phone"
                                   type="text" placeholder="Phone number" value="${cashier.phone}" class="form-control input-md"/>
                        </div>

                </div>

                <div class="form-group">
                    <label  for="email">Email</label>

                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-envelope">
                                </i>
                            </div>
                            <input id="email" name="email" type="email"
                                   placeholder="Email in format xxx@gmail.com"
                                   value="${cashier.email}"
                                   class="form-control input-md"/>
                        </div>

                </div>

                <div class="form-group">
                    <label  for="imageURL">Image URL path</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-image">
                                </i>
                            </div>
                            <input value="${cashier.imageUrl}" id="imageURL" name="imageUrl"
                                   type="text" placeholder="URL" class="form-control input-md"/>
                        </div>

                </div>

                <br>
                <div class="mx-auto">
                    <input type="submit" class="btn btn-primary btn-block" value="Submit"/>
                </div>
                <div class="text-center">
                    <a class="d-block small mt-3" href="<c:url value="/"/> ">Go back</a>
                </div>

            </form>

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

