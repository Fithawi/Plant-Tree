package com.project.springbootapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootapp.repository.PlantRepository;
import com.project.springbootapp.service.PlantService;
import com.project.springbootapp.user.Plant;

@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlantRepository plantRepository;
	
	public List<Plant> findAll() {
		
		return (List<Plant>) plantRepository.findAll();
	}

	@Override
	public Optional<Plant> findById(Long id) {
		// TODO Auto-generated method stub
		return plantRepository.findById(id);
	}

	
	
	

}
