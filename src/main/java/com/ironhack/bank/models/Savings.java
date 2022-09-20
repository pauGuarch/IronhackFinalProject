package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("3")
public class Savings extends Account{
    @Column(name = "minimun_balance")
    private BigDecimal minimumBalance;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    public Savings() {
    }

    public Savings(Integer id, Money balance, String secretKey, Owner ownerId, Owner secondaryOwner, BigDecimal penaltyFee, AccountStatus status, BigDecimal minimumBalance, Date creationDate, BigDecimal interestRate) {
        super(id, balance, secretKey, ownerId, secondaryOwner, penaltyFee, status);
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

}
