package com.ironhack.bank.models;



import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("4")
public class StudentChecking extends Account{
    @Column(name = "creation_date")
    private Date creationDate;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, AccountStatus status, Date creationDate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, status);
        this.setCreationDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}