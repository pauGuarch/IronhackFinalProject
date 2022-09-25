package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.Roles;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class AccountHolder extends User{
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "address")
    private Address address;

    public AccountHolder() {
    }

    public AccountHolder(Integer id, String name, String userName, String password, Date dateOfBirth) {
        super(id, name, userName, password, Roles.USER);
        this.setDateOfBirth(dateOfBirth);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
