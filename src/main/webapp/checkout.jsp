<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh toán</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style >
    /* styles.css */

#checkout {
    width: 80%;
    margin: auto;
}

#checkout h2 {
    text-align: center;
    margin-bottom: 20px;
}

#checkout form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

#checkout form div {
    margin-bottom: 15px;
    width: 100%;
}

#checkout form div label {
    display: inline-block;
    width: 150px;
    text-align: right;
}

#checkout form div input,
#checkout form div select {
    width: 300px;
    padding: 5px;
}

#checkout .cart-summary {
    margin-top: 20px;
    text-align: right;
    font-weight: bold;
}

#checkout .error {
    color: red;
    text-align: center;
    margin-top: 20px;
}
    
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <section id="checkout">
        <h2>Thanh toán</h2>
        <form method="post" action="${pageContext.request.contextPath}/place-order">
            <div>
                <label for="fullName">Họ và tên:</label>
                <input type="text" id="fullName" name="fullName" required>
            </div>
            <div>
                <label for="phone">Số điện thoại:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div>
                <label for="address">Địa chỉ:</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div>
                <label for="paymentMethod">Phương thức thanh toán:</label>
                <select id="paymentMethod" name="paymentMethod" required>
                    <option value="cod">Thanh toán COD</option>
                    <option value="smartbanking">Thanh toán qua Smartbanking</option>
                    <option value="zalopay">Thanh toán qua ZaloPay</option>
                    <option value="momo">Thanh toán qua MoMo</option>
                </select>
            </div>
            <div>
                <h3>Thông tin đơn hàng</h3>
                <c:forEach var="item" items="${cart.items}">
                    <p>${item.product.productName} - Số lượng: ${item.quantity} - Giá: ${item.totalPrice}</p>
                </c:forEach>
                <p><strong>Tổng tiền: ${cart.totalPrice}</strong></p>
            </div>
            <button type="submit">Đặt hàng</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <p class="error">${errorMessage}</p>
        </c:if>
    </section>
    <jsp:include page="footer.jsp" />
</body>
</html>
