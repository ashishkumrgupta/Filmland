package com.filmland.springbootstarter.util;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilmlandCommonUtil {

	private static final Logger logger = LoggerFactory.getLogger(FilmlandCommonUtil.class);

	public LocalDate getCurrentDate() {
		logger.info("local time: ", LocalDate.now());
		return LocalDate.now();
	}
}
