package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.DecimalMax;
import java.math.BigDecimal;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("2")
public class CreditCard extends Account{
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;
    @Column(name = "interest_rate")
    @DecimalMax("0.2")
    private BigDecimal interestRate;

    public CreditCard() {
    }

    public CreditCard(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, AccountStatus status, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee, status);
        this.setCreditLimit(creditLimit);
        this.setInterestRate(interestRate);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        if (creditLimit.compareTo(BigDecimal.valueOf(100.00)) < 0 || creditLimit.compareTo(BigDecimal.valueOf(100000.00)) > 0){
            this.creditLimit=BigDecimal.valueOf(100.00);
        }else{
            this.creditLimit = creditLimit;
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(BigDecimal.valueOf(0.1)) < 0 || interestRate.compareTo(BigDecimal.valueOf(0.2)) > 0){
            this.interestRate=BigDecimal.valueOf(0.2);
        }else{
            this.interestRate = interestRate;
        }
    }

}
