<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin người dùng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <section id="user-profile">
        <h2>Thông tin người dùng</h2>
        <form action="${pageContext.request.contextPath}/update-user-profile" method="post">
            <div>
                <label for="fullName">Họ và tên:</label>
                <input type="text" id="fullName" name="fullName" value="${user.fullName}" required>
            </div>
            <div>
                <label for="address">Địa chỉ:</label>
                <input type="text" id="address" name="address" value="${user.address}" required>
            </div>
            <div>
                <label for="phoneNumber">Số điện thoại:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" required>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${user.email}" required>
            </div>
            <div>
                <button type="submit">Cập nhật</button>
            </div>
        </form>
    </section>

    <jsp:include page="footer.jsp" />
</body>
</html>
