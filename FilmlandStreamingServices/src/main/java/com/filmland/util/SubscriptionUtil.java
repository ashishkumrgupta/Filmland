package com.filmland.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmland.dbrepository.SubscriptionRepository;
import com.filmland.dto.ResponseStatus;
import com.filmland.dto.SubscribeCategoryInputModel;
import com.filmland.dto.SubscribedCategories;
import com.filmland.exceptions.SubscriptionAlreadyAvailableException;
import com.filmland.services.CategoryService;
import com.filmland.services.SubscribeService;

/**
 * @author Ashish
 * 
 *         Helper class with methods for the {@link SubscribeService} to check
 *         and subscriptions if not already available for user.
 *
 */
@Component
public class SubscriptionUtil {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionUtil.class);

	/**
	 * Method to check if the user has already subscribed to the requested category.
	 * 
	 * @param user email of the user
	 * @return {@link ResponseStatus} Message based on the request served.
	 */

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FilmlandCommonUtil filmlandCommonUtil;

	/**
	 * Method to check and Add subscription for the requested user.
	 * 
	 * @param subscribeCategory
	 * @return {@link ResponseStatus}
	 */
	public boolean checkAndAddRequestedSubscriptionForUser(SubscribeCategoryInputModel subscribeCategory)
			throws SubscriptionAlreadyAvailableException {
		filmlandCommonUtil.checkUserExistance(subscribeCategory.getEmail());
		boolean subsriptionStatus = filmlandCommonUtil.checkSubsriptionStatus(subscribeCategory);
		logger.info("chekcing for subscription of user {} for category {} is {}", subscribeCategory.getEmail(),
				subscribeCategory.getCategoryToBeSubscribed(), subsriptionStatus);
		if (subsriptionStatus) {
			return addSubscription(subscribeCategory);
		} else {
			throw new SubscriptionAlreadyAvailableException();
		}
	}

	public boolean addSubscription(SubscribeCategoryInputModel subscribeCategory) {
		logger.info("adding user {} for {} category", subscribeCategory.getEmail(),
				subscribeCategory.getCategoryToBeSubscribed());
		SubscribedCategories subscribedCategories = new SubscribedCategories(subscribeCategory.getEmail(),
				subscribeCategory.getCategoryToBeSubscribed(),
				getTotalAvailableContentForCategory(subscribeCategory.getCategoryToBeSubscribed()),
				getPriceOfCategory(subscribeCategory.getCategoryToBeSubscribed()), "N",
				filmlandCommonUtil.getCurrentDate(), "Y");

		subscriptionRepository.save(subscribedCategories);
		return true;
	}

	/**
	 * Method to get Total available content for a particular category.
	 * 
	 * @param categoryName
	 * @return {@link String} total available category.
	 */
	private String getTotalAvailableContentForCategory(String categoryName) {
		logger.info("requested category name {}", categoryName);
		return categoryService.getCategoryDetailsBasedOnCategory(categoryName).getAvaialbleContent();
	}

	/**
	 * Method to get price for a particular category.
	 * 
	 * @param categoryName
	 * @return {@link String} price of the category.
	 */

	private String getPriceOfCategory(String categoryName) {
		return categoryService.getCategoryDetailsBasedOnCategory(categoryName).getPrice();
	}
}
