package model;

public class ProductFilter {
    private int productID;
    private int filterID;
	public ProductFilter() {
		super();
	}
	public ProductFilter(int productID, int filterID) {
		super();
		this.productID = productID;
		this.filterID = filterID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getFilterID() {
		return filterID;
	}
	public void setFilterID(int filterID) {
		this.filterID = filterID;
	}

	
}
