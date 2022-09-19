/* package com.ironhack.bank.models;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Embedded
    private Account originAccount;
    @Embedded
    private Account destinyAccount;
    @Column(name = "amount")
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(Integer id, Account originAccount, Account destinyAccount, BigDecimal amount) {
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

}*/
