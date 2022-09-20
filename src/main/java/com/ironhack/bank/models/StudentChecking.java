package com.ironhack.bank.models;



import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("4")
public class StudentChecking extends Account{
    @Column(name = "creation_date")
    private Date creationDate;

    public StudentChecking() {
    }

    public StudentChecking(Integer id, Money balance, String secretKey, Owner ownerId, Owner secondaryOwner, BigDecimal penaltyFee, AccountStatus status, Date creationDate) {
        super(id, balance, secretKey, ownerId, secondaryOwner, penaltyFee, status);
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}