package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Transaction;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.repositories.TransactionRepository;
import com.ironhack.bank.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Transaction getTransactionById(Integer id) {
        System.out.println("id----->"+ id);
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        }
        return transactionOptional.get();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        //get del origin i del destiny, comprobar saldos i ajuste de amount de cuentas.
        if (transaction.getId() != null && transactionRepository.existsById(transaction.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + transaction.getId() + " already exists for another Student");
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Integer transactionId) {
        Transaction transaction = getTransactionById(transactionId);
        transactionRepository.delete(transaction);
    }
}
