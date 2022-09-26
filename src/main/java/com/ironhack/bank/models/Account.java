package com.ironhack.bank.models;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;
import javax.persistence.*;
import java.lang.annotation.Target;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Inheritance(strategy= InheritanceType.JOINED)
//@DiscriminatorColumn(name="account_type", discriminatorType = DiscriminatorType.INTEGER)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Embedded
    private Money balance;
    @Column(name = "secret_key")
    private String secretKey;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "primary_owner")
    private AccountHolder primaryOwner;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "secondary_owner")
    private AccountHolder secondaryOwner;
    @Column(name = "penalty_fee")
    private BigDecimal penaltyFee;
    @Column(name = "status_")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Account() {
    }

    public Account(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, AccountStatus status) {
        this.setBalance(balance);
        this.setSecretKey(secretKey);
        this.setPrimaryOwner(primaryOwner);
        this.setSecondaryOwner(secondaryOwner);
        this.setPenaltyFee(penaltyFee);
        this.setStatus(status);
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
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

