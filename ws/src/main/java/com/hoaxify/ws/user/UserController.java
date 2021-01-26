package com.hoaxify.ws.user;

//import java.util.Date;
//import java.util.Map;
//import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class); //spring terminal log

	@Autowired
	UserService userService;

	//@CrossOrigin //farklı portlardan erişim
	//@ResponseStatus(HttpStatus.CREATED) //request status değiştirme (default : 200 OK)
	@PostMapping("/api/v1/users") //post url
	public ResponseEntity<?> createUser(@RequestBody User user) {
		log.info("1> " + user.toString());

		String username = user.getUsername();
		String displayname = user.getDisplayname();
		String password = user.getPassword();

		
		//// VALIDATION ERRORS
		ApiError validationErrors = new ApiError(400, "Validation Error", "validerr", "api/v1/users");
		
		if(username == null || username.isEmpty()) validationErrors.putError("username", "Username cannot be null");
		if(displayname == null || displayname.isEmpty()) validationErrors.putError("displayname", "Displayname cannot be null");
		if(password == null || password.isEmpty()) validationErrors.putError("password", "Password cannot be null");
		
		if (!validationErrors.getErrors().isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(validationErrors);
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		userService.saveUser(user); //service'e bağlan (set - create)

		return ResponseEntity.ok(new GenericResponse("her şey yolunda"));
	}
}
