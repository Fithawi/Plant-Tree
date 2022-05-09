package com.project.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.PlantToCartItem;

public interface PlantToCartItemRepository extends CrudRepository<PlantToCartItem,Long> {

	
	
}
