package com.hoaxify.ws.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	UserRepository userRepository;

	public void saveUser(User user) {
		log.info("2> " + user.toString());
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		log.info("3> " + user.toString());
		
		userRepository.save(user);
	}
}