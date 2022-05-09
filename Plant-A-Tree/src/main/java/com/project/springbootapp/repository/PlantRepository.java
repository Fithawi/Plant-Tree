package com.project.springbootapp.repository;



import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.Plant;

public interface PlantRepository extends CrudRepository<Plant,Long> {

	

	

}
