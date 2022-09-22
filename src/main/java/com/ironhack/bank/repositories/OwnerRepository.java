package com.ironhack.bank.repositories;

import com.ironhack.bank.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
