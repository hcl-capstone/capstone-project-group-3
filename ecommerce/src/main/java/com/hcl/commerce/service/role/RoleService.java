package com.hcl.commerce.service.role;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.role.RoleAddDTO;
import com.hcl.commerce.dto.role.RoleDTO;
import com.hcl.commerce.entity.Role;

@Service
public interface RoleService {

	Role getRole(Long id);

	Role addRole(RoleAddDTO dto);

	List<Role> getAllRole();

	Role updateRole(RoleDTO dto);

	Role deleteRole(Long id);
}
