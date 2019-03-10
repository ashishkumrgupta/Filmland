package com.filmland.springbootstarter.services;

import org.springframework.stereotype.Service;

import com.filmland.dto.ResponseStatus;
import com.filmland.dto.SubscribeCategory;
import com.filmland.util.SubscriptionUtil;

@Service
public class SubscribeService {

	private SubscriptionUtil subscriptionUtil = new SubscriptionUtil();

	public ResponseStatus addUserSubscriptionForCategory(SubscribeCategory subscribeCategory) {

		return subscriptionUtil.checkAndAddRequestedSubscriptionForUser(subscribeCategory);
	}
}
