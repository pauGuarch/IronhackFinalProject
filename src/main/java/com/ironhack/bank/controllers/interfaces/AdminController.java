package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Admin;

public interface AdminController {
    Admin getAdminById(Integer id);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Integer adminId);
}
