<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vali</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <section id="filters">
        <form method="get" action="${pageContext.request.contextPath}/vali">
            <button type="submit" name="filter" value="">Tất cả Vali</button>
            <c:forEach var="filter" items="${valiFilters}">
                <button type="submit" name="filter" value="${filter.filterName}">${filter.filterName}</button>
            </c:forEach>
        </form>
    </section>

    <section id="products">
        <h2>Vali</h2>
        <div class="product-list">
            <c:forEach var="product" items="${valiProducts}">
                <div class="product-item">
                    <a href="${pageContext.request.contextPath}/product-detail?productID=${product.productID}">
    					<img src="${product.imageURL}" alt="${product.productName}" class="product-image"/>
					</a>
                    <div class="product-info">
                        <h3 class="product-name">
                            <a href="${pageContext.request.contextPath}/product-detail?productID=${product.productID}">${product.productName}</a>
                        </h3>
                        <p class="product-description">${product.description}</p>
                        <p class="product-price">${product.price} đ</p>
                        <form method="post" action="${pageContext.request.contextPath}/vali">
                            <input type="hidden" name="productId" value="${product.productID}">
                            
                            
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>

    <jsp:include page="footer.jsp" />
</body>
</html>
