package com.filmland.springbootstarter.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filmland.dto.AvailableAndSubscribedCategories;
import com.filmland.dto.AvailableCategories;
import com.filmland.dto.SubscribedCategories;

@Service
public class CategoryService {

	public AvailableAndSubscribedCategories getUserSubscribedAndAllCategories(String user) {
		return new AvailableAndSubscribedCategories(getAllAvailableCategories(), getUserSubscribedCategories(user));
	}

	public List<SubscribedCategories> getUserSubscribedCategories(String user) {
		// write query and logic to find the subscribed categories for provided user
		return Arrays.asList(new SubscribedCategories("International Films", "8", "4", "today"));
	}

	public List<AvailableCategories> getAllAvailableCategories() {
		return Arrays.asList(new AvailableCategories("Dutch Films", "10", "4"),
				new AvailableCategories("Dutch Series", "20", "6"),
				new AvailableCategories("International Films", "30", "8"));
	}
}
