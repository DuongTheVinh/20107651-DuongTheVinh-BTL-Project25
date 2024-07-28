package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update-user-profile")
public class UpdateUserProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp?errorMessage=You%20must%20be%20logged%20in%20to%20update%20your%20profile");
            return;
        }

        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        user.setFullName(fullName);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.updateUserProfile(user);
            session.setAttribute("user", user);
            response.sendRedirect("user-profile.jsp?successMessage=Profile%20updated%20successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("user-profile.jsp?errorMessage=An%20error%20occurred%20while%20updating%20your%20profile");
        }
    }
}
