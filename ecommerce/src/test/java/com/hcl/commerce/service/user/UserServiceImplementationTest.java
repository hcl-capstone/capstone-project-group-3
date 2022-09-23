package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.role.RoleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ContextConfiguration(classes = {UserServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplementationTest {
    @MockBean
    private JavaMailSender javaMailSender;
    @MockBean
    private RoleService roleService;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserServiceImplementation userServiceImplementation;
    /**
     * Method under test: {@link UserServiceImplementation#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() {
        Users users = new Users();
        users.setAddress(new HashSet<>());
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setIdToken("ABC123");
        users.setInvoices(new ArrayList<>());
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setRoles(new HashSet<>());
        users.setUserId(123L);
        users.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(userRepository).delete((Users) any());
        assertSame(users, userServiceImplementation.deleteUser(123L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((Users) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#deleteUser(Long)}
     */
    @Test
    void testDeleteUser2() {
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        doNothing().when(userRepository).delete((Users) any());
        assertNull(userServiceImplementation.deleteUser(123L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((Users) any());
    }
}

