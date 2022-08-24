package com.hcl.commerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_role")
@Getter
@Setter
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

}
