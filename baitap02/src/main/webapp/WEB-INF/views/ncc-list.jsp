<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Nhà Cung Cấp</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    </head>
    <body class="p-4">
        <div class="container">
            <h2 class="mb-3 text-center">DANH SÁCH NHÀ CUNG CẤP</h2>

            <div class="d-flex justify-content-between mb-3">
                <form:form method="get" action="/ncc" modelAttribute="searchForm" cssClass="d-flex w-50">
                    <form:input path="keyword" cssClass="form-control me-2" placeholder="Tìm theo MÃ/TÊN/ĐỊA CHỈ/SĐT"/>
                    <button class="btn btn-outline-success" type="submit">Tìm</button>
                </form:form>

                <a href="/dt/add" class="btn btn-primary">Thêm điện thoại</a>
            </div>

            <table class="table table-bordered table-striped">
                <thead class="table-light">
                    <tr>
                        <th>Mã NCC</th>
                        <th>Tên</th>
                        <th>Địa chỉ</th>
                        <th>SĐT</th>
                        <th>Điện thoại</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ncc" items="${nccList}">
                        <tr>
                            <td>${ncc.maNcc}</td>
                            <td>${ncc.tenNhaCc}</td>
                            <td>${ncc.diaChi}</td>
                            <td>${ncc.soDienThoai}</td>
                            <td><a class="btn btn-sm btn-outline-primary" href="/dt/ncc/${ncc.maNcc}">Xem danh sách</a></td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty nccList}">
                        <tr><td colspan="5" class="text-center text-muted">Không có dữ liệu</td></tr>
                    </c:if>
                </tbody>
            </table>

            <hr/>
            <a href="/ncc/add" class="btn btn-secondary">+ Thêm NCC (tuỳ chọn)</a>
        </div>
    </body>
</html>
