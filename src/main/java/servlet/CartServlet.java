package servlet;

import model.Cart;
import model.CartItem;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        List<CartItem> items = cart.getItems();
        BigDecimal totalCartPrice = BigDecimal.ZERO;

        for (CartItem item : items) {
            BigDecimal totalPrice = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            item.setTotalPrice(totalPrice);
            totalCartPrice = totalCartPrice.add(totalPrice);
        }

        request.setAttribute("items", items);
        request.setAttribute("totalCartPrice", totalCartPrice);

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
