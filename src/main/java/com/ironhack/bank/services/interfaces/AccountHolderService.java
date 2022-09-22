package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Checking;

public interface AccountHolderService {
    AccountHolder getAccountHolderById(Integer id);
    AccountHolder saveAccountHolder(AccountHolder accountHolder);
    void deleteAccountHolder(Integer accountHolder);
}
