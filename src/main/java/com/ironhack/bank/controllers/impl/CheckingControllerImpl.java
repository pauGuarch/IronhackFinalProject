package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.controllers.interfaces.CheckingController;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Checking;
import com.ironhack.bank.services.interfaces.AccountService;
import com.ironhack.bank.services.interfaces.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckingControllerImpl implements CheckingController {
    @Autowired
    private CheckingService checkingService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/checking/{checkingId}")
    public Checking getCheckingById(@PathVariable(name = "checkingId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return checkingService.getCheckingById(id);
    }

    @PostMapping(value="/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account saveChecking(@RequestBody Checking checking) {
        System.out.println("entro controller");
        return checkingService.saveChecking(checking);
    }

    @DeleteMapping("/checking/{checkingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChecking(@PathVariable Integer checkingId) {
        System.out.println("entro controller");
        checkingService.deleteChecking(checkingId);
    }
}
