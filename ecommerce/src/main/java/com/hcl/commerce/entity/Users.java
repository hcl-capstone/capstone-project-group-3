package com.hcl.commerce.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String idToken; 

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private List<Invoice> invoices = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_user", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_address", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "address_id"))
	private Set<Address> addresses = new HashSet<>();

	public void addInvoice(Invoice invoice) {
		this.invoices.add(invoice);
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}
}
