package com.filmland.springbootstarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmland.springbootstarter.dto.ResponseStatus;
import com.filmland.springbootstarter.dto.ShareCategoryInputModel;
import com.filmland.springbootstarter.dto.SubscribeCategoryInputModel;
import com.filmland.springbootstarter.util.ShareSubscriptionUtil;
import com.filmland.springbootstarter.util.SubscriptionUtil;

@Service
public class SubscribeService {

	@Autowired
	private SubscriptionUtil subscriptionUtil;

	@Autowired
	private ShareSubscriptionUtil shareSubscriptionUtil;

	public void addUserSubscriptionForCategory(SubscribeCategoryInputModel subscribeCategory) {
		boolean status = subscriptionUtil.checkAndAddRequestedSubscriptionForUser(subscribeCategory);
		
	}

	public void shareUserCategoryWithExistingUser(ShareCategoryInputModel shareCategory) {
		shareSubscriptionUtil.checkAndShareCategoryWithUser(shareCategory);
	}
}
