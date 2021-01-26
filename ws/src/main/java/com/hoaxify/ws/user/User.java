package com.hoaxify.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data //getter/setter - tostring - constructor - vs vs
@Entity
public class User { //user model
	
	@Id //primary key
	@GeneratedValue
	private long id;
	
	@NotNull
	@Length(min = 6, max = 32)
	private String username;

	@NotNull
	@Length(min = 6, max = 64)
	private String displayname;
	

	@NotNull
	@Length(min = 6, max = 64)
	private String password;

	// public String getUsername() { return username; }
	// public void setUsername(String username) { this.username = username; }

	// public String getDisplayname() { return displayname; }
	// public void setDisplayname(String displayname) { this.displayname = displayname; }

	// public String getPassword() { return password; }
	// public void setPassword(String password) { this.password = password; }

	// @Override
	// public String toString() {
	// 	return "User [username=" + username + ", displayname=" + displayname + ", password=" + password + "]";
	// }
}
