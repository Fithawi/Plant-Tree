package com.project.adminportal.service;

import java.util.Set;

import com.project.adminportal.user.User;
import com.project.adminportal.user.security.UserRole;

public interface UserService {
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	User save(User user);
}
