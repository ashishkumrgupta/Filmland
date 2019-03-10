package com.filmland.springbootstarter.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_SUBSCRIBED_CATEGORIES")
public class SubscribedCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBSCRIPTION_ID")
	private Long subscriptionId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "REMAINING_CONTENT")
	private String remainingContent;

	@Column(name = "PRICE")
	private String price;

	public SubscribedCategories() {
	}

	public SubscribedCategories(String emailId, String categoryName, String remainingContent, String price) {
		super();
		this.emailId = emailId;
		this.categoryName = categoryName;
		this.remainingContent = remainingContent;
		this.price = price;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
}
