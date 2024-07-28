<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Access Denied</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <section id="access-denied">
        <h2>Access Denied</h2>
        <p>Bạn không có quyền truy cập vào trang này.</p>
        <a href="${pageContext.request.contextPath}/index.jsp">Trở về trang chủ</a>
    </section>

    <jsp:include page="footer.jsp" />
</body>
</html>
