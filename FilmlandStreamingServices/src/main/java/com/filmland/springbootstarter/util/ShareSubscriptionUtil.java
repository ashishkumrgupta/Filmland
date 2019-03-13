package com.filmland.springbootstarter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmland.springbootstarter.dbrepository.FilmlandUserRepository;
import com.filmland.springbootstarter.dbrepository.ShareCategoryRepository;
import com.filmland.springbootstarter.dto.ShareCategoryInputModel;
import com.filmland.springbootstarter.dto.SharedCategory;
import com.filmland.springbootstarter.dto.SubscribeCategoryInputModel;
import com.filmland.springbootstarter.exceptions.UserNotFoundException;

/**
 * @author Ashish
 * 
 *         Helper class with methods for Sharing the categories with the
 *         existing users.
 *
 */
@Component
public class ShareSubscriptionUtil {

	private static Logger logger = LoggerFactory.getLogger(ShareSubscriptionUtil.class);

	@Autowired
	private FilmlandUserRepository filmlandUserRepository;

	@Autowired
	private ShareCategoryRepository shareCategoryRepository;

	@Autowired
	private SubscriptionUtil subscriptionUtil;

	/**
	 * Method to check and share the requested category with only existing users.
	 * 
	 * @param shareCategory Details of the user.
	 */
	public boolean checkAndShareCategoryWithUser(ShareCategoryInputModel shareCategory) {
		boolean userExistanceStatus = filmlandUserRepository.existsById(shareCategory.getCustomer());
		logger.info("user existance.", userExistanceStatus);

		if (userExistanceStatus) {
			subscriptionUtil.checkAndAddRequestedSubscriptionForUser(new SubscribeCategoryInputModel(
					shareCategory.getCustomer(), shareCategory.getSubscribedCategory()));

			SharedCategory sharedCategory = new SharedCategory(shareCategory.getEmail(), shareCategory.getCustomer(),
					shareCategory.getSubscribedCategory());
			shareCategoryRepository.save(sharedCategory);
			logger.info("User exist and sharing is in progress.");
			return true;
		} else {
			throw new UserNotFoundException();
		}
	}
}
