<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Thêm NCC</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    </head>
    <body class="p-4">
        <div class="container col-md-6">
            <h2 class="mb-3 text-center">THÊM NHÀ CUNG CẤP</h2>
            <form:form method="post" action="/ncc/save" modelAttribute="ncc">
                <div class="mb-3">
                    <label>Mã NCC</label>
                    <form:input path="maNcc" cssClass="form-control"/>
                    <form:errors path="maNcc" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label>Tên NCC</label>
                    <form:input path="tenNhaCc" cssClass="form-control"/>
                    <form:errors path="tenNhaCc" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label>Địa chỉ</label>
                    <form:input path="diaChi" cssClass="form-control"/>
                    <form:errors path="diaChi" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label>Số điện thoại</label>
                    <form:input path="soDienThoai" cssClass="form-control"/>
                    <form:errors path="soDienThoai" cssClass="text-danger"/>
                </div>
                <a href="/ncc" class="btn btn-secondary">Quay lại</a>
                <button class="btn btn-primary" type="submit">Lưu</button>
            </form:form>
        </div>
    </body>
</html>
