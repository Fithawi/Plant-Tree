package com.project.springbootapp.service;

import java.util.List;
import java.util.Optional;

import com.project.springbootapp.user.CartItem;
import com.project.springbootapp.user.Plant;
import com.project.springbootapp.user.ShoppingCart;
import com.project.springbootapp.user.User;

public interface CartItemService {

List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	

  CartItem updateCartItem(CartItem cartItem);
  
CartItem addPlantToCartItem(Optional <Plant> plant, User user, int qty);
 /* 
 * CartItem findById(Long id);
 * 
 * void removeCartItem(CartItem cartItem);
 * 
 * CartItem save(CartItem cartItem);
 * 
 * List<CartItem> findByOrder(Order order);
 */
}
