package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.ItemsAccount;

public interface ItemsAccountRepository extends JpaRepository<ItemsAccount, Long> {

}
