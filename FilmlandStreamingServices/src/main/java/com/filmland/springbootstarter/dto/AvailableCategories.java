package com.filmland.springbootstarter.dto;

public class AvailableCategories {

	private String categoryName;
	private String avaialbleContent;
	private String price;

	public AvailableCategories(String categoryName, String avaialbleContent, String price) {
		super();
		this.categoryName = categoryName;
		this.avaialbleContent = avaialbleContent;
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAvaialbleContent() {
		return avaialbleContent;
	}

	public void setAvaialbleContent(String avaialbleContent) {
		this.avaialbleContent = avaialbleContent;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
