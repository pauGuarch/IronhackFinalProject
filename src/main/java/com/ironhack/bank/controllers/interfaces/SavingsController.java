package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.Savings;

public interface SavingsController {
    Savings getSavingsById(Integer id);
    Savings saveSavings(Savings checking);
    void deleteSavings(Integer savingsId);
}
