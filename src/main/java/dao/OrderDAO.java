package dao;

import model.Order;
import model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connect.DatabaseConnection;

public class OrderDAO {

	 public int addOrder(Order order) {
	        int orderId = -1;
	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "INSERT INTO Orders (UserID, OrderDate, TotalAmount, Status, FullName, Phone, Address, PaymentMethod) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            statement.setInt(1, order.getUserID());
	            statement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
	            statement.setBigDecimal(3, order.getTotalAmount());
	            statement.setString(4, order.getStatus());
	            statement.setString(5, order.getFullName());
	            statement.setString(6, order.getPhone());
	            statement.setString(7, order.getAddress());
	            statement.setString(8, order.getPaymentMethod());
	            
	            int affectedRows = statement.executeUpdate();

	            if (affectedRows > 0) {
	                try (var rs = statement.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        orderId = rs.getInt(1);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderId;
	    }
    // Lưu thông tin đơn hàng vào bảng Orders và trả về ID của đơn hàng vừa tạo
    public int saveOrder(Order order) {
        int orderId = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Orders (UserID, OrderDate, TotalAmount, Status, FullName, Phone, Address, PaymentMethod) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, order.getUserID());
            pstmt.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            pstmt.setBigDecimal(3, order.getTotalAmount());
            pstmt.setString(4, order.getStatus());
            pstmt.setString(5, order.getFullName());
            pstmt.setString(6, order.getPhone());
            pstmt.setString(7, order.getAddress());
            pstmt.setString(8, order.getPaymentMethod());

            pstmt.executeUpdate();

            // Lấy ID của đơn hàng vừa tạo
            var rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }

    // Lưu thông tin chi tiết đơn hàng vào bảng OrderDetails
    public void saveOrderDetails(List<OrderDetail> orderDetails) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            for (OrderDetail detail : orderDetails) {
                pstmt.setInt(1, detail.getOrderID());
                pstmt.setInt(2, detail.getProductID());
                pstmt.setInt(3, detail.getQuantity());
                pstmt.setBigDecimal(4, detail.getUnitPrice());
                pstmt.addBatch();
            }

            pstmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
