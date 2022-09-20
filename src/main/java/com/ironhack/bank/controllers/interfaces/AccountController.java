package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.Account;

public interface AccountController {
    //Account getAccountById(Authentication auth, Integer id);
    Account getAccountById(Integer id);
    Account saveAccount(Account account);
    void deleteAccount(Integer accountId);
}
