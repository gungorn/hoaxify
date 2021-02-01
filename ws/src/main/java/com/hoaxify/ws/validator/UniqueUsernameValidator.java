package com.hoaxify.ws.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hoaxify.ws.model.User;
import com.hoaxify.ws.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		User u = userRepository.findByUsername(username);

		return u == null;
	}
}
