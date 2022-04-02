package com.project.springbootapp.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootapp.repository.PasswordResetTokenRepository;
import com.project.springbootapp.repository.RoleRepository;
import com.project.springbootapp.repository.UserRepository;
import com.project.springbootapp.service.UserService;
import com.project.springbootapp.user.User;
import com.project.springbootapp.user.security.PasswordResetToken;
import com.project.springbootapp.user.security.UserRole;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}
	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public User findByEmail (String email) {
		return userRepository.findByEmail(email);
	}
	@Autowired
	private RoleRepository roleRepository;
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		User localUser = userRepository.findByUsername(user.getUsername());
		if(localUser != null) {
			throw new Exception("user already exists. Nothing will be done.");
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
			}
		return localUser;
	}
	
}
