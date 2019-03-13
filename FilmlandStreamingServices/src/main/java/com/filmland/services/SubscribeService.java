package com.filmland.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmland.dto.ResponseStatus;
import com.filmland.dto.ShareCategoryInputModel;
import com.filmland.dto.SubscribeCategoryInputModel;
import com.filmland.util.ShareSubscriptionUtil;
import com.filmland.util.SubscriptionUtil;

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
