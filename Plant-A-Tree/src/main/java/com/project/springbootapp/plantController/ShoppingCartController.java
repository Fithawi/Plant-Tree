package com.project.springbootapp.plantController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springbootapp.service.CartItemService;
import com.project.springbootapp.service.PlantService;
import com.project.springbootapp.service.ShoppingCartService;
import com.project.springbootapp.service.UserService;
import com.project.springbootapp.user.CartItem;
import com.project.springbootapp.user.Plant;
import com.project.springbootapp.user.ShoppingCart;
import com.project.springbootapp.user.User;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private CartItemService cartItemService;
	
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlantService plantService;
	
	
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}
	@RequestMapping("/addItem")
	public String addItem(
			
			@ModelAttribute("plant") Optional<Plant> plant,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		plant = plantService.findById(plant.get().getId());
		model.addAttribute("plant",plant);
		
			/*
			 * if (Integer.parseInt(qty) > plant.getInStockNumber()) {
			 * model.addAttribute("notEnoughStock", true); return
			 * "forward:/plantDetail?id="+plant.get().getId(); }
			 */
		
		CartItem cartItem = cartItemService.addPlantToCartItem(plant, user, Integer.parseInt(qty));
		model.addAttribute("addPlantSuccess", true);
		
		return "forward:/plantDetail?id=" + plant.get().getId();
	}
	
	
}
