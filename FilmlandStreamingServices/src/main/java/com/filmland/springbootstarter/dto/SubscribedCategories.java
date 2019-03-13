package com.filmland.springbootstarter.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SUBSCRIPTION_START_DATE")
	private LocalDate subscriptionStartDate;

	public SubscribedCategories() {
	}

	public SubscribedCategories(String emailId, String categoryName, String remainingContent, String price,
			String status, LocalDate subscriptionStartDate) {
		super();
		this.emailId = emailId;
		this.categoryName = categoryName;
		this.remainingContent = remainingContent;
		this.price = price;
		this.status = status;
		this.subscriptionStartDate = subscriptionStartDate;
	}

	@JsonIgnore
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

	@JsonIgnore
	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@JsonIgnore
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

}
