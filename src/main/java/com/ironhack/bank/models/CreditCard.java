package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("2")
public class CreditCard extends Account{
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    public CreditCard() {
    }

    public CreditCard(Integer id, Money balance, String secretKey, Owner primaryOwner, Owner secondaryOwner,
                      BigDecimal penaltyFee, BigDecimal creditLimit, BigDecimal interestRate, AccountStatus status) {
        super(id, balance, secretKey, primaryOwner, penaltyFee, status);
        this.setCreditLimit(creditLimit);
        this.setInterestRate(interestRate);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

}
