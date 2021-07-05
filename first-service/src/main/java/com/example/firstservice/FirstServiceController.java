package com.example.firstservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;
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
	
	Environment env;
	
	public FirstServiceController(Environment env) {
		// TODO Auto-generated constructor stub
		this.env = env;
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the First Service.";
	}

	@GetMapping("/message")
	public String message(@RequestHeader("first-request") String header) {
		log.info(header);

		return "Welcome to the First Service Message.";
	}
	
	@GetMapping("/check")
	public String check(HttpServletRequest request) {
		log.info("Server Port={}", request.getServerPort());
		return String.format("Hi, there, This is a message from First Servie on PORT %s.",env.getProperty("local.server.port"));
	}
}
