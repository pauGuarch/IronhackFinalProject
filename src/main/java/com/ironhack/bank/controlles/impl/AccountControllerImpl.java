package com.ironhack.bank.controlles.impl;

import com.ironhack.bank.controlles.interfaces.AccountController;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{accountId}")
    public Account getAccountById( @PathVariable(name = "accountId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return accountService.getAccountById(id);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account saveAccount( @RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @DeleteMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Integer accountId) {
        accountService.deleteAccount(accountId);
    }

}
