package com.hoaxify.ws.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@PostMapping("/api/v1/users") //post url path
	public void createUser(@RequestBody String body) {
		log.info(body); //body'yi info seviyesinde log'la
	}
}
