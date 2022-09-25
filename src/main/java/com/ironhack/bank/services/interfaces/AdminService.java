package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.Admin;

public interface AdminService {
    Admin getAdminById(Integer id);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Integer admin);
}
