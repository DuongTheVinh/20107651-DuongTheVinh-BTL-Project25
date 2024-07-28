package servlet;

import model.Cart;
import model.CartItem;
import model.Order;
import model.OrderDetail;
import model.User;
import dao.OrderDAO;
import dao.OrderDetailDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@WebServlet("/place-order")
public class PlaceOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        // Kiểm tra giỏ hàng
        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("checkout.jsp?errorMessage=Cart%20is%20empty");
            return;
        }

        // Kiểm tra người dùng
        if (user == null) {
            response.sendRedirect("checkout.jsp?errorMessage=User%20not%20logged%20in");
            return;
        }

        try {
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String paymentMethod = request.getParameter("paymentMethod");
            
            // Kiểm tra các thông tin cần thiết
            if (fullName == null || phone == null || address == null || paymentMethod == null) {
                response.sendRedirect("checkout.jsp?errorMessage=Missing%20required%20information");
                return;
            }

            // Tạo đơn hàng mới
            Order order = new Order();
            order.setUserID(user.getUserID());
            order.setOrderDate(new Date());
            order.setTotalAmount(cart.getTotalPrice());
            order.setStatus("Pending");
            order.setFullName(fullName);
            order.setPhone(phone);
            order.setAddress(address);
            order.setPaymentMethod(paymentMethod);

            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.addOrder(order); // Lưu và lấy ID đơn hàng

            // Lưu chi tiết đơn hàng
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            for (CartItem item : cart.getItems()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderID(orderId);
                orderDetail.setProductID(item.getProduct().getProductID());
                orderDetail.setQuantity(item.getQuantity());
                orderDetail.setUnitPrice(item.getProduct().getPrice());
                orderDetailDAO.addOrderDetail(orderDetail);
            }

            // Xóa giỏ hàng sau khi đặt hàng thành công
            session.removeAttribute("cart");
            response.sendRedirect("order-confirmation.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("checkout.jsp?errorMessage=An%20error%20occurred%20while%20placing%20your%20order");
        }
    }
}
