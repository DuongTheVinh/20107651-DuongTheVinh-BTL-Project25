package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.DatabaseConnection;
import model.OrderDetail;

public class OrderDetailDAO {
    public boolean saveOrderDetail(OrderDetail detail) {
        String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, detail.getOrderID());
            pstmt.setInt(2, detail.getProductID());
            pstmt.setInt(3, detail.getQuantity());
            pstmt.setBigDecimal(4, detail.getUnitPrice());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void addOrderDetail(OrderDetail orderDetail) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, orderDetail.getOrderID());
            statement.setInt(2, orderDetail.getProductID());
            statement.setInt(3, orderDetail.getQuantity());
            statement.setBigDecimal(4, orderDetail.getUnitPrice());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
