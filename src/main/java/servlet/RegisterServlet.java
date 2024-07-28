package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DatabaseConnection;
import util.PasswordUtil;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        String hashedPassword = PasswordUtil.hashPassword(password);
        String role = "user"; // Default role

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Check if there are any users in the database
            String checkUserCountSql = "SELECT COUNT(*) FROM Users";
            PreparedStatement checkUserCountStmt = conn.prepareStatement(checkUserCountSql);
            ResultSet rs = checkUserCountStmt.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                role = "admin"; // First user will be admin
            }

            String sql = "INSERT INTO Users (Username, PasswordHash, Email, FullName, Address, PhoneNumber, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, email);
            stmt.setString(4, fullName);
            stmt.setString(5, address);
            stmt.setString(6, phoneNumber);
            stmt.setString(7, role);

            stmt.executeUpdate();
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("signup.jsp?error=1");
        }
    }
}
