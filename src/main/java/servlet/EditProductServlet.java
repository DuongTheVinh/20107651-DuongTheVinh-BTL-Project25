package servlet;

import model.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/edit-product")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String productIdStr = request.getParameter("productID");
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            String priceStr = request.getParameter("price");
            String stockStr = request.getParameter("stock");
            String categoryIDStr = request.getParameter("categoryID");

            // Kiểm tra các giá trị đầu vào, đặc biệt là các trường hợp null hoặc rỗng
            if (productIdStr == null || productIdStr.isEmpty() ||
                productName == null || productName.isEmpty() ||
                description == null || description.isEmpty() ||
                priceStr == null || priceStr.isEmpty() ||
                stockStr == null || stockStr.isEmpty() ||
                categoryIDStr == null || categoryIDStr.isEmpty()) {
                // Xử lý lỗi nếu có bất kỳ trường nào rỗng
                request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin sản phẩm.");
                request.getRequestDispatcher("edit-product.jsp").forward(request, response);
                return;
            }

            // Chuyển đổi các giá trị từ chuỗi sang kiểu dữ liệu thích hợp
            int productId = Integer.parseInt(productIdStr);
            BigDecimal price = new BigDecimal(priceStr);
            int stock = Integer.parseInt(stockStr);
            int categoryID = Integer.parseInt(categoryIDStr);

            // Tạo đối tượng Product và thiết lập các thuộc tính
            Product product = new Product();
            product.setProductID(productId);
            product.setProductName(productName);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategoryID(categoryID);

            // Sử dụng ProductDAO để cập nhật thông tin sản phẩm
            ProductDAO productDAO = new ProductDAO();
            productDAO.updateProduct(product);

            response.sendRedirect("products.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật sản phẩm. Vui lòng thử lại.");
            request.getRequestDispatcher("edit-product.jsp").forward(request, response);
        }
    }
}
