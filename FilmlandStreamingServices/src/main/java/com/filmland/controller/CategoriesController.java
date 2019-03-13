package com.filmland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmland.dto.AvailableAndSubscribedCategories;
import com.filmland.services.CategoryService;

@RestController
@RequestMapping("/filmland")
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/userSubscribedCategories/{user}")
	public AvailableAndSubscribedCategories getUserSubscribedCategory(@PathVariable String user) {
		return categoryService.getUserSubscribedAndAllCategories(user);
	}
}
