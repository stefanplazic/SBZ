package com.sample.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.MessagesDTO;
import com.sample.model.Cart;
import com.sample.model.User;
import com.sample.repository.CartRepository;
import com.sample.repository.UserRepository;

@RestController
@RequestMapping(value = "api/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<MessagesDTO> getAllCategory(Principal principal) {
		User user = userRepository.findByUsername(principal.getName());
		MessagesDTO dto = new MessagesDTO();
		if (user == null || !user.getUserRola().getRole().getName().equalsIgnoreCase("USER")) {
			dto.setError("Must be logged as customer!");
			return new ResponseEntity<MessagesDTO>(HttpStatus.UNAUTHORIZED);
		}

		// get the cart if exists
		Cart myCart = cartRepository.findByUser(user);

		if (myCart == null) {
			// if cart is null
			myCart = new Cart();

		}

		return new ResponseEntity<MessagesDTO>(HttpStatus.OK);
	}
}
