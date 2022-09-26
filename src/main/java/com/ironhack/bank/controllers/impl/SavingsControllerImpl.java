package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.controllers.interfaces.SavingsController;
import com.ironhack.bank.models.CreditCard;
import com.ironhack.bank.models.Savings;
import com.ironhack.bank.services.interfaces.AccountService;
import com.ironhack.bank.services.interfaces.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavingsControllerImpl implements SavingsController {
    @Autowired
    private SavingsService savingsService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/savings/{savingsId}")
    public Savings getSavingsById(@PathVariable(name = "savingsId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return savingsService.getSavingsById(id);
    }

    @PostMapping(value="/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings saveSavings(@RequestBody Savings savings) {
        System.out.println("entro controller");
        return savingsService.saveSavings(savings);
    }

    @DeleteMapping("/savings/{savingsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSavings(@PathVariable Integer savingsId) {
        System.out.println("entro controller");
        savingsService.deleteSavings(savingsId);
    }
}
