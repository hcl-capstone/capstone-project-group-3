package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.entity.User;
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
        User user = new User();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(userRepository).delete((User) any());
        assertSame(user, userServiceImplementation.deleteUser(123L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#deleteUser(Long)}
     */
    @Test
    void testDeleteUser2() {
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        doNothing().when(userRepository).delete((User) any());
        assertNull(userServiceImplementation.deleteUser(123L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
    }
}

