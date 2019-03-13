package com.filmland.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmland.dto.ResponseStatus;
import com.filmland.dto.ShareCategoryInputModel;
import com.filmland.dto.SubscribeCategoryInputModel;
import com.filmland.services.SubscribeService;

@RestController
@RequestMapping("/filmland")
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
