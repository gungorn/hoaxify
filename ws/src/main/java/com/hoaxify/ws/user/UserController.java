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

import com.hoaxify.ws.shared.GenericResponse;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class); //spring terminal log

	@Autowired
	UserService userService;

	//@CrossOrigin //farklı portlardan erişim
	@PostMapping("/api/v1/users") //post url
	@ResponseStatus(HttpStatus.CREATED) //request status değiştirme (default : 200 OK)
	public GenericResponse createUser(@RequestBody User user) {
		log.info("1> " + user.toString());

		userService.saveUser(user); //service'e bağlan
		
		return new GenericResponse("dandini dandini dastana"); //http request response
	}
}
