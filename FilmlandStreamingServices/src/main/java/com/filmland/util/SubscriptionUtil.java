package com.filmland.util;

import com.filmland.dto.ResponseStatus;
import com.filmland.dto.SubscribeCategory;
import com.filmland.springbootstarter.services.SubscribeService;

/**
 * @author Ashish
 * 
 *         Helper class with methods for the {@link SubscribeService} to check and subscriptions
 *         if not already available for user.
 *
 */
public class SubscriptionUtil {

	/**
	 * Method to check if the user has already subscribed to the requested category.
	 * 
	 * @param user email of the user
	 * @return {@link ResponseStatus} Message based on the request served.
	 */

	private ResponseStatus responseStatus;

	public ResponseStatus checkAndAddRequestedSubscriptionForUser(SubscribeCategory subscribeCategory) {
		// check here for subscription from database. true means already subscribed.

		boolean subsriptionStatus = true;

		if (subsriptionStatus) {
			responseStatus = createResponseMessage(subscribeCategory, subsriptionStatus);
		} else {
			responseStatus = addSubscription(subscribeCategory, subsriptionStatus);
		}
		return responseStatus;
	}

	public ResponseStatus addSubscription(SubscribeCategory subscribeCategory, boolean subsriptionStatus) {
		// Add subscription here for the user into database.

		System.out.println("Subsription added.");
		return createResponseMessage(subscribeCategory, subsriptionStatus);
	}

	private ResponseStatus createResponseMessage(SubscribeCategory subscribeCategory, boolean subsriptionStatus) {

		StringBuilder msg = new StringBuilder();
		msg.append("Your Subscription to ");
		msg.append(subscribeCategory.getCategoryToBeSubscribed());

		if (!subsriptionStatus) {
			msg.append(" has been successfully added.");
			return new ResponseStatus("Login successful", msg.toString());
		}

		else {
			msg.append(" is already available");
			return new ResponseStatus("Login successful", msg.toString());
		}

	}
}
