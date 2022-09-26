package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Checking;

public interface CheckingService {
    Checking getCheckingById(Integer id);
    Account saveChecking(Checking checking);
    void deleteChecking(Integer checking);
}
