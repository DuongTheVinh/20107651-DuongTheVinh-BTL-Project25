<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <section id="cart">
        <h2>Giỏ hàng của bạn</h2>
        <c:choose>
            <c:when test="${empty cart.items}">
                <p>Giỏ hàng của bạn đang trống.</p>
            </c:when>
            <c:otherwise>
               
                    <table>
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng</th>
                            <th>Hành động</th>
                        </tr>
                        <c:forEach var="item" items="${cart.items}">
    <tr>
        <td>
            <img src="${item.product.imageURL}" alt="${item.product.productName}" style="width:50px;">
            ${item.product.productName}
        </td>
        <td>
            ${item.product.price} đ
        </td>
        <td>
            <form method="post" action="${pageContext.request.contextPath}/update-quantity">
                <input type="number" name="quantity" value="${item.quantity}" min="1">
                <input type="hidden" name="productId" value="${item.product.productID}">
                <button type="submit">Cập nhật</button>
            </form>
        </td>
        <td>
            ${item.totalPrice} đ
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/remove-item" method="post">
                <input type="hidden" name="productId" value="${item.product.productID}">
                <button type="submit">Xóa</button>
            </form>
        </td>
    </tr>
</c:forEach>
                        
                    </table>

                    <div class="cart-summary">
                        <p>Tổng tiền sản phẩm: ${cart.totalPrice} đ</p>
                    </div>
 <form action="${pageContext.request.contextPath}/checkout.jsp" method="post">
                    <div class="cart-actions" style="text-align:center;">
                        <button type="submit" class="checkout-button">Đặt hàng ${cart.totalPrice} đ</button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </section>
    <jsp:include page="footer.jsp" />
</body>
</html>
