package com.hcl.commerce.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
}
