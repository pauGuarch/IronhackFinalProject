package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
@Entity
//@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue("1")
public class Checking extends Account{

    private BigDecimal minimumBalance;
    @Column(name = "monthly_maintenance_fee")
    private BigDecimal monthlyMaintenanceFee;
    @Column(name = "creation_date")
    private Date creationDate;

    public Checking() {
    }

    public Checking(Integer id, Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, AccountStatus status, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, Date creationDate) {
        super(id, balance, secretKey, primaryOwner, secondaryOwner, penaltyFee, status);
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
