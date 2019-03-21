package com.filmland.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filmland.dbrepository.FilmlandUserRepository;
import com.filmland.dbrepository.SubscriptionRepository;
import com.filmland.dto.SubscribeCategoryInputModel;
import com.filmland.dto.SubscribedCategories;
import com.filmland.exceptions.UserNotFoundException;

@Component
public class FilmlandCommonUtil {

	private static final Logger logger = LoggerFactory.getLogger(FilmlandCommonUtil.class);

	@Autowired
	private FilmlandUserRepository filmlandUserRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	public LocalDate getCurrentDate() {
		logger.info("local time: {}", LocalDate.now());
		return LocalDate.now();
	}

	/**
	 * MEthod to check if the subscription has been expired.
	 * 
	 * @param subscriptionDate Subscription date of a user/
	 * @param month            for monthly subscription.
	 * @return {@link Boolean}
	 */
	public boolean checkIfSubscriptionDateExpiredBasedOnMonth(LocalDate subscriptionDate, long month) {
		LocalDate now = LocalDate.now();
		Period period = Period.between(now, subscriptionDate.plusMonths(month));
		return period.getDays() <= 0;
	}

	/**
	 * Method to check if the user is registered with the filmland
	 * 
	 * @param userID userId to be checked
	 * @return boolean value true if user is present or else
	 *         {@link UserNotFoundException}
	 */
	public boolean checkUserExistance(String userID) {
		boolean status = filmlandUserRepository.existsById(userID);
		if (!status) {
			throw new UserNotFoundException();
		} else {
			return status;
		}
	}

	/**
	 * Method to check if the user has already subscribed the requested category.
	 * 
	 * @param subscribeCategory
	 * @return true is category is already subscribed.
	 */
	public boolean checkSubsriptionStatus(SubscribeCategoryInputModel subscribeCategory) {
		List<SubscribedCategories> list = subscriptionRepository.findByemailIdAndCategoryName(
				subscribeCategory.getEmail(), subscribeCategory.getCategoryToBeSubscribed());
		logger.info("user is subscribed already {}", list.size());
		return list.isEmpty();
	}
}
