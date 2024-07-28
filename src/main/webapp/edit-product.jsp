<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa sản phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
       
        .form-buttons {
            text-align: center;
        }
        .form-buttons button {
            padding: 10px 20px;
            background-color: #007BFF;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-buttons button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h1>Sửa sản phẩm</h1>
    <form action="${pageContext.request.contextPath}/edit-product" method="post" enctype="multipart/form-data">
        <input type="hidden" name="productId" value="${product.productID}">
        <label for="productName">Tên sản phẩm:</label>
        <input type="text" id="productName" name="productName" value="${product.productName}" required>
        <br>
        <label for="description">Mô tả:</label>
        <textarea id="description" name="description" required>${product.description}</textarea>
        <br>
        <label for="price">Giá:</label>
        <input type="text" id="price" name="price" value="${product.price}" required>
        <br>
        <label for="stock">Số lượng:</label>
        <input type="number" id="stock" name="stock" value="${product.stock}" required>
        <br>
        <label for="imageURL">Hình ảnh:</label>
        <input type="file" id="imageURL" name="imageURL" accept="image/*">
        <br>
        <input type="submit" value="Cập nhật sản phẩm">
    </form>
    <jsp:include page="footer.jsp" />
</body>
</html>
