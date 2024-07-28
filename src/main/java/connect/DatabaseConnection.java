package connect;

//DatabaseConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
 private static final String URL = "jdbc:sqlserver://DUONGTHEVINH:1433;databaseName=ShopDB;characterEncoding=UTF-8;encrypt=true;trustServerCertificate=true;";
 private static final String USER = "sa";
 private static final String PASSWORD = "123";

 static {
     try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     } catch (ClassNotFoundException e) {
         throw new RuntimeException("Failed to load SQL Server JDBC driver", e);
     }
 }

 public static Connection getConnection() throws SQLException {
     return DriverManager.getConnection(URL, USER, PASSWORD);
 }
}
