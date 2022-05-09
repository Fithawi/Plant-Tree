package com.project.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long>{

}
