package com.ironhack.bank.repositories;

import com.ironhack.bank.models.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Integer> {
}
