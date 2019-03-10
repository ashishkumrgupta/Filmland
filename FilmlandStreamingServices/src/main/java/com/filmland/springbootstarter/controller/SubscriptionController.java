package com.filmland.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmland.dto.ResponseStatus;
import com.filmland.dto.SubscribeCategory;
import com.filmland.springbootstarter.services.SubscribeService;

@RestController
public class SubscriptionController {

	@Autowired
	private SubscribeService subscribeService;

	@RequestMapping(method = RequestMethod.POST, value = "/subscribeCategory")
	public ResponseStatus subscribeCategory(@RequestBody SubscribeCategory subscribeCategory) {
		return subscribeService.addUserSubscriptionForCategory(subscribeCategory);
	}
}
