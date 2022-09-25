package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.AccountHolder;

public interface AccountHolderService {
    AccountHolder getAccountHolderById(Integer id);
    AccountHolder saveAccountHolder(AccountHolder accountHolder);
    void deleteAccountHolder(Integer accountHolder);
}
