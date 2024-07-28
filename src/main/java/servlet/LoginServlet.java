	package servlet;
	// LoginServlet.java
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
	import javax.servlet.http.HttpSession;
	
	import connect.DatabaseConnection;
import model.User;
import util.PasswordUtil;
	
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        String hashedPassword = PasswordUtil.hashPassword(password);
	
	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "SELECT * FROM Users WHERE Username = ? AND PasswordHash = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, hashedPassword);
	
	            ResultSet rs = stmt.executeQuery();
	
	            if (rs.next()) {
	                HttpSession session = request.getSession();
	                
	               
	                String email = rs.getString("Email");
	                String fullName = rs.getString("FullName");
	                String address = rs.getString("Address");
	                String phone = rs.getString("PhoneNumber");
	                User user = new User(email, fullName, address, phone);
	                session.setAttribute("userInf", user);
	                session.setAttribute("user", rs.getString("FullName"));
	                session.setAttribute("role", rs.getString("role"));
	                response.sendRedirect("home");
	            } else {
	                response.sendRedirect("login.jsp?error=1");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("login.jsp?error=1");
	        }
	        
	    }
	}
