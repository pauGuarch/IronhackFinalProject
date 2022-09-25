package com.ironhack.bank.services.interfaces;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Transaction;

public interface TransactionService {
    Transaction getTransactionById(Integer id);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Integer transaction);
}
