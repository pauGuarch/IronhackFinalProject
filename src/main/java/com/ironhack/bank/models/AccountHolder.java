package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.Roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class AccountHolder extends User{
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    public AccountHolder() {
    }

    public AccountHolder(Integer id, String name, String userName, String password, Roles role, Date dateOfBirth) {
        super(id, name, userName, password, role);
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
