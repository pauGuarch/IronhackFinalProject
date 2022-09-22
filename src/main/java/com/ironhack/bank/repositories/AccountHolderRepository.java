package com.ironhack.bank.repositories;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
}
