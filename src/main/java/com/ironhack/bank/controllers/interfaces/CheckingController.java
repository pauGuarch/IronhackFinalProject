package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Checking;

public interface CheckingController {
    //Account getAccountById(Authentication auth, Integer id);
    Checking getCheckingById(Integer id);
    Checking saveChecking(Checking checking);
    void deleteChecking(Integer checkingId);
}
