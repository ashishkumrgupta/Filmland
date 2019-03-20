package com.filmland.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmland.dbrepository.ShareCategoryRepository;
import com.filmland.dto.ShareCategoryInputModel;
import com.filmland.dto.SharedCategory;
import com.filmland.dto.SubscribeCategoryInputModel;
import com.filmland.exceptions.SubscriptionNotAvailableException;
import com.filmland.exceptions.UserNotFoundException;

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
	private ShareCategoryRepository shareCategoryRepository;

	@Autowired
	private SubscriptionUtil subscriptionUtil;

	@Autowired
	private FilmlandCommonUtil filmlandCommonUtil;

	/**
	 * Method to check and share the requested category with only existing users.
	 * 
	 * @param shareCategory Details of the user.
	 */
	public boolean checkAndShareCategoryWithUser(ShareCategoryInputModel shareCategory) {
		if (filmlandCommonUtil.checkUserExistance(shareCategory.getEmail())) {

			SubscribeCategoryInputModel subscribeCategoryInputModelForLoginUser = new SubscribeCategoryInputModel(
					shareCategory.getEmail(), shareCategory.getSubscribedCategory());
			checkIfSubscriptionAvailableForUser(subscribeCategoryInputModelForLoginUser);

			SubscribeCategoryInputModel subscribeCategoryInputModelForCustomer = new SubscribeCategoryInputModel(
					shareCategory.getCustomer(), shareCategory.getSubscribedCategory());

			subscriptionUtil.checkAndAddRequestedSubscriptionForUser(subscribeCategoryInputModelForCustomer);

			SharedCategory sharedCategory = new SharedCategory(shareCategory.getEmail(), shareCategory.getCustomer(),
					shareCategory.getSubscribedCategory());
			shareCategoryRepository.save(sharedCategory);
			logger.info("User exist and sharing is in progress.");
			return true;
		} else {
			throw new UserNotFoundException();
		}
	}

	private void checkIfSubscriptionAvailableForUser(SubscribeCategoryInputModel subscribeCategoryInputModel) {
		if (filmlandCommonUtil.checkSubsriptionStatus(subscribeCategoryInputModel)) {
			throw new SubscriptionNotAvailableException();
		}
	}
}
