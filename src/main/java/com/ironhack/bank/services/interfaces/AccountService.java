package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.models.Account;

public interface AccountService {
    Account getAccountById(Integer id);
    Account saveAccount(Account account);
    void deleteAccount(Integer account);
    void updateBalance(Integer accountId, Money money);
}
