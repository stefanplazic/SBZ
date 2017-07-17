package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Cart;
import com.sample.model.User;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUser(User user);

}
