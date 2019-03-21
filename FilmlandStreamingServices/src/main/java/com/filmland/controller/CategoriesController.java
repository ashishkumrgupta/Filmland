package com.filmland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/userSubscribedCategories/{user}")
	public Resource<AvailableAndSubscribedCategories> getUserSubscribedCategory(@PathVariable String user) {
		Resource<AvailableAndSubscribedCategories> result = new Resource<>(
				categoryService.getUserSubscribedAndAllCategories(user));
		Link link = new Link("http://localhost:8080/filmland/userSubscribedCategories/");
		result.add(link);
		return result;
	}
}
