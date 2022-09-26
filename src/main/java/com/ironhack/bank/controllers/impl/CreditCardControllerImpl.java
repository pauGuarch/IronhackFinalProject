package com.ironhack.bank.controllers.impl;
import com.ironhack.bank.controllers.interfaces.CreditCardController;
import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.CreditCard;
import com.ironhack.bank.services.interfaces.AccountService;
import com.ironhack.bank.services.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardControllerImpl implements CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/credit_card/{creditCardId}")
    public CreditCard getCreditCardById(@PathVariable(name = "creditCardId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return creditCardService.getCreditCardById(id);
    }

    @PostMapping(value="/credit_card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard saveCreditCard(@RequestBody CreditCard creditcard) {
        System.out.println("entro controller");
        return creditCardService.saveCreditCard(creditcard);
    }

    @DeleteMapping("/credit_card/{creditCardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCreditCard(@PathVariable Integer checkingId) {
        System.out.println("entro controller");
        creditCardService.deleteCreditCard(checkingId);
    }
}
