package com.filmland.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AVAILABLE_CATEGORIES")
public class AvailableCategories {

	@Id
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="REMAINING_COUNT")
	private String remainingCount;
	
	@Column(name="PRICE")
	private String price;

	public AvailableCategories() {
		
	}
	public AvailableCategories(String categoryName, String avaialbleContent, String price) {
		super();
		this.categoryName = categoryName;
		this.remainingCount = avaialbleContent;
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAvaialbleContent() {
		return remainingCount;
	}

	public void setAvaialbleContent(String avaialbleContent) {
		this.remainingCount = avaialbleContent;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
