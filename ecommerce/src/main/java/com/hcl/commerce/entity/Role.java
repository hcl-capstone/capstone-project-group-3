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
@Table(name = "role")
@Setter
@Getter
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;
}
