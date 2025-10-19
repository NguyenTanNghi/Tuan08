<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Điện thoại theo NCC</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    </head>
    <body class="p-4">
        <div class="container">
            <h3 class="mb-3">NCC: ${ncc.maNcc} - ${ncc.tenNhaCc}</h3>

            <div class="mb-3 d-flex justify-content-between">
                <a href="/ncc" class="btn btn-secondary">← Danh sách NCC</a>
                <a href="/dt/add?maNcc=${ncc.maNcc}" class="btn btn-primary">+ Thêm điện thoại</a>
            </div>

            <table class="table table-bordered table-striped">
                <thead class="table-light">
                    <tr>
                        <th>Mã ĐT</th>
                        <th>Tên</th>
                        <th>Năm SX</th>
                        <th>Cấu hình</th>
                        <th>Hình ảnh</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dt" items="${dsDienThoai}">
                        <tr>
                            <td>${dt.maDt}</td>
                            <td>${dt.tenDt}</td>
                            <td>${dt.namSanXuat}</td>
                            <td>${dt.cauHinh}</td>
                            <td>
                                <c:if test="${not empty dt.hinhAnh}">
                                    <img src="/uploads/${dt.hinhAnh}" style="height:60px" alt="img"/>
                                </c:if>
                            </td>
                            <td class="text-center">
                                <a href="/dt/delete/${dt.maDt}" class="btn btn-sm btn-outline-danger"
                                   onclick="return confirm('Xoá điện thoại này?')">Xoá</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty dsDienThoai}">
                        <tr><td colspan="6" class="text-center text-muted">Chưa có điện thoại</td></tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>
