<!-- src/main/webapp/WEB-INF/views/DanhMucSP.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Mục Sản Phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <section id="categories">
        <h2>Danh Mục Sản Phẩm</h2>
        <div class="category">
            <h3><a href="${pageContext.request.contextPath}/vali">Vali</a></h3>
            <p>Các loại vali chất lượng cao từ Vinh Store</p>
        </div>
        <div class="category">
            <h3><a href="tui-xach.jsp">Túi Xách</a></h3>
            <p>Các loại túi xách thời trang từ Vinh Store</p>
        </div>
        <div class="category">
            <h3><a href="balo.jsp">Balo</a></h3>
            <p>Các loại balo du lịch đa năng và thời trang từ Vinh Store</p>
        </div>
        <div class="category">
            <h3><a href="phu-kien.jsp">Phụ Kiện</a></h3>
            <p>Phụ kiện dành cho vali và túi xách từ Vinh Store</p>
        </div>
    </section>

    <jsp:include page="footer.jsp" />
</body>
</html>
