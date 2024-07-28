package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connect.DatabaseConnection;
import model.Filter;
import model.Product;

public class ProductDAO {

	 public List<Product> getAllProducts() {
	        List<Product> products = new ArrayList<>();
	        String query = "SELECT * FROM Products";

	        try (Connection connection = DatabaseConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {
	                Product product = new Product();
	                product.setProductID(resultSet.getInt("ProductID"));
	                product.setCategoryID(resultSet.getInt("CategoryID"));
	                product.setProductName(resultSet.getString("ProductName"));
	                product.setDescription(resultSet.getString("Description"));
	                product.setPrice(resultSet.getBigDecimal("Price"));
	                product.setStock(resultSet.getInt("Stock"));
	                product.setImageURL(resultSet.getString("imageURL"));
	                product.setCreatedDate(resultSet.getDate("CreatedDate"));
	                products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return products;
	    }
    
    public Product getProductById(int productId) {
        Product product = null;
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product();
                    product.setProductID(rs.getInt("ProductID"));
                    product.setCategoryID(rs.getInt("CategoryID"));
                    product.setProductName(rs.getString("ProductName"));
                    product.setDescription(rs.getString("Description"));
                    product.setPrice(rs.getBigDecimal("Price"));
                    product.setStock(rs.getInt("Stock"));
                    product.setImageURL(rs.getString("imageURL"));
                    product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
 

    public List<Product> getProductsByCategory(int categoryID) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE CategoryID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, categoryID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("ProductID"));
                    product.setCategoryID(rs.getInt("CategoryID"));
                    product.setProductName(rs.getString("ProductName"));
                    product.setDescription(rs.getString("Description"));
                    product.setPrice(rs.getBigDecimal("Price"));
                    product.setStock(rs.getInt("Stock"));
                    product.setImageURL(rs.getString("imageURL"));
                    product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products;
    }
    
    
//    Load túi xách
    public List<Product> getTuiXachProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE CategoryID = 3"; // Giả sử CategoryID cho túi xách là 3
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products;
    }
//    Load Ba lô
    public List<Product> getBaloProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE CategoryID = 2"; //  CategoryID cho balo là 2
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products;
    }
//    Load phụ kiện
    public List<Product> getPhuKienProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE CategoryID = 4"; // Giả sử CategoryID cho phụ kiện là 4
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products;
    }
