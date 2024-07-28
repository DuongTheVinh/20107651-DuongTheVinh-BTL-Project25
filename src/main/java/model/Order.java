package model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderID;
    private int userID;
    private Date orderDate;
    private BigDecimal totalAmount;
    private String status;
    private String fullName;
    private String phone;
    private String address;
    private String paymentMethod;

    // Constructor mặc định và có tham số
    public Order() {}

    public Order(int orderID, int userID, Date orderDate, BigDecimal totalAmount, String status,
                 String fullName, String phone, String address, String paymentMethod) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    // Getters và setters
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
