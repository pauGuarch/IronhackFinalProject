package com.ironhack.bank.models;



import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
@DiscriminatorValue("4")
public class StudentChecking extends Account{
    @Column(name = "creation_date")
    private Date creationDate;

    public StudentChecking() {
    }

    public StudentChecking(Integer id, Money balance, String secretKey, Owner primaryOwner, BigDecimal penaltyFee, Date creationDate, AccountStatus status) {
        super(id, balance, secretKey, primaryOwner, penaltyFee, status);
        this.setCreationDate(creationDate);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}