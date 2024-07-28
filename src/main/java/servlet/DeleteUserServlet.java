package servlet;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đảm bảo yêu cầu sử dụng UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            // Lấy thông tin username từ yêu cầu
            String username = request.getParameter("username");

            // Tạo đối tượng UserDAO và gọi phương thức xóa người dùng
            UserDAO userDAO = new UserDAO();
            boolean isDeleted = userDAO.deleteUserByUsername(username);

            // Chuyển hướng đến trang quản lý người dùng với thông báo thành công hoặc thất bại
            if (isDeleted) {
                request.setAttribute("successMessage", "Người dùng đã được xóa thành công.");
            } else {
                request.setAttribute("errorMessage", "Không thể xóa người dùng. Vui lòng thử lại.");
            }

            request.getRequestDispatcher("user-management.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Đã xảy ra lỗi khi xóa người dùng. Vui lòng thử lại.");
            request.getRequestDispatcher("user-management.jsp").forward(request, response);
        }
    }
}
