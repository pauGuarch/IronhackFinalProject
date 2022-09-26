package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.Savings;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.repositories.CheckingRepository;
import com.ironhack.bank.repositories.SavingsRepository;
import com.ironhack.bank.services.interfaces.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SavingsServiceImpl implements SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Savings getSavingsById(Integer id) {
        Optional<Savings> savingsOptional = savingsRepository.findById(id);

        if (savingsOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings not found");
        }

        return savingsOptional.get();
    }

    @Override
    public Savings saveSavings(Savings savings) {
        if (savings.getId() != null && savingsRepository.existsById(savings.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + savings.getId() + " already exists for another checking");
        }
        return savingsRepository.save(savings);
    }

    @Override
    public void deleteSavings(Integer savingsId) {
        Savings savings = getSavingsById(savingsId);
        savingsRepository.delete(savings);
    }
}
