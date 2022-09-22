package com.ironhack.bank.repositories;

import com.ironhack.bank.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
