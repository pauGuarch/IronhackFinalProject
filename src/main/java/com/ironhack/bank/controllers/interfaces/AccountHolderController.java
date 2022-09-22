package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Checking;


public interface AccountHolderController {
    AccountHolder getAccountHolderById(Integer id);
    AccountHolder saveAccountHolder(AccountHolder accountHolder);
    void deleteAccountHolder(Integer accountHolderId);
}
