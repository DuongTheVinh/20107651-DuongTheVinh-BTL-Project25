package servlet;

import dao.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận productID từ URL
        String productIDStr = request.getParameter("productID");
        if (productIDStr != null && !productIDStr.isEmpty()) {
            try {
                int productID = Integer.parseInt(productIDStr);
                // Lấy thông tin sản phẩm từ cơ sở dữ liệu
                Product product = productDAO.getProductById(productID);
                if (product != null) {
                    // Thiết lập thông tin sản phẩm để hiển thị trong JSP
                    request.setAttribute("product", product);
                    // Chuyển tiếp đến trang JSP
                    RequestDispatcher dispatcher = request.getRequestDispatcher("product-detail.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Sản phẩm không tìm thấy
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                }
            } catch (NumberFormatException e) {
                // ID sản phẩm không hợp lệ
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
            }
        } else {
            // Thiếu ID sản phẩm
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing product ID");
        }
    }
}
