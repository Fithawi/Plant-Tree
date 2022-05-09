package com.project.springbootapp.service;

import java.util.Optional;

import com.project.springbootapp.user.UserShipping;

public interface UserShippingService {

	Optional<UserShipping> findById(Long id);
	
	void removeById(Long id);
}
