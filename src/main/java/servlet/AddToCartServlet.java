package servlet;

import model.Cart;
import model.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        if (product != null && product.getPrice() != null) {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }

            cart.addItem(product, quantity);
            session.setAttribute("cartSize", cart.getTotalQuantity());

            // Kiểm tra nếu là yêu cầu AJAX
            String requestedWith = request.getHeader("X-Requested-With");
            if ("XMLHttpRequest".equals(requestedWith)) {
                // Trả về tổng số lượng sản phẩm trong giỏ hàng
                response.getWriter().write(String.valueOf(cart.getTotalQuantity()));
            } else {
                // Chuyển hướng đến trang giỏ hàng
                response.sendRedirect("cart.jsp");
            }
        } else {
            // Xử lý khi sản phẩm không tồn tại hoặc không có giá
            response.sendRedirect("product-detail.jsp?productID=" + productId + "&errorMessage=Sản phẩm không khả dụng hoặc không có giá.");
        }
    }
}
