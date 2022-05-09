package com.project.springbootapp.service;

import java.util.Optional;

import com.project.springbootapp.user.UserPayment;

public interface UserPaymentService {

	Optional<UserPayment> findById(Long id);
	
	void removeById(Long id);
}