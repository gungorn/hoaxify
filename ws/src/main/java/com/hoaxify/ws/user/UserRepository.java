package com.hoaxify.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //generic interface : domain model object - primary key

}
