package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.model.Cart;
import com.sample.model.CartItem;
import com.sample.repository.CartItemRepository;

@Service
public class CartItemService {

	@Autowired
	private CartItemRepository repository;

	public CartItem save(CartItem a) {
		return repository.save(a);
	}

	public CartItem findOne(Long id) {
		return repository.findOne(id);
	}

	public List<CartItem> findAll() {
		return repository.findAll();
	}

	public Page<CartItem> findAll(Pageable page) {
		return repository.findAll(page);
	}

	public void remove(Long id) {
		repository.delete(id);
	}

	public List<CartItem> findByCart(Cart cart) {
		return repository.findByCart(cart);
	}
}
