package com.filmland.springbootstarter.dto;

public class SubscribeCategory {
	private String email;
	private String categoryToBeSubscribed;

	public SubscribeCategory(String email, String categoryToBeSubscribed) {
		super();
		this.email = email;
		this.categoryToBeSubscribed = categoryToBeSubscribed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoryToBeSubscribed() {
		return categoryToBeSubscribed;
	}

	public void setCategoryToBeSubscribed(String categoryToBeSubscribed) {
		this.categoryToBeSubscribed = categoryToBeSubscribed;
	}

}
