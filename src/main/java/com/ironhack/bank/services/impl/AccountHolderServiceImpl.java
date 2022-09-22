package com.ironhack.bank.services.impl;


import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.repositories.AccountHolderRepository;
import com.ironhack.bank.services.interfaces.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Override
    public AccountHolder getAccountHolderById(Integer id) {
        Optional<AccountHolder> accountHolderOptional = accountHolderRepository.findById(id);

        if (accountHolderOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found");
        }

        return accountHolderOptional.get();
    }

    @Override
    public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
        if (accountHolder.getId() != null && accountHolderRepository.existsById(accountHolder.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + accountHolder.getId() + " already exists for another checking");
        }
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public void deleteAccountHolder(Integer accountHolderId) {
        AccountHolder accountHolder = getAccountHolderById(accountHolderId);
        accountHolderRepository.delete(accountHolder);
    }

}
