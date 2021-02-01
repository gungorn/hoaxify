package com.hoaxify.ws.user;

import javax.validation.Valid;

//import java.util.Date;
//import java.util.Map;
//import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class); // spring terminal log

	@Autowired
	UserService userService;

	@PostMapping("/api/v1/users") // post url
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		log.info("1> " + user.toString());

		userService.saveUser(user); // service'e bağlan (set - create)

		return ResponseEntity.ok(new GenericResponse("her şey yolunda"));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationException(MethodArgumentNotValidException exception) {
		log.info("VALIDATION ERROR");

		ApiError validationErrors = new ApiError(400, "Validation Error", "validerr", "api/v1/users");

		for (FieldError error : exception.getBindingResult().getFieldErrors())
			validationErrors.putError(error.getField(), error.getDefaultMessage());

		return validationErrors;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
		log.info("DATA INTEGRITY VIOLATION ERROR");

		ApiError errors = new ApiError(400, "Data Integriry Violation Error", "dataintviol", "api/v1/users");

		errors.putError("username", exception.getMessage());

		return errors;
	}
}
