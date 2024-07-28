<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style >
    /* CSS cho phần icon giỏ hàng */
.cart-icon {
    position: relative;
    display: inline-block;
    font-size: 24px;
}

/* CSS cho hình ảnh của giỏ hàng */
.cart-icon-image {
    width: 40px; /* Điều chỉnh kích thước của icon nếu cần */
    height: auto;
}

/* CSS cho số lượng sản phẩm trong giỏ hàng */
#cart-quantity {
    position: absolute;
    top: 1px;
    right: -4px;
    background-color: #5f5e5bb0;
    color: white;
    font-size: 14px;
    font-weight: bold;
    padding: 4px 5px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    min-width: 10px;
    height: 10px;
}
    </style>
</head>
<body>
    <header>
        <h1>Vinh Store</h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                <li class="dropdown">
                    <a href="DanhMucSP.jsp" class="dropbtn">Danh mục</a>
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/vali">Vali</a>
                        <a href="${pageContext.request.contextPath}/tui-xach.jsp">Túi Xách</a>
                        <a href="${pageContext.request.contextPath}/balo.jsp">Balo</a>
                        <a href="${pageContext.request.contextPath}/phu-kien.jsp">Phụ kiện</a>
                    </div>
                </li>
                <li><a href="${pageContext.request.contextPath}/HoTroKhach.jsp">Hỗ trợ khách hàng</a></li>
                <li><a href="${pageContext.request.contextPath}/FAQ.jsp">FAQ</a></li>
                <li><a href="${pageContext.request.contextPath}/about.jsp">Giới thiệu</a></li>
                <c:if test="${sessionScope.role == 'admin'}">
                    <li><a href="${pageContext.request.contextPath}/products">Quản lý sản phẩm</a></li>
                    <li><a href="${pageContext.request.contextPath}/user-management">Quản lý người dùng</a></li>
                </c:if>
            </ul>
            <div class="cart-icon">
    <a href="${pageContext.request.contextPath}/cart.jsp">
        <img src="${pageContext.request.contextPath}/images/cart.png" alt="Giỏ hàng" class="cart-icon-image">
         <span id="cart-quantity">${sessionScope.cartSize}</span>
    </a>
</div>




            <div class="user-icon">
                <a href="#"><i class="fa fa-user" aria-hidden="true"></i></a>
                <div class="user-dropdown-content">
                    <a href="${pageContext.request.contextPath}/UserInfoServlet">Thông tin cá nhân</a>
                    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a> <!-- Chuyển hướng đến LogoutServlet -->
                </div>
            </div>
        </nav>
    </header>
</body>
</html>
