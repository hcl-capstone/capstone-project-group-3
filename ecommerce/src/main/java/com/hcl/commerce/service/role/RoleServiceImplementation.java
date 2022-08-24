package com.hcl.commerce.service.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.role.RoleAddDTO;
import com.hcl.commerce.dto.role.RoleDTO;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.repository.RoleRepository;

@Service
public class RoleServiceImplementation implements RoleService{

	@Autowired
	RoleRepository repo;
	
	@Override
	public Role getRole(Long id) {
		Optional<Role> role = repo.findById(id);
		if (role.isPresent()) {
			return role.get();
		}
		return null;
	}

	@Override
	public Role addRole(RoleAddDTO dto) {
		Role role = new Role();
		BeanUtils.copyProperties(dto, role);
		return repo.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		return repo.findAll();
	}

	@Override
	public Role updateRole(RoleDTO dto) {
		Role cat = getRole(dto.getRoleId());
		if(cat != null) {
			BeanUtils.copyProperties(dto, cat);
			return repo.save(cat);
		}
		return null;
	}

	@Override
	public Role deleteRole(Long id) {
		Role role = getRole(id);
		repo.delete(role);
		return role;
	}

}
