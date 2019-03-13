package com.filmland.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmland.springbootstarter.dto.ShareCategoryInputModel;
import com.filmland.springbootstarter.dto.SubscribeCategoryInputModel;
import com.filmland.springbootstarter.services.SubscribeService;

@RestController
public class SubscriptionController {

	@Autowired
	private SubscribeService subscribeService;

	@RequestMapping(method = RequestMethod.POST, value = "/subscribeCategory")
	public void subscribeCategory(@RequestBody SubscribeCategoryInputModel subscribeCategory) {
		subscribeService.addUserSubscriptionForCategory(subscribeCategory);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shareCategory")
	public void shareUserSubscriptionCategory(@RequestBody ShareCategoryInputModel shareCategory) {
		subscribeService.shareUserCategoryWithExistingUser(shareCategory);
	}
}