//    Lấy filter và product filter phụ kiện
    public List<Filter> getFilters() {
        List<Filter> filters = new ArrayList<>();
        String sql = "SELECT * FROM Filters WHERE CategoryID = 4"; // Giả sử CategoryID cho phụ kiện là 4
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Filter filter = new Filter();
                filter.setFilterID(rs.getInt("FilterID"));
                filter.setFilterName(rs.getString("FilterName"));
                filters.add(filter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return filters;
    }

    // Hợp nhất các phương thức `getFilteredProducts` thành một phiên bản duy nhất
    public List<Product> getFilteredProducts(String filter) {
        List<Product> products = new ArrayList<>();
        String sql;

        if (filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all")) {
            sql = "SELECT * FROM Products WHERE CategoryID = 4";
        } else {
            sql = "SELECT p.* FROM Products p " +
                  "JOIN ProductFilters pf ON p.ProductID = pf.ProductID " +
                  "JOIN Filters f ON pf.FilterID = f.FilterID " +
                  "WHERE f.FilterName = ? AND p.CategoryID = 4";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (!(filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all"))) {
                pstmt.setString(1, filter);
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products;
    }    
//    filter cho balo
    public List<Filter> getBaloFilters() {
        List<Filter> baloFilters = new ArrayList<>();
        String sql = "SELECT * FROM Filters WHERE CategoryID = 2"; // Giả sử CategoryID cho balo là 3
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Filter filter = new Filter();
                filter.setFilterID(rs.getInt("FilterID"));
                filter.setFilterName(rs.getString("FilterName"));
                baloFilters.add(filter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return baloFilters;
    }

    public List<Product> getBaloFilteredProducts(String filter) {
        List<Product> baloProducts = new ArrayList<>();
        String sql;

        if (filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all")) {
            sql = "SELECT * FROM Products WHERE CategoryID = 2";
        } else {
            sql = "SELECT p.* FROM Products p " +
                  "JOIN ProductFilters pf ON p.ProductID = pf.ProductID " +
                  "JOIN Filters f ON pf.FilterID = f.FilterID " +
                  "WHERE f.FilterName = ? AND p.CategoryID = 2";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (!(filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all"))) {
                pstmt.setString(1, filter);
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                baloProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return baloProducts;
    }
//    Lấy filter cho túi xách
    public List<Filter> getTuiXachFilters() {
        List<Filter> baloFilters = new ArrayList<>();
        String sql = "SELECT * FROM Filters WHERE CategoryID = 3"; // Giả sử CategoryID cho balo là 3
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Filter filter = new Filter();
                filter.setFilterID(rs.getInt("FilterID"));
                filter.setFilterName(rs.getString("FilterName"));
                baloFilters.add(filter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return baloFilters;
    }

    public List<Product> getTuiXachFilteredProducts(String filter) {
        List<Product> baloProducts = new ArrayList<>();
        String sql;

        if (filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all")) {
            sql = "SELECT * FROM Products WHERE CategoryID = 3";
        } else {
            sql = "SELECT p.* FROM Products p " +
                  "JOIN ProductFilters pf ON p.ProductID = pf.ProductID " +
                  "JOIN Filters f ON pf.FilterID = f.FilterID " +
                  "WHERE f.FilterName = ? AND p.CategoryID = 3";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (!(filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all"))) {
                pstmt.setString(1, filter);
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                baloProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return baloProducts;
    }
//    Filter cho vali
    public List<Filter> getValiFilters() {
        List<Filter> valiFilters = new ArrayList<>();
        String sql = "SELECT * FROM Filters WHERE CategoryID = 1"; // Giả sử CategoryID cho vali là 1
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Filter filter = new Filter();
                filter.setFilterID(rs.getInt("FilterID"));
                filter.setFilterName(rs.getString("FilterName"));
                valiFilters.add(filter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return valiFilters;
    }

    public List<Product> getValiFilteredProducts(String filter) {
        List<Product> valiProducts = new ArrayList<>();
        String sql;

        if (filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all")) {
            sql = "SELECT * FROM Products WHERE CategoryID = 1";
        } else {
            sql = "SELECT p.* FROM Products p " +
                  "JOIN ProductFilters pf ON p.ProductID = pf.ProductID " +
                  "JOIN Filters f ON pf.FilterID = f.FilterID " +
                  "WHERE f.FilterName = ? AND p.CategoryID = 1";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (!(filter == null || filter.isEmpty() || filter.equalsIgnoreCase("all"))) {
                pstmt.setString(1, filter);
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getBigDecimal("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImageURL(rs.getString("imageURL"));
                product.setCreatedDate(rs.getTimestamp("CreatedDate"));
                valiProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return valiProducts;
    }
    
    public void addProduct(Product product) {
        String sql = "INSERT INTO Products (CategoryID, ProductName, Description, Price, Stock, imageURL, CreatedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, product.getCategoryID());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getPrice());
            ps.setInt(5, product.getStock());
            ps.setString(6, product.getImageURL());
            ps.setDate(7, new java.sql.Date(product.getCreatedDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int productId) {
        Connection connection = null;
        PreparedStatement deleteProductFiltersStmt = null;
        PreparedStatement deleteProductStmt = null;

        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            // Xóa các bản ghi liên quan trong ProductFilters trước
            String deleteProductFiltersQuery = "DELETE FROM ProductFilters WHERE ProductID = ?";
            deleteProductFiltersStmt = connection.prepareStatement(deleteProductFiltersQuery);
            deleteProductFiltersStmt.setInt(1, productId);
            deleteProductFiltersStmt.executeUpdate();

            // Sau đó xóa sản phẩm trong bảng Products
            String deleteProductQuery = "DELETE FROM Products WHERE ProductID = ?";
            deleteProductStmt = connection.prepareStatement(deleteProductQuery);
            deleteProductStmt.setInt(1, productId);
            deleteProductStmt.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (deleteProductFiltersStmt != null) {
                    deleteProductFiltersStmt.close();
                }
                if (deleteProductStmt != null) {
                    deleteProductStmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(Product product) {
        String sql = "UPDATE Products SET CategoryID = ?, ProductName = ?, Description = ?, Price = ?, Stock = ?, imageURL = ?, CreatedDate = ? WHERE ProductID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, product.getCategoryID());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getPrice());
            ps.setInt(5, product.getStock());
            ps.setString(6, product.getImageURL());
            ps.setDate(7, new java.sql.Date(product.getCreatedDate().getTime()));
            ps.setInt(8, product.getProductID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
