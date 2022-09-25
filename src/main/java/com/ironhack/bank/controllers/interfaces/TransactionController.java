package com.ironhack.bank.controllers.interfaces;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Transaction;

public interface TransactionController {
    Transaction getTransactionById(Integer id);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Integer transactionId);
}
