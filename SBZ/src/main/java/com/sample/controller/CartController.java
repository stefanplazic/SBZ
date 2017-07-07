package com.sample.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.CartDTO;
import com.sample.model.Article;
import com.sample.model.Cart;
import com.sample.model.CategoryArticle;
import com.sample.model.ListActionCategory;
import com.sample.model.User;
import com.sample.repository.ArticleRepository;
import com.sample.repository.CartRepository;
import com.sample.repository.CategoryArticleRepository;
import com.sample.repository.ListActionCategoryRepository;
import com.sample.repository.UserRepository;

@RestController
@RequestMapping(value = "api/cart")
public class CartController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryArticleRepository categoryRepository;
	
	@Autowired
	private ListActionCategoryRepository actionRepository;
	
	@Autowired
	private CartRepository cartRepository;

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addCart(@RequestBody CartDTO cartDTO, Principal principal) {
		
		Cart cart = new Cart();
		Date date = new Date();
		User user = userRepository.findByUsername(principal.getName());
		Article article = articleRepository.findOne(cartDTO.getArticleDTO().getId());
		CategoryArticle category = categoryRepository.findOne(article.getPodCategory().getCategoryArticle().getId());
		ListActionCategory listAction = actionRepository.findByCategoryArticle(category);

		if(listAction != null){

			if(listAction.getActionEvent().getEndDate() == date){
				if(listAction.getActionEvent().getEndDate().getTime() >= date.getTime()){
					/*
					 * Treba implementirati da akcija nestane
					 */

					return new ResponseEntity<>(HttpStatus.OK);
				} else {

					double discountArticle = article.getPrice() - ((article.getPrice() * listAction.getActionEvent().getProcent() ) / 100 );
					cart.setArticle(article);
					cart.setUser(user);
					cart.setPrice(article.getPrice());
					cart.setCount(cartDTO.getCount());
					cart.setNewPrice(discountArticle * cartDTO.getCount());
					cart.setDiscountArticle(discountArticle);
					
					cartRepository.save(cart);

					return new ResponseEntity<>(HttpStatus.OK);
				}
			} else {
				
				double discountArticle = article.getPrice() - ((article.getPrice() * listAction.getActionEvent().getProcent() ) / 100 );
				cart.setArticle(article);
				cart.setUser(user);
				cart.setPrice(article.getPrice());
				cart.setCount(cartDTO.getCount());
				cart.setNewPrice(discountArticle * cartDTO.getCount());
				cart.setDiscountArticle(discountArticle);
				
				cartRepository.save(cart);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
		} else {

			cart.setArticle(article);
			cart.setUser(user);
			cart.setPrice(article.getPrice());
			cart.setCount(cartDTO.getCount());
			cart.setNewPrice(article.getPrice() * cartDTO.getCount());
			cart.setDiscountArticle(article.getPrice());
			
			cartRepository.save(cart);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<CartDTO>> allByUser(Principal principal) {
		
		User user = userRepository.findByUsername(principal.getName());
		List<Cart> cart = cartRepository.findByUser(user);
		
		List<CartDTO> cartDTO = new ArrayList<>();
		for(Cart c: cart){
			cartDTO.add(new CartDTO(c));
		}
		
		return new ResponseEntity<>(cartDTO, HttpStatus.OK);
	}
}
