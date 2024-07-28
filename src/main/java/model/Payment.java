package model;

import java.util.Date;

public class Payment {
    private int paymentID;
    private int orderID;
    private String paymentMethod;
    private String paymentStatus;
    private Date paymentDate;
	public Payment() {
		super();
	}
	public Payment(int paymentID, int orderID, String paymentMethod, String paymentStatus, Date paymentDate) {
		super();
		this.paymentID = paymentID;
		this.orderID = orderID;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
    
}
