package com.filmland.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping("/subscribeCategory")
	public ResponseStatus subscribeCategory(@RequestBody SubscribeCategoryInputModel subscribeCategory) {
		subscribeService.addUserSubscriptionForCategory(subscribeCategory);
		return new ResponseStatus(new Date(), "Login successful", "Category is successfully subscribed.");
	}

	@PostMapping("/shareCategory")
	public ResponseStatus shareUserSubscriptionCategory(@RequestBody ShareCategoryInputModel shareCategory) {
		subscribeService.shareUserCategoryWithExistingUser(shareCategory);
		return new ResponseStatus(new Date(), "Login successful", "Category is successfully shared.");
	}
}
