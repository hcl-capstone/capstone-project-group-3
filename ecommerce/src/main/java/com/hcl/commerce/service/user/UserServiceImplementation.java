package com.hcl.commerce.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.commerce.Email;
import com.hcl.commerce.dto.user.UserInputDTO;
import com.hcl.commerce.entity.Users;
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
	public Users registerUser(UserInputDTO dto) {
		Users user = new Users();
		BeanUtils.copyProperties(dto, user);
		Email.sendRegistrationMail(javaMailSender, user.getEmail(), user.getFirstName());
		return userRepository.save(user);
	}

	@Override
	public Users getUser(Long userId) {
		Optional<Users> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public Users deleteUser(Long userId) {
		Users user = getUser(userId);
		System.out.println("Deleting");
		userRepository.delete(user);
		System.out.println("Delete Success");
		return user;
	}

	@Override
	public List<Users> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Users getUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Users updateUser(Long userId, UserInputDTO dto) {
		Users user = getUser(userId);
		if (user != null) {
			BeanUtils.copyProperties(dto, user);
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public Users getUserByEmail(String userEmail) {
		return userRepository.findByEmail(userEmail);
	}

	@Override
	public Users getUserByIdToken(String idToken) {
		return userRepository.findByIdToken(idToken); 
	}

}
