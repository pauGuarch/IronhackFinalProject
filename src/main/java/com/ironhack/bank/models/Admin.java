package com.ironhack.bank.models;

import com.ironhack.bank.enums.Roles;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User{
    @Column(name = "level")
    private String level;

    public Admin() {
    }

    public Admin(Integer id, String name, String userName, String password, String level) {
        super(name, userName, password, Roles.ADMIN);
        this.setLevel(level);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
