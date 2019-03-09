package com.filmland.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmland.dto.AvailableAndSubscribedCategories;
import com.filmland.springbootstarter.services.CategoryService;

@RestController
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/userSubscribedCategories")
	public AvailableAndSubscribedCategories getUserSubscribedCategory() {
		return categoryService.getUserSubscribedAndAllCategories();
	}
}
