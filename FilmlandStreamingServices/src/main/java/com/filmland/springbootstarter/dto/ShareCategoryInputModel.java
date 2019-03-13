package com.filmland.springbootstarter.dto;

public class ShareCategoryInputModel {

	private String email;
	private String customer;
	private String subscribedCategory;

	public ShareCategoryInputModel(String email, String customer, String subscribedCategory) {
		super();
		this.email = email;
		this.customer = customer;
		this.subscribedCategory = subscribedCategory;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getSubscribedCategory() {
		return subscribedCategory;
	}

	public void setSubscribedCategory(String subscribedCategory) {
		this.subscribedCategory = subscribedCategory;
	}

}
