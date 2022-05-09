package com.project.springbootapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootapp.repository.UserShippingRepository;
import com.project.springbootapp.service.UserShippingService;
import com.project.springbootapp.user.UserShipping;

@Service

public class UserShippingServiceImpl implements UserShippingService{
	
@Autowired
private UserShippingRepository userShippingRepository;

	@Override
	public Optional<UserShipping> findById(Long id) {
		// TODO Auto-generated method stub
		return userShippingRepository.findById(id);
	}

	@Override
	public void removeById(Long id) {
		// TODO Auto-generated method stub
		userShippingRepository.deleteById(id);
	}

}
