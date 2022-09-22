package com.ironhack.bank.controllers.impl;

import com.ironhack.bank.controllers.interfaces.AccountHolderController;
import com.ironhack.bank.controllers.interfaces.AdminController;
import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Admin;
import com.ironhack.bank.services.interfaces.AccountHolderService;
import com.ironhack.bank.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

    @RestController
public class AdminControllerImpl implements AdminController {
        @Autowired
        private AdminService adminService;

        @GetMapping("/admin/{adminId}")
        public Admin getAdminById(@PathVariable(name = "adminId") Integer id) {
            //System.out.println(authentication.getName());
            //System.out.println(authentication.getCredentials());
            System.out.println("entro");
            return adminService.getAdminById(id);
        }

        @PostMapping(value="/admin", consumes = "application/json", produces = "application/json")
        @ResponseStatus(HttpStatus.CREATED)
        public Admin saveAdmin(@RequestBody Admin admin) {
            System.out.println("entro controller");
            return adminService.saveAdmin(admin);
        }

        @DeleteMapping("/admin/{adminId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteAdmin(@PathVariable Integer adminId) {
            System.out.println("entro controller");
            adminService.deleteAdmin(adminId);
        }
}
