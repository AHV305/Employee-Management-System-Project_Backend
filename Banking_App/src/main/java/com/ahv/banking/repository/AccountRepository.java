package com.ahv.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahv.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
