package com.filmland.springbootstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FilmlandServicesStarter {

	private static final Logger logger = LoggerFactory.getLogger(FilmlandServicesStarter.class);

	public static void main(String[] args) {
		logger.info("Starting FilmlandServices.");
		SpringApplication.run(FilmlandServicesStarter.class, args);
	}

}
