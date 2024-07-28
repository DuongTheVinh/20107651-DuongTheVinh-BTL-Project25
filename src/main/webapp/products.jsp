<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
      
        .action-buttons a, .action-buttons form {
            display: inline-block;
            margin-right: 5px;
        }
        .action-buttons a, .action-buttons button {
            padding: 5px 10px;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 3px;
        }
        .action-buttons button {
            cursor: pointer;
        }
        .action-buttons a:hover, .action-buttons button:hover {
            background-color: #0056b3;
        }
        .add-product-button {
            margin: 20px 0;
            text-align: right;
        }
        .add-product-button a {
            padding: 10px 20px;
            text-decoration: none;
            color: white;
            background-color: #28a745;
            border-radius: 5px;
        }
        .add-product-button a:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />

    <h1>Quản lý sản phẩm</h1>
    <a href="${pageContext.request.contextPath}/add-product.jsp">Thêm sản phẩm mới</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Mô tả</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Hình ảnh</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach var="product" items="${productList}">
         
            <tr>
                <td>${product.productID}</td>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.stock}</td>
                <td><img src="${product.imageURL}" alt="${product.productName}" width="50"></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit-product.jsp?productId=${product.productID}">Sửa</a> |
                    <form action="${pageContext.request.contextPath}/delete-product" method="post" style="display:inline;">
                        <input type="hidden" name="productId" value="${product.productID}">
                        <input type="submit" value="Xóa">
                    </form>
                </td>
            </tr>
           
        </c:forEach>
    </table>

    <jsp:include page="footer.jsp" />
</body>
</html>
