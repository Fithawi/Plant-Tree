package com.project.springbootapp.service;

import java.util.Set;

import com.project.springbootapp.user.User;
import com.project.springbootapp.user.security.PasswordResetToken;
import com.project.springbootapp.user.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	void createPasswordResetTokenForUser(final User user, final String token);
    User findByUsername(String username);
	
	User findByEmail (String email);
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
