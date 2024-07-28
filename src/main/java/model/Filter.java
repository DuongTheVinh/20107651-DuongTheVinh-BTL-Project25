package model;

public class Filter {
    private int filterID;
    private String filterName;
    private int categoryID;
	public Filter() {
		super();
	}
	public Filter(int filterID, String filterName, int categoryID) {
		super();
		this.filterID = filterID;
		this.filterName = filterName;
		this.categoryID = categoryID;
	}
	public int getFilterID() {
		return filterID;
	}
	public void setFilterID(int filterID) {
		this.filterID = filterID;
	}
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

}
