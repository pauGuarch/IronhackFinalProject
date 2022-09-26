package com.ironhack.bank.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "origin_account")
    private Account originAccount;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "destiny_account")
    private Account destinyAccount;
    @Column(name = "amount")
    @NotNull
    @DecimalMin("0.01")
    @Digits(integer=6, fraction=2)
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(Account originAccount, Account destinyAccount, BigDecimal amount) {
        this.setId(id);
        this.setOriginAccount(originAccount);
        this.setDestinyAccount(destinyAccount);
        this.setAmount(amount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(Account destinyAccount) {
        this.destinyAccount = destinyAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
