	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html lang="vi">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>${product.productName}</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
	</head>
	<body>
	    <jsp:include page="header.jsp" />
	
	    <section id="product-detail">
	        <div class="product-detail-container">
	            <div class="product-images">
	                <img src="${product.imageURL}" alt="${product.productName}">
	            </div>
	            <div class="product-info">
	                <h2>${product.productName}</h2>
	                <p class="price">${product.price} đ</p>
	                <div class="product-description">${product.description}</div>
	                <form method="post" action="${pageContext.request.contextPath}/add-to-cart">
	                    <input type="hidden" name="productId" value="${product.productID}">
	                    <div class="form-group">
	                        <label for="quantity">Số lượng:</label>
	                        <input type="number" id="quantity" name="quantity" value="1" min="1">
	                    </div>
	                    <div class="form-buttons">
	                        <button type="submit" class="${pageContext.request.contextPath}/cart">Thêm vào giỏ hàng</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	       
	        <div class="promotions">
	        <h3>KHUYẾN MÃI - ƯU ĐÃI</h3>
	        <p><i class="fas fa-gift"></i> "Tặng nóng" 1.500.000đ khi mua hóa đơn từ 7.000.000đ</p>
	        <p><i class="fas fa-gift"></i> "Tặng nóng" 1.000.000đ khi mua hóa đơn từ 6.000.000đ</p>
	        <p><i class="fas fa-gift"></i> "Tặng nóng" 500.000đ khi mua hóa đơn từ 5.000.000đ</p>
	    </div>
	    <div class="additional-info">
	        <h3>Thông tin bổ sung</h3>
	        <p class="info-item"><i class="fas fa-shipping-fast"></i> Freeship đơn hàng online từ 1,000,000đ</p>
	        <p class="info-item"><i class="fas fa-truck"></i> Giao hàng hỏa tốc 2H (Điều kiện áp dụng)</p>
	        <p class="info-item"><i class="fas fa-exchange-alt"></i> Đổi trả trong 7 ngày nếu bị lỗi kỹ thuật</p>
	    </div>
	    
	    </section>
	    
	    <c:if test="${param.added eq 'true'}">
	    <div class="notification">
	        <p>Sản phẩm <strong>${addedProduct.productName}</strong> đã được thêm vào giỏ hàng!</p>
	        <img src="${addedProduct.imageURL}" alt="${addedProduct.productName}" style="width:50px; height:50px;">
	    </div>
	</c:if>
	    
	    <c:if test="${not empty errorMessage}">
	        <div class="error">
	            <p>${errorMessage}</p>
	        </div>
	    </c:if>
	
	    <jsp:include page="footer.jsp" />
	    <script>
	    function addToCart(productId, quantity) {
	        var xhr = new XMLHttpRequest();
	        xhr.open("POST", "${pageContext.request.contextPath}/add-to-cart", true);
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	        xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
	        xhr.onreadystatechange = function() {
	            if (xhr.readyState == 4 && xhr.status == 200) {
	                // Cập nhật số lượng sản phẩm trên icon giỏ hàng
	                document.getElementById("cart-quantity").innerText = xhr.responseText;
	            }
	        };
	        xhr.send("productId=" + productId + "&quantity=" + quantity);
	    }

</script>
	    
	</body>
	</html>
