package com.filmland.util;

import com.filmland.dto.ShareCategory;

/**
 * @author Ashish
 * 
 *         Helper class with methods for Sharing the categories with the
 *         existing users.
 *
 */
public class ShareSubscriptionUtil {

	/**
	 * Method to check and share the requested category with only existing users.
	 * 
	 * @param shareCategory Details of the user.
	 */
	public void checkAndShareCategoryWithUser(ShareCategory shareCategory) {
		boolean userExistanceStatus = checkRequesteddUxserExistence(shareCategory);

		if (userExistanceStatus) {
			// update database for main user --Shared with---
			// customer --- subscribed category, start date , remaining---
		} else {
			// you can not share the category as provided user doesn't exist.
		}
	}

	/**
	 * Method to check if the requested customer by user is in the subscription or
	 * not.
	 * 
	 * @param shareCategory Details of the user.
	 */
	public boolean checkRequesteddUxserExistence(ShareCategory shareCategory) {
		// check here in data base if the requested user exists.
		return true;
	}
}
