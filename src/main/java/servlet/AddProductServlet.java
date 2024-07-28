package servlet;

import model.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;

@WebServlet("/add-product")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "C:\\Users\\ADMIN\\eclipse-workspace\\MyProject\\src\\main\\webapp\\images";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            String priceStr = request.getParameter("price");
            String stockStr = request.getParameter("stock");
            String categoryIDStr = request.getParameter("categoryID");
            Part imagePart = request.getPart("image");

            if (productName == null || productName.isEmpty() ||
                description == null || description.isEmpty() ||
                priceStr == null || priceStr.isEmpty() ||
                stockStr == null || stockStr.isEmpty() ||
                categoryIDStr == null || categoryIDStr.isEmpty() ||
                imagePart == null || imagePart.getSize() == 0) {

                request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin sản phẩm và chọn hình ảnh.");
                request.getRequestDispatcher("add-product.jsp").forward(request, response);
                return;
            }

            BigDecimal price = new BigDecimal(priceStr);
            int stock = Integer.parseInt(stockStr);
            int categoryID = Integer.parseInt(categoryIDStr);

            String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            imagePart.write(uploadPath + File.separator + fileName);

            Product product = new Product();
            product.setProductName(productName);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategoryID(categoryID);
            product.setImageURL(UPLOAD_DIR + File.separator + fileName);

            ProductDAO productDAO = new ProductDAO();
            productDAO.addProduct(product);

            response.sendRedirect("products.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Đã xảy ra lỗi khi thêm sản phẩm. Vui lòng thử lại.");
            request.getRequestDispatcher("add-product.jsp").forward(request, response);
        }
    }
}
