package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DatabaseConnection;
import model.CartItem;
import model.Product;

public class ShoppingCartDAO {
    public void addOrUpdateItem(int userId, int productId, int quantity) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Check if item already exists in cart
            String query = "SELECT Quantity FROM ShoppingCart WHERE UserID = ? AND ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // If item exists, update the quantity
                int newQuantity = rs.getInt("Quantity") + quantity;
                query = "UPDATE ShoppingCart SET Quantity = ? WHERE UserID = ? AND ProductID = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, newQuantity);
                ps.setInt(2, userId);
                ps.setInt(3, productId);
                ps.executeUpdate();
            } else {
                // If item does not exist, insert a new record
                query = "INSERT INTO ShoppingCart (UserID, ProductID, Quantity, AddedDate) VALUES (?, ?, ?, GETDATE())";
                ps = connection.prepareStatement(query);
                ps.setInt(1, userId);
                ps.setInt(2, productId);
                ps.setInt(3, quantity);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeItem(int userId, int productId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM ShoppingCart WHERE UserID = ? AND ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CartItem> getCartItems(int userId) {
        List<CartItem> items = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT p.ProductID, p.ProductName, p.Price, p.ImageURL, s.Quantity " +
                           "FROM Products p INNER JOIN ShoppingCart s ON p.ProductID = s.ProductID " +
                           "WHERE s.UserID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setImageURL(rs.getString("ImageURL"));

                CartItem item = new CartItem(product, rs.getInt("Quantity"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
