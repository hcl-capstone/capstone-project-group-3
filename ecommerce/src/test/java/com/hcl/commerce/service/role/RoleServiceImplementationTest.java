package com.hcl.commerce.service.role;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.role.RoleAddDTO;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.repository.RoleRepository;
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
}

