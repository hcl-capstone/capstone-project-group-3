package com.hcl.commerce.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.commerce.Email;
import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.entity.User;
import com.hcl.commerce.repository.UserRepository;
import com.hcl.commerce.service.role.RoleService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleService roleService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public User registerUser(UserInputDTO dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		Email.sendRegistrationMail(javaMailSender, user.getEmail(), user.getFirstName());
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User deleteUser(Long userId) {
		User user = getUser(userId);
		System.out.println("Deleting");
		userRepository.delete(user);
		System.out.println("Delete Success");
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User updateUser(Long userId, UserInputDTO dto) {
		User user = getUser(userId);
		if (user != null) {
			BeanUtils.copyProperties(dto, user);
			return userRepository.save(user);
		}
		return null;
	}

}
