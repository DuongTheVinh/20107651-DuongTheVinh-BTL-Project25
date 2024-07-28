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

@WebServlet("/vali")
public class ValiServlet extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter = request.getParameter("filter");
        List<Filter> valiFilters = productDAO.getValiFilters();
        List<Product> valiProducts;
        
        if (filter == null || filter.isEmpty()) {
            valiProducts = productDAO.getValiFilteredProducts("all");
        } else {
            valiProducts = productDAO.getValiFilteredProducts(filter);
        }

        request.setAttribute("valiFilters", valiFilters);
        request.setAttribute("valiProducts", valiProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vali.jsp");
        dispatcher.forward(request, response);
    }
}
