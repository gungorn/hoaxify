package com.hoaxify.ws.user;

import lombok.Data;

@Data //getter/setter - tostring - constructor - vs vs
public class User { //user model
	private String username;
	private String displayname;
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