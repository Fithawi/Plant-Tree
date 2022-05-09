package com.project.springbootapp.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootapp.repository.ShoppingCartRepository;
import com.project.springbootapp.service.CartItemService;
import com.project.springbootapp.service.ShoppingCartService;
import com.project.springbootapp.user.CartItem;
import com.project.springbootapp.user.ShoppingCart;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal cartTotal = new BigDecimal(0);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			if(cartItem.getPlant().getInStockNumber() > 0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal = cartTotal.add(cartItem.getSubtotal());
			}
		}
		
		 shoppingCart.setGrandTotal(cartTotal);
		
		shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}

}
