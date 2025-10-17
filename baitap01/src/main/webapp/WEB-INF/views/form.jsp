<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Employee Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-5">
<div class="container col-md-6">
    <h2 class="text-center mb-4">
        <c:choose>
            <c:when test="${not empty employee and employee.id ne null}">
                UPDATE EMPLOYEE
            </c:when>
            <c:otherwise>
                REGISTRATION EMPLOYEE
            </c:otherwise>
        </c:choose>

    </h2>

    <%--@elvariable id="employee" type=""--%>
    <form:form action="/save" method="post" modelAttribute="employee">
        <form:hidden path="id"/>

        <div class="mb-3">
            <label>First Name</label>
            <form:input path="firstName" cssClass="form-control"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Last Name</label>
            <form:input path="lastName" cssClass="form-control"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Email</label>
            <form:input path="email" cssClass="form-control"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Date of Birth</label>
            <form:input path="dateOfBirth" type="date" cssClass="form-control"/>
            <form:errors path="dateOfBirth" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Phone number</label>
            <form:input path="phone" cssClass="form-control"/>
            <form:errors path="phone" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Gender</label><br/>
            <form:radiobutton path="gender" value="Male"/> Male
            <form:radiobutton path="gender" value="Female"/> Female
            <form:errors path="gender" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Address</label>
            <form:input path="address" cssClass="form-control"/>
            <form:errors path="address" cssClass="text-danger"/>
        </div>

        <a href="/" class="btn btn-secondary">Back</a>
        <button type="submit" class="btn btn-primary">Save</button>
    </form:form>

</div>
</body>
</html>
