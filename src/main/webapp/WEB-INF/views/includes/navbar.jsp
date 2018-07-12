<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 10.12.2017
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav style="background-color: #eaeaea !important;" class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="mainNav">
    <a class="navbar-brand" href="<c:url value="/"/> ">Web Shop</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">

        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="<c:url value="/" />">
                    <i class="fa fa-fw fa-mail-forward"></i>
                    <span class="nav-link-text">Home</span>
                </a>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/transaction/list"/>">
                        <i class="fa fa-fw fa-sort-numeric-asc"></i>
                        <span class="nav-link-text">Transactions list</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/cashier/list"/>">
                        <i class="fa fa-fw fa-id-badge"></i>
                        <span class="nav-link-text">Cashiers list</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/"/>">
                        <i class="fa fa-fw fa-list-alt"></i>
                        <span class="nav-link-text">Items list</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/registration" />">
                        <i class="fa fa-fw fa-plus-square"></i>
                        <span class="nav-link-text">Add Cashier</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/item/item-creation-page" />">
                        <i class="fa fa-fw fa-table"></i>
                        <span class="nav-link-text">Add Item</span>
                    </a>
                </li>

                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/transaction/statistics" />">
                        <i class="fa fa-fw fa-area-chart"></i>
                        <span class="nav-link-text">Statistics</span>
                    </a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/transaction/list"/>">
                        <i class="fa fa-fw fa-sort-numeric-asc"></i>
                        <span class="nav-link-text">Transations list</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/cashier/profile-${cashier.id}"/>">
                        <i class="fa fa-fw fa-id-badge"></i>
                        <span class="nav-link-text">Profile</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/cashier/edit-${cashier.id}"/>">
                        <i class="fa fa-fw fa-cog"></i>
                        <span class="nav-link-text">Edit Profile</span>
                    </a>
                </li>
            </sec:authorize>


        </ul>



        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-fw fa-sign-out"></i>Logout</a>
            </li>
        </ul>
    </div>
</nav>
