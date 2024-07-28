<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm sản phẩm mới</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
        

        .form-buttons {
            text-align: center;
        }
        .form-buttons button {
            padding: 10px 20px;
            background-color: #28a745;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-buttons button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h1>Thêm sản phẩm mới</h1>
    <form action="${pageContext.request.contextPath}/add-product" method="post" enctype="multipart/form-data">
        <label for="productName">Tên sản phẩm:</label>
        <input type="text" id="productName" name="productName" required>
        <br>
        <label for="description">Mô tả:</label>
        <textarea id="description" name="description" required></textarea>
        <br>
        <label for="price">Giá:</label>
        <input type="text" id="price" name="price" required>
        <br>
        <label for="stock">Số lượng:</label>
        <input type="number" id="stock" name="stock" required>
        <br>
        <label for="imageURL">Hình ảnh:</label>
        <input type="file" id="imageURL" name="imageURL" accept="image/*" required>
        <br>
        <input type="submit" value="Thêm sản phẩm">
    </form>
    <jsp:include page="footer.jsp" />
</body>
</html>
