package com.hcl.commerce.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.entity.User;

@Service
public interface UserService {

	User registerUser(UserInputDTO dto);

	User getUser(Long userId);

	User deleteUser(Long userId);

	List<User> getAllUser();

	User getUser(String username, String password);

	User updateUser(Long userId, UserInputDTO dto);

}
