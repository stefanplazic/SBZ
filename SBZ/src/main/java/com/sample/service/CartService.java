package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.model.Cart;
import com.sample.model.User;
import com.sample.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;

	public Cart save(Cart a) {
		return repository.save(a);
	}

	public Cart findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Cart> findAll() {
		return repository.findAll();
	}

	public Page<Cart> findAll(Pageable page) {
		return repository.findAll(page);
	}

	public void remove(Long id) {
		repository.delete(id);
	}

	public Cart findByUser(User user) {
		return repository.findByUser(user);
	}
}
