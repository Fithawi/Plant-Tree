package com.project.adminportal.service;

import java.util.List;
import java.util.Optional;

import com.project.adminportal.user.Plant;

public interface PlantService {
Plant save(Plant plant);
List<Plant> findAll();

Optional<Plant> findById(Long id);
}
