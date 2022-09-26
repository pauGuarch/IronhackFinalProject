package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.CreditCard;

public interface CreditCardController {
    CreditCard getCreditCardById(Integer id);
    CreditCard saveCreditCard(CreditCard checking);
    void deleteCreditCard(Integer creditCardId);
}
