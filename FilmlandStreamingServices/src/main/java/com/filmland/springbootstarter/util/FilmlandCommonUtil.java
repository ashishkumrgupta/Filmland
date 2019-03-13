package com.filmland.springbootstarter.util;

import java.time.LocalDate;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilmlandCommonUtil {

	private static final Logger logger = LoggerFactory.getLogger(FilmlandCommonUtil.class);

	public LocalDate getCurrentDate() {
		logger.info("local time: ", LocalDate.now());
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
}
