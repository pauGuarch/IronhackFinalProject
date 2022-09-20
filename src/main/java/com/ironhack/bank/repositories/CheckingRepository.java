package com.ironhack.bank.repositories;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Integer> {

}
