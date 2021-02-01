package com.hoaxify.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.hoaxify.ws.validator.UniqueUsername;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class User { // user model

	@Id // primary key
	@GeneratedValue
	private long id;

	@NotNull
	@Length(min = 6, max = 32)
	@Column(unique = true)
	@UniqueUsername // ben yazdım
	private String username;

	@NotNull
	@Length(min = 6, max = 64)
	private String displayname;

	private String testColumn;

	@NotNull
	@Length(min = 6, max = 64)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password is not secure")
	private String password;
}
