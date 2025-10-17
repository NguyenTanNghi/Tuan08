<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-4">
<div class="container">

    <h2 class="text-center mb-4">EMPLOYEE LIST</h2>

    <!-- Search Form -->
    <div class="d-flex justify-content-between mb-3">
        <%--@elvariable id="searchForm" type=""--%>
        <form:form method="get" action="/" modelAttribute="searchForm" cssClass="d-flex">
            <form:input path="keyword" cssClass="form-control me-2" placeholder="Search by name or email"/>
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form:form>

        <a href="add" class="btn btn-primary">Add Employee</a>
    </div>

    <!-- Employee Table -->
    <table class="table table-bordered table-striped">
        <thead class="table-light text-center">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${employees}">
            <tr>
                <td>${e.firstName}</td>
                <td>${e.lastName}</td>
                <td>${e.gender}</td>
                <td>${e.dateOfBirth}</td>
                <td>${e.email}</td>
                <td>${e.phone}</td>
                <td class="text-center">
                    <a href="edit/${e.id}" class="btn btn-sm btn-outline-primary">Edit</a>
                    <a href="delete/${e.id}" class="btn btn-sm btn-outline-danger"
                       onclick="return confirm('Delete this employee?')">Delete</a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty employees}">
            <tr>
                <td colspan="7" class="text-center text-muted">No employees found</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>
