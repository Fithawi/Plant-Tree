package com.project.springbootapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.springbootapp.user.CartItem;
import com.project.springbootapp.user.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem,Long>{

	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
}
