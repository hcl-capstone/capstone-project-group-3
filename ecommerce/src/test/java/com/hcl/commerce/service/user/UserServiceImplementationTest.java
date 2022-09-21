package com.hcl.commerce.service.user;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.entity.Users;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.role.RoleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
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
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(user);
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        assertSame(user, userServiceImplementation.registerUser(userInputDTO));
        verify(javaMailSender).send((SimpleMailMessage) any());
        verify(userRepository).save((Users) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#getUser(Long)}
     */
    @Test
    void testGetUser() {
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, userServiceImplementation.getUser(123L));
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
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(user);
        assertSame(user, userServiceImplementation.getUser("janedoe", "iloveyou"));
        verify(userRepository).findByUsernameAndPassword((String) any(), (String) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#updateUser(Long, UserInputDTO)}
     */
    @Test
    void testUpdateUser() {
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(user);
        Users user1 = new Users();
        user1.setAddresses(new HashSet<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setInvoices(new ArrayList<>());
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUserId(123L);
        user1.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        assertSame(user1, userServiceImplementation.updateUser(123L, userInputDTO));
        verify(userRepository).save((Users) any());
        verify(userRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#updateUser(Long, UserInputDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.hcl.commerce.service.user.UserServiceImplementation.getUser(UserServiceImplementation.java:40)
        //       at com.hcl.commerce.service.user.UserServiceImplementation.updateUser(UserServiceImplementation.java:67)
        //   In order to prevent updateUser(Long, UserInputDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateUser(Long, UserInputDTO).
        //   See https://diff.blue/R013 to resolve this issue.
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(user);
        when(userRepository.findById((Long) any())).thenReturn(null);
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        userServiceImplementation.updateUser(123L, userInputDTO);
    }
    /**
     * Method under test: {@link UserServiceImplementation#updateUser(Long, UserInputDTO)}
     */
    @Test
    void testUpdateUser3() {
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        when(userRepository.save((Users) any())).thenReturn(user);
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setEmail("jane.doe@example.org");
        userInputDTO.setFirstName("Jane");
        userInputDTO.setLastName("Doe");
        userInputDTO.setPassword("iloveyou");
        userInputDTO.setUsername("janedoe");
        assertNull(userServiceImplementation.updateUser(123L, userInputDTO));
        verify(userRepository).findById((Long) any());
    }
    /**
     * Method under test: {@link UserServiceImplementation#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() {
        Users user = new Users();
        user.setAddresses(new HashSet<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setInvoices(new ArrayList<>());
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(123L);
        user.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(userRepository).delete((Users) any());
        assertSame(user, userServiceImplementation.deleteUser(123L));
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
        ArrayList<Users> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<Users> actualAllUser = userServiceImplementation.getAllUser();
        assertSame(userList, actualAllUser);
        assertTrue(actualAllUser.isEmpty());
        verify(userRepository).findAll();
    }
}