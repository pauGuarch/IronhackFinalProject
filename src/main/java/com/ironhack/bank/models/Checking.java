package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("1")
public class Checking extends Account{

    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    @Column(name = "creation_date")
    private Date creationDate;

    public Checking() {
    }

    public Checking(Integer id, Money balance, String secretKey, Owner ownerId, Owner secondaryOwner, BigDecimal penaltyFee, AccountStatus status, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, Date creationDate) {
        super(id, balance, secretKey, ownerId, secondaryOwner, penaltyFee, status);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = creationDate;
    }

    public Checking(BigDecimal balance) {
        super();
        setBalance(balance);
    }

    public void setBalance(BigDecimal balance) {
        Money money = new Money(balance);
        super.setBalance(money);
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMantainanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMantainanceFee(BigDecimal monthlyMantainanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
