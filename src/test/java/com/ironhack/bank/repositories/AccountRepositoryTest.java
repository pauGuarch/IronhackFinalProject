package com.ironhack.bank.repositories;

import com.ironhack.bank.models.Checking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private CheckingRepository checkingRepository;

    @Test
    void createCheckingAccountTest() {
        BigDecimal result = BigDecimal.valueOf(0);
        Checking account = new Checking(BigDecimal.valueOf(500));
        account = checkingRepository.save(account);
        Optional<Checking> accountSaved = checkingRepository.findById(account.getId());
        if (accountSaved.isPresent()) {
            result = accountSaved.get().getBalance().getAmount();
        }
        assertEquals(BigDecimal.valueOf(500), result.setScale(0));
    }
}