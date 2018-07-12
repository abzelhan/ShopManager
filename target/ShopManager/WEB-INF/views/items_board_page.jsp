<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 05.12.2017
  Time: 2:11
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
    <title>SB Admin</title>
    <!-- Bootstrap core CSS-->
    <link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/static/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <!-- Page level plugin CSS-->
    <link href="<c:url value="/static/vendor/datatables/dataTables.bootstrap4.css" />" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/static/css/sb-admin.css" />" rel="stylesheet">

    <style>
        .thumbnail {
            position: relative;
            width: auto;
            height: 200px;
            overflow: hidden;
        }
        .thumbnail img {
            position: absolute;
            left: 50%;
            top: 50%;
            height: 100%;
            width: auto;
            -webkit-transform: translate(-50%,-50%);
            -ms-transform: translate(-50%,-50%);
            transform: translate(-50%,-50%);
        }
        .thumbnail img.portrait {
            width: 100%;
            height: auto;
        }
    </style>
</head>

<body class="fixed-nav sticky-footer bg-light" id="page-top">
<!-- Navigation-->
<jsp:include page="includes/navbar.jsp"></jsp:include>
<div class="content-wrapper">
    <div class="container-fluid">
        <h1>Items</h1>
        <hr>
        <!-- Example DataTables Card-->
        <div class="row w-75 mx-auto">

            <c:forEach items="${items}" var="item">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card ">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="#">
                                <div class="thumbnail mx-auto">
                                    <img  class="portrait" src="${item.imageUrl}" alt="">
                                </div>
                            </a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">${item.name}</a>
                                </h4>
                                <h5>$${item.price}</h5>
                                <p>${item.description}</p>
                                <h6>Available:${item.amount}</h6>
                            </div>
                            <div class="card-footer">
                                <a href="<c:url value="/item/edit-${item.id}"></c:url>" class="btn btn-success">Edit</a>
                                <a href="<c:url value="/item/delete-${item.id}"></c:url>" class="btn btn-danger">Remove</a>

                            </div>
                        </sec:authorize>

                        <sec:authorize access="hasRole('ROLE_USER')">

                        <c:if test="${item.amount != 0}">
                            <a href="#">
                                <div class="thumbnail mx-auto">
                                    <img  class="portrait" src="${item.imageUrl}" alt="">
                                </div>
                            </a>
                        </c:if>
                        <c:if test="${item.amount == 0}">
                            <a href="#">
                                <div class="thumbnail mx-auto">
                                    <img style="   -webkit-filter: grayscale(100%);filter: grayscale(100%);" class="portrait" src="${item.imageUrl}" alt="">
                                </div>
                            </a>
                        <div  class="card-img-overlay mx-auto">
                            <h4 class="card-title">
                                <a style="color:white;">Not available</a>
                            </h4>
                        </div>
                        </c:if>

                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">${item.name}</a>
                            </h4>
                            <h5>$${item.price}</h5>
                            <p>${item.description}</p>
                            <h6>Available:${item.amount}</h6>
                                <c:if test="${item.amount != 0}">
                                    <form method="post" action="/transaction/create-${cashier.id}-${item.id}">
                                        <input type="hidden"
                                               name="${_csrf.parameterName}"
                                               value="${_csrf.token}"/>
                                        <div class="form-group">
                                            <label for="quantity">Quantity:</label>
                                            <select id="quantity" name="amount" >
                                                <c:forEach var="i" begin="1" end="${item.amount}">
                                                    <option value="${i}">${i}</option>
                                                </c:forEach>

                                            </select>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Sell"/>

                                    </form>

                                </c:if>
                        </div>
                        </sec:authorize>


                    </div>
                </div>

            </c:forEach>





        </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © Abzal Sahitov 2017</small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="<c:url value="/logout" /> ">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="/static/vendor/jquery/jquery.min.js" /> "></script>
    <script src="<c:url value="/static/vendor/bootstrap/js/bootstrap.bundle.min.js" /> "></script>
    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/static/vendor/jquery-easing/jquery.easing.min.js" />"></script>
    <!-- Page level plugin JavaScript-->
    <script src="<c:url value="/static/vendor/datatables/jquery.dataTables.js" /> "></script>
    <script src="<c:url value="/static/vendor/datatables/dataTables.bootstrap4.js" /> "></script>
    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/static/js/sb-admin.min.js" /> "></script>
    <!-- Custom scripts for this page-->
    <script src="<c:url value="/static/js/sb-admin-datatables.min.js" /> "></script>


</div>
</body>

</html>
