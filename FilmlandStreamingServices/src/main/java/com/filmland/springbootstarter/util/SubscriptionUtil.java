package com.filmland.springbootstarter.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmland.springbootstarter.dbrepository.SubscriptionRepository;
import com.filmland.springbootstarter.dto.ResponseStatus;
import com.filmland.springbootstarter.dto.SubscribeCategory;
import com.filmland.springbootstarter.dto.SubscribedCategories;
import com.filmland.springbootstarter.services.SubscribeService;

/**
 * @author Ashish
 * 
 *         Helper class with methods for the {@link SubscribeService} to check
 *         and subscriptions if not already available for user.
 *
 */
@Component
public class SubscriptionUtil {

	/**
	 * Method to check if the user has already subscribed to the requested category.
	 * 
	 * @param user email of the user
	 * @return {@link ResponseStatus} Message based on the request served.
	 */

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	private ResponseStatus responseStatus;

	public ResponseStatus checkAndAddRequestedSubscriptionForUser(SubscribeCategory subscribeCategory) {
		boolean subsriptionStatus = checkSubsriptionStatus(subscribeCategory);

		if (subsriptionStatus) {
			responseStatus = addSubscription(subscribeCategory, subsriptionStatus);
		} else {
			responseStatus = createResponseMessage(subscribeCategory, subsriptionStatus);
		}
		return responseStatus;
	}

	/**
	 * Method to check if the user has already subscribed the requested category.
	 * 
	 * @param subscribeCategory
	 * @return true is category is already subscribed.
	 */
	private boolean checkSubsriptionStatus(SubscribeCategory subscribeCategory) {
		List<SubscribedCategories> list = subscriptionRepository.findByemailIdAndCategoryName(
				subscribeCategory.getEmail(), subscribeCategory.getCategoryToBeSubscribed());
		return list.isEmpty();
	}

	public ResponseStatus addSubscription(SubscribeCategory subscribeCategory, boolean subsriptionStatus) {
		SubscribedCategories subscribedCategories = new SubscribedCategories(subscribeCategory.getEmail(),
				subscribeCategory.getCategoryToBeSubscribed(), "10", "10");
		subscriptionRepository.save(subscribedCategories);

		return createResponseMessage(subscribeCategory, subsriptionStatus);
	}

	private ResponseStatus createResponseMessage(SubscribeCategory subscribeCategory, boolean subsriptionStatus) {

		StringBuilder msg = new StringBuilder();
		msg.append("Your Subscription to ");
		msg.append(subscribeCategory.getCategoryToBeSubscribed());

		if (subsriptionStatus) {
			msg.append(" has been successfully added.");
			return new ResponseStatus("Login successful", msg.toString());
		}

		else {
			msg.append(" is already available");
			return new ResponseStatus("Login successful", msg.toString());
		}

	}
}
