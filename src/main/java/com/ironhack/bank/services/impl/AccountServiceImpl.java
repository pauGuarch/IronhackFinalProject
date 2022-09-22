package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account getAccountById(Integer id) {
        Optional<Account> accountOptional = accountRepository.findById(id);

        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }

        return accountOptional.get();
    }

    @Override
    public Account saveAccount(Account account) {
        if (account.getId() != null && accountRepository.existsById(account.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + account.getId() + " already exists for another Student");
        }
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Integer studentId) {
        Account student = getAccountById(studentId);

        accountRepository.delete(student);
    }
}
