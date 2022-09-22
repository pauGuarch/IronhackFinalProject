package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Admin;
import com.ironhack.bank.repositories.AccountHolderRepository;
import com.ironhack.bank.repositories.AdminRepository;
import com.ironhack.bank.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin getAdminById(Integer id) {
        Optional<Admin> adminOptional = adminRepository.findById(id);

        if (adminOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "admin not found");
        }

        return adminOptional.get();
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        if (admin.getId() != null && adminRepository.existsById(admin.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + admin.getId() + " already exists for another admin");
        }
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        Admin admin = getAdminById(adminId);
        adminRepository.delete(admin);
    }
}
