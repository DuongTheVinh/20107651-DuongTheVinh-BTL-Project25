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

@WebServlet("/phu-kien")
public class PhuKienServlet extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter = request.getParameter("filter");
        List<Filter> filters = productDAO.getFilters();
        List<Product> products;
        
        if (filter == null || filter.isEmpty()) {
            products = productDAO.getFilteredProducts("all");
        } else {
            products = productDAO.getFilteredProducts(filter);
        }

        request.setAttribute("filters", filters);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phu-kien.jsp");
        dispatcher.forward(request, response);
    }
}
