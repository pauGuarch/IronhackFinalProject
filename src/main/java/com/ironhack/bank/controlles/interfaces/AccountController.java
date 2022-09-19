package com.ironhack.bank.controlles.interfaces;

import com.ironhack.bank.models.Account;
import org.springframework.security.core.Authentication;

public interface AccountController {
    //Account getAccountById(Authentication auth, Integer id);
    Account getAccountById(Integer id);
    Account saveAccount(Account account);
    void deleteAccount(Integer accountId);
}
