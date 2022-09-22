package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.Owner;

public interface OwnerController {
    Owner getOwnerById(Integer id);
    Owner saveOwner(Owner checking);
    void deleteOwner(Integer checkingId);
}
