package com.project.springbootapp.service;

import com.project.springbootapp.user.User;
import com.project.springbootapp.user.security.PasswordResetToken;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	void createPasswordResetTokenForUser(final User user, final String token);
}
