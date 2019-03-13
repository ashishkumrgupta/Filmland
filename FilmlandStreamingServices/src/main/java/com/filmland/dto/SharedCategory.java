package com.filmland.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_SHARED_SUBSCRIPTION_CATEGORIES")
public class SharedCategory {

	@Id
	@Column(name = "SHARED_SUBSCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String sharedSubscriptionId;

	@Column(name = "EMAIL_ID_OWNER")
	private String emailIdOwner;

	@Column(name = "EMAIL_ID_SHARED_WITH")
	private String emailIdSharedWith;

	@Column(name = "SHARED_CATEGORY")
	private String sharedCategory;

	public SharedCategory(String emailIdOwner, String emailIdSharedWith,
			String sharedCategory) {
		super();
		this.emailIdOwner = emailIdOwner;
		this.emailIdSharedWith = emailIdSharedWith;
		this.sharedCategory = sharedCategory;
	}

	public String getSharedSubscriptionId() {
		return sharedSubscriptionId;
	}

	public void setSharedSubscriptionId(String sharedSubscriptionId) {
		this.sharedSubscriptionId = sharedSubscriptionId;
	}

	public String getEmailIdOwner() {
		return emailIdOwner;
	}

	public void setEmailIdOwner(String emailIdOwner) {
		this.emailIdOwner = emailIdOwner;
	}

	public String getEmailIdSharedWith() {
		return emailIdSharedWith;
	}

	public void setEmailIdSharedWith(String emailIdSharedWith) {
		this.emailIdSharedWith = emailIdSharedWith;
	}

	public String getSharedCategory() {
		return sharedCategory;
	}

	public void setSharedCategory(String sharedCategory) {
		this.sharedCategory = sharedCategory;
	}
}
