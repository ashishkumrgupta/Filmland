package com.filmland.springbootstarter.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmland.springbootstarter.dto.ResponseStatus;
import com.filmland.springbootstarter.dto.ShareCategoryInputModel;
import com.filmland.springbootstarter.dto.SubscribeCategoryInputModel;
import com.filmland.springbootstarter.services.SubscribeService;

@RestController
public class SubscriptionController {

	@Autowired
	private SubscribeService subscribeService;

	@RequestMapping(method = RequestMethod.POST, value = "/subscribeCategory")
	public ResponseStatus subscribeCategory(@RequestBody SubscribeCategoryInputModel subscribeCategory) {
		return new ResponseStatus(new Date(), "Login successful", "Category is successfully subscribed.");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shareCategory")
	public ResponseStatus shareUserSubscriptionCategory(@RequestBody ShareCategoryInputModel shareCategory) {
		subscribeService.shareUserCategoryWithExistingUser(shareCategory);
		return new ResponseStatus(new Date(), "Login successful", "Category is successfully shared.");
	}
}
