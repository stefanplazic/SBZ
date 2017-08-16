package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Cart;
import com.sample.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	public List<CartItem> findByCart(Cart cart);
}
