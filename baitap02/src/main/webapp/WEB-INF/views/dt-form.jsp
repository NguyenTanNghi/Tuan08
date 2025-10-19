<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Thêm điện thoại</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    </head>
    <body class="p-4">
        <div class="container col-md-7">
            <h2 class="mb-3 text-center">THÊM ĐIỆN THOẠI</h2>

            <%--@elvariable id="dt" type=""--%>
            <form:form method="post" modelAttribute="dt" action="/dt/save" enctype="multipart/form-data">

                <div class="mb-3">
                    <label>Mã ĐT *</label>
                    <form:input path="maDt" cssClass="form-control" required="required"/>
                    <form:errors path="maDt" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <label>Tên điện thoại *</label>
                    <form:input path="tenDt" cssClass="form-control" required="required"/>
                    <form:errors path="tenDt" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <label>Năm sản xuất (YYYY) *</label>
                    <form:input path="namSanXuat" cssClass="form-control" required="required" pattern="^[0-9]{4}$"/>
                    <div class="form-text">Phải là số nguyên 4 chữ số</div>
                    <form:errors path="namSanXuat" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <label>Cấu hình (≤ 255 ký tự) *</label>
                    <form:input path="cauHinh" cssClass="form-control" required="required" maxlength="255"
                                pattern="^.{1,255}$"/>
                    <form:errors path="cauHinh" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <label>Nhà cung cấp *</label>
                    <form:select path="nhaCungCap.maNcc" cssClass="form-select" required="required">
                        <form:options items="${nccList}" itemValue="maNcc" itemLabel="tenNhaCc"/>
                    </form:select>
                    <form:errors path="nhaCungCap" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <label>Hình ảnh (png/jpg/jpeg)</label>
                    <input type="file" name="imageFile" class="form-control" accept=".png,.jpg,.jpeg"/>
                </div>

                <a href="/ncc" class="btn btn-secondary">Huỷ</a>
                <button type="submit" class="btn btn-primary">Thêm</button>

            </form:form>
        </div>
    </body>
</html>
