package com.hcl.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.commerce.dto.role.RoleAddDTO;
import com.hcl.commerce.dto.role.RoleDTO;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.service.role.RoleService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
public class RoleController {
	@Autowired
	RoleService serv;
	
	@PostMapping("role/add")
	public Role createRole(@RequestBody RoleAddDTO dto) {
		log.info("User_role was added");
		return serv.addRole(dto);
	}
	
	@GetMapping("role/all")
	public List<Role> allRole() {
		log.info("All user_role were requested");
		return serv.getAllRole();
	}
	
	@PostMapping("role/update")
	public Role updateRole(@RequestBody RoleDTO dto) {
		log.info("User_roles were updated");
		return serv.updateRole(dto);
	}
	
	@GetMapping("role/get/{id}")
	public Role getRole(@PathVariable Long id) {
		log.info("User_role got got");
		return serv.getRole(id);
	}
	
	@DeleteMapping("role/delete/{id}")
	public Role deleteRole(@PathVariable Long id) {
		log.info("A user_role was deleted");
		return serv.deleteRole(id);
	}

	
}
