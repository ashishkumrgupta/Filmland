package com.filmland.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmland.springbootstarter.dbrepository.CategoryRepository;
import com.filmland.springbootstarter.dbrepository.SubscriptionRepository;
import com.filmland.springbootstarter.dto.AvailableAndSubscribedCategories;
import com.filmland.springbootstarter.dto.AvailableCategories;
import com.filmland.springbootstarter.dto.SubscribedCategories;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	public AvailableAndSubscribedCategories getUserSubscribedAndAllCategories(String user) {
		return new AvailableAndSubscribedCategories(getAllAvailableCategories(), getUserSubscribedCategories(user));
	}

	public List<SubscribedCategories> getUserSubscribedCategories(String userEmailId) {
		return subscriptionRepository.findByemailId(userEmailId);
	}

	public List<AvailableCategories> getAllAvailableCategories() {
		List<AvailableCategories> availableCategory = new ArrayList<AvailableCategories>();
		categoryRepository.findAll().forEach(availableCategory::add);

		return availableCategory;
	}
}
