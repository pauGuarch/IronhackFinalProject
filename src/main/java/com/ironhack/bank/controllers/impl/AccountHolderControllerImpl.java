package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.controllers.interfaces.AccountHolderController;
import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.services.interfaces.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountHolderControllerImpl implements AccountHolderController {
    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping("/account_holder/{accountHolderId}")
    public AccountHolder getAccountHolderById(@PathVariable(name = "accountHolderId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return accountHolderService.getAccountHolderById(id);
    }

    @PostMapping(value="/account_holder", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder saveAccountHolder(@RequestBody AccountHolder accountHolder) {
        System.out.println("entro controller");
        return accountHolderService.saveAccountHolder(accountHolder);
    }

    @DeleteMapping("/account_holder/{accountholderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountHolder(@PathVariable Integer accountHolderId) {
        System.out.println("entro controller");
        accountHolderService.deleteAccountHolder(accountHolderId);
    }
}
