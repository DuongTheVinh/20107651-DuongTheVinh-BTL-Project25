package model;

import java.util.Date;

public class Review {
    private int reviewID;
    private int productID;
    private int userID;
    private int rating;
    private String comment;
    private Date reviewDate;
	public Review() {
		super();
	}
	public Review(int reviewID, int productID, int userID, int rating, String comment, Date reviewDate) {
		super();
		this.reviewID = reviewID;
		this.productID = productID;
		this.userID = userID;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
    
}
