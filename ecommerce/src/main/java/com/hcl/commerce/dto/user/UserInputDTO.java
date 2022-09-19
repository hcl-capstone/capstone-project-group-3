package com.hcl.commerce.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String IdToken; 
}
