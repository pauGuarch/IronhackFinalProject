package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.controllers.interfaces.AccountController;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

    @PatchMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Account updateAccountBalance(@PathVariable Integer accountId, @RequestBody Money money) {
        return accountService.updateBalance(accountId, money);
    }

    @DeleteMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Integer accountId) {
        accountService.deleteAccount(accountId);
    }

}
