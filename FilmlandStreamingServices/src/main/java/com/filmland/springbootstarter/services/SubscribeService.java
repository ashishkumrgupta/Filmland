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

	public boolean addUserSubscriptionForCategory(SubscribeCategoryInputModel subscribeCategory) {
		return subscriptionUtil.checkAndAddRequestedSubscriptionForUser(subscribeCategory);
		
	}

	public boolean shareUserCategoryWithExistingUser(ShareCategoryInputModel shareCategory) {
		return shareSubscriptionUtil.checkAndShareCategoryWithUser(shareCategory);
	}
}
