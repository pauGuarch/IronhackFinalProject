package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type", discriminatorType = DiscriminatorType.INTEGER)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Embedded
    @Column(name = "balance")
    private Money balance;
    @Column(name = "secret_key")
    private String secretKey;
    @ManyToOne
    @JoinColumn(name = "primary_owner")
    private Owner ownerId;
    //@JoinColumn(name = "owner_id", insertable=false, updatable = false=false)
    @ManyToOne
    @JoinColumn(name = "secondary_owner")
    private Owner secondaryOwner;
    @Column(name = "penalty_fee")
    private BigDecimal penaltyFee;
    @Column(name = "status_")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Account() {
    }

    public Account(Integer id, Money balance, String secretKey, Owner ownerId, Owner secondaryOwner, BigDecimal penaltyFee, AccountStatus status) {
        this.id = id;
        this.balance = balance;
        this.secretKey = secretKey;
        this.ownerId = ownerId;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
        this.status = status;
    }

    public Owner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Owner getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Owner secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }
}

