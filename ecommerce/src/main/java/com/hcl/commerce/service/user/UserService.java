package com.hcl.commerce.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.entity.Users;

@Service
public interface UserService {

	Users registerUser(UserInputDTO dto);

	Users getUser(Long userId);

	Users deleteUser(Long userId);

	List<Users> getAllUser();

	Users getUser(String username, String password);

	Users updateUser(Long userId, UserInputDTO dto);

}
