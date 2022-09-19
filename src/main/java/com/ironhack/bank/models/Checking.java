package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
@DiscriminatorValue("1")
public class Checking extends Account{

    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    @Column(name = "creation_date")
    private Date creationDate;

    public Checking() {
    }

    public Checking(BigDecimal minimumBalance, BigDecimal monthlyMantainanceFee, Date creationDate) {
        this.setMinimumBalance(minimumBalance);
        this.setMonthlyMantainanceFee(monthlyMantainanceFee);
        this.setCreationDate(creationDate);
    }

    public Checking(Integer id, Money balance, String secretKey, Owner primaryOwner, Owner secondaryOwner,
                    BigDecimal penaltyFee, BigDecimal minimumBalance, BigDecimal monthlyMantainanceFee, Date creationDate, AccountStatus status) {
        super(id, balance, secretKey, primaryOwner, penaltyFee, status);
        this.setMinimumBalance(minimumBalance);
        this.setMonthlyMantainanceFee(monthlyMantainanceFee);
        this.setCreationDate(creationDate);
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
