<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

</head>

<body class="fixed-nav sticky-footer bg-light" id="page-top">
<!-- Navigation-->
<jsp:include page="includes/navbar.jsp"></jsp:include>
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
        <div class="card-header">
        <i class="fa fa-table"></i> List of Cashiers</div>
        <div class="card-body">
        <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Profile</th>

        </tr>
        </thead>
        <tfoot>
        <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Profile</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${cashiers}" var="cashier">
        <tr>
        <td>${cashier.user.username}</td>
        <td>${cashier.user.password}</td>
        <td><a href="<c:url value="/cashier/edit-${cashier.id}"/> " class="btn btn-success mx-auto custom-width">Edit</a></td>
        <td><a href="<c:url value="/cashier/delete-${cashier.id}"></c:url>" class="btn btn-danger mx-auto custom-width">Delete</a></td>
        <td><a href="<c:url value="/cashier/profile-${cashier.id}"/> " class="btn btn-info mx-auto custom-width">View</a></td>


        </tr>
        </c:forEach>



        </tbody>
        </table>
        </div>
        </div>
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
