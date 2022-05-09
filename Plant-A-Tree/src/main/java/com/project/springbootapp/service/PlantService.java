package com.project.springbootapp.service;

import java.util.List;
import java.util.Optional;

import com.project.springbootapp.user.Plant;

public interface PlantService {
	List<Plant> findAll ();
	
	Optional<Plant> findById(Long id);
	
}
