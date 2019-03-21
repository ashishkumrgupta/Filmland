package com.filmland.scheduler;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.filmland.dbrepository.SubscriptionRepository;
import com.filmland.dto.SubscribedCategories;
import com.filmland.util.FilmlandCommonUtil;

/**
 * class having scheduler to automatically check the expired subscription of the
 * users.
 * 
 * @author ashis
 *
 */
@Component
public class FilmlandUserSubscriptionChecker {
	private static final Logger logger = LoggerFactory.getLogger(FilmlandUserSubscriptionChecker.class);

	private static final String INACTIVE_SUBSCRIPTION = "N";
	private static final String ACTIVE_SUBSCRIPTION = "Y";

	@Value("${filmland.app.freeSubscriptionMonthDuration}")
	private long freeSubscriptionMonthDuration;

	@Value("${filmland.app.paymentCycleMonthDuration}")
	private long paymentCycleMonthDuration;

	@Autowired
	private SubscriptionRepository subscriptionInfoRepository;

	@Autowired
	private FilmlandCommonUtil filmlandCommonUtil;

	@Scheduled(cron = "0 0/2 * 1/1 * ?")
	public void checkAndUpdateStatusOfSubscriptions() {

		List<SubscribedCategories> activeSubscriptions = subscriptionInfoRepository
				.findBySubscriptionStatus(ACTIVE_SUBSCRIPTION);

		if (!activeSubscriptions.isEmpty()) {
			logger.info("Total service with active subscription : {}", activeSubscriptions.size());

			List<SubscribedCategories> expiredSubscriptions = activeSubscriptions.parallelStream()
					.map(curentSubscription -> {
						if (filmlandCommonUtil.checkIfSubscriptionDateExpiredBasedOnMonth(
								curentSubscription.getSubscriptionStartDate(), paymentCycleMonthDuration)
								|| filmlandCommonUtil.checkIfSubscriptionDateExpiredBasedOnMonth(
										curentSubscription.getSubscriptionStartDate(), freeSubscriptionMonthDuration)) {
							if (curentSubscription.getIsNewMember().equals(ACTIVE_SUBSCRIPTION)) {
								curentSubscription.setIsNewMember(INACTIVE_SUBSCRIPTION);
							}
							curentSubscription.setStatus(INACTIVE_SUBSCRIPTION);
						}
						return curentSubscription;
					}).collect(Collectors.toList());

			if (null != expiredSubscriptions && !expiredSubscriptions.isEmpty()) {
				logger.info("After scan the number of services with inactive subscriptions are : {}",
						expiredSubscriptions.size());
				expiredSubscriptions.forEach(subscriptionInfo -> subscriptionInfoRepository.save(subscriptionInfo));
			}
		}
	}
}
