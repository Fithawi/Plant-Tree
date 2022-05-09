package com.project.springbootapp.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootapp.repository.CartItemRepository;
import com.project.springbootapp.repository.PlantToCartItemRepository;
import com.project.springbootapp.service.CartItemService;
import com.project.springbootapp.user.CartItem;
import com.project.springbootapp.user.Plant;
import com.project.springbootapp.user.PlantToCartItem;
import com.project.springbootapp.user.ShoppingCart;
import com.project.springbootapp.user.User;

@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private PlantToCartItemRepository plantToCartItemRepository;
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getPlant().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
				/*.setScale(2, BigDecimal.ROUND_HALF_UP);*/
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
	
	public CartItem addPlantToCartItem(Optional <Plant> plant, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if(plant.get().getId() == cartItem.getPlant().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(plant.get().getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		/* cartItem.setPlant(plant); */
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(plant.get().getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
		
		PlantToCartItem plantToCartItem = new PlantToCartItem();
		/* plantToCartItem.setPlant(plant); */
		plantToCartItem.setCartItem(cartItem);
		plantToCartItemRepository.save(plantToCartItem);
		
		return cartItem;
	}
	
	
}
