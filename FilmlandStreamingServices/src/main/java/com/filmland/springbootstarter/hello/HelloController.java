package com.filmland.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hi";
	}
	@RequestMapping("/helloo")
	public String nextHello() {
		return "hi you";
	}
}