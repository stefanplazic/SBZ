package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Account;

public interface AccountReposotory extends JpaRepository<Account, Long> {

}
