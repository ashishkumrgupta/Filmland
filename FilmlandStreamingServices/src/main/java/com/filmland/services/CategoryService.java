package com.filmland.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmland.dbrepository.CategoryRepository;
import com.filmland.dbrepository.SubscriptionRepository;
import com.filmland.dto.AvailableAndSubscribedCategories;
import com.filmland.dto.AvailableCategories;
import com.filmland.dto.SubscribedCategories;
import com.filmland.exceptions.CategoryNotFoundException;

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

	/**
	 * To find category details from the data base.
	 * 
	 * @param categoryName requested category Name.
	 * @return {@link AvailableCategories}
	 */
	public AvailableCategories getCategoryDetailsBasedOnCategory(String categoryName) {

		Optional<AvailableCategories> a = categoryRepository.findById(categoryName);
		if (a.isPresent())
			return a.get();
		else
			throw new CategoryNotFoundException();
	}
}
