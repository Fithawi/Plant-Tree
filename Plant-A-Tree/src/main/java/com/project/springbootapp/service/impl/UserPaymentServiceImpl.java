package com.project.springbootapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootapp.repository.UserPaymentRepository;
import com.project.springbootapp.service.UserPaymentService;
import com.project.springbootapp.user.UserPayment;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Override
	public Optional <UserPayment> findById(Long id) {
		// TODO Auto-generated method stub
		return userPaymentRepository.findById(id);
	}


	public void removeById(Long id) {
		// TODO Auto-generated method stub
		
		userPaymentRepository.deleteById(id);
	}

	
}
