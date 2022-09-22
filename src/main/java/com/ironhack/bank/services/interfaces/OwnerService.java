package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.Owner;

public interface OwnerService {
    Owner getOwnerById(Integer id);
    Owner saveOwner(Owner owner);
    void deleteOwner(Integer owner);
}
