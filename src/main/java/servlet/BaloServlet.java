package servlet;

import dao.ProductDAO;
import model.Filter;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/balo")
public class BaloServlet extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter = request.getParameter("filter");
        List<Filter> baloFilters = productDAO.getBaloFilters();
        List<Product> baloProducts;
        
        if (filter == null || filter.isEmpty()) {
            baloProducts = productDAO.getBaloFilteredProducts("all");
        } else {
            baloProducts = productDAO.getBaloFilteredProducts(filter);
        }

        request.setAttribute("baloFilters", baloFilters);
        request.setAttribute("baloProducts", baloProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("balo.jsp");
        dispatcher.forward(request, response);
    }
}
