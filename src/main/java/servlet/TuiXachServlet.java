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

@WebServlet("/tui-xach")
public class TuiXachServlet extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String filter = request.getParameter("filter");
        List<Filter> tuiXachFilters = productDAO.getTuiXachFilters();
        List<Product> tuiXachProducts;
        
        if (filter == null || filter.isEmpty()) {
            tuiXachProducts = productDAO.getTuiXachFilteredProducts("all");
        } else {
            tuiXachProducts = productDAO.getTuiXachFilteredProducts(filter);
        }

        request.setAttribute("tuiXachFilters", tuiXachFilters);
        request.setAttribute("tuiXachProducts", tuiXachProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tui-xach.jsp");
        dispatcher.forward(request, response);
    }
}
