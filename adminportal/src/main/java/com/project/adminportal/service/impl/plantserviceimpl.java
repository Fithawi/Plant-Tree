package com.project.adminportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adminportal.repository.PlantRepository;
import com.project.adminportal.service.PlantService;
import com.project.adminportal.user.Plant;

@Service
public class plantserviceimpl implements PlantService{

	@Autowired
	private PlantRepository plantRepository;
	
	public Plant save(Plant plant) {
		
		return plantRepository.save(plant);
	}
	public List<Plant> findAll(){
		return (List<Plant>) plantRepository.findAll();
		
	}
	@Override
	public Optional<Plant> findById(Long id) {
		// TODO Auto-generated method stub
		return plantRepository.findById(id);
	}
}
