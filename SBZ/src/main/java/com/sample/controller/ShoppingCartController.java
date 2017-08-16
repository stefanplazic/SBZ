package com.sample.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.CartItemDTO;
import com.sample.dto.MessagesDTO;
import com.sample.model.Article;
import com.sample.model.Cart;
import com.sample.model.CartItem;
import com.sample.model.User;
import com.sample.repository.UserRepository;
import com.sample.service.ArticleService;
import com.sample.service.CartItemService;
import com.sample.service.CartService;

@RestController
@RequestMapping(value = "api/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartService cartService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<MessagesDTO> addItem(Principal principal, @RequestBody CartItemDTO cartItemDTO) {

		User user = userRepository.findByUsername(principal.getName());
		MessagesDTO dto = new MessagesDTO();
		if (user == null || !user.getUserRola().getRole().getName().equalsIgnoreCase("USER")) {
			dto.setError("Must be logged as customer!");
			return new ResponseEntity<MessagesDTO>(HttpStatus.UNAUTHORIZED);
		}

		// get the cart if exists
		Cart myCart = cartService.findByUser(user);

		if (myCart == null) {
			// if cart is null
			myCart = new Cart();
			myCart.setUser(user);
		}

		// check if article with that id exists
		Article article = articleService.findOne(cartItemDTO.getArticle().getId());
		if (article == null) {
			System.out.println("Usao u article");
			dto.setError("Given article doesn't exists.");
			return new ResponseEntity<MessagesDTO>(dto, HttpStatus.BAD_REQUEST);
		}

		// save cartItem to Shoppin-cart
		CartItem itemToSave = new CartItem();
		itemToSave.setCount(cartItemDTO.getCount());
		itemToSave.setArticle(article);
		myCart.getCartItems().add(itemToSave);

		// save cartItem
		itemToSave = cartItemService.save(itemToSave);
		// save cart
		cartService.save(myCart);

		return new ResponseEntity<MessagesDTO>(HttpStatus.OK);
	}
}
