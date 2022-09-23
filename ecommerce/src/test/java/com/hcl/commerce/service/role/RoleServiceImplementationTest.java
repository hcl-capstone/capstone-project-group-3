package com.hcl.commerce.service.role;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.role.RoleAddDTO;
import com.hcl.commerce.dto.role.RoleDTO;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {RoleServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class RoleServiceImplementationTest {
    @MockBean
    private RoleRepository roleRepository;
    @Autowired
    private RoleServiceImplementation roleServiceImplementation;
    /**
     * Method under test: {@link RoleServiceImplementation#getRole(Long)}
     */
    @Test
    void testGetRole() {
        Role role = new Role();
        role.setRoleId(123L);
        role.setRoleName("Role Name");
        Optional<Role> ofResult = Optional.of(role);
        when(roleRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(role, roleServiceImplementation.getRole(123L));
        verify(roleRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RoleServiceImplementation#getRole(Long)}
     */
    @Test
    void testGetRole2() {
        when(roleRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(roleServiceImplementation.getRole(123L));
        verify(roleRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RoleServiceImplementation#addRole(RoleAddDTO)}
     */
    @Test
    void testAddRole() {
        Role role = new Role();
        role.setRoleId(123L);
        role.setRoleName("Role Name");
        when(roleRepository.save((Role) any())).thenReturn(role);
        RoleAddDTO roleAddDTO = new RoleAddDTO();
        roleAddDTO.setRoleName("Role Name");
        assertSame(role, roleServiceImplementation.addRole(roleAddDTO));
        verify(roleRepository).save((Role) any());
    }
    /**
     * Method under test: {@link RoleServiceImplementation#getAllRole()}
     */
    @Test
    void testGetAllRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        when(roleRepository.findAll()).thenReturn(roleList);
        List<Role> actualAllRole = roleServiceImplementation.getAllRole();
        assertSame(roleList, actualAllRole);
        assertTrue(actualAllRole.isEmpty());
        verify(roleRepository).findAll();
    }
    /**
     * Method under test: {@link RoleServiceImplementation#updateRole(RoleDTO)}
     */
    @Test
    void testUpdateRole() {
        Role role = new Role();
        role.setRoleId(123L);
        role.setRoleName("Role Name");
        Optional<Role> ofResult = Optional.of(role);
        Role role1 = new Role();
        role1.setRoleId(123L);
        role1.setRoleName("Role Name");
        when(roleRepository.save((Role) any())).thenReturn(role1);
        when(roleRepository.findById((Long) any())).thenReturn(ofResult);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(123L);
        roleDTO.setRoleName("Role Name");
        assertSame(role1, roleServiceImplementation.updateRole(roleDTO));
        verify(roleRepository).save((Role) any());
        verify(roleRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RoleServiceImplementation#updateRole(RoleDTO)}
     */
    @Test
    void testUpdateRole3() {
        Role role = new Role();
        role.setRoleId(123L);
        role.setRoleName("Role Name");
        when(roleRepository.save((Role) any())).thenReturn(role);
        when(roleRepository.findById((Long) any())).thenReturn(Optional.empty());
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(123L);
        roleDTO.setRoleName("Role Name");
        assertNull(roleServiceImplementation.updateRole(roleDTO));
        verify(roleRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link RoleServiceImplementation#deleteRole(Long)}
     */
    @Test
    void testDeleteRole() {
        Role role = new Role();
        role.setRoleId(123L);
        role.setRoleName("Role Name");
        Optional<Role> ofResult = Optional.of(role);
        when(roleRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(roleRepository).delete((Role) any());
        assertSame(role, roleServiceImplementation.deleteRole(123L));
        verify(roleRepository).findById((Long) any());
        verify(roleRepository).delete((Role) any());
    }
    /**
     * Method under test: {@link RoleServiceImplementation#deleteRole(Long)}
     */
    @Test
    void testDeleteRole2() {
        when(roleRepository.findById((Long) any())).thenReturn(Optional.empty());
        doNothing().when(roleRepository).delete((Role) any());
        assertNull(roleServiceImplementation.deleteRole(123L));
        verify(roleRepository).findById((Long) any());
        verify(roleRepository).delete((Role) any());
    }
}

