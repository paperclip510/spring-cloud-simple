package com.example.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

// zuul
// http://localhost:8081/welcome
// spring cloud gateway 
// http://localhost:8081/first-service/welcome

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the First Service.";
	}

	@GetMapping("/message")
	public String message(@RequestHeader("first-request") String header) {
		log.info(header);

		return "Welcome to the First Service.";
	}
}
