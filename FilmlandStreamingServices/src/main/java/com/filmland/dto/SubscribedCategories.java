package com.filmland.dto;

public class SubscribedCategories {
	private String categoryName;
	private String remainingContent;
	private String price;
	private String startDate;

	public SubscribedCategories(String categoryName, String remainingContent, String price, String startDate) {
		super();
		this.categoryName = categoryName;
		this.remainingContent = remainingContent;
		this.price = price;
		this.startDate = startDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getRemainingContent() {
		return remainingContent;
	}

	public void setRemainingContent(String remainingContent) {
		this.remainingContent = remainingContent;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
