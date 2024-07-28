<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Người Dùng - Vinh Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <section id="edit-user">
        <h2>Chỉnh Sửa Người Dùng</h2>
        <form action="${pageContext.request.contextPath}/updateUser" method="post">
            <input type="hidden" name="userID" value="${user.userID}">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" readonly>
            
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" value="${user.fullName}" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${user.address}">
            
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}">
            
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value="user" ${user.role == 'user' ? 'selected' : ''}>User</option>
                <option value="admin" ${user.role == 'admin' ? 'selected' : ''}>Admin</option>
            </select>
            
            <button type="submit" class="save-btn">Lưu thay đổi</button>
        </form>
    </section>
    <jsp:include page="footer.jsp" />
</body>
</html>
