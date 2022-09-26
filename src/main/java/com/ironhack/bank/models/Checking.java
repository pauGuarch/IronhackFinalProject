package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Currency;

@Entity
@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue("1")
public class Checking extends Account{
    //private static final BigDecimal defaultMinimumBalance = BigDecimal.valueOf(250);
    //@Digits(integer=3, fraction=2)
    @Column(name = "minimum_balance")
    private BigDecimal minimumBalance;
    //@Digits(integer=3, fraction=2)
    @Column(name = "monthly_maintenance_fee")
    private BigDecimal monthlyMaintenanceFee;
    @Column(name = "creation_date")
    private Date creationDate;

    public Checking() {
    }

    public Checking(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                    AccountStatus status, BigDecimal monthlyMaintenanceFee) {
        super(balance, secretKey, primaryOwner, secondaryOwner, status);
        //this.setMinimumBalance(defaultMinimumBalance);
        this.setMonthlyMaintenanceFee(monthlyMaintenanceFee);
        this.setCreationDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
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

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
