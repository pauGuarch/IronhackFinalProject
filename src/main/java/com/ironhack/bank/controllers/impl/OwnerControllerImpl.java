package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.controllers.interfaces.CheckingController;
import com.ironhack.bank.controllers.interfaces.OwnerController;
import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.Owner;
import com.ironhack.bank.services.interfaces.AccountService;
import com.ironhack.bank.services.interfaces.CheckingService;
import com.ironhack.bank.services.interfaces.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerControllerImpl implements OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owner/{ownerId}")
    public Owner getOwnerById(@PathVariable(name = "ownerId") Integer id) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.getCredentials());
        System.out.println("entro");
        return ownerService.getOwnerById(id);
    }

    @PostMapping(value="/owner", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Owner saveOwner(@RequestBody Owner owner) {
        System.out.println("entro controller");
        return ownerService.saveOwner(owner);
    }

    @DeleteMapping("/owner/{ownerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOwner(@PathVariable Integer ownerId) {
        System.out.println("entro controller");
        ownerService.deleteOwner(ownerId);
    }
}
