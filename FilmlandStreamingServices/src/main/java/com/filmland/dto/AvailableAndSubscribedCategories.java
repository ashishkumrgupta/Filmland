package com.filmland.dto;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class AvailableAndSubscribedCategories extends ResourceSupport {

	private List<AvailableCategories> availableCategories;
	private List<SubscribedCategories> subscribedCategories;

	public AvailableAndSubscribedCategories(List<AvailableCategories> availableCategories,
			List<SubscribedCategories> subscribedCategories) {
		super();
		this.availableCategories = availableCategories;
		this.subscribedCategories = subscribedCategories;
	}

	public List<AvailableCategories> getAvailableCategories() {
		return availableCategories;
	}

	public void setAvailableCategories(List<AvailableCategories> availableCategories) {
		this.availableCategories = availableCategories;
	}

	public List<SubscribedCategories> getSubscribedCategories() {
		return subscribedCategories;
	}

	public void setSubscribedCategories(List<SubscribedCategories> subscribedCategories) {
		this.subscribedCategories = subscribedCategories;
	}
}
