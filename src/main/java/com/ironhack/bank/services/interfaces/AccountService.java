package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.Account;

public interface AccountService {
    Account getAccountById(Integer id);
    Account saveAccount(Account account);
    void deleteAccount(Integer account);
}
