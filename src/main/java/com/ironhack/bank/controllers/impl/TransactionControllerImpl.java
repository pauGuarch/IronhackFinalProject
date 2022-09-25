package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.controllers.interfaces.TransactionController;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Transaction;
import com.ironhack.bank.services.interfaces.AccountService;
import com.ironhack.bank.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionControllerImpl implements TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction/{transactionId}")
    public Transaction getTransactionById(@PathVariable(name = "transactionId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction saveTransaction( @RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/transaction/{transactionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable Integer transactionId) {
        transactionService.deleteTransaction(transactionId);
    }
}
