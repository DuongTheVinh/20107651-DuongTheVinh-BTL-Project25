<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Người Dùng - Vinh Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <section id="user-management">
        <h2>Quản Lý Người Dùng</h2>
        <table class="user-table">
            <thead>
                <tr>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.userID}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.fullName}</td>
                        <td>${user.address}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.role}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/edit-user" method="post" style="display:inline;">
                                <input type="hidden" name="userID" value="${user.userID}">
                                <button type="submit" class="edit-btn">Chỉnh sửa</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/deleteUser" method="post" style="display:inline;">
                                <input type="hidden" name="userID" value="${user.userID}">
                                <button type="submit" class="delete-btn">Xóa</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <jsp:include page="footer.jsp" />
</body>
</html>
