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
    @ManyToOne
    //@JoinColumn(name = "owner_id", insertable=false, updatable = false=false)
    @JoinColumn(name = "secondary_owner")
    private Owner secondaryOwner;
    @Column(name = "penalty_fee")
    private BigDecimal penaltyFee;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Account() {
    }

    public Account(Integer id, Money balance, String secretKey, Owner ownerId, BigDecimal penaltyFee, AccountStatus status) {
        this.setId(id);
        this.setBalance(balance);
        this.setSecretKey(secretKey);
        this.setOwnerId(ownerId);
        this.setPenaltyFee(penaltyFee);
        this.setStatus(status);
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


}

