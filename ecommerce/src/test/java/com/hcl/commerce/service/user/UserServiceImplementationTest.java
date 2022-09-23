package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.entity.Address;
import com.hcl.commerce.entity.Invoice;
import com.hcl.commerce.entity.Role;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.role.RoleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
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
     * Method under test: {@link UserServiceImplementation#registerUser(UserInputDTO)}
     */
    @Test
    void testRegisterUser() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());
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
        when(userRepository.save((Users) any())).thenReturn(users);
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setIdToken("ABC123");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        assertSame(users, userServiceImplementation.registerUser(userInputDTO));
        verify(javaMailSender).send((SimpleMailMessage) any());
        verify(userRepository).save((Users) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUser(Long)}
     */
    @Test
    void testGetUser() {
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
        assertSame(users, userServiceImplementation.getUser(123L));
        verify(userRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUser(Long)}
     */
    @Test
    void testGetUser2() {
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(userServiceImplementation.getUser(123L));
        verify(userRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUser(String, String)}
     */
    @Test
    void testGetUser3() {
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
        when(userRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(users);
        assertSame(users, userServiceImplementation.getUser("janedoe", "iloveyou"));
        verify(userRepository).findByUsernameAndPassword((String) any(), (String) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#updateUser(Long, UserInputDTO)}
     */
    @Test
    void testUpdateUser() {
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
        Users users1 = new Users();
        users1.setAddress(new HashSet<>());
        users1.setEmail("jane.doe@example.org");
        users1.setFirstName("Jane");
        users1.setIdToken("ABC123");
        users1.setInvoices(new ArrayList<>());
        users1.setLastName("Doe");
        users1.setPassword("iloveyou");
        users1.setRoles(new HashSet<>());
        users1.setUserId(123L);
        users1.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(users1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setIdToken("ABC123");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        assertSame(users1, userServiceImplementation.updateUser(123L, userInputDTO));
        verify(userRepository).save((Users) any());
        verify(userRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#updateUser(Long, UserInputDTO)}
     */
    @Test
    void testUpdateUser3() {
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
        when(userRepository.save((Users) any())).thenReturn(users);
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setIdToken("ABC123");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        assertNull(userServiceImplementation.updateUser(123L, userInputDTO));
        verify(userRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail() {
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
        when(userRepository.findByEmail((String) any())).thenReturn(users);
        assertSame(users, userServiceImplementation.getUserByEmail("jane.doe@example.org"));
        verify(userRepository).findByEmail((String) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUserByIdToken(String)}
     */
    @Test
    void testGetUserByIdToken() {
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
        when(userRepository.findByIdToken((String) any())).thenReturn(users);
        assertSame(users, userServiceImplementation.getUserByIdToken("ABC123"));
        verify(userRepository).findByIdToken((String) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUserByName(String)}
     */
    @Test
    void testGetUserByName() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(userServiceImplementation.getUserByName("Name").isEmpty());
        verify(userRepository).findAll();
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUserByName(String)}
     */
    @Test
    void testGetUserByName2() {
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
        ArrayList<Users> usersList = new ArrayList<>();
        usersList.add(users);
        when(userRepository.findAll()).thenReturn(usersList);
        assertTrue(userServiceImplementation.getUserByName("Name").isEmpty());
        verify(userRepository).findAll();
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUserByName(String)}
     */
    @Test
    void testGetUserByName3() {
        Users users = mock(Users.class);
        when(users.getLastName()).thenReturn("Doe");
        when(users.getFirstName()).thenReturn("Jane");
        doNothing().when(users).setAddress((Set<Address>) any());
        doNothing().when(users).setEmail((String) any());
        doNothing().when(users).setFirstName((String) any());
        doNothing().when(users).setIdToken((String) any());
        doNothing().when(users).setInvoices((List<Invoice>) any());
        doNothing().when(users).setLastName((String) any());
        doNothing().when(users).setPassword((String) any());
        doNothing().when(users).setRoles((Set<Role>) any());
        doNothing().when(users).setUserId((Long) any());
        doNothing().when(users).setUsername((String) any());
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
        ArrayList<Users> usersList = new ArrayList<>();
        usersList.add(users);
        when(userRepository.findAll()).thenReturn(usersList);
        assertEquals(1, userServiceImplementation.getUserByName("").size());
        verify(userRepository).findAll();
        verify(users).getFirstName();
        verify(users).setAddress((Set<Address>) any());
        verify(users).setEmail((String) any());
        verify(users).setFirstName((String) any());
        verify(users).setIdToken((String) any());
        verify(users).setInvoices((List<Invoice>) any());
        verify(users).setLastName((String) any());
        verify(users).setPassword((String) any());
        verify(users).setRoles((Set<Role>) any());
        verify(users).setUserId((Long) any());
        verify(users).setUsername((String) any());
    }
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
    /**
     * Method under test: {@link UserServiceImplementation#getAllUser()}
     */
    @Test
    void testGetAllUser() {
        ArrayList<Users> usersList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(usersList);
        List<Users> actualAllUser = userServiceImplementation.getAllUser();
        assertSame(usersList, actualAllUser);
        assertTrue(actualAllUser.isEmpty());
        verify(userRepository).findAll();
    }
}

