<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body>
    <jsp:include page="header.jsp" />
    
     <section id="hero">
        <h2>Chào mừng đến với Vinh Store</h2>
        <p>Chuyên cung cấp các loại vali và túi xách chất lượng từ Vinh Store</p>
        <a href="DanhMucSP.jsp" class="button">Xem Sản Phẩm</a>
    </section>

    <section id="featured-products">
        <h2>Sản phẩm nổi bật</h2>
        <div class="carousel-container">
            <button class="carousel-button prev-button" onclick="scrollCarousel(-1)">&#10094;</button>
            <div class="carousel">
                <c:forEach var="product" items="${products}">
    <div class="carousel-item">
        <a href="${pageContext.request.contextPath}/product-detail?productID=${product.productID}">
    <img src="${product.imageURL}" alt="${product.productName}" class="product-image"/>
</a>
        <div class="product-info">
           <h3 class="product-name">
    <a href="${pageContext.request.contextPath}/product-detail?productID=${product.productID}">${product.productName}</a>
</h3>
            <p class="product-price">${product.price} đ</p>
        </div>
    </div>
</c:forEach>
                
            </div>
            <button class="carousel-button next-button" onclick="scrollCarousel(1)">&#10095;</button>
        </div>
    </section>
    
    <section id="faq">
        <h2>Câu Hỏi Thường Gặp</h2>
        <div class="faq-item">
            <h3>Vinh Store có các loại vali nào?</h3>
            <p>Chúng tôi có các loại vali với nhiều kích thước và màu sắc khác nhau.</p>
        </div>
        <div class="faq-item">
            <h3>Sản phẩm của Vinh Store có bảo hành không?</h3>
            <p>Chúng tôi cung cấp bảo hành cho tất cả sản phẩm.</p>
        </div>
        <div class="faq-item">
            <h3>Làm thế nào để mua hàng?</h3>
            <p>Bạn có thể đặt hàng trực tuyến hoặc đến cửa hàng của chúng tôi.</p>
        </div>
        <div class="faq-item">
            <h3>Có những phương thức thanh toán nào?</h3>
            <p>Chúng tôi chấp nhận thanh toán bằng tiền mặt, thẻ tín dụng và chuyển khoản ngân hàng.</p>
        </div>
        <div class="faq-item">
            <h3>Tôi có thể đổi trả sản phẩm không?</h3>
            <p>Chúng tôi có chính sách đổi trả trong vòng 30 ngày.</p>
        </div>
        <div class="faq-item">
            <h3>Vinh Store có giao hàng toàn quốc không?</h3>
            <p>Chúng tôi có dịch vụ giao hàng toàn quốc.</p>
        </div>
    </section>
    <section id="contact-form">
        <h2>Liên Hệ Với Chúng Tôi</h2>
        <form action="#" method="post">
            <label for="name">Tên:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="phone">Số điện thoại:</label>
            <input type="number" id="phone" name="phone" required>
            
            <label for="message">Nội dung:</label>
            <textarea id="message" name="message" required></textarea>
            
            <button type="submit">Gửi</button>
        </form>
    </section>

    <jsp:include page="footer.jsp" />
</body>
</html>
