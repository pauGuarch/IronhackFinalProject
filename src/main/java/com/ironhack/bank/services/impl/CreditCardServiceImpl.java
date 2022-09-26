package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.CreditCard;
import com.ironhack.bank.models.Savings;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.repositories.CreditCardRepository;
import com.ironhack.bank.services.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public CreditCard getCreditCardById(Integer id) {
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(id);

        if (creditCardOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CreditCard not found");
        }

        return creditCardOptional.get();
    }

    @Override
    public CreditCard saveCreditCard(CreditCard creditCard) {
        if (creditCard.getId() != null && creditCardRepository.existsById(creditCard.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + creditCard.getId() + " already exists for another checking");
        }
        return creditCardRepository.save(creditCard);
    }

    @Override
    public void deleteCreditCard(Integer creditCardId) {
        CreditCard creditCard = getCreditCardById(creditCardId);
        creditCardRepository.delete(creditCard);
    }
}
