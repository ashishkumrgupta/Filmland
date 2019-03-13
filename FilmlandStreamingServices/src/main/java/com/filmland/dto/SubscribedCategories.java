package com.filmland.dto;

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
	private String subscriptionStatus;

	@Column(name = "SUBSCRIPTION_START_DATE")
	private LocalDate subscriptionStartDate;

	@Column(name = "NEW_MEMBER")
	private String isNewMember;

	public SubscribedCategories() {
	}

	public SubscribedCategories(String emailId, String categoryName, String remainingContent, String price,
			String status, LocalDate subscriptionStartDate, String isNewMember) {
		super();
		this.emailId = emailId;
		this.categoryName = categoryName;
		this.remainingContent = remainingContent;
		this.price = price;
		this.subscriptionStatus = status;
		this.subscriptionStartDate = subscriptionStartDate;
		this.isNewMember = isNewMember;
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
		return subscriptionStatus;
	}

	public void setStatus(String status) {
		this.subscriptionStatus = status;
	}

	public LocalDate getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	@JsonIgnore
	public String getIsNewMember() {
		return isNewMember;
	}

	public void setIsNewMember(String isNewMember) {
		this.isNewMember = isNewMember;
	}

}
