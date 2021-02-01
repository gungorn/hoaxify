package com.hoaxify.ws.repository;

import com.hoaxify.ws.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

//generic interface : domain model object - primarykey
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username); // ismi önemli

}
