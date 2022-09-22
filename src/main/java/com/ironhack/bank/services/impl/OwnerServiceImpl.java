package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.Owner;
import com.ironhack.bank.repositories.OwnerRepository;
import com.ironhack.bank.services.interfaces.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner getOwnerById(Integer id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);

        if (ownerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found");
        }

        return ownerOptional.get();
    }

    @Override
    public Owner saveOwner(Owner owner) {
        if (owner.getId() != null && ownerRepository.existsById(owner.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + owner.getId() + " already exists for another checking");
        }
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Integer ownerId) {
        Owner owner = getOwnerById(ownerId);
        ownerRepository.delete(owner);
    }
}
