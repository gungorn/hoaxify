package com.hoaxify.ws.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController //burada fena olaylar dönüyor!
public class UserController {


	private static final Logger log = LoggerFactory.getLogger(UserController.class);


	@Autowired
	UserService userService;

	//@CrossOrigin //
	@PostMapping("/api/v1/users") //post url path
	@ResponseStatus(HttpStatus.CREATED) //request status değiştirme (default : 200 OK)
	public void createUser(@RequestBody User user) {
		log.info(user.toString()); //body'yi info seviyesinde log'la

		userService.save(user);
	}
}
