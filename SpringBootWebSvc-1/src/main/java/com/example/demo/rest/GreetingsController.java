package com.example.demo.rest;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	Logger logger = LoggerFactory.getLogger(GreetingsController.class);

	@GetMapping("/defaultGreetings")
	public String defaultGreetings() {
		logger.info("Inside DefaultGreetings().. Info!");
		logger.debug("Inside DefaultGreetings().. Debug!");
		return "Hello from Application";
	}

	@GetMapping("/greetings/{name}")
	public String greetingWithName(@PathVariable String name) {
		logger.info("Inside greetingWithName().. ");
		return "Hello from " + name;
	}

	@GetMapping("/randomNumberGenerator")
	public ResponseEntity<String> randomNumberGenerator() {
		Random r = new Random();
		int numbers = 100000 + (int) (r.nextDouble() * 999999);
		if (numbers < 200000) {
			return new ResponseEntity<String>("Restricted Range  - Please try again", HttpStatus.FORBIDDEN);
		} else if (numbers < 300000) {
			return new ResponseEntity<String>("Number Not Valid - Please try again", HttpStatus.NOT_ACCEPTABLE);
		} else
			return new ResponseEntity<String>("Random Number is : " + numbers, HttpStatus.OK);
	}
}
