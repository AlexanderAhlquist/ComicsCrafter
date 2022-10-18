package com.ahlquist.comics_crafter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Project by Alexander Ahlquist
 */
@SpringBootApplication
public class ComicsCrafterApplication {
	private static final Logger log = LoggerFactory.getLogger(ComicsCrafterApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ComicsCrafterApplication.class, args);
	}

}
