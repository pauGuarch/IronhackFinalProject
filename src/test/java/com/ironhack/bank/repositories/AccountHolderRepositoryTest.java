package com.ironhack.bank.repositories;

import com.ironhack.bank.models.AccountHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountHolderRepositoryTest {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    private AccountHolder accountHolder;
    private AccountHolder accountHolder2;
    private AccountHolder accountHolder3;

    @BeforeEach
    void setUp() {
        accountHolder = accountHolderRepository.save(new AccountHolder("Peter Jackson", "peter_jackson", "qwerty", Date.valueOf("2001-09-09")));
        accountHolder2 = accountHolderRepository.save(new AccountHolder("Lina Morgan", "lina_morgan", "12345", Date.valueOf("2011-09-09")));
        accountHolder3 = accountHolderRepository.save(new AccountHolder("Steve O", "steve_o", "asdfg", Date.valueOf("1988-09-09")));
    }

    @AfterEach
    void tearDown() {
        accountHolderRepository.deleteAll();
    }

    @Test
    public void testFindById() {
        Optional<AccountHolder> accountHolderOptional = accountHolderRepository.findById(accountHolder.getId());
        assertEquals("Peter Jackson", accountHolderOptional.get().getName());
    }
/*
    @Test
    public void deleteById() {
        accountHolderRepository.deleteById(accountHolder2.getId());
        assert(, accountHolderRepository.findById(accountHolder2.getId()));
    }*/

}