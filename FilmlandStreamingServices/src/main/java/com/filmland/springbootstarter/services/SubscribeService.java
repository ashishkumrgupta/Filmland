package com.filmland.springbootstarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmland.springbootstarter.dto.ResponseStatus;
import com.filmland.springbootstarter.dto.ShareCategory;
import com.filmland.springbootstarter.dto.SubscribeCategory;
import com.filmland.springbootstarter.util.ShareSubscriptionUtil;
import com.filmland.springbootstarter.util.SubscriptionUtil;

@Service
public class SubscribeService {

	@Autowired
	private SubscriptionUtil subscriptionUtil;

	@Autowired
	private ShareSubscriptionUtil shareSubscriptionUtil;

	public ResponseStatus addUserSubscriptionForCategory(SubscribeCategory subscribeCategory) {

		return subscriptionUtil.checkAndAddRequestedSubscriptionForUser(subscribeCategory);
	}

	public void shareUserCategoryWithExistingUser(ShareCategory shareCategory) {
		shareSubscriptionUtil.checkAndShareCategoryWithUser(shareCategory);
	}
}
