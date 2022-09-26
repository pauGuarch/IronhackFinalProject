package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.Savings;

public interface SavingsService {
    Savings getSavingsById(Integer id);
    Savings saveSavings(Savings savings);
    void deleteSavings(Integer savings);
}
