package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.CreditCard;

public interface CreditCardService {
    CreditCard getCreditCardById(Integer id);
    CreditCard saveCreditCard(CreditCard creditCard);
    void deleteCreditCard(Integer creditCard);
}
