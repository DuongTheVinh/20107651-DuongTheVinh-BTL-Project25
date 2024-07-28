package model;


import java.math.BigDecimal;
import java.util.Date;

public class Product  {
    private int productID;
    private int categoryID;
    private String productName;
    private String description;
    private BigDecimal price;
    private int stock;
    private String imageURL;
    private Date createdDate;
	public Product() {
		super();
	}
	public Product(int productID, int categoryID, String productName, String description, BigDecimal price, int stock,
			String imageURL, Date createdDate) {
		super();
		this.productID = productID;
		this.categoryID = categoryID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imageURL = imageURL;
		this.createdDate = createdDate;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

    // Getters and setters
}
