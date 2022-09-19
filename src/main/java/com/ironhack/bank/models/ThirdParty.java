package com.ironhack.bank.models;

import com.ironhack.bank.enums.Roles;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ThirdParty extends User{
    @Column(name = "secret_key")
    private String secretKey;

    public ThirdParty() {
    }

    public ThirdParty(Integer id, String name, String userName, String password, Roles role, String secretKey) {
        super(id, name, userName, password, role);
        this.setSecretKey(secretKey);
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
